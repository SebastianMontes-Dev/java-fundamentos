/**
 * ============================================================
 *  TEMA: Estructuras de Control — Bucles en Java
 *  SECCIÓN: 07 — Bucles
 *  ARCHIVO: MenuIterativo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Implementarás un menú interactivo completo usando un bucle `while` controlado
 *  por una variable centinela (boolean). Combina while, if-else if, Scanner y
 *  operaciones aritméticas en un solo programa. Este es el patrón clásico de
 *  "aplicación de consola" que encontrarás en sistemas de punto de venta,
 *  cajeros automáticos y herramientas de línea de comandos.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Variable centinela (boolean): controla cuándo debe salir el bucle.
 *  - Text Block ("""): sintaxis Java 15+ para strings multilínea más legibles.
 *  - Menú de opciones: combinación while + if-else if + Scanner.
 *  - Acumulador (saldoActual): variable que se modifica progresivamente.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  boolean salir = false;
 *  while (!salir) {
 *      // mostrar menú
 *      // leer opción
 *      // procesar con if-else
 *      // si opción es salir: salir = true;
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - No validar que el retiro no supere el saldo disponible.
 *  - Usar nextInt() y luego nextLine() sin consumir el salto de línea pendiente.
 *  - Olvidar la condición de salida, creando un bucle infinito.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html
 * ============================================================
 */
import java.util.Scanner;

public class MenuIterativo {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        // Saldo inicial del cajero (actúa como acumulador)
        double saldoActual = 10000;

        // Variable centinela: cuando sea true, el bucle termina
        boolean salir = false;

        // El bucle se ejecuta mientras NO queramos salir
        while (!salir) {

            // Menú mostrado con Text Block (""") — más legible que concatenar strings
            System.out.print("""
                    \n*** Cajero Automático ***
                    Menú:
                    1. Saldo actual
                    2. Depositar dinero
                    3. Retirar dinero
                    4. Salir
                    Opción:\s""");

            var opcion = sc.nextInt();

            // Procesamos la opción elegida por el usuario
            if (opcion == 1) {
                System.out.printf("Saldo actual: $%.2f%n", saldoActual);

            } else if (opcion == 2) {
                System.out.print("Ingrese la cantidad que desea depositar: $");
                var deposito = sc.nextDouble();
                saldoActual += deposito; // operador compuesto: suma y asigna
                System.out.printf("Depósito exitoso. Nuevo saldo: $%.2f%n", saldoActual);

            } else if (opcion == 3) {
                System.out.print("Ingrese la cantidad que desea retirar: $");
                var retirar = sc.nextDouble();

                // Validación: no se puede retirar más de lo que hay
                if (retirar <= saldoActual) {
                    saldoActual -= retirar;
                    System.out.printf("Retiro exitoso. Nuevo saldo: $%.2f%n", saldoActual);
                } else {
                    System.out.println("Saldo insuficiente. Intente con un monto menor.");
                }

            } else if (opcion == 4) {
                // Activamos la condición de salida del bucle
                salir = true;
                System.out.println("Gracias por usar el cajero automático. ¡Hasta pronto!");

            } else {
                System.out.println("Opción no válida. Por favor, elija una opción del 1 al 4.");
            }
        }

        sc.close();
    }
}
