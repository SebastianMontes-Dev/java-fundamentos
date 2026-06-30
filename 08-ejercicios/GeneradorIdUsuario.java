import java.util.Random;
import java.util.Scanner;

/**
 * ============================================================
 *  TEMA: Ejercicios Aplicados en Java
 *  SECCIÓN: 08 — Ejercicios
 *  ARCHIVO: GeneradorIdUsuario.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Implementarás un generador de ID único que combina manipulación de cadenas,
 *  números aleatorios y entrada de usuario. Extraerás iniciales con substring(),
 *  normalizarás texto con toUpperCase() y añadirás entropía con Random. Este
 *  patrón se usa en sistemas de matrículas, códigos de empleado y generación
 *  de identificadores únicos en aplicaciones reales.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - substring(inicio, fin): extrae las primeras letras del nombre y apellido.
 *  - toUpperCase(): normaliza las iniciales a mayúsculas.
 *  - Random.nextInt(limite): genera un número aleatorio entre 0 y limite-1.
 *  - Formateo con guiones: construye un ID legible concatenando partes.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  String iniciales = nombre.toUpperCase().substring(0, 2);
 *  int aleatorio = new Random().nextInt(10000);
 *  String id = iniciales + "-" + aleatorio;
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - No validar que el nombre/apellido tengan al menos 2 caracteres.
 *  - Usar substring sin verificar la longitud antes → StringIndexOutOfBoundsException.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Random.html
 * ============================================================
 */
public class GeneradorIdUsuario {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String inicialesNombre = scanner.nextLine().toUpperCase().substring(0, 2);

        System.out.print("Ingrese sus apellidos: ");
        String inicialesApellido = scanner.nextLine().toUpperCase().substring(0, 2);

        System.out.print("Ingrese su año de nacimiento (ej. 1995): ");
        String anioNacimiento = scanner.nextLine();
        String digitosAnio = anioNacimiento.substring(2, 4);

        int numeroAleatorio = random.nextInt(10000);

        // ID formateado: NA-AP-95-XXXX
        String idUsuario = inicialesNombre + "-" + inicialesApellido
                + "-" + digitosAnio + "-" + numeroAleatorio;

        System.out.println("\nID generado: " + idUsuario);

        scanner.close();
    }
}
