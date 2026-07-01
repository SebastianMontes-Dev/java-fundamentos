# Sección 17 — Clases Internas en Java

## ¿Qué vas a aprender en esta sección?

Java permite definir una clase DENTRO de otra clase. Suena extraño al principio, pero es una herramienta de encapsulación muy poderosa que usan frameworks como Swing, Android y Spring internamente. Hay 4 tipos de clases anidadas, cada una con un propósito distinto.

Las **static nested classes** son clases normales que viven dentro de otra por organización. Las **inner classes** (clases internas de miembro) tienen acceso a los atributos del objeto externo usando `Outer.this`. Las **local classes** se definen dentro de un método y solo existen ahí. Las **anonymous classes** son la versión pre-lambda de "crear una implementación de una interfaz sobre la marcha" — antes de Java 8, esta era la ÚNICA forma de pasar comportamiento como parámetro.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `ClasesAnidadasStatic.java` | Clases anidadas estáticas | `static class`, organización de código, clases helper, acceso a miembros static externos |
| `ClasesInternasMiembro.java` | Clases internas de miembro | `Outer.this`, acceso a atributos privados del outer, creación con `outer.new Inner()` |
| `ClasesAnonimasYLocales.java` | Clases locales y anónimas | Clases en métodos, implementación inline de interfaces, predecesor de lambdas |

## Ejemplo de salida esperada

Ejecutando `ClasesInternasMiembro.java`:

```
=== Clases Internas de Miembro ===

--- Iterador personalizado ---
Elemento 0: Manzana
Elemento 1: Banana
Elemento 2: Naranja

(El iterador accede a los atributos privados de ColeccionSimple
 usando Outer.this sin getters)
```

## Tip profesional

> Con las lambdas de Java 8, las clases anónimas cayeron en desuso para casos simples. Pero siguen siendo necesarias cuando implementas una interfaz con MÚLTIPLES métodos abstractos, o una clase abstracta. Las static nested classes son las más usadas en producción porque no requieren una instancia del outer y son más fáciles de testear. Regla: empieza con static nested, usa inner solo si realmente necesitas acceso a los atributos del outer.
