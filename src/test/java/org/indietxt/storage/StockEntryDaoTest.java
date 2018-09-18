package org.indietxt.storage;

import static org.indietxt.storage.StockEntryPredicates.byId;
import static org.indietxt.storage.StockEntryPredicates.alwaysTrue;
import static org.junit.Assert.assertTrue;

import org.indietxt.model.StockEntry;
import org.junit.Test;

public class StockEntryDaoTest {

	@Test
	public void addEntityTest() {

		StockEntry stockEntry = new StockEntry(10,3);

		//invoke
		StockEntryDAO stockEntryDAO = new StockEntryDAO();
		stockEntryDAO.addEntity(stockEntry);

		//Assert
		assertTrue(stockEntryDAO.filterEntities(alwaysTrue()).count() == 1);

	}

	@Test
	public void removeEntityTest() {

		StockEntry stockEntry = new StockEntry(10,3);

		//invoke
		StockEntryDAO stockEntryDAO = new StockEntryDAO();
		stockEntryDAO.addEntity(stockEntry);
		stockEntryDAO.removeEntities(alwaysTrue());

		//Assert
		assertTrue(stockEntryDAO.filterEntities(alwaysTrue()).count() == 0);

	}

	@Test
	public void existEntityTest() {

		StockEntry stockEntry = new StockEntry(10,3);

		//invoke
		StockEntryDAO stockEntryDAO = new StockEntryDAO();
		stockEntryDAO.addEntity(stockEntry);

		//Assert
		assertTrue(stockEntryDAO.existEntities(byId(stockEntry.getSizeId())));

	}

	@Test
	public void findEntityTest() {

		StockEntry stockEntry = new StockEntry(10,3);

		//invoke
		StockEntryDAO stockEntryDAO = new StockEntryDAO();
		stockEntryDAO.addEntity(stockEntry);
		stockEntryDAO.addEntity(stockEntry);
		stockEntryDAO.addEntity(stockEntry);

		//Assert
		assertTrue(stockEntryDAO.filterEntities(alwaysTrue()).count() == 3);

	}
}
