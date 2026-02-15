- Sistema de Gestión Inmobiliaria

Sistema desarrollado en Java que modela el funcionamiento de una inmobiliaria, permitiendo administrar clientes, propiedades, publicaciones y operaciones inmobiliarias (alquileres y ventas).

El proyecto está diseñado bajo los principios de Programación Orientada a Objetos (POO), aplicando herencia, encapsulamiento y modelado de dominio para representar correctamente la lógica del negocio.

- Objetivo

Modelar un sistema inmobiliario aplicando buenas prácticas de diseño orientado a objetos, organizando las entidades principales del dominio y sus relaciones mediante una arquitectura clara y modular.

El foco del proyecto está en:

Modelado correcto de entidades

Uso adecuado de herencia

Separación de responsabilidades

Gestión dinámica de colecciones con ArrayList

- Tecnologías Utilizadas

Java (JDK 17 o compatible)

Eclipse IDE for Java Developers (includes Incubating components)

Versión: 2025-06 (4.36.0)

Proyecto modular (module-info.java)

Estructuras dinámicas con ArrayList

- Diseño Orientado a Objetos

El sistema aplica los siguientes conceptos fundamentales:

+ Clase abstracta

+ Herencia

+ Encapsulamiento

+ Relaciones entre objetos

+ Organización por paquetes

+ Gestión de colecciones dinámicas (ArrayList)

+ Modelado de dominio

+ Modelo del Sistema

El dominio del sistema está compuesto por las siguientes clases:

- Cliente

Representa a las personas que realizan operaciones inmobiliarias dentro del sistema.

- Propiedad (Clase Abstracta)

Propiedad es una clase abstracta que define las características comunes a todas las propiedades inmobiliarias.

Contiene los atributos y comportamientos compartidos, evitando duplicación de código y permitiendo extender el modelo de manera escalable.

- Casa

Clase concreta que hereda de Propiedad, representando propiedades tipo casa con características específicas.

- Departamento

Clase concreta que hereda de Propiedad, representando propiedades tipo departamento.

- Publicacion

Modela la publicación de una propiedad, permitiendo vincularla con información relevante para su oferta.

- OperacionInmobiliaria

Representa operaciones como alquiler o venta, vinculando:

Cliente

Propiedad

Tipo de operación

- Sistema

Clase encargada de administrar las colecciones principales del sistema mediante el uso de ArrayList, centralizando la lógica de gestión.

+ Funcionalidades

Registro de clientes

Registro de propiedades

Diferenciación entre casas y departamentos mediante herencia

Creación de publicaciones

Registro de operaciones (venta / alquiler)

Listado de entidades registradas

Gestión dinámica de datos en memoria con ArrayList

- Estructura del Proyecto
src/
 ├── modelo/
 │   ├── Propiedad.java (abstract)
 │   ├── Casa.java
 │   ├── Departamento.java
 │   ├── Cliente.java
 │   ├── Publicacion.java
 │   ├── OperacionInmobiliaria.java
 │   └── Sistema.java
 │
 └── test/
     └── Test.java


modelo/ → Contiene las entidades del dominio.

test/ → Clase principal para ejecución.

module-info.java → Configuración modular del proyecto.

- Cómo Ejecutar
Desde Eclipse

Clonar el repositorio:

git clone https://github.com/tuusuario/sistema-gestion-inmobiliaria.git


Importar como Existing Java Project

Ejecutar Test.java

Desde consola

Compilar:

javac src/modelo/*.java src/test/*.java


Ejecutar:

java test.Test

(Posibles Mejoras Futuras)

Persistencia con base de datos (MySQL / PostgreSQL)

Interfaz gráfica (JavaFX / Swing)

Implementación de patrones de diseño

Sistema de búsqueda avanzada

Exportación de reportes

API REST para integración con aplicaciones web

--> Enfoque Profesional

Este proyecto demuestra:

Capacidad de modelado orientado a objetos

Uso correcto de clases abstractas

Aplicación de herencia

Organización modular del código

Manejo de colecciones dinámicas

Separación clara entre dominio y ejecución



--> Es un proyecto personal desarrollado para fortalecer habilidades en Java y diseño orientado a objetos.
