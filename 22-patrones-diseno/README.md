# Sección 22: Patrones de Diseño Básicos

En esta sección aprenderás sobre los Patrones de Diseño Creacionales más comunes y fundamentales en Java. Los patrones de diseño son soluciones habituales a problemas comunes en el diseño de software. Cada patrón es como un plano que se puede personalizar para resolver un problema de diseño particular en tu código.

## Archivos en esta sección

1. **`PatronSingleton.java`**: Garantiza que una clase tenga solo una instancia en toda la aplicación y proporciona un punto de acceso global a ella. Verás por qué frameworks como Spring lo utilizan por defecto para gestionar sus componentes.
2. **`PatronFactory.java`**: Define una interfaz para crear un objeto, pero deja que las subclases decidan qué clase instanciar. Esto centraliza la creación de objetos y flexibiliza el código.
3. **`PatronBuilder.java`**: Separa la construcción de un objeto complejo de su representación, permitiendo que el mismo proceso de construcción cree diferentes representaciones. Útil para evitar constructores con listas interminables de parámetros.

## ¿Por qué son importantes los patrones de diseño?
- Son un **vocabulario común** entre desarrolladores.
- **Soluciones probadas** que evitan reinventar la rueda.
- Fomentan un código más **limpio, mantenible y escalable**.
