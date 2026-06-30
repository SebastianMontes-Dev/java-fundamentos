# Sección 10 — Métodos (Funciones)

## ¿Qué vas a aprender en esta sección?

Si has llegado hasta aquí, probablemente has escrito varios `main` que empiezan a ser largos y difíciles de seguir. Los métodos (también llamados funciones) son la solución: te permiten dividir tu programa en BLOQUES REUTILIZABLES con un nombre descriptivo, parámetros de entrada y un valor de retorno.

Un método bien diseñado hace UNA sola cosa y la hace bien. Esta sección te introduce a los conceptos fundamentales: cómo declarar un método con `static` (para que pueda ser llamado desde `main` sin crear objetos), cómo definir parámetros para recibir datos externos, y cómo usar `void` cuando el método no devuelve nada versus un tipo de retorno cuando sí devuelve un valor.

Esta sección es intencionalmente corta porque actúa como puente hacia la Programación Orientada a Objetos. En POO, los métodos viven dentro de objetos y ganan todo su poder. Pero los fundamentos de declaración, parámetros y retorno que aprendes aquí se aplican exactamente igual.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `Funciones.java` | Declaración e invocación de un método | `static`, `void`, parámetros, llamado desde `main` |

## Ejemplo de salida esperada

```
=== Invocando un método desde main ===

Mensaje: Hola mundo desde Java
Mensaje: ¡Los métodos hacen el código reutilizable!
```

## Tip profesional

> Nombra tus métodos con VERBOS en infinitivo o imperativo: `calcularTotal()`, `enviarCorreo()`, `validarEntrada()`. Esto hace que el código se lea como una frase: `if (usuario.validarEntrada())` es mucho más claro que `if (usuario.check())`. Y recuerda: un método que hace más de una cosa debería ser dos métodos.
