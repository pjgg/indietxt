package org.indietxt.storage;

import java.util.Arrays;
import java.util.function.Predicate;

import org.indietxt.model.ProductSize;

public class ProductSizePredicates {

	public static Predicate<ProductSize> alwaysTrue() {
		return product -> true;
	}

	public static Predicate<ProductSize> equivalentLogic(int systemSizePerm[]) {
		return product -> Arrays.asList(systemSizePerm).contains(product.getSizeSystem());
	}

	public static Predicate<ProductSize> byId(int id) {
		return product -> product.getId() == id;
	}

	public static Predicate<ProductSize> bySizeSystem(int s) {
		return product -> product.getSizeSystem() == s;
	}
}
