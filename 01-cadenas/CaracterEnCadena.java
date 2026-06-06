/**
 * ============================================================
 *  TEMA: Manipulación de Cadenas (String) en Java
 *  SECCIÓN: 01 — Cadenas
 *  ARCHIVO: CaracterEnCadena.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  charAt() te permite acceder a UN carácter específico de una cadena usando su
 *  índice (posición). Es como tratar la cadena como un arreglo de caracteres de
 *  solo lectura. Fundamental para validar formatos (ej: si un DNI empieza con X),
 *  procesar texto carácter por carácter o extraer iniciales.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - charAt(indice): devuelve el carácter (tipo char) en la posición 'indice'.
 *  - Índices base 0: el primer carácter está en la posición 0.
 *  - length(): devuelve la cantidad total de caracteres de la cadena.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  String nombre = "Java";
 *  char primeraLetra = nombre.charAt(0); // 'J'
 *  char ultimaLetra = nombre.charAt(nombre.length() - 1); // 'a'
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar un índice negativo o >= length() → StringIndexOutOfBoundsException.
 *  - Confundir charAt() con substring(): charAt() devuelve un char, no un String.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
 * ============================================================
 */
public class CaracterEnCadena {

    public static void main(String[] args) {
        String cadena = "hombre";

        System.out.println("Cadena completa: " + cadena);

        // Primer carácter → índice 0
        char primerCaracter = cadena.charAt(0);
        System.out.println("Primer carácter (índice 0): " + primerCaracter);

        // Último carácter → índice length()-1
        char ultimoCaracter = cadena.charAt(cadena.length() - 1);
        System.out.println("Último carácter (índice " + (cadena.length() - 1) + "): " + ultimoCaracter);
    }
}
