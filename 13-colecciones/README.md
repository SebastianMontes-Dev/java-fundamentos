# Sección 13 — Colecciones

## ¿Qué vas a aprender en esta sección?

Los arreglos son útiles, pero tienen una limitación frustrante: su tamaño es FIJO. En el mundo real, las listas crecen y se reducen constantemente. El Java Collections Framework (JCF) resuelve esto con un conjunto de clases y interfaces optimizadas para diferentes escenarios de almacenamiento y acceso a datos.

Esta sección cubre las colecciones más utilizadas en el día a día: `ArrayList` (lista dinámica basada en arreglo), `LinkedList` (lista doblemente enlazada, óptima para inserciones/eliminaciones frecuentes al inicio), `HashMap` (diccionario clave-valor con búsqueda O(1)) y `HashSet` (conjunto que garantiza unicidad). También exploramos diferentes formas de iterar colecciones: for-each, for con índice, Iterator (para eliminar durante la iteración) y el estilo funcional con forEach + lambda.

La elección de la colección correcta impacta directamente el rendimiento de tu aplicación. `ArrayList` es excelente para acceso aleatorio por índice; `LinkedList` brilla en inserciones al inicio; `HashMap` es imbatible para búsquedas por clave; `HashSet` es perfecto cuando necesitas garantizar que no hay duplicados. Conocer cuándo usar cada una es marca de un desarrollador Java competente.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `ArrayListEjemplo.java` | Lista dinámica con operaciones CRUD | `add()`, `get()`, `remove()`, `size()`, `contains()` |
| `HashMapEjemplo.java` | Diccionario clave-valor | `put()`, `get()`, `containsKey()`, `keySet()` |
| `LinkedListEjemplo.java` | Lista doblemente enlazada + uso como cola | `addFirst()`, `addLast()`, `removeFirst()`, `offer()`, `poll()` |
| `IterarColecciones.java` | Cinco formas de recorrer colecciones | for-each, for clásico, Iterator, lambda, method reference |
| `HashSetEjemplo.java` | Conjuntos sin duplicados + operaciones | `add()`, `contains()`, `addAll()`, `retainAll()` |

## Ejemplo de salida esperada

Ejecutando `ArrayListEjemplo.java`:

```
=== ArrayList en Java ===

--- Agregando frutas ---
Total de frutas: 4

--- Accediendo por índice ---
Fruta en índice 0: Manzana
Fruta en índice 2: Naranja

Después de insertar Fresa en índice 1:
  - Manzana
  - Fresa
  - Banana
  - Naranja
  - Uva

Después de eliminar el índice 3:
  - Manzana
  - Fresa
  - Banana
  - Uva

¿Contiene 'Banana'? true
¿Contiene 'Sandía'? false
```

## Tip profesional

> Los genéricos (`<String>`, `<Integer>`) no son opcionales: son seguridad de tipos. `ArrayList<String>` te garantiza que solo guardará Strings y te ahorra casts manuales. Si omites el genérico (`ArrayList lista = new ArrayList()`), trabajarás con `Object` y el compilador no te avisará si metes un tipo incorrecto. Siempre usa el diamante `<>` en la declaración. Y recuerda: `ArrayList<int>` NO compila; usa la clase envolvente `Integer` para tipos primitivos.
