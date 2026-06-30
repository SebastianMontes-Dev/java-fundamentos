# Sección 12 — Utilidades de Java: Math, Arrays, Collections, Character y System

## ¿Qué vas a aprender en esta sección?

Java viene con un arsenal de clases utilitarias que te ahorran escribir desde cero lo que ya está resuelto. Esta sección es un "tour de atajos" por las 5 clases que más vas a usar en tu día a día como desarrollador Java.

`Math` tiene todo lo que necesitas para cálculos: máximo, mínimo, potencias, raíces, redondeo y trigonometría. `Arrays` te da herramientas para ordenar, buscar y manipular arreglos. `Collections` hace lo mismo para listas, conjuntos y mapas. `Character` clasifica y transforma caracteres. `System` te conecta con el sistema operativo: tiempo, propiedades, copia de arrays de bajo nivel, y la consola. Conocer estas clases es lo que separa a un principiante que reinventa la rueda de un desarrollador que usa las herramientas que ya existen.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `ClaseMath.java` | Operaciones matemáticas avanzadas | `max()`, `min()`, `abs()`, `pow()`, `sqrt()`, `round()`, `ceil()`, `floor()`, `random()`, `hypot()`, `log()` |
| `ClaseArrays.java` | Manipulación de arreglos con java.util.Arrays | `sort()`, `binarySearch()`, `fill()`, `copyOf()`, `asList()`, `toString()`, `deepToString()`, `equals()` |
| `ClaseCollections.java` | Operaciones sobre listas y colecciones | `sort()`, `reverse()`, `shuffle()`, `min()`, `max()`, `frequency()`, `binarySearch()`, `fill()` |
| `ClaseCharacterYSystem.java` | Utilidades de caracteres y sistema | `isDigit()`, `isLetter()`, `isWhitespace()`, `toUpperCase()`, `System.currentTimeMillis()`, `System.arraycopy()`, `System.getProperty()` |

## Ejemplo de salida esperada

Ejecutando `ClaseMath.java`:

```
=== La Clase Math ===

max(45, 22)  = 45
min(45, 22)  = 22
abs(-15)     = 15
pow(2, 8)    = 256.0
sqrt(144)    = 12.0
round(4.7)   = 5
ceil(4.3)    = 5.0
floor(4.7)   = 4.0
random()     = 0.7234198...
```

## Tip profesional

> Las clases utilitarias están llenas de métodos `static` — no necesitas instanciarlas. `Math.max(a, b)` siempre está disponible. Pero no te aprendas todos los métodos de memoria: la documentación de Java (`javadoc`) es tu mejor amiga. En el IDE, escribe `Math.` y deja que el autocompletado te muestre las opciones. La diferencia entre un buen desarrollador y uno excelente no es memorizar la API, sino saber QUE existe y DÓNDE buscarla.
