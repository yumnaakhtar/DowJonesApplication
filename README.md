# DowJonesApplication

## Background
This SpringBoot Application allows a user to perform any of the three functions below:
  1) Upload a Bulk Data Set
  2) Query Data by Stock Ticker
  3) Add a New Record

## Usage
In order to use this application, MongoDB should be installed on your computer. Ensure you are in the directory of DowJonesApplicationSpring before running the commands below.

  1) Compile with Maven using the following command:
      ```
      mvn clean install 
      ```
  2) Run the application with the following command:
      ``` 
      java -jar target/DowJonesApplicationSpring-0.0.1-SNAPSHOT.jar 
      ```
  3) Open the URL below to see the application:
        http://localhost:8080/
        
## Technologies Used
This application leverages the following technology:
  1) Spring Boot
  2) MongoDB
  
## How to Use Application
  1) Upload Bulk Data Set: After choosing this option from the homepage, you will be redirected to a page where you can upload a CSV file. In this repository, a CSV file is uploaded with the name "dow_jones_index.csv". Please upload this file for this step. This file can be found in the same level as the README.md page, one step above the DowJonesApplicationSpring folder.
  2) Query by Stock Ticker: After choosing this option from the homepage, you will be redirected to a page where you can enter a ticker and view the information for all of the stocks in the database with this ticker. If there are no stocks with this ticker, you will see a "No Records Found" message on screen. 
  3) Add a New Record: After choosing this option from the homepage, you will be redirected to a page where you can enter details of a new stock you would like to add to the database. The stock ticker field is mandatory and if you do not enter a stock ticker, an error message will appear. Once a record is added to the database, you can go back to the Query by Stock Ticker page and query the stock you just added to the database.
  4) There are unit tests which run automatically on the command mvn clean install. They can also be run using an IDE (run as JUnit Test). These tests can be found under DowJonesApplicationSpring\src\test\java\com\dowjones\tests\DowJonesApplicationSpringApplicationTests.java.
  
  
 ## Author
  Yumna Akhtar
