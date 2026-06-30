/**
 * ============================================================
 *  TEMA: Métodos (Funciones) en Java — Booleanos y condiciones
 *  SECCIÓN: 10 — Métodos
 *  ARCHIVO: ParOImparFunciones.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Los métodos pueden devolver valores booleanos (true/false) para indicar el
 *  resultado de una validación. Aquí crearás un método que determina si un número
 *  es par o impar usando el operador módulo (%) y devuelve un boolean. Este patrón
 *  es muy común en validaciones y lógica de negocio.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Tipo de retorno boolean: el método devuelve true o false.
 *  - Módulo (%): operador que devuelve el residuo de una división entera.
 *  - Scanner: clase para leer entrada del usuario desde la consola.
 *  - Condicional if-else: estructura para ejecutar código según una condición.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  static boolean esPar(int numero) {
 *      return numero % 2 == 0;
 *  }
 *  // Invocación: boolean resultado = esPar(10); // true
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar que % calcula el RESTO, no el cociente.
 *  - No cerrar el Scanner después de usarlo (fuga de recursos).
 *  - Confundir = (asignación) con == (comparación) en la condición.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
 *  - Scanner API: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
 * ============================================================
 */
import java.util.Scanner;

public class ParOImparFunciones {

    /**
     * Determina si un número entero es par o impar.
     *
     * @param numeroRecibido número entero a evaluar
     * @return true si el número es par, false si es impar
     */
    static boolean confirmarPar(int numeroRecibido) {
        if (numeroRecibido % 2 == 0) {
            System.out.println("El número " + numeroRecibido + " SÍ es par");
            return true;
        } else {
            System.out.println("El número " + numeroRecibido + " NO es par (es impar)");
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Verificador de número par o impar ===\n");

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número que desea verificar: ");
        int numero = sc.nextInt();

        // Invocamos el método y mostramos el resultado
        boolean esPar = confirmarPar(numero);

        System.out.println("Resultado de la verificación: " + (esPar ? "PAR" : "IMPAR"));

        sc.close();
    }
}
