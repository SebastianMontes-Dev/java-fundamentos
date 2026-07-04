# Sección 32 — Java Moderno (14-17)

## ¿Qué vas a aprender en esta sección?

Java ha evolucionado MÁS en los últimos 5 años que en los 15 anteriores. Esta sección cubre las features que transformaron el lenguaje entre Java 14 y 17, convirtiéndolo en un lenguaje moderno y expresivo sin perder su esencia. Si aprendiste Java en la universidad con versiones antiguas, esto es lo que necesitas para ponerte al día.

`var` (Java 10) elimina la redundancia de declarar el tipo cuando es obvio por el contexto. Switch expressions (Java 14) convierten el switch tradicional en una expresión concisa con `->` y `yield`. Text blocks (Java 15) te permiten escribir strings multilínea sin concatenar `\n`. Pattern matching para `instanceof` (Java 16) elimina el casting redundante. Records (Java 14+) son clases inmutables de datos en una sola línea. Y sealed classes (Java 17) te dejan controlar QUIÉN puede heredar de tu clase.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `VarEInferencia.java` | Inferencia de tipos con var | `var`, cuándo usarlo, limitaciones, legibilidad, `var` en bucles foreach |
| `SwitchExpresiones.java` | Switch moderno como expresión | `->` arrow case, `yield`, múltiples labels, sin fall-through, switch como valor |
| `TextBlocksYPatternMatching.java` | Strings multilínea y pattern matching | `""" """`, indentación automática, `instanceof` con binding, flujo de control simplificado |
| `RecordsYSellados.java` | Records (data carriers) y sealed classes | `record`, constructor canónico, `equals`/`hashCode`/`toString` automáticos, `sealed`/`permits` |

## Ejemplo de salida esperada

Ejecutando `SwitchExpresiones.java`:

```
=== Switch Expressions (Java 14+) ===

--- Switch moderno con -> ---
Resultado con 2: martes
Resultado con 6: fin de semana

--- Switch como expresión ---
Tipo de día de "LUNES": DÍA LABORAL

--- Múltiples labels ---
Día 1 (lunes): día laboral
Día 6 (sábado): fin de semana
```

## Tip profesional

> No uses `var` para todo — resérvalo para casos donde el tipo es obvio (`var lista = new ArrayList<String>()`) o es irrelevante (variables locales intermedias). Si alguien necesita mirar el lado derecho para entender el tipo, estás usando `var` mal. Records son perfectos para DTOs, value objects y respuestas de API. Y con sealed classes, por fin puedes modelar jerarquías cerradas (como `Resultado = Éxito | Error`) sin que nadie añada subclases inesperadas.
