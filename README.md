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

## Upload data to database

### Requirements
To run the tests you will need:

- [Python](https://www.python.org/downloads/)

### Upload

First you will have to download the data from the anlix-io repository and 
paste the "dados" folder in post-data, now just run the commands:

```bash
cd post-data
python -m venv venv
source venv/bin/activate
pip install pandas
pip install requests
python main.py
```
Now the entire database is in your database.

## Test with newman

### Requirements
To run the test with newman you need:

- [Newman](https://www.npmjs.com/package/newman)


### Run test

To test, just run this command:

```bash
newman run collection.json
```
