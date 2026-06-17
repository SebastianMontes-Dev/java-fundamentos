# Sección 23: Anotaciones y Reflexión

¡Bienvenido a la sección 23 del curso de Fundamentos de Java! 

En esta sección exploraremos conceptos avanzados pero esenciales en el desarrollo moderno de Java, que son fundamentales para entender cómo funcionan los frameworks como **Spring Boot**, **Hibernate/JPA** y **JUnit**.

## Archivos en esta sección

1. **`AnotacionesBasicas.java`**: Exploramos las anotaciones que ya vienen integradas en Java (`@Override`, `@Deprecated`, `@SuppressWarnings`). Aprenderás cómo estas anotaciones interactúan con el compilador para evitar errores.
2. **`AnotacionPersonalizada.java`**: Aprenderemos a crear nuestras propias anotaciones usando `@interface`, configurando cuándo están disponibles (`@Retention`) y dónde pueden ser usadas (`@Target`).
3. **`ReflexionBasica.java`**: Una introducción práctica a la API de Reflexión. Aprenderemos a inspeccionar clases en tiempo de ejecución, leeremos las anotaciones personalizadas creadas previamente y veremos cómo invocar métodos dinámicamente.

## ¿Qué es la Reflexión y por qué es importante?

La **Reflexión** (Reflection API) es la capacidad de un programa en Java de inspeccionarse a sí mismo en tiempo de ejecución. Permite:
- Obtener información sobre clases, métodos y campos privados.
- Leer anotaciones personalizadas y tomar decisiones basadas en ellas.
- Invocar métodos de forma dinámica.

Esta es exactamente la "magia" detrás de frameworks como Spring Boot: cuando usas una anotación como `@GetMapping("/ruta")`, Spring usa reflexión para encontrar ese método y ejecutarlo cuando alguien visita esa URL.

## Cómo ejecutar los ejemplos

Para ejecutar estos ejemplos correctamente y ver cómo se relacionan las clases entre sí, recomendamos compilar todos los archivos de la carpeta a la vez:

```bash
javac *.java
java AnotacionesBasicas
java AnotacionPersonalizada
java ReflexionBasica
```
