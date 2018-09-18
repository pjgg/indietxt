package org.indietxt.storage;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.indietxt.model.ProductSize;
import org.indietxt.model.StockEntry;

public class ProductSizePredicates {

	public static Predicate<ProductSize> alwaysTrue() {
		return product -> true;
	}

	public static Predicate<ProductSize> equivalentLogic(List<String> systemSizePerm) {
		return product -> systemSizePerm.contains(Integer.toString(product.getSizeSystem()));
	}

	public static Predicate<ProductSize> byId(int id) {
		return product -> product.getId() == id;
	}

	public static Predicate<ProductSize> bySizeSystem(int s) {
		return product -> product.getSizeSystem() == s;
	}

	public static Predicate<ProductSize> byEquivalentLogic(List<String> systemSizePerm, int stockequivalent, StockEntryDAO stockEntryDAO ) {
		return product -> {
			StockEntry stockEntry = stockEntryDAO.filterEntities(StockEntryPredicates.byId(product.getId())).findAny().get();
			return systemSizePerm.contains(Integer.toString(product.getSizeSystem())) && stockEntry.getQty() <= stockequivalent;
		};
	}

	public static Predicate<ProductSize> byIds(Integer[] ids) {
		return product -> Arrays.asList(ids).contains(product.getId());
	}
}
