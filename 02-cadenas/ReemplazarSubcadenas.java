/**
 * ============================================================
 *  TEMA: Manipulación de Cadenas (String) en Java
 *  SECCIÓN: 02 — Cadenas
 *  ARCHIVO: ReemplazarSubcadenas.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  replace() sustituye TODAS las ocurrencias de una subcadena por otra dentro de
 *  un String. Como los Strings son inmutables en Java, el método NO modifica la
 *  cadena original sino que devuelve UNA NUEVA cadena con los reemplazos aplicados.
 *  Es esencial para limpiar datos, normalizar formatos y corregir texto automáticamente.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - replace(viejo, nuevo): reemplaza todas las ocurrencias de 'viejo' por 'nuevo'.
 *  - Inmutabilidad: el String original permanece intacto, se crea uno nuevo.
 *  - Funciona tanto con caracteres (char) como con subcadenas (CharSequence).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  String texto = "Hola mundo, adios mundo";
 *  String nuevo = texto.replace("mundo", "Java"); // "Hola Java, adios Java"
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar asignar el resultado: texto.replace("a", "b") no modifica 'texto'.
 *    Siempre hacer: texto = texto.replace("a", "b") o guardar en otra variable.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
 * ============================================================
 */
public class ReemplazarSubcadenas {

    public static void main(String[] args) {
        String cadena = "clase de matematicas";
        System.out.println("Cadena original:   " + cadena);

        // Reemplazar "matematicas" por "calculo"
        String cadenaReemplazada = cadena.replace("matematicas", "calculo");
        System.out.println("Cadena modificada: " + cadenaReemplazada);
    }
}
