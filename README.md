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
├── README.md
├── complexityChart.png
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
│   │   ├── java
│   │   │   └── org
│   │   │       └── indietxt
│   │   │           └── performance
│   │   │               ├── BenchmarkRunner.java
│   │   │               └── StockManagerPerformance.java
│   │   └── resources
│   │       ├── loadProductSizeEighHundredItems.csv
│   │       ├── loadProductSizeFiftyItems.csv
│   │       ├── loadProductSizeFiveHundredItems.csv
│   │       ├── loadProductSizeFourHundredItems.csv
│   │       ├── loadProductSizeHundredItems.csv
│   │       ├── loadProductSizeNineHundredItems.csv
│   │       ├── loadProductSizeSevenHundredItems.csv
│   │       ├── loadProductSizeSixHundredItems.csv
│   │       ├── loadProductSizeTenItems.csv
│   │       ├── loadProductSizeThousandItems.csv
│   │       ├── loadProductSizeThreeHundredItems.csv
│   │       ├── loadProductSizeTwoHundredItems.csv
│   │       ├── loadStockEighHundredItems.csv
│   │       ├── loadStockFiftyItems.csv
│   │       ├── loadStockFiveHundredItems.csv
│   │       ├── loadStockFourHundredItems.csv
│   │       ├── loadStockHundredItems.csv
│   │       ├── loadStockNineHundredItems.csv
│   │       ├── loadStockSevenHundredItems.csv
│   │       ├── loadStockSixHundredItems.csv
│   │       ├── loadStockTenItems.csv
│   │       ├── loadStockThousandItems.csv
│   │       ├── loadStockThreeHundredItems.csv
│   │       └── loadStockTwoHundredItems.csv
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

I request to retrieve the stock of each item(with equivalent logic - full exercise), and I got the following result.
We run, 2 Rounds, 20 iterations each one.

<img align="center" src="https://github.com/pjgg/indietxt/blob/master/complexityChart.png">


Summary
     
   ```
   Benchmark                                              (iterations)  Mode  Cnt   Score   Error  Units
   
  StockManagerPerformance.stockManagerTest                              1  avgt   20   0.006 ± 0.001  ms/op
  StockManagerPerformance.stockManagerTenItemsTest                      1  avgt   20   0.016 ± 0.001  ms/op
  StockManagerPerformance.stockManagerFiftyItemsTest                    1  avgt   20   0.140 ± 0.006  ms/op
  StockManagerPerformance.stockManagerHundredItemsTest                  1  avgt   20   0.313 ± 0.014  ms/op
  StockManagerPerformance.stockManagerTwoHundredItemsTest               1  avgt   20   0.905 ± 0.013  ms/op  
  StockManagerPerformance.stockManagerThreeHundredItemsTest             1  avgt   20   1.806 ± 0.044  ms/op
  StockManagerPerformance.stockManagerFourHundredItemsTest              1  avgt   20   3.077 ± 0.139  ms/op
  StockManagerPerformance.stockManagerFiveHundredItemsTest              1  avgt   20   4.550 ± 0.031  ms/op
  StockManagerPerformance.stockManagerSixHundredItemsTest               1  avgt   20   6.684 ± 0.165  ms/op
  StockManagerPerformance.stockManagerSevenHundredItemsTest             1  avgt   20   8.918 ± 0.173  ms/op
  StockManagerPerformance.stockManagerEighHundredItemsTest              1  avgt   20  12.289 ± 0.343  ms/op
  StockManagerPerformance.stockManagerNineHundredItemsTest              1  avgt   20  15.159 ± 0.759  ms/op
  StockManagerPerformance.stockManagerThousandItemsTest                 1  avgt   20  17.997 ± 0.246  ms/op
   ```

 1 items Test (product / stock)
 
