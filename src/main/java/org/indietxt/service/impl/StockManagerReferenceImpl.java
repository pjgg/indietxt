package org.indietxt.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.indietxt.model.ProductSize;
import org.indietxt.service.StockManager;
import org.indietxt.model.StockEntry;
import org.indietxt.storage.ProductSizeDAO;
import org.indietxt.storage.ProductSizePredicates;
import org.indietxt.storage.StockEntryDAO;
import org.indietxt.storage.StockEntryPredicates;

import static org.indietxt.storage.StockEntryPredicates.byId;
import static org.indietxt.storage.StockEntryPredicates.alwaysTrue;

public class StockManagerReferenceImpl implements StockManager {

	protected ProductSizeDAO productSizeDAO;
	protected StockEntryDAO stockEntryDAO;

	public StockManagerReferenceImpl(ProductSizeDAO productSizeDAO, StockEntryDAO stockEntryDAO) {
		this.productSizeDAO = productSizeDAO;
		this.stockEntryDAO = stockEntryDAO;
	}

	@Override
	public void loadItems(List<ProductSize> productSizes, List<StockEntry> stockSizes) {

		stockSizes.forEach(p -> stockEntryDAO.addEntity(p));
		productSizes.forEach(p -> {
			List<String> perm = getPermutations(Integer.toString(p.getSizeSystem()));
				if (!productSizeDAO.existEntities(ProductSizePredicates.equivalentLogic(perm))) {
					productSizeDAO.addEntity(p);
				} else {
					int indexOfSizeSystem = perm.indexOf(Integer.toString(p.getSizeSystem()));
					int sizeSytem = Integer.valueOf(perm.get(indexOfSizeSystem));

					StockEntry stockEntry = stockEntryDAO.filterEntities(StockEntryPredicates.byId(p.getId())).findAny().get();
					List<ProductSize> tmp = productSizeDAO.filterEntities(ProductSizePredicates.byEquivalentLogic(perm, stockEntry.getQty(), stockEntryDAO)).collect(Collectors.toList());
					if (!tmp.isEmpty()){
						List<Integer> ids = tmp.stream().map(ProductSize::getId).collect(Collectors.toList());
						productSizeDAO.removeEntities(ProductSizePredicates.byIds(ids.toArray(new Integer[ids.size()])));
						productSizeDAO.addEntity(p);
					}
				}
		});
	}


	@Override
	public List<StockEntry> retrieveStock() {

		List<ProductSize> pSize =  productSizeDAO.filterEntities(ProductSizePredicates.alwaysTrue()).collect(Collectors.toList());
		List<Integer> ids = pSize.stream().map(ProductSize::getId).collect(Collectors.toList());
		return stockEntryDAO.filterEntities(StockEntryPredicates.byIds(ids.toArray(new Integer[ids.size()]))).collect(Collectors.toList());
	}

	@Override
	public Boolean cleanStockEntry() {
		stockEntryDAO.removeEntities(StockEntryPredicates.alwaysTrue());
		return true;
	}

	@Override
	public Boolean cleanProductSize() {
		productSizeDAO.removeEntities(ProductSizePredicates.alwaysTrue());
		return true;
	}


}
