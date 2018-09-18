package org.indietxt.service;

import org.indietxt.service.impl.StockManagerReferenceImpl;
import org.indietxt.storage.ProductSizeDAO;
import org.indietxt.storage.StockEntryDAO;

public enum StockManagerServiceLocator {

	INSTANCE;

	private final StockManager stockManagerReference;

	StockManagerServiceLocator() {
		stockManagerReference = new StockManagerReferenceImpl(new ProductSizeDAO(), new StockEntryDAO());
	}

	public StockManager getStockManagerReference() {
		return stockManagerReference;
	}
}
