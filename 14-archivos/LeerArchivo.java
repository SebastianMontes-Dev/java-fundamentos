/**
 * ============================================================
 *  TEMA: Manejo de Archivos en Java
 *  SECCIÓN: 14 — Archivos
 *  ARCHIVO: LeerArchivo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Leer archivos de texto es una operación fundamental en cualquier aplicación real:
 *  configuraciones, logs, datos de entrada, etc. Aquí aprenderás a usar `File`
 *  para representar la ruta del archivo y `Scanner` para leerlo línea por línea.
 *  También manejarás `FileNotFoundException` para el caso de que el archivo no
 *  exista, una buena práctica que todo desarrollador debe aplicar.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - File: representa la ruta de un archivo o directorio en el sistema.
 *  - Scanner con File: lee el contenido del archivo como haría con System.in.
 *  - hasNextLine(): verifica si hay más líneas por leer.
 *  - nextLine(): lee la siguiente línea completa del archivo.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  File archivo = new File("datos.txt");
 *  Scanner lector = new Scanner(archivo);
 *  while (lector.hasNextLine()) {
 *      String linea = lector.nextLine();
 *      System.out.println(linea);
 *  }
 *  lector.close();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar rutas relativas que no coinciden con el directorio de ejecución.
 *  - No cerrar el Scanner (fuga de recursos).
 *  - No manejar FileNotFoundException (el programa crashea si el archivo no existe).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/essential/io/scanning.html
 * ============================================================
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivo {

    public static void main(String[] args) {

        System.out.println("=== Lectura de Archivos en Java ===\n");

        // File representa la ruta del archivo
        File archivo = new File("ejemplo.txt");

        // Si el archivo no existe, creamos uno de demostración
        if (!archivo.exists()) {
            crearArchivoDemostracion(archivo);
        }

        // Leemos el archivo usando try-with-resources (cierra el Scanner automáticamente)
        System.out.println("Contenido del archivo '" + archivo.getName() + "':");
        System.out.println("----------------------------------------");

        try (Scanner lector = new Scanner(archivo)) {

            int numeroLinea = 1;
            // Mientras haya líneas por leer...
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                // Mostramos cada línea con su número
                System.out.printf("%2d | %s%n", numeroLinea, linea);
                numeroLinea++;
            }

        } catch (FileNotFoundException e) {
            // Si el archivo no existe, informamos sin crashear
            System.out.println("Error: No se encontró el archivo '" + archivo.getName() + "'.");
            System.out.println("Detalle: " + e.getMessage());
        }

        System.out.println("----------------------------------------");
        System.out.println("Lectura completada.");
    }

    /**
     * Crea un archivo de demostración para que el ejemplo funcione sin configuración previa.
     */
    static void crearArchivoDemostracion(File archivo) {
        try (java.io.FileWriter escritor = new java.io.FileWriter(archivo)) {
            escritor.write("Bienvenido a Java\n");
            escritor.write("Este es un archivo de ejemplo\n");
            escritor.write("Aprendiendo a leer archivos\n");
            escritor.write("Línea 4: ¡Es más fácil de lo que parece!\n");
            escritor.write("Línea 5: Cada línea se lee con nextLine()\n");
            System.out.println("(Se creó un archivo de demostración: " + archivo.getName() + ")\n");
        } catch (java.io.IOException e) {
            System.out.println("No se pudo crear el archivo de demostración.");
        }
    }
}
