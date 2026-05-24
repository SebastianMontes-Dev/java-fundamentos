/**
 * Demostración de búsqueda de subcadenas en Java.
 *
 * Métodos utilizados:
 *   - indexOf()     : devuelve el índice de la PRIMERA aparición de la subcadena.
 *   - lastIndexOf() : devuelve el índice de la ÚLTIMA aparición de la subcadena.
 *
 * Si la subcadena no existe en la cadena, ambos métodos devuelven -1.
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
