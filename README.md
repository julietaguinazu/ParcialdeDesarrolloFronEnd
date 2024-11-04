PARCIAL DE DESARROLLO DE SOFTWARE - EXAMEN MAGNETO
En el proyecto permite detectar humanos mutantes a través del análisis de una secuencia de ADN organizada en una matriz. Según la API, una secuencia se considera mutante si se identifican más de una serie de cuatro letras iguales en cualquier dirección: horizontal, vertical o diagonal.

COMO ES EL DESAFIO
En el mismo se persiven distintos niveles con diferentes dificultades.Para este proyecto estamos empleando Java con el framework Spring.
En el codigo se recibe un arreglo de String donde cada String es una fila de una tabla.Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.

Enlace para Pruebas y Documentación , para verificar el proyecto 

- Swagger UI: Si la API está en funcionamiento, puedes realizar pruebas en :
  http://localhost:8080/swagger-ui/index.html#/mutant-stats-controller/getMutantStats

- Postman: También puedes utilizar Postman para realizar pruebas. En el proyecto, se incluye el archivo ParcialMagneto.postman_collection.json que contiene:

  - Una petición POST con ejemplo de ADN mutante para verificar.Recibe un JSON con la matriz de ADN y determina si es mutante, si lo es tirara como respuesta un true y si no un false.

  - Una petición GET que muestra las estadísticas de verificación de ADN. Devuelve un JSON con el conteo de mutantes y humanos verificados indicando cuantos humanos , cuantos mutantes y el ratio .
