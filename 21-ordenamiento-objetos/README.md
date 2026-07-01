# Sección 21 — Ordenamiento de Objetos y Optional

## ¿Qué vas a aprender en esta sección?

Ordenar números es fácil: `Arrays.sort()` y listo. Pero, ¿cómo ordenas una lista de `Persona` por edad, o por nombre alfabéticamente, o por ambos? Java tiene dos mecanismos: `Comparable` (orden natural, implementado por la clase misma) y `Comparator` (órdenes alternativos, definidos externamente). Esta distinción es fundamental en Java y aparece en todas las colecciones ordenadas (`TreeSet`, `TreeMap`).

La segunda parte cubre `Optional<T>`: el antídoto de Java contra `NullPointerException`. En vez de devolver `null` cuando un valor puede no existir, devuelves un `Optional` que OBLIGA a quien lo recibe a manejar el caso de ausencia. Aprenderás a crear, transformar y desempaquetar Optionals, y las trampas comunes al usarlos.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `ComparableBasico.java` | Orden natural de objetos | `implements Comparable<T>`, `compareTo()`, `Collections.sort()`, `TreeSet` |
| `ComparatorEjemplo.java` | Múltiples criterios de orden con Comparator | `Comparator<T>`, `comparing()`, `thenComparing()`, `reversed()`, lambdas como comparators |
| `OptionalBasico.java` | Eliminando NullPointerException | `of()`, `ofNullable()`, `isPresent()`, `ifPresent()`, `orElse()`, `orElseThrow()`, `map()`, `filter()` |

## Ejemplo de salida esperada

Ejecutando `ComparableBasico.java`:

```
=== Comparable: Orden Natural ===

--- Ordenado por nombre ---
Ana (edad: 25)
Carlos (edad: 30)
María (edad: 22)

--- TreeSet (orden automático) ---
Ana, Carlos, María
```

## Tip profesional

> Usa `Comparable` cuando tu clase tiene UN orden natural obvio (Persona por nombre, Transacción por fecha). Usa `Comparator` para órdenes alternativos o cuando no puedes modificar la clase. Con Java 8+, prefieres `Comparator.comparing(Persona::getEdad)` sobre crear clases anónimas. Y con `Optional`: NUNCA llames a `.get()` sin verificar `isPresent()`, estarías anulando su propósito. Si tienes una cadena de operaciones, usa `.map()` y `.orElse()` — es más idiomático y seguro.
