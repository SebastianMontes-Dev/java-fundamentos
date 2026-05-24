/**
 * Demostración de los métodos más comunes de la clase String en Java.
 *
 * Métodos cubiertos:
 *   - length()      : devuelve la longitud (cantidad de caracteres) de la cadena.
 *   - replace()     : reemplaza un carácter o subcadena por otro.
 *   - toUpperCase() : convierte todos los caracteres a mayúsculas.
 *   - toLowerCase() : convierte todos los caracteres a minúsculas.
 *   - trim()        : elimina los espacios en blanco al inicio y al final.
 *
 * Nota: Los objetos String en Java son inmutables. Cada método devuelve
 * una nueva cadena sin modificar la original.
 */
public class MetodosCadenas {

    public static void main(String[] args) {
        String cadena = "Informacion";
        System.out.println("Cadena original: " + cadena);
        System.out.println();

        // Longitud de la cadena
        int longitud = cadena.length();
        System.out.println("Longitud: " + longitud);

        // Reemplazar el carácter 'a' por 'i' en toda la cadena
        String cadenaReemplazada = cadena.replace('a', 'i');
        System.out.println("Reemplazando 'a' → 'i': " + cadenaReemplazada);

        // Convertir a mayúsculas
        String enMayusculas = cadena.toUpperCase();
        System.out.println("En mayúsculas:          " + enMayusculas);

        // Convertir a minúsculas
        String enMinusculas = cadena.toLowerCase();
        System.out.println("En minúsculas:          " + enMinusculas);

        System.out.println();

        // Eliminar espacios al inicio y al final con trim()
        String cadenaConEspacios = "  LEO REYES  ";
        System.out.println("Con espacios : '" + cadenaConEspacios + "'");
        System.out.println("Sin espacios : '" + cadenaConEspacios.trim() + "'");
    }
}
