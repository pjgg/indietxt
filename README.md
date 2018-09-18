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
3. [serviceMainClass](https://github.com/pjgg/indietxt/blob/master/src/main/java/org/indietxt/service/impl/StockManagerReferenceImpl.java "Service main class")
4. [StorageLayer](https://github.com/pjgg/indietxt/blob/master/src/main/java/org/indietxt/storage/AbstractDAO.java "Storage main class")

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

