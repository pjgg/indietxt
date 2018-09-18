package org.indietxt.service;

import java.util.ArrayList;
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

	default List<String> getPermutations(String input) {

		List strList = new ArrayList<>();
		permutations("", input, strList);
		return strList;
	}

	default void permutations(String consChars, String input, List list) {

		if(input.isEmpty()) {
			list.add(consChars + input);
			return;
		}

		for(int i = 0; i < input.length(); i++) {
			permutations(consChars + input.charAt(i),
					input.substring(0, i)+input.substring(i+1), list);
		}
	}
}
