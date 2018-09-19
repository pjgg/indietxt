package org.indietxt.performance;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.indietxt.acceptanceTest.utils.CsvFileReader;
import org.indietxt.model.ProductSize;
import org.indietxt.model.StockEntry;
import org.indietxt.service.StockManager;
import org.indietxt.service.StockManagerServiceLocator;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;


public class StockManagerPerformance {

	@State(Scope.Benchmark)
	public static class ExecutionPlan {

		private final ClassLoader classLoader = getClass().getClassLoader();

		@Param({ "1"})
		public int iterations;

		List<ProductSize> productSizeOneItemExample;
		List<StockEntry> stockOneItemExample;

		List<ProductSize> productSizeTenItemExample;
		List<StockEntry> stockTenItemExample;

		List<ProductSize> productSizeFiftytemExample;
		List<StockEntry> stockFiftyItemExample;

		List<ProductSize> productSizeHundredItemExample;
		List<StockEntry> stockHundredItemExample;

		List<ProductSize> productSizeTwoHundredItemExample;
		List<StockEntry> stockTwoHundredItemExample;

		List<ProductSize> productSizeThreeHundredItemExample;
		List<StockEntry> stockThreeHundredItemExample;

		List<ProductSize> productSizeFourHundredItemExample;
		List<StockEntry> stockFourHundredItemExample;

		List<ProductSize> productSizeFiveHundredItemExample;
		List<StockEntry> stockFiveHundredItemExample;

		List<ProductSize> productSizeSixHundredItemExample;
		List<StockEntry> stockSixHundredItemExample;

		List<ProductSize> productSizeSevenHundredItemExample;
		List<StockEntry> stockSevenHundredItemExample;

		List<ProductSize> productSizeEighHundredItemExample;
		List<StockEntry> stockEighHundredItemExample;

		List<ProductSize> productSizeNineHundredItemExample;
		List<StockEntry> stockNineHundredItemExample;

		List<ProductSize> productSizeThousandItemExample;
		List<StockEntry> stockThousandItemExample;

		StockManager stockManager;

