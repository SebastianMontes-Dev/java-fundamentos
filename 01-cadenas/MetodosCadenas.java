/**
 * ============================================================
 *  TEMA: Manipulación de Cadenas (String) en Java
 *  SECCIÓN: 01 — Cadenas
 *  ARCHIVO: MetodosCadenas.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Este archivo reúne los 5 métodos más utilizados de la clase String: length()
 *  para conocer el tamaño, replace() para sustituir texto, toUpperCase() y
 *  toLowerCase() para normalizar mayúsculas/minúsculas, y trim() para limpiar
 *  espacios. Dominar estos métodos es el primer paso para cualquier tarea de
 *  procesamiento de texto en Java, desde formularios web hasta parseo de archivos.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - length(): devuelve la cantidad de caracteres de la cadena.
 *  - replace(): reemplaza un carácter o subcadena por otro (todas las ocurrencias).
 *  - toUpperCase() / toLowerCase(): convierten a mayúsculas/minúsculas.
 *  - trim(): elimina espacios en blanco al inicio y al final.
 *  - Inmutabilidad: los String en Java NUNCA se modifican; cada método devuelve una NUEVA cadena.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  String texto = "  Hola Mundo  ";
 *  texto.trim().toUpperCase(); // "HOLA MUNDO"
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Esperar que el String original cambie: String es INMUTABLE, siempre guarda el resultado.
 *  - trim() solo elimina espacios al inicio y final, no los espacios entre palabras.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
 * ============================================================
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
