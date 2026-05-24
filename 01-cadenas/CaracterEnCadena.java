/**
 * Demostración del método charAt() para acceder a caracteres individuales
 * de una cadena en Java.
 *
 * charAt(indice) devuelve el carácter ubicado en la posición indicada.
 * Los índices comienzan en 0 (primer carácter) y terminan en length()-1 (último).
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
