# Assurity Consulting API Assignment

**Description**:  This code base is created to address the test case provided in the API assignment

### Technology stack 
  - Java programing language
  - Rest assured
### Supported Operating Systems
* Windows
* Linux
* Mac

## Dependencies
- Following dependencies are used in this project
  - TestNG
  - Rest Assured
  - Jackson Databind
  - Log4j 2 api

## Prerequisites
Following dependencies should be installed before build and run the test suite.
* Java 8 or above
* Maven 3.8.x versions

#### Execute the Test Suite
1. Fist make sure the project is already built - Run the command `- mvn clean install -DskipTests=true` in terminal.(This might take some time around 2 min to download the dependencies during the fist execution)
2. Execute the suite using `- mvn clean test -Pbvt -Dsuite=TestSuite` command in terminal. 
3. Or you can run the test from the IDE

##### View Test Results Report
- Open the file `target/surefire-reports/emailable-report.html`.

Note: - if the test is executed using IDE this file will not be created/updated, in that case please refer the IDE results tab

## Test Data
- Update following folder for the test data
  - \src\main\resources\testdata\APIVerification.properties
