Feature: as an indieTxt manager I would like to calculate the stock

  @CleanData
  Scenario: calculate stock with equivalent logic
    Given a productSize csv "loadProductSizeCaseBasic.csv" and a stock entry csv "loadStockEntryCaseBasic.csv" with a "ReferenceImpl" stockManager
    When when I request to retrieve a stock
    Then check that the result much with the expected solution "basicSolution.csv"

  @CleanData
  Scenario: calculate stock with same sizeSystem and equivalent logic
    Given a productSize csv "loadProductSizeCaseSizeSystem.csv" and a stock entry csv "loadStockEntryCaseSizeSystem.csv" with a "ReferenceImpl" stockManager
    When when I request to retrieve a stock
    Then check that the result much with the expected solution "sizeSystemSolution.csv"

  @CleanData
  Scenario: calculate stock with same sizeSystem and equivalent logic - complex example
    Given a productSize csv "loadProductSizeCaseSizeSystemComplex.csv" and a stock entry csv "loadStockEntryCaseSizeSystemComplex.csv" with a "ReferenceImpl" stockManager
    When when I request to retrieve a stock
   Then check that the result much with the expected solution "sizeSystemSolutionComplex.csv"

  @CleanData
  Scenario: calculate stock with same sizeSystem and equivalent logic - reverse example
    Given a productSize csv "loadProductSizeCaseSizeSystemReverse.csv" and a stock entry csv "loadStockEntryCaseSizeSystem.csv" with a "ReferenceImpl" stockManager
    When when I request to retrieve a stock
    Then check that the result much with the expected solution "sizeSystemSolution.csv"

  @CleanData
  Scenario: calculate stock with same sizeSystem and equivalent logic - messy example
    Given a productSize csv "loadProductSizeCaseMessy.csv" and a stock entry csv "loadStockEntryCaseMessy.csv" with a "ReferenceImpl" stockManager
    When when I request to retrieve a stock
    Then check that the result much with the expected solution "sizeSystemSolutionMessy.csv"
