/**
 * ============================================================
 *  TEMA: Ejercicios Aplicados en Java
 *  SECCIÓN: 02 — Ejercicios
 *  ARCHIVO: GeneradorEmail.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aplicarás métodos de manipulación de cadenas para construir automáticamente
 *  un correo electrónico corporativo a partir del nombre del empleado y la empresa.
 *  Combina strip(), toLowerCase() y replace() en un flujo de transformación de
 *  texto similar al que usarías en sistemas de onboarding, generación de cuentas
 *  y normalización de datos en entornos empresariales.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - strip(): elimina espacios en blanco al inicio y final (versión moderna de trim()).
 *  - toLowerCase(): normaliza todo el texto a minúsculas para el formato de correo.
 *  - replace(): sustituye espacios por puntos o los elimina según la parte del correo.
 *  - Concatenación de cadenas: unir partes para formar el correo final.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  String correo = nombre.strip().toLowerCase().replace(" ", ".")
 *                  + "@" + empresa.strip().toLowerCase().replace(" ", "")
 *                  + "." + dominio;
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Mezclar trim() y strip(): en Java 11+ prefiere strip() (maneja Unicode).
 *  - Olvidar normalizar a minúsculas: los correos electrónicos no distinguen mayúsculas,
 *    pero es buena práctica estandarizarlos.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html
 * ============================================================
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
