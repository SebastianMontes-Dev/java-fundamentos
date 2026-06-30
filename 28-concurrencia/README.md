# Sección 20: Concurrencia y Multihilos

Esta sección introduce los conceptos de programación concurrente y asíncrona en Java, los cuales son fundamentales para crear aplicaciones eficientes y de alto rendimiento.

## Archivos en esta sección

1. **[HilosBasicos.java](./HilosBasicos.java)**
   - Introduce los conceptos base de la concurrencia.
   - Analiza las diferencias entre extender la clase `Thread` e implementar la interfaz `Runnable`.
   - Explora los métodos fundamentales: `start()` para iniciar un hilo en paralelo, y `sleep()` para pausar su ejecución.

2. **[SincronizacionHilos.java](./SincronizacionHilos.java)**
   - Explica el problema de las condiciones de carrera (race conditions).
   - Muestra cómo varios hilos modificando un recurso compartido al mismo tiempo pueden causar corrupción o pérdida de datos.
   - Implementa la palabra clave `synchronized` para asegurar exclusión mutua y proteger los datos compartidos.
   - Muestra el uso de `Thread.join()` para esperar la finalización de los hilos.

3. **[EjecutoresYFuturos.java](./EjecutoresYFuturos.java)**
   - Muestra el enfoque moderno y recomendado para la concurrencia en Java.
   - Uso de `ExecutorService` y `Executors` para gestionar Thread Pools de forma eficiente, reutilizando los hilos y mejorando el rendimiento.
   - Introducción a la programación asíncrona avanzada con `CompletableFuture` (uso de `supplyAsync`, `thenApply` y `join`).

## Cómo ejecutar los archivos

Cada archivo de Java dentro de este repositorio está diseñado de manera independiente y contiene su propio método `main`. Puedes compilar y ejecutar cada uno de ellos individualmente desde tu terminal o consola:

```bash
# Ejemplo compilando y ejecutando HilosBasicos
javac HilosBasicos.java
java HilosBasicos
```
