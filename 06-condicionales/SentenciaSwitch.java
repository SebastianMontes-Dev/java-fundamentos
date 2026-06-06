/**
 * ============================================================
 *  TEMA: Estructuras Condicionales en Java
 *  SECCIÓN: 06 — Condicionales
 *  ARCHIVO: SentenciaSwitch.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La sentencia `switch` permite ejecutar diferentes bloques de código según el
 *  valor de una variable (int, char, String, enum). Es más limpio que múltiples
 *  `if-else if` cuando comparas una misma variable contra muchos valores fijos.
 *  El `break` es esencial para evitar el "fall-through" (que se ejecuten los
 *  casos siguientes sin quererlo).
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - case: cada valor posible que puede tomar la variable evaluada.
 *  - break: sale del switch inmediatamente después de ejecutar un caso.
 *  - default: se ejecuta si ningún case coincide (opcional pero recomendado).
 *  - Fall-through: sin break, la ejecución "cae" al siguiente case.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  switch (variable) {
 *      case valor1:
 *          // código
 *          break;
 *      case valor2:
 *          // código
 *          break;
 *      default:
 *          // código por defecto
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar el `break` provoca que se ejecuten los casos siguientes (fall-through).
 *  - No incluir un caso `default` para manejar valores inesperados.
 *  - Intentar usar switch con tipos no soportados (double, boolean, long no son válidos).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html
 * ============================================================
 */
import java.util.Scanner;

public class SentenciaSwitch {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        // Solicitamos un número de día al usuario
        System.out.print("Ingrese el número de día (1 = Lunes, 2 = Martes, ...): ");
        var dia = sc.nextInt();

        System.out.println();

        // Evaluamos la variable 'dia' contra cada caso posible
        switch (dia) {
            case 1:
                System.out.println("Día lunes - Inicio de semana");
                break; // Salimos del switch, NO seguimos al case 2

            case 2:
                System.out.println("Día martes");
                break;

            case 3:
                System.out.println("Día miércoles - Mitad de semana");
                break;

            case 4:
                System.out.println("Día jueves");
                break;

            case 5:
                System.out.println("Día viernes - ¡Fin de semana laboral!");
                break;

            case 6:
                System.out.println("Día sábado - Fin de semana");
                break;

            case 7:
                System.out.println("Día domingo");
                break;

            // Si el usuario ingresa cualquier número fuera del 1-7
            default:
                System.out.println("No seleccionaste un día válido (1-7).");
                break;
        }

        sc.close();
    }
}
