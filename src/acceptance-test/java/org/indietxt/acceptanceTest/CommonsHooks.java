package org.indietxt.acceptanceTest;

import cucumber.api.java.After;

import org.indietxt.service.StockManager;
import org.indietxt.service.StockManagerServiceLocator;

import java.util.logging.Logger;

public class CommonsHooks {

    private final static Logger LOGGER = Logger.getLogger(CommonsHooks.class.getName());

    private StockManager stockManagerReference = StockManagerServiceLocator.INSTANCE.getStockManagerReference();

    @After("@CleanData")
    public void cleanData() {
        LOGGER.info("Clean all Data");
        stockManagerReference.cleanProductSize();
        stockManagerReference.cleanStockEntry();
    }


}
