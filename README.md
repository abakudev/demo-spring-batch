# Spring Batch Example

Practical example of Spring Batch.

## Description

This service imports data from a CSV spreadsheet, transforms it with custom code and stores the final results in a database.

## Getting Started

### Dependencies 

What do you need?

* Java 11 or later
* Spring Boot
* Maven 3.2+

### Installing

  ```
  mvn clean install
  ```

### Executing program

  ```
  mvn spring-boot:run
  ```

### Test

Load CSV to DB

  * http://localhost:8081/batch/start - Trigger point for Spring Batch
  * http://localhost:8081/h2-console - H2 Console for querying the in-memory tables.
  