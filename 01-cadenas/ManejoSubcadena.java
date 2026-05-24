/**
 * Demostración del método substring() para extraer porciones de una cadena en Java.
 *
 * Métodos utilizados:
 *   - length()               : devuelve la cantidad de caracteres de la cadena.
 *   - substring(inicio, fin) : extrae los caracteres desde el índice 'inicio'
 *                              hasta 'fin - 1' (el índice final es exclusivo).
 *
 * Ejemplo visual con "Comida de japon":
 *   índices:  0123456789012345
 *   cadena:   Comida de japon
 *             ^^^^^^           → substring(0, 6)  = "Comida"
 *                    ^^        → substring(7, 9)  = "de"
 *                       ^^^^^ → substring(10, 15) = "japon"
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
