/**
 * ============================================================
 *  TEMA: Manejo de Archivos en Java
 *  SECCIÓN: 14 — Archivos
 *  ARCHIVO: EscribirArchivo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  `FileWriter` es la clase más directa para escribir texto en archivos. Puede
 *  sobrescribir el archivo completo o agregar contenido al final (modo append).
 *  Aprenderás a escribir líneas con `write()`, a usar el modo append para no
 *  perder datos existentes, y a manejar `IOException` correctamente. Este es el
 *  mecanismo base usado por logs, exportación de reportes y persistencia simple.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - FileWriter: clase para escribir caracteres en un archivo.
 *  - Modo sobrescritura: `new FileWriter("archivo.txt")` — borra el contenido anterior.
 *  - Modo append: `new FileWriter("archivo.txt", true)` — agrega al final.
 *  - IOException: excepción verificada que debes manejar al trabajar con archivos.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  FileWriter escritor = new FileWriter("salida.txt");
 *  escritor.write("Hola mundo\n");
 *  escritor.close(); // ¡siempre cerrar!
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - No cerrar el FileWriter (el contenido puede no guardarse).
 *  - Usar modo sobrescritura sin querer y perder datos existentes.
 *  - Olvidar los saltos de línea (\n o System.lineSeparator()).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
 * ============================================================
 */
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EscribirArchivo {

    public static void main(String[] args) {

        System.out.println("=== Escritura de Archivos en Java ===\n");

        String nombreArchivo = "registro.txt";

        // Ejemplo 1: Escribir un archivo nuevo (sobrescribe si ya existe)
        System.out.println("--- Escribiendo archivo nuevo ---");
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            escritor.write("=== REGISTRO DE ACTIVIDAD ===\n");
            escritor.write("Aplicación iniciada.\n");
            escritor.write("Usuario: SebastianMontes-Dev\n");
            escritor.write("Fecha: " + obtenerFechaActual() + "\n");
            System.out.println("Archivo '" + nombreArchivo + "' escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        // Ejemplo 2: Agregar más contenido sin borrar lo anterior (modo append)
        System.out.println("\n--- Agregando contenido (modo append) ---");
        try (FileWriter escritor = new FileWriter(nombreArchivo, true)) {
            // El 'true' en el constructor activa el modo append
            escritor.write("\n--- NUEVA SESIÓN ---\n");
            escritor.write("Fecha: " + obtenerFechaActual() + "\n");
            escritor.write("El usuario realizó 3 operaciones.\n");
            escritor.write("Sesión finalizada correctamente.\n");
            System.out.println("Contenido agregado a '" + nombreArchivo + "'.");
        } catch (IOException e) {
            System.out.println("Error al agregar contenido: " + e.getMessage());
        }

        // Ejemplo 3: Escribir múltiples líneas desde un arreglo
        System.out.println("\n--- Escribiendo desde un arreglo ---");
        String[] productos = {"Laptop", "Monitor", "Teclado", "Mouse"};

        try (FileWriter escritor = new FileWriter("productos.txt")) {
            escritor.write("=== LISTA DE PRODUCTOS ===\n");
            for (int i = 0; i < productos.length; i++) {
                escritor.write((i + 1) + ". " + productos[i] + "\n");
            }
            System.out.println("Archivo 'productos.txt' generado con " + productos.length + " productos.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static String obtenerFechaActual() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
