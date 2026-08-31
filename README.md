# Health Insurance GET API Practice Project

Stack:
- Java 21
- Spring Boot 3.5.3
- Tomcat 10.1.47
- PostgreSQL
- Spring Data JPA

## Setup

Create PostgreSQL database:

CREATE DATABASE health_insurance_db;

Then update:
src/main/resources/application.properties

spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

## Data

schema.sql creates the complete schema.
data.sql inserts 60 records into every table.

All records are connected through foreign keys:
Customer -> Policy -> PolicyMember -> Claim -> Hospital -> ClaimDocument
Policy -> PremiumPayment
Policy -> InsuranceProduct

## Practice

ServiceImpl classes are intentionally incomplete.
Implement all business logic yourself.

Start with CustomerServiceImpl and the first four scenarios.
