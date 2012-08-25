aLiteral
========

1. Introducción
---------------
Conversor de numeros y fechas de formato numérico a formato texto

Librería cortesía de Javier Olcina (javier.olcina@uv.es)

2. Instalación
--------------
 
2.1 Requisitos Previos
----------------------
Java 1.6 o superior

3.- Configuración aplicación
----------------------------
  Dos ficheros de configuración:
    ./conf/log4j.xml --> Configuración de las trazas con log4j
    ./conf/main.properties --> Propiedades de configuración de la aplicación

4. Ejecución
------------

Si se elige una configuración de la JVM por defecto y se deja el classpath por defecto de la aplicación
que se ha generado en el fichero META-INF/MANIFEST del ${project.artifactId}-${project.version}.jar
ejecutar:

java -jar ${project.artifactId}-${project.version}.jar

Si se quiere modificar la línea de ejecución de la aplicación, o coger todos los componentes presentes en el directorios lib/
ejecutar la calculadora basta con situarse en el directorio bin y ejecutar:

cd bin
./startup.sh -->Para entornos linux
./startup.bat -->Para entornos windows


5. Documentación
----------------
Toda la documentación del proyecto está disponible en ${repoPublicSiteUrl}/${project.groupId}/${project.artifactId}

6. Compilación
--------------
mvn clean install

7. Integración con develenv
---------------------------

Para integrarlo con develenv se han de realizar los siguientes pasos:

