# indietxt POC

![travicBuild](https://travis-ci.org/pjgg/indietxt.svg?branch=master "build status")
![Coverage Status](https://coveralls.io/repos/github/pjgg/indietxt/badge.svg?branch=master "https://coveralls.io/github/pjgg/indietxt?branch=master")

<img align="right" src="https://github.com/pjgg/indietxt/blob/master/logo.png">

  There are equivalent sizes, which are those whose sizing system contains the same numbers, although in different positions. For the equivalent sizes one must select the one with the highest stock, discarding their equivalences. The objective is to show those product sizes that have Stock.

## Data constraint and new datasets

We assume that all product sizes doesn't start by 0. For example 001 will be not a valid inbound data.
On the other hand we encourage you to develop your own datasets. You could place your own CSV on this [folder](https://github.com/pjgg/indietxt/blob/master/src/acceptance-test/resources). You could copy/paste a gherkins [test case definition](https://github.com/pjgg/indietxt/blob/master/src/acceptance-test/resources/features/ExerciseAcceptance.feature "Test definition") replacing the existing CSV filenames by your own ones. In order to run the acceptance test you could run [mainAcceptanceClass](https://github.com/pjgg/indietxt/blob/master/src/acceptance-test/java/RunCukesTest.java "Main acceptance test class") or execute `mvn test -P acceptance`
.

### Index 

1. [Test_definition](https://github.com/pjgg/indietxt/blob/master/src/acceptance-test/resources/features/ExerciseAcceptance.feature "Test definition")
2. [mainAcceptanceClass](https://github.com/pjgg/indietxt/blob/master/src/acceptance-test/java/RunCukesTest.java "Main acceptance test class")
3. [UnitTestFolder](https://github.com/pjgg/indietxt/blob/master/src/test/java/org/indietxt "Main unitTest folder")
4. [Microbenchmark](https://github.com/pjgg/indietxt/blob/master/src/microbenchmark/java/org/indietxt/performance/StockManagerPerformance.java "Performance Test")
5. [serviceMainClass](https://github.com/pjgg/indietxt/blob/master/src/main/java/org/indietxt/service/impl/StockManagerReferenceImpl.java "Service main class")
6. [StorageLayer](https://github.com/pjgg/indietxt/blob/master/src/main/java/org/indietxt/storage/AbstractDAO.java "Storage main class")


```
.
├── GetOneItemSize.png
├── README.md
├── logo.png
├── pom.xml
├── src
│   ├── acceptance-test
│   │   ├── java
│   │   │   ├── RunCukesTest.java
│   │   │   └── org
│   │   │       └── indietxt
│   │   │           └── acceptanceTest
│   │   │               ├── CalculateStockIT.java
│   │   │               ├── CommonsHooks.java
│   │   │               └── utils
│   │   │                   ├── ClassPattern.java
│   │   │                   ├── CsvFileReader.java
│   │   │                   ├── Pattern.java
│   │   │                   └── PatternMatching.java
│   │   └── resources
│   │       ├── basicSolution.csv
│   │       ├── features
│   │       │   └── ExerciseAcceptance.feature
│   │       ├── loadProductSizeCaseBasic.csv
│   │       ├── loadProductSizeCaseMessy.csv
│   │       ├── loadProductSizeCaseSizeSystem.csv
│   │       ├── loadProductSizeCaseSizeSystemComplex.csv
│   │       ├── loadProductSizeCaseSizeSystemReverse.csv
│   │       ├── loadStockEntryCaseBasic.csv
│   │       ├── loadStockEntryCaseMessy.csv
│   │       ├── loadStockEntryCaseSizeSystem.csv
│   │       ├── loadStockEntryCaseSizeSystemComplex.csv
│   │       ├── sizeSystemSolution.csv
│   │       ├── sizeSystemSolutionComplex.csv
│   │       └── sizeSystemSolutionMessy.csv
│   ├── main
│   │   └── java
│   │       └── org
│   │           └── indietxt
│   │               ├── model
│   │               │   ├── ProductSize.java
│   │               │   └── StockEntry.java
│   │               ├── service
│   │               │   ├── StockManager.java
│   │               │   ├── StockManagerServiceLocator.java
│   │               │   └── impl
│   │               │       └── StockManagerReferenceImpl.java
│   │               └── storage
│   │                   ├── AbstractDAO.java
│   │                   ├── ProductSizeDAO.java
│   │                   ├── ProductSizePredicates.java
│   │                   ├── StockEntryDAO.java
│   │                   └── StockEntryPredicates.java
│   ├── microbenchmark
│   │   └── java
│   │       └── org
│   │           └── indietxt
│   │               └── performance
│   │                   ├── BenchmarkRunner.java
│   │                   └── StockManagerPerformance.java
│   └── test
│       └── java
│           └── org
│               └── indietxt
│                   ├── service
│                   │   ├── ServiceLocatorTest.java
│                   │   └── StockManagerReferenceImplTest.java
│                   └── storage
│                       ├── ProductSizeDaoTest.java
│                       └── StockEntryDaoTest.java
└── suply-chain.iml

```


## Implementation considerations

We ask you to solve it using the **Java** programming language. You are only allowed to use test libraries (JUnit, TestNG, Hamcrest,...) and nothing else.

You are free to implement any mechanism for feeding input into your solution (for example, using hard coded data within a unit test).

Remember that the **automated and self-checking tests** are mandatory. You should provide sufficient evidence that your solution is complete by, as a minimum, indicating that it works correctly against the supplied test data.

We kindly ask you to put your code on a public project in `github.com` under your account. Use Maven or Gradle as automation tool and link it to a build service likeTravis CI.  

## What we value most?

The goal is to provide us with a full understanding of your coding style and skills. We’ll pay particular attention to:

* readable and well-structured code
* design and domain modelling
* quality of tests

## Microbenchmark

With just one item in stock and product storage, I request to retrieve the stock of each item(with equivalent logic - full exercise), and I got the following result.
We run, 2 Rounds, 20 iterations each one.

```
Result "org.indietxt.performance.StockManagerPerformance.stockManagerTest":
  0.560 ±(99.9%) 0.116 ms/op [Average]
  (min, avg, max) = (0.318, 0.560, 0.737), stdev = 0.133
  CI (99.9%): [0.444, 0.676] (assumes normal distribution)
  ```
  
So, all executions with a 99.9% will be between 0.444 ms and 0.676 ms
<img align="center" src="https://github.com/pjgg/indietxt/blob/master/GetOneItemSize.png">

  