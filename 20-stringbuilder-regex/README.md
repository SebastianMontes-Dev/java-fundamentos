# Sección 20 — StringBuilder, StringBuffer y Expresiones Regulares

## ¿Qué vas a aprender en esta sección?

Concatenar Strings con `+` en un bucle es uno de los pecados de rendimiento más comunes en Java. Cada `+` crea un nuevo objeto String porque String es INMUTABLE. Para 10 iteraciones no pasa nada; para 10,000, tu programa se arrastra. `StringBuilder` es la solución: un buffer mutable diseñado para construir strings eficientemente. Aprenderás a usar `append()`, `insert()`, `delete()` y `reverse()`, y a construir dinámicamente reportes, CSVs y HTML.

La segunda mitad cubre **expresiones regulares** (regex): un mini-lenguaje para buscar patrones en texto. Validar emails, extraer números de un string, dividir por múltiples delimitadores — todo esto es trivial con `Pattern` y `Matcher`. Es una herramienta que todo desarrollador debe tener en su caja.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `StringBuilderBasico.java` | Construcción eficiente de strings | `append()`, `insert()`, `delete()`, `reverse()`, `capacity()` vs `length()`, diferencia con String inmutable |
| `StringBuilderPractico.java` | Casos de uso reales con StringBuilder | Generar CSV, reportes, JSON manual, HTML dinámico, formateo de tablas |
| `RegexBasico.java` | Expresiones regulares con Pattern y Matcher | `Pattern.compile()`, `matches()`, `find()`, `group()`, `split()`, clases de caracteres, cuantificadores |

## Ejemplo de salida esperada

Ejecutando `StringBuilderBasico.java`:

```
=== StringBuilder vs String ===

--- String (inmutable, costoso en bucles) ---
Tiempo con String:  145 ms (10,000 repeticiones)
Tiempo con StringBuilder: 0 ms

--- Operaciones con StringBuilder ---
append:    Hola Mundo Java
insert(0): ¡Hola Mundo Java
delete:    Hola Java
reverse:   avaJ aloH
```

## Tip profesional

> Usa `StringBuilder` para concatenar en bucles o cuando construyes strings pieza por pieza. `StringBuffer` es su gemelo thread-safe (sincronizado) pero más lento; úsalo solo en entornos multi-hilo. Para regex, compila el `Pattern` una vez y reúsalo: `Pattern.compile()` es costoso. Y para validar formatos simples como emails, considera usar `String.indexOf('@')` en vez de regex — es más rápido y más legible.
