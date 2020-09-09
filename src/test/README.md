
                  mvn versions:display-dependency-updates

Result:

 The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-6
[INFO]   org.testng:testng ..................................... 7.1.0 -> 7.3.0

                  mvn versions:use-latest-versions
Result:

Major version changes allowed
 
                  mvn clean test


Results :

Tests run: 26, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 323.16 sec

                  mvn clean test -Dtest=CartTest,ProductSortTest
Results :   
                    
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 95.522 sec

                  mvn clean test -Dtest=ProductSortTest#sortByZtoA+sortByZtoA
Result:

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 17.751 s - in tests.ProductSortTest

                  mvn clean test -Dtest=MavenProperties -Duser=standard_user -Dpassword=secret_sauce -Dtest=CartTest#testRedMarkWithAmountItemIntoCart
Result:

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 11.048 s - in tests.CartTest

                  mvn -f pom2.xml clean test -DsuiteXmlFile=src/test/resources/smoke.xml
                  
Result:

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 64.85 s - in TestSuite
