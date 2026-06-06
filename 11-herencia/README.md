# Sección 11 — Herencia, Polimorfismo, Interfaces y Clases Abstractas

## ¿Qué vas a aprender en esta sección?

Esta sección cubre los conceptos más poderosos de la POO y donde muchos principiantes se atascan. Vamos por partes.

**Herencia** (`extends`) permite que una clase HIJA herede atributos y métodos de una clase PADRE. La relación es "ES-UN": un Perro ES-UN Animal. Esto promueve la reutilización de código y establece jerarquías naturales. Junto con la herencia viene la **sobrescritura** (`@Override`): la clase hija puede proporcionar su propia versión de un método del padre.

**Polimorfismo** es la capacidad de tratar objetos de diferentes subclases como si fueran del tipo de la superclase. Una variable de tipo `Animal` puede contener un `Perro`, un `Gato` o un `Pajaro`, y al llamar a un método se ejecutará la versión específica de cada uno. Esto es lo que permite escribir código genérico que funciona con cualquier subtipo futuro.

**Interfaces** definen CONTRATOS: qué métodos debe tener una clase, pero no cómo implementarlos. A diferencia de la herencia (solo puedes extender UNA clase), puedes implementar MÚLTIPLES interfaces. **Clases abstractas** son un punto intermedio: pueden tener métodos implementados (concretos) y métodos sin implementar (abstractos). No se pueden instanciar directamente.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `HerenciaBasica.java` | Subclases que extienden una superclase | `extends`, `super()`, herencia de métodos |
| `SobrescrituraMetodos.java` | Métodos @Override en subclases | `@Override`, especialización de comportamiento |
| `Polimorfismo.java` | Arreglo polimórfico + enlace dinámico | Variable tipo padre, objeto tipo hijo, `instanceof` |
| `Interfaces.java` | Definición e implementación de interfaces | `interface`, `implements`, múltiples interfaces |
| `ClasesAbstractas.java` | Clases abstractas con métodos concretos y abstractos | `abstract class`, método abstracto, método concreto |

## Ejemplo de salida esperada

Ejecutando `Polimorfismo.java`:

```
=== Polimorfismo en Java ===

Área del círculo (radio 5.0): 78.54
  -> Esta figura es un Círculo

Área del rectángulo (4.0 x 6.0): 24.00
  -> Esta figura es un Rectángulo

Área del triángulo (3.0 x 8.0): 12.00
  -> Esta figura es un Triángulo
```

## Tip profesional

> La pregunta del millón: ¿interfaz o clase abstracta? Usa INTERFAZ cuando definas un CONTRATO que clases no relacionadas pueden compartir (ej: `Volador` puede ser implementado por `Pajaro` y `Avion`). Usa CLASE ABSTRACTA cuando compartas ESTADO (atributos) y lógica parcial entre clases relacionadas (ej: `Empleado` con atributo `nombre` compartido entre `EmpleadoTiempoCompleto` y `EmpleadoMedioTiempo`). Y recuerda el principio de diseño más importante: "prefiere composición sobre herencia". No heredes solo por reutilizar código.
