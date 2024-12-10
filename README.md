#Proyecto ejemplo Selenium + Java + Page Factory 

##Estructura del proyecto
main 
    -> main
        -> pages
        -> helper
        -> utils
            -> driver
            -> config
            -> logger
test 
    -> java
        -> test

#Proyecto ejemplo Selenium + Java + Cucumber + BDD

##Estructura del proyecto

main
    -> main
        -> pages: se guardan todas clases que representan las paginas del proyecto 
        -> helper 
        -> utils
            -> driver
            -> config
            -> logger
test
    -> java
        -> Cucumber
            -> common: configuraciones globales que se compartene entre los test.
            -> config: Devuelve la instancia del TextContext que alberga las configuraciones para tosos los test.
            -> step: Se implementan los pasos del archivo feature
            TestRunner.java
    -> resources
        -> features: Aqui se encuentran todos los achivos feature.

Proyecto construido en el IDE IntelliJ aplicando el patron de diseño POM con Page Factory, tambien implementa la metodologia de desarrollo BDD en lenguaje Gherkin utilizando Cucumber.

Requisitos

Java JDK 17
Maven
IntelliJ

Como ejecutar la prueba
 
Ejecutar la clase  TestRunner.java que es el ejecutor de las pruebas creadas para cucumber

Los reportes se crean en la carpeta report en la raiz de proyecto pero puede configurarse en la clase TestConstant que se encuentra en la carpeta utils
Si se activan las capturas de pantalla en los reportes, estan se guardan en la carpeta screenshopt(esto se activa en el archivo config.json)
Los logs se crean en la carpeta logs en la raiz de proyecto

Las configuraciones de driver se cargan desde el archivo config.json que se encuentra en la ruta test-> resources 
actualmente solo soporta los navegadores chrome y firefox.