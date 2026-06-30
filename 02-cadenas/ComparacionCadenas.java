/**
 * ============================================================
 *  TEMA: Manipulación de Cadenas (String) en Java
 *  SECCIÓN: 02 — Cadenas
 *  ARCHIVO: ComparacionCadenas.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Comparar cadenas correctamente es una de las habilidades más importantes en Java.
 *  Aprenderás la diferencia entre equals() (compara CONTENIDO) y == (compara
 *  REFERENCIAS de memoria), un error clásico que todo principiante comete. También
 *  verás equalsIgnoreCase() para comparaciones que no distingan mayúsculas/minúsculas,
 *  esencial en validaciones de usuario, búsquedas y formularios.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - equals(): compara el contenido exacto (distingue mayúsculas/minúsculas).
 *  - equalsIgnoreCase(): compara el contenido ignorando mayúsculas/minúsculas.
 *  - Operador ==: compara REFERENCIAS de memoria, NO el contenido. NUNCA usarlo para strings.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  String a = "hola";
 *  String b = "hola";
 *  a.equals(b);             // true (mismo contenido)
 *  "HOLA".equalsIgnoreCase("hola"); // true
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar == para comparar cadenas: solo funciona por casualidad con literales en el String Pool.
 *    Siempre usar equals() para comparar valores de texto.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
 * ============================================================
 */
public class ComparacionCadenas {

    public static void main(String[] args) {
        String cadena1 = "computadora";
        String cadena2 = "computadora";
        String cadena3 = "salmon";
        String cadena4 = "COMPUTADORA";

        // Mismo contenido → true
        System.out.println("¿cadena1 igual a cadena2? " + cadena1.equals(cadena2));

        // Contenido diferente → false
        System.out.println("¿cadena1 igual a cadena3? " + cadena1.equals(cadena3));

        // Sin ignorar mayúsculas: "computadora" != "COMPUTADORA" → false
        System.out.println("¿cadena1 igual a cadena4 (con mayúsculas)?   " + cadena1.equals(cadena4));

        // Ignorando mayúsculas: "computadora" == "COMPUTADORA" → true
        System.out.println("¿cadena1 igual a cadena4 (sin mayúsculas)?   " + cadena1.equalsIgnoreCase(cadena4));
    }
}
