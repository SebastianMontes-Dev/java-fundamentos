# 📦 Sección 17: Expresiones Lambda y Streams

## 🎯 Objetivo de aprendizaje

Aprender a utilizar **expresiones lambda** e introducirse a la **programación funcional** en Java mediante la API de **Streams**. Al finalizar esta sección, serás capaz de escribir código más conciso, declarativo y expresivo para procesar colecciones de datos.

---

## 📚 Contenido

| # | Archivo | Tema | Conceptos clave |
|---|---------|------|-----------------|
| 1 | [LambdasBasicas.java](LambdasBasicas.java) | Expresiones Lambda | Sintaxis lambda, interfaces funcionales, `@FunctionalInterface`, `Predicate`, `Function`, `Consumer`, `Supplier` |
| 2 | [StreamsBasicos.java](StreamsBasicos.java) | Streams API — Básico | `stream()`, `filter()`, `map()`, `forEach()`, `collect()`, `Collectors` |
| 3 | [StreamsAvanzados.java](StreamsAvanzados.java) | Streams API — Avanzado | `reduce()`, `sorted()`, `distinct()`, `flatMap()`, `Optional`, `groupingBy()`, estadísticas |

---

## 🧠 Conceptos fundamentales

### ¿Qué es una expresión lambda?
Una **lambda** es una función anónima (sin nombre) que se puede pasar como argumento a un método. Simplifica enormemente el código que antes requería clases anónimas.

```java
// Antes (clase anónima)
Comparator<String> comp = new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
};

// Después (lambda)
Comparator<String> comp = (a, b) -> a.compareTo(b);
```

### ¿Qué es un Stream?
Un **Stream** es una secuencia de elementos que soporta operaciones de procesamiento declarativas. No almacena datos — es un *pipeline* de operaciones que se aplican a una fuente de datos.

```java
// Pipeline típico
List<String> resultado = lista.stream()     // 1. Crear stream
    .filter(x -> condición)                  // 2. Operación intermedia
    .map(x -> transformación)                // 3. Operación intermedia
    .collect(Collectors.toList());           // 4. Operación terminal
```

---

## 📝 Orden de estudio recomendado

1. **LambdasBasicas.java** — Primero comprende la sintaxis y las interfaces funcionales
2. **StreamsBasicos.java** — Luego aprende las operaciones básicas de Streams
3. **StreamsAvanzados.java** — Finalmente, domina las operaciones avanzadas y estadísticas

---

## ⚡ Interfaces funcionales más importantes

| Interfaz | Método | Entrada | Salida | Uso |
|----------|--------|---------|--------|-----|
| `Predicate<T>` | `test(T)` | `T` | `boolean` | Evaluar condiciones |
| `Function<T,R>` | `apply(T)` | `T` | `R` | Transformar valores |
| `Consumer<T>` | `accept(T)` | `T` | `void` | Consumir/procesar valores |
| `Supplier<T>` | `get()` | — | `T` | Generar/proveer valores |
| `Comparator<T>` | `compare(T,T)` | `T, T` | `int` | Comparar dos valores |

---

## ⚠️ Errores comunes

- ❌ Reutilizar un Stream después de una operación terminal
- ❌ Olvidar la operación terminal (el pipeline nunca se ejecuta)
- ❌ Modificar variables locales desde dentro de una lambda
- ❌ Usar `Optional.get()` sin verificar `isPresent()`
- ❌ Confundir `map()` (transforma) con `flatMap()` (aplana y transforma)

---

## 🔧 Requisitos

- **Java 8** o superior (las lambdas y streams se introdujeron en Java 8)
- Cada archivo es **autocontenido** y se puede compilar/ejecutar de forma independiente

```bash
# Compilar y ejecutar cualquier archivo
javac LambdasBasicas.java && java LambdasBasicas
javac StreamsBasicos.java && java StreamsBasicos
javac StreamsAvanzados.java && java StreamsAvanzados
```

---

## 🔗 Recursos adicionales

- 📖 [Tutorial oficial de Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
- 📖 [Tutorial oficial de Streams](https://docs.oracle.com/javase/tutorial/collections/streams/)
- 📖 [java.util.function (interfaces funcionales)](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)
- 📖 [java.util.stream.Collectors](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html)
