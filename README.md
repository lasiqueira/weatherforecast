# weatherforecast
Java 16 and Spring boot 2 Weather Forecast REST API

## Setup
You need to inform an API Key for the OpenWeatherMAP API in application.properties

`apikey=MYAPIKEY`

You can get one by making a free account at [https://openweathermap.org/]

You need [JDK16+](https://jdk.java.net/) and [Gradle 7.0.2+](https://gradle.org/releases/) to build and run this project.

## Building
`gradle clean build`

## Running
`gradle bootRun`

## Documentation
(default: http://localhost:8080)  
server:port/swagger-ui.html

## Example
`curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/v1/data/cities/London/countries/GB`

