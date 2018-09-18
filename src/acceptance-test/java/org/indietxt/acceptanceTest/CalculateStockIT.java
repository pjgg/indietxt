package org.indietxt.acceptanceTest;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.indietxt.model.ProductSize;
import org.indietxt.model.StockEntry;
import org.indietxt.service.StockManager;
import org.indietxt.service.StockManagerServiceLocator;
import org.indietxt.acceptanceTest.utils.CsvFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class CalculateStockIT {

	private final ClassLoader classLoader = getClass().getClassLoader();
	private final static Logger LOGGER = Logger.getLogger(CommonsHooks.class.getName());
	private StockManager stockManagerReference = StockManagerServiceLocator.INSTANCE.getStockManagerReference();
	private StockManager stockManagerSelected;
	private List<StockEntry> result;

	@Given("^a productSize csv \"([^\"]*)\" and a stock entry csv \"([^\"]*)\" with a \"([^\"]*)\" stockManager$")
	public void a_productSize_csv_and_a_stock_entry_csv_with_a_stockManager(String productSizeFileName, String stockEntryFileName, String algorithm) throws Throwable {
		CsvFileReader<ProductSize> csvReader = new CsvFileReader();
		File productSizeCsv = new File(classLoader.getResource(productSizeFileName).getFile());
		List<ProductSize> productSizeList = csvReader.read(productSizeCsv, new ProductSize(0,0, "desc"), ProductSize.class);

		CsvFileReader<StockEntry> csvStockReader = new CsvFileReader();
		File stockEntryCsv = new File(classLoader.getResource(stockEntryFileName).getFile());
		List<StockEntry> stockEntryList = csvStockReader.read(stockEntryCsv, new StockEntry(0,0), StockEntry.class);

		switch(algorithm) {
			default:
				stockManagerSelected = stockManagerReference;
				break;
		}

		stockManagerSelected.loadItems(productSizeList, stockEntryList);
	}

	@When("^when I request to retrieve a stock$")
	public void when_I_request_to_retrieve_a_stock() throws Throwable {
		result = stockManagerSelected.retrieveStock();
	}

	@Then("^check that the result much with the expected solution \"([^\"]*)\"$")
	public void check_that_the_result_much_with_the_expected_solution(String expectedResultFileName) throws Throwable {
		CsvFileReader<StockEntry> csvStockReader = new CsvFileReader();
		File stockEntryCsv = new File(classLoader.getResource(expectedResultFileName).getFile());
		List<StockEntry> expectedStockEntryResult = csvStockReader.read(stockEntryCsv, new StockEntry(0,0), StockEntry.class);

		// expected stock amount
		assertTrue("unexpected resultsize: " + expectedStockEntryResult.size(), result.size() == expectedStockEntryResult.size());

		//expected stock ids
		List<Integer> ids = expectedStockEntryResult.stream().map(StockEntry::getSizeId).collect(Collectors.toList());
		assertTrue(result.stream().map(r -> r.getSizeId())
				.collect(Collectors.toList()).containsAll(ids));

	}

}
