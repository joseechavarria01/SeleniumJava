
# Proyecto ejemplo Selenium + Java + Cucumber + BDD

## Estructura del proyecto

src
- main
  - pages: Se guardan todas las clases que representan las páginas del proyecto
  - helper
  - utils
    - driver
    - config
    - logger

test
- java
    - Cucumber
        - common: Configuraciones globales que se comparten entre los tests.
        - config: Devuelve la instancia del `TestContext` que alberga las configuraciones para todos los tests.
        - step: Se implementan los pasos del archivo feature.
        - TestRunner.java
    - resources
        - features: Aquí se encuentran todos los archivos feature.


---

Proyecto construido en el IDE IntelliJ aplicando el patrón de diseño **POM** con **Page Factory**, también implementa la metodología de desarrollo **BDD** en lenguaje **Gherkin** utilizando **Cucumber**.

## Requisitos
- **Java JDK 17**
- **Maven**
- **IntelliJ**

## Cómo ejecutar la prueba
1. Ejecutar la clase `TestRunner.java`, que es el ejecutor de las pruebas creadas para Cucumber.
2. Los reportes se generan en la carpeta `report` en la raíz del proyecto, pero puede configurarse en la clase `TestConstant` que se encuentra en la carpeta `utils`.
3. Si se activan las capturas de pantalla en los reportes, estas se guardan en la carpeta `screenshot` (esto se activa en el archivo `config.json`).
4. Los logs se generan en la carpeta `logs` en la raíz del proyecto.
5. Las configuraciones del driver se cargan desde el archivo `config.json` ubicado en `test -> resources`. Actualmente, solo soporta los navegadores **Chrome** y **Firefox**.  
