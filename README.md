# reactive-programming
This is a project that uses spring web flux
![Issues](https://img.shields.io/github/issues/ricardohsmello/reactive-programming) 
![Forks](https://img.shields.io/github/forks/ricardohsmello/reactive-programming) 
![Stars](https://img.shields.io/github/stars/ricardohsmello/reactive-programming) 
![Release Version](https://img.shields.io/github/release/ricardohsmello/reactive-programming)

[![Build Status](https://travis-ci.org/ricardohsmello/reactive-programming.svg?branch=main)](https://travis-ci.org/ricardohsmello/reactive-programming)
[![Coverage Status](https://coveralls.io/repos/github/ricardohsmello/reactive-programming/badge.svg?branch=main)](https://coveralls.io/github/ricardohsmello/reactive-programming?branch=main)

# Reactive Programming

## Built With

- [`Kotlin`](https://kotlinlang.org/) - Language
- [`Spring-boot`](https://spring.io/projects/spring-boot) - world's most popular Java framework.
- [`MongoDB`](https://www.mongodb.com/) - MongoDB Atlas is a multi-cloud database service
- [`Docker`](https://www.docker.com//) - Docker is an open platform for developing, shipping, and running applications

 # Usage
## Cloning the repo

First of all we need clone the repo:
```
$ git clone https://github.com/ricardohsmello/reactive-programming.git
```
## Running sonarqube 

```
$ cd reactive-programming
$ docker-compose up -d
$ ./gradlew sonar -Dsonar.host.url=http://localhost:7000/
```

If everything its correct, the sonar will be available on: 

```
http://localhost:7000/
```

![Sonarqube](https://s1.imghub.io/9QW8d.png)


## Endpoints
### GET /fund/all
- Response: Code 200
```
[
    {
        "id": "dae245e5-e460-46bf-8482-09cb06ad3325",
        "name": "MGSF11"
    },
    {
        "id": "ff6339ec-663b-4340-a231-a60e8c14b876",
        "name": "Ricas"
    }
]
```

### POST fund/ 
- Response: Code 200
```json
[
    {
        "name": "FundName"
    }
]
```

### POST fund/delete/{id} 
- Response: Code 201
