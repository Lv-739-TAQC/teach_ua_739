# Team: Lv-739.TAQC
_ _ _ 
### Project implementation in Java:
[Click here](https://github.com/Lv-739-TAQC/teach_ua_739)
_ _ _ 
### Description:
[***Teach Ukrainian***](https://speak-ukrainian.org.ua/dev/) website test automation project provides UI, API and DB testing with Selenium and WebDriver Manager using Page Object Model design pattern.
_ _ _ 
### Framework Overview:
Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements. It helps reduce code duplication and improves test case maintenance.  
In Page Object Model, consider each web page of an application as a class file. Each class file will contain only corresponding web page elements. Using these elements, operations on the website under test can be performed.
_ _ _  
### Technologies:
* **Selenium**  
  That is a free (open-source) automated testing framework used to validate web applications across different browsers and platforms.
* **WebDriver Manager**  
  WebDriver Manager is a web framework that permits to execute cross-browser tests. This tool is used for automating web-based application testing to verify that it performs properly.
* **Maven**  
  Maven is a build automation tool developed by Apache Software Foundation to build, publish, and deploy several projects at once for better project management. The tool allows to build and document the lifecycle framework.
* **Allure**  
  Allure Framework is a flexible lightweight multi-language test report tool that shows a very concise representation of what have been tested in a neat web report form.
* **TestNG**  
  TestNG is an automation testing framework. Using TestNG, one can generate a proper report, and can easily come to know how many test-cases are passed, failed, and skipped. Also, failed test-cases can be executed separately.
_ _ _
### Executing tests:
**Run all tests:**  
*`mvn clean test`*

**Run a single test class:**  
*`mvn test -Dtest=ClassNameTest1`*

For instance:  
`mvn test -Dtest=CentreComponentTest`

**Run multiple test classes:**  
*`mvn test -Dtest=ClassNameTest1, ClassNameTest2`*

For instance:  
`mvn test -Dtest=CentreComponentTest, ClubComponentTest`
_ _ _
### Required to install:
* *Java(1.11)*
* *Maven(4.0.0)*
_ _ _  
### Clone:
Clone this repository to your local machine using:  *`https://github.com/Lv-739-TAQC/teach_ua_739.git`*
_ _ _  
### Properties:
Create in *`src/test/resources/`* file *`data.properties`* with the following content inside:

*`baseUiUrl=https://example.org.ua`*

*`adminEmail=example@test.com`*  
*`adminPassword=example`*

*`userEmail=user@gmail.com`*  
*`userPassword=userPassword`*
_ _ _
### Allure reports:
Obtain the folder *allure-results* under *target* directory.

See reports using the following command:

*`allure serve allure-results`*
_ _ _
### Information links :
[Selenium documentation](https://www.selenium.dev/documentation/)  
[Allure documentation](https://docs.qameta.io/allure/)