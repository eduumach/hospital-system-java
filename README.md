# Hospital System

Project proposed by [anlix-io](https://github.com/anlix-io/desafio-anlix). 

## Compile and run

### Requirements
For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)

### Running the application locally
```bash
export SPRING_DATASOURCE_URL=<your database url>
export SPRING_DATASOURCE_USERNAME=<your username database>
export SPRING_DATASOURCE_PASSWORD=<your password database>
export SPRING_JPA_HIBERNATE_DDL_AUTO=update
./mvnw spring-boot:run
```

## Docker Compose

### Requirements
To run the application with docker you need:

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Running the application locally

```bash
docker-compose up
```

## Test with newman

### Requirements
To run the test with newman you need:

- [Newman](https://www.npmjs.com/package/newman)


### Run test

To test, just run this command:

```bash
newman run collection.json
```

## Documentation

For the documentation I used postaman, and I uploaded some data on heroku to facilitate testing for anyone using the api:

- [Heroku](https://hospital-system-eduumach.herokuapp.com/)

[![Run in Postman](https://run.pstmn.io/button.svg)](https://documenter.getpostman.com/view/13970793/UVeNkMfX)

## Uploading the data

To upload the data I used a python script:

- [Uploading the data](post-data/README.md)