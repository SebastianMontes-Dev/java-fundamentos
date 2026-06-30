# Sección 11 — Static y Final

## ¿Qué vas a aprender en esta sección?

Hasta ahora, cada objeto tenía sus propias copias de los atributos. Pero, ¿qué pasa si necesitas un valor que pertenezca a LA CLASE, no a cada instancia? Ahí entra `static`. Un contador de cuántos objetos se han creado, una constante como `Math.PI`, o un método utilitario como `Integer.parseInt()` — todos son `static`.

El modificador `final` es el guardián de la inmutabilidad. Una variable `final` no puede reasignarse; un método `final` no puede sobrescribirse; una clase `final` no puede heredarse. Juntos, `static final` crean constantes de clase como `Math.PI` o `Integer.MAX_VALUE`. Esta sección cubre variables y métodos estáticos, bloques de inicialización, `import static`, y los tres usos de `final`.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `StaticVariablesMetodos.java` | Variables y métodos de clase, contador de instancias | `static`, acceso `Clase.metodo()`, palabra reservada `this` vs contexto static |
| `StaticBloquesImport.java` | Bloques de inicialización static e import static | `static { }`, orden de inicialización, `import static java.lang.Math.*` |
| `FinalYConstantes.java` | El modificador final en variables, métodos y clases | `final`, `static final`, constantes, método/parámetro final, clase final |

## Ejemplo de salida esperada

Ejecutando `StaticVariablesMetodos.java`:

```
=== Static: Variables y Métodos de Clase ===

--- Contador de instancias ---
Nuevo producto creado. Total: 1
Nuevo producto creado. Total: 2
Nuevo producto creado. Total: 3
Total de productos creados: 3

--- Acceso a métodos static ---
Suma: 10 + 5 = 15
Multiplicación: 10 * 5 = 50
(NO necesitas instanciar Calculadora)
```

## Tip profesional

> La regla de oro: un método `static` NO puede acceder a `this` ni a atributos de instancia, porque se ejecuta sin un objeto concreto. Si tu método no necesita estado del objeto, hazlo `static` — ganas claridad y evitas crear instancias innecesarias. Para constantes, siempre usa `static final` en mayúsculas con `_`: `public static final double IVA = 0.16;`. Y nunca uses `import static *` en código de producción: oscurece de dónde vienen los métodos.
