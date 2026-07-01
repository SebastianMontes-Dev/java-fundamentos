# Sección 14 — Matrices y Arrays Multidimensionales

## ¿Qué vas a aprender en esta sección?

Hasta ahora trabajaste con arreglos de una dimensión: una simple fila. Pero el mundo no es unidimensional: una hoja de cálculo es una matriz, una imagen es una cuadrícula de píxeles, un tablero de ajedrez es 8x8. Los arreglos bidimensionales (matrices) son la herramienta para modelar estos escenarios.

En Java, una matriz es "un arreglo de arreglos": `int[][]`. Esto tiene una consecuencia interesante: las filas pueden tener diferentes longitudes (jagged arrays). Aprenderás a declarar, inicializar y recorrer matrices con bucles anidados, a realizar operaciones como suma de matrices y transpuesta, y a trabajar con arrays escalonados que optimizan memoria cuando las filas no son uniformes.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `MatricesBasicas.java` | Declaración, inicialización y recorrido de matrices | `int[][]`, `.length` para filas/columnas, `for` anidado, `for-each` en 2D, `Arrays.deepToString()` |
| `OperacionesMatrices.java` | Suma, transpuesta y operaciones matriciales | Suma elemento a elemento, transpuesta (filas↔columnas), inicialización con valores, validación de dimensiones |
| `MatrizIrregular.java` | Arrays escalonados (jagged arrays) | Filas de diferente longitud, ahorro de memoria, casos de uso reales (tablas sparse) |

## Ejemplo de salida esperada

Ejecutando `MatricesBasicas.java`:

```
=== Matrices (Arrays 2D) ===

--- Declaración e Inicialización ---
[1, 2, 3]
[4, 5, 6]
[7, 8, 9]

Número de filas:    3
Número de columnas: 3
Elemento [1][1]:     5 (centro)

--- Recorrido con for anidado ---
Fila 0: 1 2 3
Fila 1: 4 5 6
Fila 2: 7 8 9

--- Recorrido con for-each ---
1 2 3 4 5 6 7 8 9
```

## Tip profesional

> `matriz.length` te da el número de FILAS. Para las columnas necesitas `matriz[fila].length`. Esto es fuente constante de errores en principiantes. En bucles anidados, la convención es usar `i` para filas (externo) y `j` para columnas (interno). Y para imprimir matrices bonito, `Arrays.deepToString(matriz)` es tu mejor amigo: convierte `int[][]` a `[[1, 2, 3], [4, 5, 6]]` en una línea.
