package org.indietxt.service;

import java.util.Arrays;
import java.util.List;

import org.indietxt.model.ProductSize;
import org.indietxt.model.StockEntry;

public interface StockManager {

	void loadItems(List<ProductSize> productSizes, List<StockEntry> stockSizes);

	List<StockEntry> retrieveStock();

	Boolean cleanStockEntry();

	Boolean cleanProductSize();

	default boolean isEquivalents(int sizeSystemA, int sizeSystemB) {
		// 1. sort first sizeSystem
		String s1 = String.valueOf(sizeSystemA);
		char[] c1 = s1.toCharArray();
		Arrays.sort(c1);

		// 2. sort second sizeSystem
		String s2 = String.valueOf(sizeSystemB);
		char[] c2 = s2.toCharArray();
		Arrays.sort(c2);

		// 3. compare
		return(Arrays.equals(c1,c2));
	}

	default int[] permutation(int n) {
		int[] a = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = i;

		for (int i = 0; i < n; i++) {
			int r = (int) (Math.random() * (i+1));     // int between 0 and i
			int swap = a[r];
			a[r] = a[i];
			a[i] = swap;
		}

		return a;
	}
}
