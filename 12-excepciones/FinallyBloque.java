/**
 * ============================================================
 *  TEMA: Manejo de Excepciones en Java
 *  SECCIÓN: 12 — Excepciones
 *  ARCHIVO: FinallyBloque.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  El bloque `finally` se ejecuta SIEMPRE, independientemente de si ocurrió una
 *  excepción o no, e incluso si hay un `return` dentro del try o catch. Su propósito
 *  principal es liberar recursos (cerrar archivos, conexiones de red, streams, etc.)
 *  garantizando que la limpieza se realice sin importar cómo termine el bloque try.
 *  Con try-with-resources (Java 7+) muchos casos de finally se simplifican, pero
 *  entenderlo es fundamental.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - finally: se ejecuta después de try (y catch si hubo), SIEMPRE.
 *  - Garantía de ejecución: incluso con return, break o excepción no capturada.
 *  - Limpieza de recursos: cerrar archivos, scanners, conexiones.
 *  - try-with-resources: alternativa moderna que cierra automáticamente (Java 7+).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  try {
 *      // abrir recurso
 *  } catch (Exception e) {
 *      // manejar error
 *  } finally {
 *      // cerrar recurso (se ejecuta SIEMPRE)
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Creer que finally no se ejecuta si hay return en try (SÍ se ejecuta).
 *  - Lanzar una excepción dentro de finally (puede ocultar la excepción original).
 *  - Poner return dentro de finally (suprime cualquier excepción no capturada).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html
 * ============================================================
 */
public class FinallyBloque {

    public static void main(String[] args) {

        System.out.println("=== El bloque finally en Java ===\n");

        // Ejemplo 1: finally con try exitoso (sin excepción)
        System.out.println("--- Ejemplo 1: Sin excepción ---");
        probarFinally(10, 2);

        // Ejemplo 2: finally cuando ocurre una excepción
        System.out.println("\n--- Ejemplo 2: Con excepción ---");
        probarFinally(10, 0);

        // Ejemplo 3: Demostración de que finally se ejecuta incluso con return
        System.out.println("\n--- Ejemplo 3: finally con return en try ---");
        int resultado = demostrarReturnConFinally();
        System.out.println("Valor retornado: " + resultado);
    }

    static void probarFinally(int a, int b) {
        try {
            System.out.println("  [try] Iniciando división " + a + " / " + b);
            int resultado = a / b;
            System.out.println("  [try] Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("  [catch] Error: división entre cero.");
        } finally {
            // Este mensaje aparece SIEMPRE, haya o no excepción
            System.out.println("  [finally] Limpieza completada. Recursos liberados.");
        }
    }

    static int demostrarReturnConFinally() {
        try {
            System.out.println("  [try] Ejecutando return 100...");
            return 100; // Aunque hay return, el finally se ejecuta ANTES de devolver
        } finally {
            System.out.println("  [finally] ¡Me ejecuto incluso antes del return!");
            // ¡Cuidado! Si pones un return aquí, SOBREESCRIBE el return del try
        }
    }
}
