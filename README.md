# flagpicker

Pre-Requisite:
 Mongo DB, Java 1.8

Instructions: 
1. Download and run it as a Springboot program. Convert to Maven project if the spring boot option doesn't appear by default.
2. This has 2 REST services. One to fetch the continents and next one is to fetch the countries based on name.
3. JUnit test cases are available in the test directory from the REST controllers onwards.
4. Actuator framework is plugged in to know the health of application.
5. This uses NoSQL MongoDB as the backend Database.
6. To create a standalone jar. Do 'mvn clean intall' from the flagpicker directory.
7. java -jar target/FlagPicker-0.0.1-SNAPSHOT.jar


Services:
This will fetch all continents
http://localhost:8080/FlagPicker/continents

Search url for a continent. This will fetch America and Africa. It's case insensitive.
http://localhost:8080/FlagPicker/continents?name=ca

This will fetch the countries
http://localhost:8080/FlagPicker/countries?names=USA,India

Acutator Url:
http://localhost:8080/FlagPicker/actuator/health
