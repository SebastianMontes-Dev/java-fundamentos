/**
 * ============================================================
 *  TEMA: Manejo de Excepciones en Java
 *  SECCIÓN: 12 — Excepciones
 *  ARCHIVO: MultiplesCatch.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Un mismo bloque `try` puede tener MÚLTIPLES bloques `catch` para manejar
 *  diferentes tipos de excepciones de forma específica. Java evalúa los catch
 *  en orden, ejecutando SOLO el primero que coincida con la excepción lanzada.
 *  También existe el multi-catch (`catch (Exc1 | Exc2 e)`) para manejar varios
 *  tipos con el mismo código. Es clave para dar respuestas precisas a cada error.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Múltiples catch: un catch por cada tipo de excepción que quieras manejar.
 *  - Jerarquía de excepciones: los catch más específicos DEBEN ir primero.
 *  - Multi-catch (|): `catch (IOException | SQLException e)` comparte lógica.
 *  - Jerarquía: Exception > RuntimeException > ArithmeticException, etc.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  try {
 *      // código riesgoso
 *  } catch (ArithmeticException e) {
 *      // manejo específico para división entre cero
 *  } catch (NullPointerException e) {
 *      // manejo específico para objeto nulo
 *  } catch (Exception e) {
 *      // captura cualquier otra excepción (genérico, al final)
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Poner `catch (Exception e)` primero: capturaría todo y los catch específicos
 *    nunca se ejecutarían (error de compilación en algunos casos).
 *  - Multi-catch con tipos relacionados por herencia (no permitido).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/essential/exceptions/catch.html
 * ============================================================
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiplesCatch {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.println("=== Múltiples Catch en Java ===\n");

        try {
            System.out.print("Ingrese un número entero (numerador): ");
            int numerador = sc.nextInt();

            System.out.print("Ingrese otro número entero (denominador): ");
            int denominador = sc.nextInt();

            // Esta línea puede lanzar ArithmeticException si denominador = 0
            int resultado = numerador / denominador;
            System.out.println("Resultado de la división: " + resultado);

        } catch (ArithmeticException e) {
            // Se ejecuta solo si hubo división entre cero
            System.out.println("Error matemático: No se puede dividir entre cero.");

        } catch (InputMismatchException e) {
            // Se ejecuta solo si el usuario ingresó texto en vez de número
            System.out.println("Error de entrada: Debe ingresar un número entero válido.");

        } catch (Exception e) {
            // Catch genérico: captura cualquier otra excepción no prevista
            // Siempre debe ir AL FINAL, después de los catch específicos
            System.out.println("Error inesperado: " + e.getMessage());

        } finally {
            // El bloque finally SIEMPRE se ejecuta, haya o no excepción
            System.out.println("\n[finally] Cerrando recursos del programa...");
            sc.close();
        }

        System.out.println("Programa finalizado.");
    }
}
