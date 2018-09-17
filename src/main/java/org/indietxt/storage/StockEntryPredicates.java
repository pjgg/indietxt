package org.indietxt.storage;

import java.util.Arrays;
import java.util.function.Predicate;

import org.indietxt.model.StockEntry;

public class StockEntryPredicates {

	public static Predicate<StockEntry> alwaysTrue() {
		return stock -> true;
	}

	public static Predicate<StockEntry> hasStockIdQuantityGreaterOrEqualThan(int q) {
		return stock -> stock.getQty() != null && stock.getQty() >= q;
	}

	public static Predicate<StockEntry> hasStockIdNotNull() {
		return stock -> stock.getSizeId() != null;
	}

	public static Predicate<StockEntry> byId(int id) {
		return stock -> stock.getSizeId() == id;
	}

	public static Predicate<StockEntry> byIds(Integer[] ids) {
		return stock -> Arrays.asList(ids).contains(stock.getSizeId());
	}
}
