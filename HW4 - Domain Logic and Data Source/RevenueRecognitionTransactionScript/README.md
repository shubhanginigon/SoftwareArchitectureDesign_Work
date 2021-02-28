># Revenue Recognition with Transaction Script

This spring boot application is for revenue recognition where, users should be able to (1) add contract which would insert revenue recognition, (2) calculate recognized revenue as of some date

I have created this application with two approaches 

1) Transaction Script with Table Data Gateway

2) [Domain Model with JPA](https://github.com/shubhanginigon/HW/tree/main/HW4%20-%20Domain%20Logic%20and%20Data%20Source/RevenueRecognitionDomainModel)

>### Prerequisites

> Create the spring boot project with following dependencies:

1) Lombok - for reducing boilerplate code

2) JDBC API - api for database interaction

3) H2 - in-memory database (feel free to use others)

4) Spring Web - provides controllers and MVC support

> Also add following dependencies from [Maven Repository](https://mvnrepository.com/)

1) Money-api and moneta - for working with currency file

2) Tomcat jasper - for working with jsp file

3) Jackson xml - in case you would like to work with xml file

4) Jstl - for rendering ModelAndView objects in jsp files

> Add application properties for data source H2

![alt](./img/appProperties.PNG)

>### Steps to create application 

> <b>Create Script</b>

> 1. Create script package with following scripts

>> - RevenueRecognitionScript.java(Interface)

![alt](./img/rrScript.PNG)

>> - RevenueRecognitionScriptImpl.java: we are using money api (e.g., Monetary)

![alt](./img/rrScriptIm1.PNG)

![alt](./img/rrScriptIm2.PNG)

> <b>Create Data Gateways</b>

>> - AbstractTableDataGateway.java (Abstract class): DataSource which is provided by JDBC API and automatically search the database for you 

![alt](./img/abstractGate.PNG)

>> - ProductTableDataGateway.java

![alt](./img/productGate.PNG)

![alt](./img/productGate2.PNG)

>> - ContractTableDataGateway.java

![alt](./img/contractGate1.PNG)

![alt](./img/contractGate1.PNG)

>> - RevenueRecognitionTableDataGateway.java

![alt](./img/rrGate1.PNG)

![alt](./img/rrGate2.PNG)


> <b>Create Helpers</b>

>> - DollarHelper.java 

![alt](./img/dollar.PNG)

> <b>Create Factory</b>

>> - RevenueRecognitionFactory.java

![alt](./img/rrFactory1.PNG)

![alt](./img/rrFactory2.PNG)

> <b>Create Controllers</b>

>> - ScriptController.java: Autowired our RevenueRecognitionScript which contains all our business logic, and our DollarHelper

![alt](./img/scriptCon1.PNG)

![alt](./img/scriptCon2.PNG)

>> - HomeController.java: render the web UI for users to interact, which the UI will in turn route the request to ScriptController.java. autowiring some gateways so we can find some info to show to the web UI

![alt](./img/homeCon.PNG)

![alt](./img/homeCon1.PNG)

> <b>Create Views</b>

>> - Home.jsp

![alt](./img/home.PNG)

>> - checkrr.jsp

![alt](./img/checkrr.PNG)

>> - showrr.jsp

![alt](./img/showrr.PNG)

>> Add Data in data.sql

![alt](./img/data.PNG)


>## Output 

> - Home 

![alt](./img/homepage.PNG)

> - Check Revenue page

![alt](./img/check.PNG)

> - Show Revenue

![alt](./img/show.PNG)
