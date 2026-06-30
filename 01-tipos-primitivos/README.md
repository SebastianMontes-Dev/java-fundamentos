# Sección 01 — Tipos Primitivos, Casting y Wrappers

## ¿Qué vas a aprender en esta sección?

Antes de escribir una sola línea de lógica, necesitas entender los ladrillos con los que Java construye todo: los 8 tipos primitivos. No son objetos, viven en el stack, y cada uno tiene un tamaño y propósito específico. Esta sección es el fundamento más importante del curso.

Aprenderás qué son `byte`, `short`, `int`, `long`, `float`, `double`, `char` y `boolean`, cuándo usar cada uno, y — crucialmente — cómo convertir entre ellos sin perder datos. El casting implícito (widening) ocurre automáticamente cuando Java sabe que no habrá pérdida; el casting explícito (narrowing) te obliga a asumir la responsabilidad porque puedes perder precisión. También cubrimos las clases envolventes (wrappers) como `Integer` y `Double`, que envuelven primitivos en objetos, y el mecanismo de autoboxing/unboxing que Java hace transparente para ti.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `TiposPrimitivos.java` | Los 8 tipos, rangos, valores por defecto y sufijos | `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`, sufijos `L`/`f`/`d`, `Character` y `Boolean` |
| `CastingYConversion.java` | Conversión entre tipos, widening vs narrowing | Casting implícito, casting explícito, pérdida de precisión, `Integer.parseInt()`, `String.valueOf()` |
| `WrapperYAutoboxing.java` | Clases envolventes, autoboxing y unboxing | `Integer`, `Double`, `Boolean`, `Character`, `.valueOf()`, `.parseXxx()`, `null` en wrappers |

## Ejemplo de salida esperada

Ejecutando `TiposPrimitivos.java`:

```
=== Los 8 Tipos Primitivos de Java ===

--- Enteros ---
byte:  8 bits, rango [-128 a 127], valor por defecto: 0
short: 16 bits, rango [-32768 a 32767], valor por defecto: 0
int:   32 bits, rango [-2.1M a 2.1M], valor por defecto: 0
long:  64 bits, valor por defecto: 0L

--- Decimales ---
float:  32 bits, precisión ~7 dígitos, sufijo: f
double: 64 bits, precisión ~15 dígitos, tipo por defecto para decimales

--- Otros ---
char:   16 bits, Unicode, rango [0 a 65535]
boolean: true o false (NO 0 o 1)
```

## Tip profesional

> Los primitivos son más rápidos que los wrappers porque viven en el stack y no requieren desreferenciar punteros. Pero los wrappers son necesarios para colecciones (`ArrayList<Integer>`, no `ArrayList<int>`), para representar la ausencia de valor (`null`) y para usar métodos utilitarios como `Integer.parseInt()`. La regla de oro: usa primitivos por defecto y wrappers solo cuando los necesites.
