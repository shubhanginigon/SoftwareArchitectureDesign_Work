># Revenue Recognition with Domain Model 

This spring boot application is for revenue recognition where, users should be able to (1) add contract which would insert revenue recognition, (2) calculate recognized revenue as of some date

I have created this application with two approaches 

1) [Transaction Script with Table Data Gateway](https://github.com/shubhanginigon/HW/tree/main/HW4%20-%20Domain%20Logic%20and%20Data%20Source/RevenueRecognitionTransactionScript)

2) Domain Model with JPA

>### Prerequisites

> Create the spring boot project with following dependencies:

1) Lombok - for reducing boilerplate code

2) JPA dependency

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

> <b>Create Models</b>

> 1. Create model package with following classes

>> - Product.java: The use of @Transient which indicates the variable that will not be included in the database. Also @PostLoad which indicates the method that needs to be executed after find/query the object

![alt](./img/product.PNG)

>> - Contract.java:The @ManytoOne product and @OneToMany which uses CascadeType.ALL + orphanRemoval = true to make sure all revenue recognitions will be removed if its associated contract is removed

![alt](./img/contract1.PNG)

>>  - To keep BigDecimal revenue_ (which persist in Database) and MonetaryAmount revenue (which is used as object for money) consistent, we put this conversion on PrePersist and PostLoad

![alt](./img/contract2.PNG)

>> - RevenueRecognition.java: fetchType is set to Lazy, so it does not require to load all revenue recognition until it is needed. Similarly, PrePersist and PostLoad keeps amount consistent between Monetary and BigDecimal

![alt](./img/rr1.PNG)

![alt](./img/rr2.PNG)

> <b>Create Dao</b>

- These are the JPA Repositories.

>> - ContractJPADao.java

![alt](./img/contractDao.PNG)

>> - ProductJPADao.java

![alt](./img/productDao.PNG)

>> - RevenueRecognitonJPADao.java

![alt](./img/rrDao.PNG)

> <b>Create Helpers</b>

- Jpa does not know how to automatically convert LocalDate to sql date.JPA is implemented with a default AttributeConverter interface which we can create a class to implement this interface, and define the rules to convert LocalDate to sql date

>> - LocalDateConverter.java: @Converter(autoApply=true) which makes sure this converter will apply to any LocalDate or any type define in the AttributeConverter<ConvertedFrom, ConvertedTo)

![alt](./img/localDate.PNG)

>> - DollarHelper.java 

![alt](./img/dollar.PNG)

> <b>Create Recognition Strategy</b>

-  We first create an interface, and then implement two concrete implementations.

>> - RecognitionStrategy.java(Interface)

![alt](./img/recognition.PNG)

>> - CompleteRecognitionStrategy.java 

![alt](./img/complete.PNG)

>> - ThreeWayRecognitionStrategy.java

![alt](./img/threeway.PNG)

![alt](./img/threeway1.PNG)

> <b>Create Services</b>

- Creating some facade to help in general logic, and service to help implement business logic.

>> - RevenueRecognitionFacade.java(Interface)

![alt](./img/rrFacade.PNG)

>> - RevenueRecognitionService.java(Interface)

![alt](./img/rrService.PNG)

>> - RevenueRecognitionFacadeImpl.java

![alt](./img/rrFacadeIm.PNG)

>> - RevenueRecognitionServiceImpl.java: the use of @Transactional which is needed for inserting information into Revenue Recognition tables on calculateRevenueRecognition method. If you decide not to use @Transactional, then calculateRevenueRecognition require a save method

![alt](./img/rrServiceIm.PNG)

> <b>Create Controllers</b>

>> - HomeController.java

![alt](./img/homeCon.PNG)

>> - DomainModelController.java

![alt](./img/domainCon.PNG)

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

> - Homepage

![alt](./img/homepage.PNG)

> - Check Revenue page

![alt](./img/check.PNG)

> - Show Revenue

![alt](./img/show.PNG)
