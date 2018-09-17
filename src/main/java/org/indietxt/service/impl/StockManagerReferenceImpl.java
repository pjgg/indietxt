package org.indietxt.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.indietxt.model.ProductSize;
import org.indietxt.service.StockManager;
import org.indietxt.model.StockEntry;
import org.indietxt.storage.ProductSizeDAO;
import org.indietxt.storage.ProductSizePredicates;
import org.indietxt.storage.StockEntryDAO;
import org.indietxt.storage.StockEntryPredicates;

public class StockManagerReferenceImpl implements StockManager {

	protected ProductSizeDAO productSizeDAO = new ProductSizeDAO();
	protected StockEntryDAO stockEntryDAO = new StockEntryDAO();

	@Override
	public void loadItems(List<ProductSize> productSizes, List<StockEntry> stockSizes) {
		stockSizes.forEach(p -> stockEntryDAO.addEntity(p));
		productSizes.forEach(p -> {
			int perm[] = permutation(p.getSizeSystem());
			if (!productSizeDAO.existEntities(ProductSizePredicates.equivalentLogic(perm))){
				productSizeDAO.addEntity(p);
			}else{
				int indexOfSizeSystem = Arrays.asList(perm).indexOf(p.getSizeSystem());
				int sizeSytem = perm[indexOfSizeSystem];
				productSizeDAO.filterEntities(ProductSizePredicates.bySizeSystem(sizeSytem)).forEach(sizeSystemProd -> {
					List<StockEntry> equivalentStock = stockEntryDAO.filterEntities(StockEntryPredicates.byId(sizeSystemProd.getId())).collect(Collectors.toList());
					List<StockEntry> originalProductStock = stockEntryDAO.filterEntities(StockEntryPredicates.byId(p.getId())).collect(Collectors.toList());

					if(originalProductStock.get(0).getQty()>equivalentStock.get(0).getQty()){
						productSizeDAO.addEntity(p);
					}else{
						productSizeDAO.addEntity(sizeSystemProd);
					}
				});
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
