Feature: as an indieTxt manager I would like to calculate the stock

  @CleanData
  Scenario: calculate stock with equivalent logic
    Given a productSize csv "loadProductSizeCaseBasic.csv" and a stock entry csv "loadStockEntryCaseBasic.csv" with a "ReferenceImpl" stockManager
    When when I request to retrieve a stock
    Then check that the result much with the expected solution "basicSolution.csv"

