# Sección 15 — Programación Orientada a Objetos (Básica)

## ¿Qué vas a aprender en esta sección?

Este es el punto de inflexión. Hasta ahora has escrito programas procedurales: datos por un lado, funciones por otro. La Programación Orientada a Objetos (POO) cambia el paradigma: ahora los DATOS y los MÉTODOS que operan sobre ellos viven JUNTOS dentro de una CLASE. Una clase es un molde. Un objeto es una instancia concreta creada a partir de ese molde.

Aprenderás los cuatro conceptos fundacionales: (1) **clases** como plantillas con atributos y métodos, (2) **constructores** para inicializar objetos en el momento de crearlos con `new`, (3) la palabra clave **`this`** para referenciar el objeto actual y diferenciar atributos de parámetros, y (4) **encapsulamiento** —ocultar los detalles internos con `private` y exponer solo lo necesario mediante getters y setters públicos.

Encapsulamiento merece énfasis: es lo que separa un programa que "funciona" de uno que está BIEN DISEÑADO. Al hacer los atributos privados, controlas exactamente cómo se modifican, puedes validar datos en los setters y puedes cambiar la implementación interna sin romper el código que usa tu clase. Es el concepto que más impacta la mantenibilidad a largo plazo.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `ClasePersona.java` | Definición de clase, atributos, métodos y creación de objetos | `class`, `new`, atributos, métodos, operador `.` |
| `Constructores.java` | Constructores con y sin parámetros, sobrecarga | `Constructor()`, sobrecarga, valores por defecto |
| `UsoThis.java` | Palabra clave `this` y encadenamiento de constructores | `this.atributo`, `this()`, diferenciar parámetro de atributo |
| `Encapsulamiento.java` | Atributos privados con getters y setters públicos | `private`, `public`, `getSaldo()`, `set` con validación |
| `ClasePrincipal.java` | Integración de múltiples clases + métodos con retorno | Orquestación, `return`, clases trabajando juntas |

## Ejemplo de salida esperada

Ejecutando `ClasePersona.java`:

```
=== Creando objetos a partir de una clase ===

Nombre: Carlos Mendoza | Edad: 28 años
Nombre: María García | Edad: 34 años
```

## Tip profesional

> En Java, cada archivo `.java` puede contener UNA sola clase pública (con el mismo nombre del archivo) y múltiples clases no públicas. En estos ejercicios ponemos varias clases en un mismo archivo por simplicidad educativa. En un proyecto real, cada clase pública va en su propio archivo. También: usa `this.` para acceder a atributos aunque no haya ambigüedad —deja claro que es un atributo de instancia, no una variable local.
