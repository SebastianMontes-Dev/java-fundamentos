# 📦 Sección 16: Genéricos en Java

## 📖 Descripción

Los **genéricos** son una de las características más poderosas de Java. Permiten escribir clases, interfaces y métodos que funcionan con **cualquier tipo de dato**, manteniendo la **seguridad de tipos** en tiempo de compilación. Sin genéricos, tendríamos que usar `Object` para todo y hacer casting manual, lo que es propenso a errores.

## 🎯 Objetivos de aprendizaje

Al completar esta sección, serás capaz de:

- ✅ Entender **por qué existen** los genéricos y qué problema resuelven
- ✅ Crear **clases genéricas** con uno o más parámetros de tipo
- ✅ Escribir **métodos genéricos** independientes de la clase
- ✅ Usar **tipos acotados** (`extends`) para restringir tipos aceptados
- ✅ Aplicar **comodines** (`?`, `? extends`, `? super`) correctamente
- ✅ Usar genéricos con **colecciones** (`List<T>`, `Map<K,V>`, `Set<T>`)
- ✅ Crear **clases utilitarias genéricas** reutilizables

## 📂 Archivos de la sección

| # | Archivo | Tema | Conceptos clave |
|---|---------|------|-----------------|
| 1 | `GenericosBasicos.java` | Introducción a genéricos | Clase `Caja<T>`, parámetros de tipo, seguridad de tipos, operador diamante |
| 2 | `MetodosGenericos.java` | Métodos genéricos | Métodos `<T>`, tipos acotados, comodines `?`, `? extends`, `? super`, PECS |
| 3 | `GenericosConColecciones.java` | Genéricos con colecciones | `List<T>`, `Map<K,V>`, `Set<T>`, clase utilitaria genérica, filtrado y transformación |

## 🚀 ¿Cómo ejecutar los archivos?

Cada archivo es independiente y se puede compilar y ejecutar por separado:

```bash
# Compilar
javac GenericosBasicos.java

# Ejecutar
java GenericosBasicos
```

## 📝 Conceptos fundamentales

### ¿Qué son los genéricos?

Los genéricos permiten **parametrizar tipos**. En lugar de escribir una clase diferente para cada tipo de dato, escribes UNA sola clase que funciona con todos:

```java
// Sin genéricos (inseguro):
Object dato = "Hola";
String texto = (String) dato; // Casting manual, puede fallar

// Con genéricos (seguro):
Caja<String> caja = new Caja<>("Hola");
String texto = caja.getContenido(); // Sin casting, tipo garantizado
```

### Convenciones de nombres para parámetros de tipo

| Letra | Significado | Uso común |
|-------|-------------|-----------|
| `T` | Type | Tipo general |
| `E` | Element | Elementos de colecciones |
| `K` | Key | Claves de mapas |
| `V` | Value | Valores de mapas |
| `N` | Number | Tipos numéricos |
| `S`, `U` | — | Segundo, tercer tipo adicional |

### Regla PECS

> **P**roducer **E**xtends, **C**onsumer **S**uper

- Si **lees** de una estructura genérica → usa `? extends T`
- Si **escribes** en una estructura genérica → usa `? super T`

## ⚠️ Errores comunes

1. **Usar tipos primitivos**: `Caja<int>` ❌ → `Caja<Integer>` ✅
2. **Raw types**: `List lista = new ArrayList()` ❌ → `List<String> lista = new ArrayList<>()` ✅
3. **Crear instancias de T**: `new T()` ❌ (no es posible por borrado de tipos)
4. **Confundir `<T>` con `<?>`**: `T` se puede reusar, `?` es un tipo desconocido

## 🔗 Recursos adicionales

- 📘 [Tutorial oficial de genéricos (Oracle)](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
- 📘 [Métodos genéricos (Oracle)](https://docs.oracle.com/javase/tutorial/java/generics/methods.html)
- 📘 [Comodines (Oracle)](https://docs.oracle.com/javase/tutorial/java/generics/wildcards.html)

## 📌 Prerequisitos

Antes de estudiar esta sección, asegúrate de dominar:

- Programación orientada a objetos (clases, herencia, interfaces)
- Colecciones básicas (ArrayList, HashMap)
- Concepto de tipos de datos en Java
