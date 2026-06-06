/**
 * ============================================================
 *  TEMA: Métodos (Funciones) en Java
 *  SECCIÓN: 09 — Métodos
 *  ARCHIVO: Funciones.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Un método (o función) es un bloque de código reutilizable que ejecuta una tarea
 *  específica. Los métodos permiten organizar el código, evitar repetición y hacer
 *  programas más mantenibles. Aquí aprenderás a declarar un método estático (static)
 *  con parámetros y a invocarlo desde el método principal `main`.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Firma del método: `static void nombre(tipo parametro)` define qué recibe y devuelve.
 *  - static: permite invocar el método sin crear un objeto de la clase.
 *  - void: el método no devuelve ningún valor.
 *  - Parámetros: variables que reciben datos al invocar el método.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  static void saludar(String mensaje) {
 *      System.out.println("Mensaje: " + mensaje);
 *  }
 *  // Invocación: saludar("Hola mundo");
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar el tipo del parámetro en la declaración: `void saludar(mensaje)` no compila.
 *  - Pasar un argumento de tipo incorrecto al método.
 *  - Llamar al método desde un contexto no estático sin crear instancia.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
 * ============================================================
 */
public class Funciones {

    /**
     * Método que recibe un mensaje de texto y lo imprime en consola
     * con un prefijo decorativo.
     *
     * @param mensaje texto que se desea imprimir
     */
    static void saludar(String mensaje) {
        System.out.println("Mensaje: " + mensaje);
    }

    public static void main(String[] args) {

        System.out.println("=== Invocando un método desde main ===\n");

        // Llamamos al método 'saludar' pasando un String como argumento
        saludar("Hola mundo desde Java");

        // Podemos invocar el método tantas veces como necesitemos
        saludar("¡Los métodos hacen el código reutilizable!");
    }
}
