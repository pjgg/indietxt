package org.indietxt.service;

import static org.mockito.Mockito.mock;

import org.indietxt.model.ProductSize;
import org.indietxt.model.StockEntry;
import org.indietxt.service.impl.StockManagerReferenceImpl;
import org.indietxt.storage.ProductSizeDAO;
import org.indietxt.storage.StockEntryDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.runners.MockitoJUnitRunner;
import static org.indietxt.storage.ProductSizePredicates.alwaysTrue;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class)
public class StockManagerReferenceImplTest {

	@Test
	public void cleanStockEntryTest() {

		//Mock
		StockEntryDAO stockEntryDao = mock(StockEntryDAO.class);
		ProductSizeDAO productSizeDAO = mock(ProductSizeDAO.class);

		//invoke
		StockManagerReferenceImpl stockManagerReference = new StockManagerReferenceImpl(productSizeDAO, stockEntryDao);
		stockManagerReference.cleanStockEntry();

		//Verify
		verify(stockEntryDao, times(1)).removeEntities(Matchers.any());

	}

	@Test
	public void cleanProductSizeTest() {

		//Mock
		StockEntryDAO stockEntryDao = mock(StockEntryDAO.class);
		ProductSizeDAO productSizeDAO = mock(ProductSizeDAO.class);

		//invoke
		StockManagerReferenceImpl stockManagerReference = new StockManagerReferenceImpl(productSizeDAO, stockEntryDao);
		stockManagerReference.cleanProductSize();

		//Verify
		verify(productSizeDAO, times(1)).removeEntities(Matchers.any());
	}

	@Test
	public void retrieveStockTest() {

		//Mock
		StockEntryDAO stockEntryDao = mock(StockEntryDAO.class);
		ProductSizeDAO productSizeDAO = mock(ProductSizeDAO.class);
		ProductSize productSize = new ProductSize(10,101, "XL");
		Stream<ProductSize> streamProductSizeMock = Arrays.asList(productSize).stream();
		StockEntry stockEntry = new StockEntry(10,3);
		Stream<StockEntry> streamStockEntryMock = Arrays.asList(stockEntry).stream();

		//Stubbing
		when(productSizeDAO.filterEntities(alwaysTrue())).thenReturn(streamProductSizeMock);
		when(stockEntryDao.filterEntities(Matchers.any())).thenReturn(streamStockEntryMock);

		//invoke
		StockManagerReferenceImpl stockManagerReference = new StockManagerReferenceImpl(productSizeDAO, stockEntryDao);
		List<StockEntry> result = stockManagerReference.retrieveStock();

		//Asserts
		assertTrue(result.size() == 1);

		//Verify
		verify(productSizeDAO, times(1)).filterEntities(alwaysTrue());
		verify(stockEntryDao, times(1)).filterEntities(Matchers.any());
	}


	@Test
	public void loadItemsNoneEquivalentTest() {
		//Mock
		StockEntryDAO stockEntryDao = mock(StockEntryDAO.class);
		ProductSizeDAO productSizeDAO = mock(ProductSizeDAO.class);
		ProductSize productSize = new ProductSize(10,101, "XL");
		List<ProductSize> productSizeList =  Arrays.asList(productSize);
		StockEntry stockEntry = new StockEntry(10,3);
		List<StockEntry> stockSizesList =  Arrays.asList(stockEntry);

		//Stubbing
		when(productSizeDAO.existEntities(Matchers.any())).thenReturn(false);

		//invoke
		StockManagerReferenceImpl stockManagerReference = new StockManagerReferenceImpl(productSizeDAO, stockEntryDao);
		stockManagerReference.loadItems(productSizeList, stockSizesList);

		//Verify
		verify(productSizeDAO, times(1)).existEntities(Matchers.any());
	}


	@Test
	public void loadItemsTest() {
		//Mock
		StockEntryDAO stockEntryDao = mock(StockEntryDAO.class);
		ProductSizeDAO productSizeDAO = mock(ProductSizeDAO.class);
		ProductSize productSize = new ProductSize(10,101, "XL");
		List<ProductSize> productSizeList =  Arrays.asList(productSize);
		StockEntry stockEntry = new StockEntry(10,3);
		List<StockEntry> stockSizesList =  Arrays.asList(stockEntry);

		//Stubbing
		when(productSizeDAO.existEntities(Matchers.any())).thenReturn(true);
		when(stockEntryDao.filterEntities(Matchers.any())).thenReturn(stockSizesList.stream());
		when(productSizeDAO.filterEntities(Matchers.any())).thenReturn(productSizeList.stream());

		//invoke
		StockManagerReferenceImpl stockManagerReference = new StockManagerReferenceImpl(productSizeDAO, stockEntryDao);
		stockManagerReference.loadItems(productSizeList, stockSizesList);

		//Verify
		verify(productSizeDAO, times(1)).existEntities(Matchers.any());
		verify(productSizeDAO, times(1)).filterEntities(Matchers.any());
		verify(stockEntryDao, times(1)).filterEntities(Matchers.any());
	}
}