```
Result "org.indietxt.performance.StockManagerPerformance.stockManagerTest":
  0.006 ±(99.9%) 0.001 ms/op [Average]
  (min, avg, max) = (0.004, 0.006, 0.008), stdev = 0.001
  CI (99.9%): [0.005, 0.006] (assumes normal distribution)
  ```
  
  10 items Test (product / stock)
  
  ```
 Result "org.indietxt.performance.StockManagerPerformance.stockManagerTenItemsTest":
   0.016 ±(99.9%) 0.001 ms/op [Average]
   (min, avg, max) = (0.015, 0.016, 0.017), stdev = 0.001
   CI (99.9%): [0.015, 0.016] (assumes normal distribution)
  ```
    
  50 items Test (product / stock)
  
  ```
Result "org.indietxt.performance.StockManagerPerformance.stockManagerFiftyItemsTest":
  0.140 ±(99.9%) 0.006 ms/op [Average]
  (min, avg, max) = (0.134, 0.140, 0.162), stdev = 0.007
  CI (99.9%): [0.133, 0.146] (assumes normal distribution)
  ```
    
   100 items Test (product / stock)
   
  ```
  Result "org.indietxt.performance.StockManagerPerformance.stockManagerHundredItemsTest":
    0.313 ±(99.9%) 0.014 ms/op [Average]
    (min, avg, max) = (0.301, 0.313, 0.357), stdev = 0.016
    CI (99.9%): [0.299, 0.326] (assumes normal distribution)
  ```
  
   200 items Test (product / stock)
     
    ```
    Result "org.indietxt.performance.StockManagerPerformance.stockManagerTwoHundredItemsTest":
      0.905 ±(99.9%) 0.013 ms/op [Average]
      (min, avg, max) = (0.873, 0.905, 0.929), stdev = 0.015
      CI (99.9%): [0.891, 0.918] (assumes normal distribution)
    ```
  
   300 items Test (product / stock)
     
    ```
    Result "org.indietxt.performance.StockManagerPerformance.stockManagerThreeHundredItemsTest":
      1.806 ±(99.9%) 0.044 ms/op [Average]
      (min, avg, max) = (1.722, 1.806, 1.913), stdev = 0.050
      CI (99.9%): [1.762, 1.850] (assumes normal distribution)
    ```
 
   400 items Test (product / stock)
         
     ```
     Result "org.indietxt.performance.StockManagerPerformance.stockManagerFourHundredItemsTest":
       3.077 ±(99.9%) 0.139 ms/op [Average]
       (min, avg, max) = (2.972, 3.077, 3.536), stdev = 0.160
       CI (99.9%): [2.938, 3.216] (assumes normal distribution)
     ```
     
   500 items Test (product / stock)
        
    ```
    Result "org.indietxt.performance.StockManagerPerformance.stockManagerFiveHundredItemsTest":
      4.550 ±(99.9%) 0.031 ms/op [Average]
      (min, avg, max) = (4.491, 4.550, 4.656), stdev = 0.036
      CI (99.9%): [4.519, 4.581] (assumes normal distribution)
    ```
  
  600 items Test (product / stock)
           
       ```
     Result "org.indietxt.performance.StockManagerPerformance.stockManagerSixHundredItemsTest":
       6.684 ±(99.9%) 0.165 ms/op [Average]
       (min, avg, max) = (6.576, 6.684, 7.394), stdev = 0.190
       CI (99.9%): [6.519, 6.849] (assumes normal distribution)
       ```
       
   700 items Test (product / stock)
         
     ```
    Result "org.indietxt.performance.StockManagerPerformance.stockManagerSevenHundredItemsTest":
      8.918 ±(99.9%) 0.173 ms/op [Average]
      (min, avg, max) = (8.719, 8.918, 9.522), stdev = 0.199
      CI (99.9%): [8.745, 9.091] (assumes normal distribution)
     ```
          
   800 items Test (product / stock)
       
   ```
   Result "org.indietxt.performance.StockManagerPerformance.stockManagerEighHundredItemsTest":
     12.289 ±(99.9%) 0.343 ms/op [Average]
     (min, avg, max) = (11.650, 12.289, 13.479), stdev = 0.395
     CI (99.9%): [11.945, 12.632] (assumes normal distribution)
   ```
      
   900 items Test (product / stock)
           
    ```
     Result "org.indietxt.performance.StockManagerPerformance.stockManagerNineHundredItemsTest":
       15.159 ±(99.9%) 0.759 ms/op [Average]
       (min, avg, max) = (14.204, 15.159, 17.892), stdev = 0.874
       CI (99.9%): [14.401, 15.918] (assumes normal distribution)
    ```
       
   1000 items Test (product / stock)
   
   ```
  Result "org.indietxt.performance.StockManagerPerformance.stockManagerThousandItemsTest":
    17.997 ±(99.9%) 0.246 ms/op [Average]
    (min, avg, max) = (17.761, 17.997, 18.681), stdev = 0.283
    CI (99.9%): [17.752, 18.243] (assumes normal distribution)
   ```
   
## Conclusion

Based on our studies we concluded that the current basic implementation [StockManagerReferenceImpl](https://github.com/pjgg/indietxt/blob/master/src/main/java/org/indietxt/service/impl/StockManagerReferenceImpl.java) has a exponential cyclomatic complexity level. On the first hand it's quite surprising if you have a look the method code, because if you consider a stream as a loop, then I will say that the complexity level should be 3 * O(n). 

Code snippet:
  ```
  @Override
  	public List<StockEntry> retrieveStock() {
  
  		List<ProductSize> pSize =  productSizeDAO.filterEntities(ProductSizePredicates.alwaysTrue()).collect(Collectors.toList());
  		List<Integer> ids = pSize.stream().map(ProductSize::getId).collect(Collectors.toList());
  		return stockEntryDAO.filterEntities(StockEntryPredicates.byIds(ids.toArray(new Integer[ids.size()]))).collect(Collectors.toList());
  	}
  ```
  
But the data never lie you (this could be the title of a movie ;) ). 
This exercise it's just an example of Java8 features, however if you think to move on "this code" to production you should analise the behavior with a profiler in order to understand, where the bottle neck is?. Could be memory, could be CPU... etc. 

Finally an other conclusion could be that nowadays with lambdas, static imports or default methods that inject code into your class make more fuzzy your code, in order to understand your "cyclomatic complexity" this is why is always a good reason to test your code with frameworks or libraries that "
throw a little light on your darkness". Also the numbers are not important at all (depends on your laptop, the services or programs that your are running at this moment), however the shape of your graph it's very important.

Well Thank you if you are following this exercise, and remember that you could reuse the acceptance and performance test defined in this project with your own [StockManager](https://github.com/pjgg/indietxt/blob/master/src/main/java/org/indietxt/service/StockManager.java) implementation. Just remember to add your implementation to the [ServiceLocator](https://github.com/pjgg/indietxt/blob/master/src/main/java/org/indietxt/service/StockManagerServiceLocator.java) and also update your acceptance test [given](https://github.com/pjgg/indietxt/blob/master/src/acceptance-test/java/org/indietxt/acceptanceTest/CalculateStockIT.java) step in order to add your "algorithm" name.  

```
switch(algorithm) {
            case "yourAlgorithmName"
			default:
				stockManagerSelected = stockManagerReference;
				break;
		}
```

Finally you need to update the [acceptance test definition](https://github.com/pjgg/indietxt/blob/master/src/acceptance-test/resources/features/ExerciseAcceptance.feature) and replace the keyword "ReferenceImpl" by your algorithm name. By this way you will set your implementation as a default acceptance test implementation.

Well if you have any question, or you just wanna chat about technology, you can contact me at anytime. 
  