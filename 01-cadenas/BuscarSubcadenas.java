/**
 * ============================================================
 *  TEMA: Manipulación de Cadenas (String) en Java
 *  SECCIÓN: 01 — Cadenas
 *  ARCHIVO: BuscarSubcadenas.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a buscar texto dentro de una cadena usando indexOf() (primera
 *  aparición) y lastIndexOf() (última aparición). Estas búsquedas son esenciales
 *  para validar si una cadena contiene cierta palabra, extraer información de
 *  logs, procesar archivos de texto o implementar filtros de búsqueda básicos.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - indexOf(): devuelve el índice de la PRIMERA aparición de la subcadena (o -1 si no existe).
 *  - lastIndexOf(): devuelve el índice de la ÚLTIMA aparición de la subcadena (o -1 si no existe).
 *  - Los índices en String comienzan en 0 (primer carácter).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  String texto = "hola mundo hola";
 *  int primera = texto.indexOf("hola");    // 0
 *  int ultima  = texto.lastIndexOf("hola"); // 11
 *  int noEsta  = texto.indexOf("adios");    // -1
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Asumir que indexOf devuelve false/true en vez de un índice numérico.
 *  - No verificar si devolvió -1 antes de usar el índice (causaría StringIndexOutOfBoundsException).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
 * ============================================================
 */
public class BuscarSubcadenas {

    public static void main(String[] args) {

        // La cadena tiene "practica" dos veces para mostrar la diferencia
        // entre indexOf (primera aparición) y lastIndexOf (última aparición)
        String cadena = "practica java practica";

        // Primera aparición de "practica" → índice 0
        int primeraAparicion = cadena.indexOf("practica");
        System.out.println("Índice de la primera aparición de 'practica': " + primeraAparicion);

        // Última aparición de "practica" → índice 14
        int ultimaAparicion = cadena.lastIndexOf("practica");
        System.out.println("Índice de la última aparición de 'practica':  " + ultimaAparicion);

        // Subcadena que no existe → devuelve -1
        int noEncontrada = cadena.indexOf("clases");
        System.out.println("Índice de 'clases' (no existe):               " + noEncontrada);
    }
}
