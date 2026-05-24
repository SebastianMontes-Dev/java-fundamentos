/**
 * Demostración del método replace() para reemplazar subcadenas en Java.
 *
 * replace(viejo, nuevo) sustituye TODAS las ocurrencias de 'viejo' por 'nuevo'.
 *
 * Los Strings en Java son inmutables: replace() no modifica la cadena original,
 * sino que devuelve una nueva cadena con los cambios aplicados.
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
