# Sección 22 — Manejo de Archivos

## ¿Qué vas a aprender en esta sección?

Tus programas, hasta ahora, viven y mueren en la memoria RAM: cuando termina la ejecución, todo se pierde. Los archivos son la forma más básica de PERSISTENCIA: datos que sobreviven al programa y pueden leerse después. Esta sección te enseña a leer archivos de texto existentes y a escribir nuevos, cerrando el ciclo de "entrada → procesamiento → salida permanente".

Tres herramientas cubrimos: `Scanner` con `File` (la forma más sencilla de leer archivos línea por línea), `FileWriter` (escribir texto directamente, con opción de sobrescribir o agregar al final), y `BufferedReader` (lectura eficiente con buffer para archivos grandes). Todas usan `try-with-resources` —la sintaxis moderna que cierra automáticamente los recursos sin necesidad de un bloque `finally` manual—.

El manejo de archivos es inevitablemente propenso a errores: el archivo puede no existir, no tener permisos de lectura, estar bloqueado por otro proceso. Por eso cada ejemplo incluye manejo de `IOException` y `FileNotFoundException`, preparándote para el mundo real donde las cosas fallan y tu código debe responder con gracia.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `LeerArchivo.java` | Lectura línea por línea con Scanner + File | `File`, `Scanner(File)`, `hasNextLine()`, try-with-resources |
| `EscribirArchivo.java` | Escritura y append con FileWriter | `FileWriter`, modo sobrescritura, modo append (`true`) |
| `BufferedReaderEjemplo.java` | Lectura eficiente con buffer + filtrado | `BufferedReader`, `FileReader`, `readLine()`, filtro por contenido |

## Ejemplo de salida esperada

Ejecutando `EscribirArchivo.java`:

```
=== Escritura de Archivos en Java ===

--- Escribiendo archivo nuevo ---
Archivo 'registro.txt' escrito correctamente.

--- Agregando contenido (modo append) ---
Contenido agregado a 'registro.txt'.

--- Escribiendo desde un arreglo ---
Archivo 'productos.txt' generado con 4 productos.
```

## Tip profesional

> try-with-resources (`try (FileWriter fw = new FileWriter(...)) { ... }`) es tu mejor amigo. Olvídate de cerrar manualmente con `fw.close()` en un `finally`: esta sintaxis cierra automáticamente cualquier recurso que implemente `AutoCloseable`, incluso si ocurre una excepción. Funciona con Scanner, FileWriter, BufferedReader, conexiones de red y más. Es una de esas features de Java que una vez que la adoptas, no vuelves atrás. Y sobre rutas de archivos: usa `File.separator` o rutas relativas con `/` en vez de `\` para que tu código funcione en cualquier sistema operativo.
