# Sección 05 — Operadores

## ¿Qué vas a aprender en esta sección?

Los operadores son los verbos de cualquier lenguaje de programación: suman, restan, comparan, asignan, incrementan. Java clasifica sus operadores en varios grupos, y esta sección cubre los tres más fundamentales: **aritméticos**, **unitarios** y **de asignación**.

Hay dos trampas famosas que todo principiante debe conocer: (1) la división entera — `5 / 2` da 2, no 2.5, porque ambos operandos son enteros; y (2) la diferencia entre `++a` (pre-incremento) y `a++` (post-incremento) — uno incrementa ANTES de usar la variable, el otro DESPUÉS. Estos comportamientos no son aleatorios: están perfectamente definidos y son consistentes. Entenderlos es la diferencia entre código que funciona y horas de debugging confuso.

El ejercicio del ticket de venta te muestra cómo estos operadores trabajan juntos en un contexto práctico, porque en el mundo real nunca usas un operador aislado.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `OperadoresAritmeticos.java` | Suma, resta, multiplicación, división y módulo | `+`, `-`, `*`, `/`, `%`, división entera |
| `OperadoresUnitarios.java` | Pre y post incremento/decremento | `++a` vs `a++`, `--a` vs `a--`, `+a`, `-a` |
| `OperadorSimpleYCompuesto.java` | Asignación simple y compuesta | `=`, `+=`, `-=`, `*=`, `/=`, `%=` |
| `TicketVenta.java` | Ticket de compra con cálculo de impuesto | `+`, `%`, `printf()`, aplicación práctica |

## Ejemplo de salida esperada

Ejecutando `OperadoresUnitarios.java`:

```
=== Operadores Unitarios ===
Valor base: a = 6

+a              → resultado = 6, a = 6
-a              → resultado = -6, a = 6
resultado = ++a → resultado = 7, a = 7
resultado = --a → resultado = 5, a = 5
resultado = a++ → resultado = 6, a = 7
resultado = a-- → resultado = 6, a = 5
```

## Tip profesional

> Los operadores compuestos (`+=`, `-=`, etc.) no solo son más cortos: evitan repetir el nombre de la variable, lo que reduce bugs de tipeo. Un `+=` también maneja automáticamente el casting: `byte b = 10; b += 5;` compila, mientras que `b = b + 5;` no (porque `b + 5` promueve a `int`). Úsalos siempre que puedas.
