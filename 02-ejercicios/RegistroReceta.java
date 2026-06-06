import java.util.Scanner;

/**
 * ============================================================
 *  TEMA: Ejercicios Aplicados en Java
 *  SECCIÓN: 02 — Ejercicios
 *  ARCHIVO: RegistroReceta.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Implementarás un registro de recetas de cocina usando entrada por consola.
 *  Capturarás campos de texto, un valor numérico decimal (tiempo de preparación)
 *  y una clasificación (dificultad). Es un Excelente ejercicio para practicar
 *  la combinación de diferentes tipos de datos en una aplicación de formulario,
 *  similar a los CRUD que construirás en aplicaciones web o de escritorio.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - nextLine(): lectura de cualquier cantidad de texto hasta el Enter.
 *  - Double.parseDouble(): conversión de texto a número decimal.
 *  - Secuencias de escape \t y \n para formatear la presentación de datos.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  String nombre = sc.nextLine();
 *  double tiempo = Double.parseDouble(sc.nextLine());
 *  System.out.println("\tNombre: " + nombre);
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar nextDouble() y luego nextLine() sin consumir el salto de línea sobrante.
 *  - No validar que el tiempo ingresado sea un número positivo.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
 * ============================================================
 */
public class RegistroReceta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la receta: ");
        String receta = scanner.nextLine();

        System.out.print("Ingrese los ingredientes principales: ");
        String ingredientes = scanner.nextLine();

        System.out.print("Ingrese el tiempo de preparación (minutos): ");
        double tiempo = Double.parseDouble(scanner.nextLine());

        System.out.print("Dificultad de la receta (Fácil, Media, Difícil): ");
        String dificultad = scanner.nextLine();

        System.out.println("\n--- Receta Registrada ---");
        System.out.println("\tNombre:       " + receta);
        System.out.println("\tIngredientes: " + ingredientes);
        System.out.println("\tTiempo:       " + tiempo + " minuto(s)");
        System.out.println("\tDificultad:   " + dificultad);

        scanner.close();
    }
}
