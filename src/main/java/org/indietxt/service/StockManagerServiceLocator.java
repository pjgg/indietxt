package org.indietxt.service;

import org.indietxt.service.impl.StockManagerReferenceImpl;

public enum StockManagerServiceLocator {

	INSTANCE;

	private final StockManager stockManagerReference;

	StockManagerServiceLocator() {
		stockManagerReference = new StockManagerReferenceImpl();
	}

	public StockManager getStockManagerReference() {
		return stockManagerReference;
	}
}
