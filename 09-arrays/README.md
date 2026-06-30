# Sección 15 — Arreglos (Arrays)

## ¿Qué vas a aprender en esta sección?

Un programa sin arreglos es como una oficina sin archivador: puedes trabajar con UN dato a la vez. Los arreglos te permiten almacenar COLECCIONES de datos del mismo tipo bajo un solo nombre, accediendo a cada elemento por su índice numérico. Son la estructura de datos más fundamental y la base sobre la que se construyen todas las demás.

En Java, los arreglos tienen tres características que debes interiorizar: (1) su TAMAÑO es FIJO —una vez creado, no puedes agregar o quitar elementos—, (2) los índices empiezan en CERO —el primer elemento es `arreglo[0]`, el último es `arreglo[length - 1]`—, y (3) los valores no inicializados toman VALORES POR DEFECTO —0 para números, `false` para booleanos, `null` para objetos—.

El patrón más importante que aprenderás aquí es "llenar y recorrer": usar un bucle `for` para cargar datos en el arreglo (desde Scanner, por ejemplo) y otro `for` para procesarlos. Este patrón se repite en prácticamente toda aplicación que maneje listas de datos.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `Arreglos.java` | Declaración, asignación y acceso por índice | `new int[tamaño]`, índices, valores por defecto |
| `ArreglosSintaxis.java` | Tres formas de inicializar arreglos | `{}`, `new int[]{}`, `var`, sintaxis comparada |
| `IntroducirEnterosEnArreglo.java` | Llenado dinámico con Scanner y bucle for | `Scanner` + arreglos, `arreglo.length`, recorrido |
| `IterarArreglos.java` | Recorrido de arreglos con bucle for | `for` + índice, `.length`, relación índice-valor |

## Ejemplo de salida esperada

Ejecutando `IntroducirEnterosEnArreglo.java`:

```
Ingrese el tamaño del arreglo: 3

--- Ingrese los 3 números ---
Posición 0: 10
Posición 1: 25
Posición 2: 42

--- Contenido del arreglo ---
Índice [0] = 10
Índice [1] = 25
Índice [2] = 42
```

## Tip profesional

> La propiedad `.length` de un arreglo es tu mejor amiga. NUNCA uses números mágicos como `for (int i = 0; i < 5; i++)` cuando puedes usar `for (int i = 0; i < arreglo.length; i++)`. Si mañana cambia el tamaño del arreglo, el primer código se rompe; el segundo se adapta solo. Y recuerda: `arreglo.length` es un atributo (no un método), por eso no lleva paréntesis.
