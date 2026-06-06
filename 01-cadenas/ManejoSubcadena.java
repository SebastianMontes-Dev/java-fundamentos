/**
 * ============================================================
 *  TEMA: Manipulación de Cadenas (String) en Java
 *  SECCIÓN: 01 — Cadenas
 *  ARCHIVO: ManejoSubcadena.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  substring() te permite EXTRAER una porción (subcadena) de una cadena más grande
 *  especificando los índices de inicio y fin. Es una de las operaciones más usadas
 *  para parsear datos: extraer nombres de un texto, leer campos de un CSV, obtener
 *  extensiones de archivos, o cualquier tarea que implique "recortar" texto.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - substring(inicio, fin): extrae desde 'inicio' (inclusive) hasta 'fin' (exclusive).
 *  - length(): devuelve el número total de caracteres en la cadena.
 *  - El índice 'fin' NO se incluye en el resultado (fin - 1 es el último incluido).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  String fecha = "2026-06-06";
 *  String anio = fecha.substring(0, 4); // "2026"
 *  String mes  = fecha.substring(5, 7); // "06"
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Pasar un índice inicio > índice fin → StringIndexOutOfBoundsException.
 *  - Olvidar que el índice fin es exclusivo, incluyendo uno de más o de menos.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
 * ============================================================
 */
public class ManejoSubcadena {

    public static void main(String[] args) {
        String cadena = "Comida de japon";

        int longitud = cadena.length();
        System.out.println("Cadena original: " + cadena);
        System.out.println("Longitud total:  " + longitud);
        System.out.println();

        // Extracción de las tres palabras de la cadena
        String parte1 = cadena.substring(0, 6);   // "Comida"
        String parte2 = cadena.substring(7, 9);   // "de"
        String parte3 = cadena.substring(10, 15); // "japon"

        System.out.println("Primera parte  (índices 0-5):   " + parte1);
        System.out.println("Segunda parte  (índices 7-8):   " + parte2);
        System.out.println("Tercera parte  (índices 10-14): " + parte3);
    }
}
