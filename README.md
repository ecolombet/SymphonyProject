#Private Project for Symphony interview.

##Goal
Provide a test automation project based on Selenium Webdriver to test Symphony login page https://my.symphony.com.

##Description
The project has been developped with Apache Maven 3.3.9,  Selenium Webdriver 3.141.59 and is based on Junit 4.
The tests and framework classes are under src.test.java.homework.symphony

##How to run tests
To run the full list of test, you can use maven cli command:

```
mvn test
```

The test runs will be managed by surefire plugin and results stored under target/surefire-reports, containing console logs and a html report per test.

The default browser used is Chrome. It can be configured with browser parameter like:

```
mvn -Dbrowser=firefox test
mvn -Dbrowser=ie test
```

The default url used is http://my.symphony.com. It can be configured with url parameter like:

```
mvn -Durl=http://test.symphony.com test
```

To run a specific test class, you can use test parameter like:

```
mvn -Dtest=SignInMissingAccountTest test
```