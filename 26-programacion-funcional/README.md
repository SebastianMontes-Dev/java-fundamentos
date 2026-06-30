# 📦 Sección 18: Programación Funcional

## 🎯 Objetivo

Aprender los fundamentos de la **programación funcional en Java**: interfaces funcionales integradas, referencias a métodos y composición de funciones. Estas herramientas son la base para escribir código más conciso, expresivo y mantenible.

---

## 📚 Contenido

| # | Archivo | Tema | Conceptos Clave |
|---|---------|------|-----------------|
| 1 | [InterfacesFuncionales.java](InterfacesFuncionales.java) | Interfaces funcionales integradas | `Predicate<T>`, `Function<T,R>`, `Consumer<T>`, `Supplier<T>`, `UnaryOperator<T>`, `BinaryOperator<T>`, `BiFunction`, `BiConsumer` |
| 2 | [ReferenciasMetodos.java](ReferenciasMetodos.java) | Referencias a métodos | `Clase::metodoEstatico`, `objeto::metodo`, `Clase::metodoInstancia`, `Clase::new` |
| 3 | [ComposicionFunciones.java](ComposicionFunciones.java) | Composición de funciones | `andThen()`, `compose()`, `and()`, `or()`, `negate()`, `Predicate.not()`, pipelines |

---

## 🧠 Conceptos Fundamentales

### Interfaz Funcional

Una **interfaz funcional** es una interfaz que tiene exactamente **un método abstracto**. Puede tener métodos `default` y `static` adicionales.

```java
@FunctionalInterface
public interface MiInterfaz<T> {
    T procesar(T valor);  // Un solo método abstracto
}
```

### Las 4 Interfaces Principales

```
┌──────────────────────────────────────────────────────┐
│                                                      │
│   Predicate<T>    →  T  → boolean    (evaluar)       │
│   Function<T,R>   →  T  → R          (transformar)   │
│   Consumer<T>     →  T  → void       (consumir)      │
│   Supplier<T>     →  () → T          (proveer)       │
│                                                      │
└──────────────────────────────────────────────────────┘
```

### Referencias a Métodos

Son una forma abreviada de lambdas cuando solo llaman a un método existente:

```
Lambda                          →  Referencia a Método
──────────────────────────────────────────────────────
s -> Integer.parseInt(s)        →  Integer::parseInt
s -> System.out.println(s)      →  System.out::println
s -> s.toUpperCase()            →  String::toUpperCase
s -> new ArrayList<>(s)         →  ArrayList::new
```

### Composición de Funciones

```
f.andThen(g)  →  entrada → [f] → [g] → salida  (orden natural)
f.compose(g)  →  entrada → [g] → [f] → salida  (orden inverso)

p1.and(p2)    →  ambos deben ser true
p1.or(p2)     →  al menos uno debe ser true
p.negate()    →  invierte el resultado
```

---

## 💻 ¿Cómo ejecutar?

Cada archivo es independiente y se puede compilar y ejecutar por separado:

```bash
# Compilar
javac InterfacesFuncionales.java

# Ejecutar
java InterfacesFuncionales
```

---

## 📋 Requisitos Previos

- **Java 11+** (para `Predicate.not()`)
- Conocimientos de [Expresiones Lambda](../17-expresiones-lambda/) (Sección 17)
- Conocimientos de [Genéricos](../14-generics/) (Sección 14)

---

## 🔗 Secciones Relacionadas

- ← Anterior: [Sección 17 — Expresiones Lambda](../17-expresiones-lambda/)
- → Siguiente: [Sección 19 — Streams API](../19-streams-api/)

---

## 📝 Ejercicios Sugeridos

1. **Validador de contraseñas**: Crea predicados para verificar longitud mínima, al menos una mayúscula, al menos un dígito, y combínalos con `and()`.

2. **Conversor de unidades**: Crea funciones para convertir temperaturas (°C → °F → °K) usando `andThen()` y `compose()`.

3. **Procesador de textos**: Construye un pipeline que limpie, normalice y formatee datos de un CSV simulado.

4. **Sistema de notificaciones**: Usa `Consumer` para crear diferentes canales de notificación (consola, archivo, email simulado) y encadénalos con `andThen()`.
