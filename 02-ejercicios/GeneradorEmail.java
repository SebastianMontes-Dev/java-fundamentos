/**
 * Ejercicio: Generador de correo corporativo.
 *
 * A partir del nombre del empleado, la empresa y el dominio,
 * el programa construye automáticamente una dirección de correo corporativo.
 *
 * Formato generado: nombre.apellido@empresa.dominio
 *
 * Conceptos practicados:
 *   - strip()      : elimina espacios al inicio y al final.
 *   - toLowerCase(): convierte todo a minúsculas.
 *   - replace()    : reemplaza espacios por puntos (en nombre) o los elimina (en empresa).
 *   - Concatenación de cadenas para armar el correo final.
 */
public class GeneradorEmail {

    public static void main(String[] args) {
        String nombre  = "Ubaldo Acosta Soto";
        String empresa = "Global Mentoring";
        String dominio = "com.mx";

        // "Ubaldo Acosta Soto" → "ubaldo.acosta.soto"
        String nombreEmail = nombre.strip().toLowerCase().replace(" ", ".");

        // "Global Mentoring" → "globalmentoring"
        String empresaEmail = empresa.strip().toLowerCase().replace(" ", "");

        // Construir el correo: nombre@empresa.dominio
        String correo = nombreEmail + "@" + empresaEmail + "." + dominio;

        System.out.println("Nombre  : " + nombre);
        System.out.println("Empresa : " + empresa);
        System.out.println("Correo  : " + correo);
    }
}
