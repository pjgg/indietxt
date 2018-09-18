package org.indietxt.storage;

import static org.junit.Assert.assertTrue;
import static org.indietxt.storage.ProductSizePredicates.alwaysTrue;
import static org.indietxt.storage.ProductSizePredicates.byId;

import org.indietxt.model.ProductSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductSizeDaoTest {

	@Test
	public void addEntityTest() {

		ProductSize productSize = new ProductSize(10,101, "XL");

		//invoke
		ProductSizeDAO productSizeDAO = new ProductSizeDAO();
		productSizeDAO.addEntity(productSize);

		//Assert
		assertTrue(productSizeDAO.filterEntities(alwaysTrue()).count() == 1);

	}

	@Test
	public void removeEntityTest() {

		ProductSize productSize = new ProductSize(10,101, "XL");

		//invoke
		ProductSizeDAO productSizeDAO = new ProductSizeDAO();
		productSizeDAO.addEntity(productSize);
		productSizeDAO.removeEntities(alwaysTrue());

		//Assert
		assertTrue(productSizeDAO.filterEntities(alwaysTrue()).count() == 0);

	}


	@Test
	public void existEntityTest() {

		ProductSize productSize = new ProductSize(10,101, "XL");

		//invoke
		ProductSizeDAO productSizeDAO = new ProductSizeDAO();
		productSizeDAO.addEntity(productSize);

		//Assert
		assertTrue(productSizeDAO.existEntities(byId(productSize.getId())));

	}



	@Test
	public void findEntityTest() {

		ProductSize productSize = new ProductSize(10,101, "XL");

		//invoke
		ProductSizeDAO productSizeDAO = new ProductSizeDAO();
		productSizeDAO.addEntity(productSize);
		productSizeDAO.addEntity(productSize);
		productSizeDAO.addEntity(productSize);

		//Assert
		assertTrue(productSizeDAO.filterEntities(alwaysTrue()).count() == 3);

	}

}
