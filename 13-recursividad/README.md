# Sección 13 — Recursividad

## ¿Qué vas a aprender en esta sección?

La recursividad es una de las ideas más elegantes y poderosas de la computación: una función que se llama a sí misma para resolver un problema dividiéndolo en versiones más pequeñas de sí mismo. Un bucle repite código; la recursividad lo redefine en sus propios términos.

El secreto de toda función recursiva exitosa son dos piezas: el **caso base** (la condición que detiene la recursión) y el **paso recursivo** (cómo reduces el problema hacia el caso base). Sin caso base, tu programa se va de stack overflow — la recursión se llama infinitamente hasta que la memoria se agota. Aprenderás los ejemplos clásicos (factorial, Fibonacci) y uno más avanzado (Torres de Hanoi) que demuestra cómo la recursividad resuelve problemas que serían muy difíciles de expresar iterativamente.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `FactorialRecursivo.java` | Cálculo de factorial con y sin recursión | Caso base, paso recursivo, stack overflow, comparación iterativo vs recursivo |
| `FibonacciRecursivo.java` | Sucesión de Fibonacci recursiva | Doble recursión, árbol de llamadas, memoización con Map, explosión exponencial |
| `TorresDeHanoi.java` | Torres de Hanoi recursivo | Recursión indirecta, conteo de movimientos, complejidad O(2^n) |

## Ejemplo de salida esperada

Ejecutando `FactorialRecursivo.java`:

```
=== Factorial: Recursivo vs Iterativo ===

factorial(5): 5! = 5 * 4 * 3 * 2 * 1

--- Traza recursiva ---
factorial(5) llamado
  factorial(4) llamado
    factorial(3) llamado
      factorial(2) llamado
        factorial(1) llamado -> caso base: factorial(1) = 1
      factorial(2) = 2
    factorial(3) = 6
  factorial(4) = 24
factorial(5) = 120

Iterativo (for):    120
Recursivo:           120
```

## Tip profesional

> La recursividad es elegante pero no siempre eficiente. Cada llamada recursiva consume memoria en el stack. Problemas con recursión profunda (>10,000 niveles) lanzan `StackOverflowError`. La regla: usa recursividad cuando el problema sea naturalmente recursivo (árboles, backtracking, divide y vencerás) y tu profundidad máxima sea manejable. Para todo lo demás, la iteración es más segura y rápida. Y nunca olvides el caso base: es tu paracaídas.
