package org.indietxt.performance;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

		@Param({ "1"})
		public int iterations;

		ProductSize productSizeExample;

		StockManager stockManager;

		@Setup(Level.Invocation)
		public void setUp() {

			stockManager = StockManagerServiceLocator.INSTANCE.getStockManagerReference();
			stockManager.cleanStockEntry();
			stockManager.cleanProductSize();

			ProductSize productSize = new ProductSize(10,101, "XL");
			List<ProductSize> streamProductSize = Arrays.asList(productSize);

			StockEntry stockEntry = new StockEntry(10,3);
			List<StockEntry> streamStockEntry = Arrays.asList(stockEntry);

			stockManager.loadItems(streamProductSize, streamStockEntry);

		}
	}

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5)
	public void stockManagerTest(ExecutionPlan plan) {

		for (int i = plan.iterations; i > 0; i--) {
			plan.stockManager.retrieveStock();
		}
	}

}
