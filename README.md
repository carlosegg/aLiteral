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

3. Configuración aplicación
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


5. Compilación
--------------
mvn clean install

6. Integración con ![develenv] (http://develenv.softwaresano.com)
---------------------------

Para integrarlo con ![develenv] (http://develenv.softwaresano.com) se han de realizar los siguientes pasos:

* Acceder por ssh a develenv

```
ssh root@develenv
su - develenv
cd app/jenkins/jobs
mkdir -p aLiteral
wget https://raw.github.com/carlosegg/aLiteral/master/src/main/jenkins/aLiteral/config.xml
```

* Recargar la configuración de jenkins

 En un navegador acceder a http://develenv/jenkins/reload para que cargue la configuración del job de jenkins (aLiteral)

* Ejecutar el job de jenkins correspondiente a aLiteral
 Si la ejecución es correcta se deben haber creado los siguientes links

Site del proyecto: http://develenv/sites/es.uv/aLiteral/
Métricas del proyecto: http://develenv/sonar/project/index/es.uv:aLiteral
Artefacto del proyecto: http://develenv/nexus/content/groups/public-snapshots/es/uv/aLiteral/0.0.1-SNAPSHOT/

