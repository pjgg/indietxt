package org.indietxt.acceptanceTest.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.indietxt.model.ProductSize;
import org.indietxt.model.StockEntry;

// CODE INSPIRED FROM THE FOLLOWING WEB SITE
//https://examples.javacodegeeks.com/core-java/writeread-csv-files-in-java-example/
public class CsvFileReader<E> {

	private final static Logger LOGGER = Logger.getLogger(CsvFileReader.class.getName());

	private static final String COMMA_DELIMITER = ",";

	//ProductSize attributes index
	private static final int PRODUCT_SIZE_ID = 0;
	private static final int PRODUCT_SIZE_SYSTEM = 1;
	private static final int PRODUCT_SIZE_DESCRIPTION = 2;


	//stockEntry attributes index
	private static final int STOCK_ENTRY_ID = 0;
	private static final int STOCK_ENTRY_QUANTITY = 1;

	public List<E> read(File fileName, E fakeInstanceClass, Class<E> type) {

		BufferedReader fileReader = null;
		List<E> entities = new ArrayList<E>();

		try {

			String line = "";

			//Create the file reader
			fileReader = new BufferedReader(new FileReader(fileName));

			//Read the CSV file header to skip it
			fileReader.readLine();

			//Read the file line by line starting from the second line
			while ((line = fileReader.readLine()) != null) {
				//Get all tokens available in line
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {

					PatternMatching patternMatching = new PatternMatching(
							ClassPattern.inCaseOf(ProductSize.class, productSizeRecords -> new ProductSize(Integer.parseInt(tokens[PRODUCT_SIZE_ID]), Integer.parseInt(tokens[PRODUCT_SIZE_SYSTEM]),tokens[PRODUCT_SIZE_DESCRIPTION])),
							ClassPattern.inCaseOf(StockEntry.class, stockRecords -> new StockEntry(Integer.parseInt(tokens[STOCK_ENTRY_ID]), Integer.parseInt(tokens[STOCK_ENTRY_QUANTITY])))
					);

					entities.add(type.cast(patternMatching.matchFor(fakeInstanceClass)));
				}
			}


		} catch (Exception e) {
			LOGGER.info("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				LOGGER.info("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}
		return entities;
	}
}