		@Setup(Level.Invocation)
		public void setUp() {

			stockManager = StockManagerServiceLocator.INSTANCE.getStockManagerReference();
			stockManager.cleanStockEntry();
			stockManager.cleanProductSize();

			ProductSize productSize = new ProductSize(10,101, "XL");
			productSizeOneItemExample = Arrays.asList(productSize);

			StockEntry stockEntry = new StockEntry(10,3);
			stockOneItemExample = Arrays.asList(stockEntry);

			CsvFileReader<ProductSize> csvReader = new CsvFileReader();
			File productSizeCsv = new File(classLoader.getResource("loadProductSizeTenItems.csv").getFile());
			productSizeTenItemExample = csvReader.read(productSizeCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry> csvStockReader = new CsvFileReader();
			File stockEntryCsv = new File(classLoader.getResource("loadStockTenItems.csv").getFile());
			stockTenItemExample = csvStockReader.read(stockEntryCsv, new StockEntry(0,0), StockEntry.class);

			CsvFileReader<ProductSize> csvFiftyReader = new CsvFileReader();
			File productSizeFiftyCsv = new File(classLoader.getResource("loadProductSizeFiftyItems.csv").getFile());
			productSizeFiftytemExample = csvFiftyReader.read(productSizeFiftyCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry>  csvStockFiftyReader = new CsvFileReader();
			File stockFiftyEntryCsv = new File(classLoader.getResource("loadStockFiftyItems.csv").getFile());
			stockFiftyItemExample = csvStockFiftyReader.read(stockFiftyEntryCsv, new StockEntry(0,0), StockEntry.class);

			CsvFileReader<ProductSize> csvHundredReader = new CsvFileReader();
			File productSizeHundredCsv = new File(classLoader.getResource("loadProductSizeHundredItems.csv").getFile());
			productSizeHundredItemExample = csvHundredReader.read(productSizeHundredCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry> csvHundredStockReader = new CsvFileReader();
			File stockHundredEntryCsv = new File(classLoader.getResource("loadStockHundredItems.csv").getFile());
			stockHundredItemExample = csvHundredStockReader.read(stockHundredEntryCsv, new StockEntry(0,0), StockEntry.class);

			CsvFileReader<ProductSize> csvTwoHundredReader = new CsvFileReader();
			File productSizecsvTwoHundredCsv = new File(classLoader.getResource("loadProductSizeTwoHundredItems.csv").getFile());
			productSizeTwoHundredItemExample = csvTwoHundredReader.read(productSizecsvTwoHundredCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry> csvTwoHundredStockReader = new CsvFileReader();
			File stockTwoHundredEntryCsv = new File(classLoader.getResource("loadStockTwoHundredItems.csv").getFile());
			stockTwoHundredItemExample = csvTwoHundredStockReader.read(stockTwoHundredEntryCsv, new StockEntry(0,0), StockEntry.class);

			CsvFileReader<ProductSize> csvThreeHundredReader = new CsvFileReader();
			File productSizecsvThreeHundredCsv = new File(classLoader.getResource("loadProductSizeThreeHundredItems.csv").getFile());
			productSizeThreeHundredItemExample = csvThreeHundredReader.read(productSizecsvThreeHundredCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry> csvThreeHundredStockReader = new CsvFileReader();
			File stockThreeHundredEntryCsv = new File(classLoader.getResource("loadStockThreeHundredItems.csv").getFile());
			stockThreeHundredItemExample = csvThreeHundredStockReader.read(stockThreeHundredEntryCsv, new StockEntry(0,0), StockEntry.class);

			CsvFileReader<ProductSize> csvFourHundredReader = new CsvFileReader();
			File productSizecsvFourHundredCsv = new File(classLoader.getResource("loadProductSizeFourHundredItems.csv").getFile());
			productSizeFourHundredItemExample = csvFourHundredReader.read(productSizecsvFourHundredCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry> csvFourHundredStockReader = new CsvFileReader();
			File stockFourHundredEntryCsv = new File(classLoader.getResource("loadStockFourHundredItems.csv").getFile());
			stockFourHundredItemExample = csvFourHundredStockReader.read(stockFourHundredEntryCsv, new StockEntry(0,0), StockEntry.class);

			CsvFileReader<ProductSize> csvFiveHundredReader = new CsvFileReader();
			File productSizecsvFiveHundredCsv = new File(classLoader.getResource("loadProductSizeFiveHundredItems.csv").getFile());
			productSizeFiveHundredItemExample = csvFiveHundredReader.read(productSizecsvFiveHundredCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry> csvFiveHundredStockReader = new CsvFileReader();
			File stockFiveHundredEntryCsv = new File(classLoader.getResource("loadStockFiveHundredItems.csv").getFile());
			stockFiveHundredItemExample = csvFiveHundredStockReader.read(stockFiveHundredEntryCsv, new StockEntry(0,0), StockEntry.class);

			CsvFileReader<ProductSize> csvSixHundredReader = new CsvFileReader();
			File productSizecsvSixHundredCsv = new File(classLoader.getResource("loadProductSizeSixHundredItems.csv").getFile());
			productSizeSixHundredItemExample = csvSixHundredReader.read(productSizecsvSixHundredCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry> csvSixHundredStockReader = new CsvFileReader();
			File stockSixHundredEntryCsv = new File(classLoader.getResource("loadStockSixHundredItems.csv").getFile());
			stockSixHundredItemExample = csvSixHundredStockReader.read(stockSixHundredEntryCsv, new StockEntry(0,0), StockEntry.class);

			CsvFileReader<ProductSize> csvSevenHundredReader = new CsvFileReader();
			File productSizecsvSevenHundredCsv = new File(classLoader.getResource("loadProductSizeSevenHundredItems.csv").getFile());
			productSizeSevenHundredItemExample = csvSevenHundredReader.read(productSizecsvSevenHundredCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry> csvSevenHundredStockReader = new CsvFileReader();
			File stockSevenHundredEntryCsv = new File(classLoader.getResource("loadStockSevenHundredItems.csv").getFile());
			stockSevenHundredItemExample = csvSevenHundredStockReader.read(stockSevenHundredEntryCsv, new StockEntry(0,0), StockEntry.class);

			CsvFileReader<ProductSize> csvEighHundredReader = new CsvFileReader();
			File productSizecsvEighHundredCsv = new File(classLoader.getResource("loadProductSizeEighHundredItems.csv").getFile());
			productSizeEighHundredItemExample = csvEighHundredReader.read(productSizecsvEighHundredCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry> csvEighHundredStockReader = new CsvFileReader();
			File stockEighHundredEntryCsv = new File(classLoader.getResource("loadStockEighHundredItems.csv").getFile());
			stockEighHundredItemExample = csvEighHundredStockReader.read(stockEighHundredEntryCsv, new StockEntry(0,0), StockEntry.class);


			CsvFileReader<ProductSize> csvNineHundredReader = new CsvFileReader();
			File productSizecsvNineHundredCsv = new File(classLoader.getResource("loadProductSizeNineHundredItems.csv").getFile());
			productSizeNineHundredItemExample = csvNineHundredReader.read(productSizecsvNineHundredCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry> csvNineHundredStockReader = new CsvFileReader();
			File stockNineHundredEntryCsv = new File(classLoader.getResource("loadStockNineHundredItems.csv").getFile());
			stockNineHundredItemExample = csvNineHundredStockReader.read(stockNineHundredEntryCsv, new StockEntry(0,0), StockEntry.class);

			CsvFileReader<ProductSize> csvThousandReader = new CsvFileReader();
			File productSizeThousandCsv = new File(classLoader.getResource("loadProductSizeThousandItems.csv").getFile());
			productSizeThousandItemExample = csvThousandReader.read(productSizeThousandCsv, new ProductSize(0,0, "desc"), ProductSize.class);

			CsvFileReader<StockEntry> csvThousandStockReader = new CsvFileReader();
			File stockThousandEntryCsv = new File(classLoader.getResource("loadStockThousandItems.csv").getFile());
			stockThousandItemExample = csvThousandStockReader.read(stockThousandEntryCsv, new StockEntry(0,0), StockEntry.class);

		}
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeOneItemExample, plan.stockOneItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}


	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerTenItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeTenItemExample, plan.stockTenItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}


	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerFiftyItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeFiftytemExample, plan.stockFiftyItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}


	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerHundredItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeHundredItemExample, plan.stockHundredItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}


	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerThousandItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeThousandItemExample, plan.stockThousandItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerTwoHundredItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeTwoHundredItemExample, plan.stockTwoHundredItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerThreeHundredItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeThreeHundredItemExample, plan.stockThreeHundredItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerFourHundredItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeFourHundredItemExample, plan.stockFourHundredItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerFiveHundredItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeFiveHundredItemExample, plan.stockFiveHundredItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerSixHundredItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeSixHundredItemExample, plan.stockSixHundredItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerSevenHundredItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeSevenHundredItemExample, plan.stockSevenHundredItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerEighHundredItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeEighHundredItemExample, plan.stockEighHundredItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerNineHundredItemsTest(ExecutionPlan plan) {
		plan.stockManager.loadItems(plan.productSizeNineHundredItemExample, plan.stockNineHundredItemExample);
		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}
}
