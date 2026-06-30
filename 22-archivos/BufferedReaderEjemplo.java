/**
 * ============================================================
 *  TEMA: Manejo de Archivos en Java
 *  SECCIÓN: 22 — Archivos
 *  ARCHIVO: BufferedReaderEjemplo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  `BufferedReader` envuelve un `FileReader` y añade un BUFFER interno que lee
 *  grandes bloques de datos de una vez, haciendo la lectura mucho más eficiente
 *  que leer carácter por carácter. Es la opción recomendada para leer archivos
 *  de texto grandes. Además, ofrece el método `readLine()` que devuelve una
 *  línea completa o `null` cuando se llega al final del archivo.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - BufferedReader: añade buffering para lectura eficiente.
 *  - FileReader: lector base que conecta con el archivo.
 *  - readLine(): lee una línea completa y devuelve null al final.
 *  - Decorator pattern: BufferedReader "decora" un FileReader añadiéndole funcionalidad.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  BufferedReader lector = new BufferedReader(new FileReader("datos.txt"));
 *  String linea;
 *  while ((linea = lector.readLine()) != null) {
 *      System.out.println(linea);
 *  }
 *  lector.close();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - No cerrar el BufferedReader (fuga de recursos del sistema operativo).
 *  - Olvidar que readLine() devuelve null al final y no una línea vacía.
 *  - Usar FileReader sin BufferedReader para archivos grandes (ineficiente).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/essential/io/buffers.html
 * ============================================================
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderEjemplo {

    public static void main(String[] args) {

        System.out.println("=== BufferedReader en Java ===\n");

        // Primero aseguramos que exista un archivo para leer
        String nombreArchivo = "productos.txt";
        if (!new java.io.File(nombreArchivo).exists()) {
            crearArchivoEjemplo(nombreArchivo);
        }

        // Lectura eficiente con BufferedReader usando try-with-resources
        System.out.println("Leyendo '" + nombreArchivo + "' con BufferedReader:\n");

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {

            String linea;
            int contadorLineas = 0;

            // readLine() devuelve null cuando no hay más líneas que leer
            while ((linea = lector.readLine()) != null) {
                contadorLineas++;
                System.out.println("Línea " + contadorLineas + ": " + linea);
            }

            System.out.println("\nTotal de líneas leídas: " + contadorLineas);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Ejemplo adicional: leer solo las líneas que contienen cierta palabra (filtro)
        System.out.println("\n--- Filtrando líneas con BufferedReader ---");
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {

            String linea;
            String filtro = "Producto";

            System.out.println("Líneas que contienen '" + filtro + "':");
            while ((linea = lector.readLine()) != null) {
                if (linea.contains(filtro)) {
                    System.out.println("  -> " + linea);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void crearArchivoEjemplo(String nombreArchivo) {
        try (java.io.FileWriter fw = new java.io.FileWriter(nombreArchivo)) {
            fw.write("=== LISTA DE PRODUCTOS ===\n");
            fw.write("1. Producto: Laptop\n");
            fw.write("2. Producto: Monitor\n");
            fw.write("3. Producto: Teclado\n");
            fw.write("4. Producto: Mouse\n");
            System.out.println("(Archivo '" + nombreArchivo + "' creado para el ejemplo)\n");
        } catch (IOException e) {
            System.out.println("No se pudo crear el archivo de ejemplo.");
        }
    }
}
