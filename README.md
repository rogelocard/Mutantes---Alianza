# Mutantes---Alianza
Prueba Tecnica 

Introducción:
El examen técnico consiste en el diseño y desarrollo de una API REST que cumplira las siguientes funcionalidad:
 - Analizar una secuenca de ADN y determinar si la misma correspnde a un Humano o Mutante.
 - Consultar el ratio de mutantes / humanos luego de cada analisis que fue realizado con cada api request.de las requests al api.

# Indice

-  [Examen](#examen)
  -  [Especificaciones](#especificaciones)
  -  [Implementación y tecnologias usadas](#implementaci%C3%B3n-y-tecnologias-usadas)
-  [Setup](#setup)
  -  [Instrucciones](#instrucciones)
  -  [API Url](#api)
  -  [Servicios](#servicios)
     -  [Es mutante](#es-mutante)
     -  [Estadisticas](#estadisticas)

## Examen
Este se encuentra en la carpeta "doc" del proyecto
### Implementacion y tecnologias usadas

- [Spring Boot](https://projects.spring.io/spring-boot/)
- [SL4FJ](https://www.slf4j.org/)
- [MongoDb](https://www.mongodb.com/)

## Setup

### Instrucciones
Para poder correr la app de forma local unicamente son necesarios 2 requisitos:
  - Java JDK 1.8
  - Maven

Una vez que confirmamos que cumplimos ambos requisitos se deben realizar los siguientes pasos:
  - Clonar este repositorio: https://github.com/rogelocard/Mutantes---Alianza
  - Ejecutar desde su IDE la clase AlianzaPruebaTecnicaApplication.java para iniciar la App.

Una vez que la aplicacion se inicie, se pueden realizar las request a la API.

El puerto por defecto de la API es 8080.

### API Url

URL local: http://localhost:8080

### Servicios
#### Es mutante

Request: 
- POST http://localhost:8080/mutant

Request body (secuencia ADN mutante):

```
  {"dna":["TTTTGA", "ATGTGC", "AGTTGG", "AGATGG", "CCCCTA", "TCGCTG"]}
```

#### Estadisticas

Request: 
- GET #### Estadisticas

Request: 
- GET http://detect-mutant.sa-east-1.elasticbeanstalk.com/stats

Response: 200 (application/json)

```
{
    count_mutant_dna: 0,
    count_human_dna: 0,
    ratio: 0.0
}
```


