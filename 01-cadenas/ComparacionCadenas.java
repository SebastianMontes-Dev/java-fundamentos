/**
 * Demostración de comparación de cadenas en Java.
 *
 * Métodos utilizados:
 *   - equals()           : compara el contenido exacto (distingue mayúsculas/minúsculas).
 *   - equalsIgnoreCase() : compara el contenido ignorando mayúsculas/minúsculas.
 *
 * IMPORTANTE: Nunca comparar cadenas con == en Java.
 * El operador == compara referencias de memoria, no el contenido.
 * Siempre usar equals() para comparar el valor de dos cadenas.
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
