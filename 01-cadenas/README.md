# Sección 01 — Manipulación de Cadenas (String)

## ¿Qué vas a aprender en esta sección?

La clase `String` es, sin exagerar, la clase más utilizada en Java. Cada vez que trabajas con texto —y en programación trabajas con texto constantemente— estás usando un String. Esta sección te enseña los métodos fundamentales que usarás todos los días como desarrollador: cómo medir la longitud de un texto, acceder a caracteres individuales, extraer partes de una cadena, buscar y reemplazar contenido, y comparar textos correctamente.

Pero hay algo más importante que los métodos individuales: entender que los Strings en Java son **INMUTABLES**. Esto significa que ningún método modifica el String original; cada operación crea uno nuevo. Esta característica tiene implicaciones profundas en rendimiento y en cómo escribes tu código. La verás en acción en cada ejercicio y la comentamos explícitamente donde importa.

Cuando termines esta sección, serás capaz de procesar cualquier tipo de texto: desde limpiar datos ingresados por un usuario hasta parsear información de archivos, construir mensajes dinámicos o validar formatos como correos electrónicos y números de teléfono.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `BuscarSubcadenas.java` | Búsqueda de palabras dentro de un texto | `indexOf()`, `lastIndexOf()`, índices en Strings |
| `CaracterEnCadena.java` | Acceso a caracteres por posición | `charAt()`, `length()`, índice base cero |
| `ComparacionCadenas.java` | Comparación correcta de textos | `equals()`, `equalsIgnoreCase()`, por qué NO usar `==` |
| `ManejoSubcadena.java` | Extracción de partes de un texto | `substring(inicio, fin)`, índices inclusivos/exclusivos |
| `MetodosCadenas.java` | Compilación de los métodos más usados | `length()`, `replace()`, `toUpperCase()`, `toLowerCase()`, `trim()` |
| `ReemplazarSubcadenas.java` | Sustitución de texto dentro de una cadena | `replace()`, inmutabilidad de Strings |

## Ejemplo de salida esperada

Ejecutando `MetodosCadenas.java`:

```
Cadena original: Informacion

Longitud: 11
Reemplazando 'a' → 'i': Informicion
En mayúsculas:          INFORMACION
En minúsculas:          informacion

Con espacios : '  LEO REYES  '
Sin espacios : 'LEO REYES'
```

## Tip profesional

> Cuando necesites concatenar muchas cadenas dentro de un bucle, no uses `+`. Cada concatenación con `+` crea un nuevo String en memoria. Para escenarios con muchas uniones, usa `StringBuilder` (más rápido, menos memoria). No lo verás en esta sección, pero es bueno saberlo desde ahora. Para concatenaciones simples fuera de bucles, `+` es perfectamente válido.
