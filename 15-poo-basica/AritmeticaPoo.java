/**
 * ============================================================
 *  TEMA: Programación Orientada a Objetos — Métodos de instancia
 *  SECCIÓN: 15 — POO Básica
 *  ARCHIVO: AritmeticaPoo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Los métodos de instancia operan sobre los atributos de un objeto. A diferencia
 *  de los métodos estáticos, los métodos de instancia se invocan a través de un
 *  objeto creado con `new`. Aquí construirás una calculadora orientada a objetos
 *  donde cada operación (sumar, restar, multiplicar, dividir) es un método que
 *  trabaja con los atributos `num1` y `num2` del objeto.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Método de instancia: método que pertenece a un objeto, no a la clase.
 *  - Atributos de instancia: variables que almacenan el estado de cada objeto.
 *  - Encapsulamiento implícito: los atributos son accedidos por los métodos del objeto.
 *  - Scanner: clase para leer entrada del usuario desde la consola.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  class Calculadora {
 *      double a, b;
 *      void sumar() { System.out.println(a + b); }
 *  }
 *  Calculadora calc = new Calculadora();
 *  calc.a = 10; calc.b = 5; calc.sumar();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Invocar un método de instancia sin crear el objeto con `new` (NullPointerException).
 *  - Olvidar asignar valores a los atributos antes de usar los métodos.
 *  - Dividir entre cero: con double produce Infinity, con int lanza ArithmeticException.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html
 *  - Scanner API: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
 * ============================================================
 */
import java.util.Scanner;

public class AritmeticaPoo {

    // Atributos: operandos de la calculadora
    double num1;
    double num2;

    /**
     * Realiza la suma de num1 y num2 y muestra el resultado.
     */
    void sumar() {
        System.out.println("Suma           : " + num1 + " + " + num2 + " = " + (num1 + num2));
    }

    /**
     * Realiza la resta de num1 y num2 y muestra el resultado.
     */
    void restar() {
        System.out.println("Resta          : " + num1 + " - " + num2 + " = " + (num1 - num2));
    }

    /**
     * Realiza la multiplicación de num1 y num2 y muestra el resultado.
     */
    void multiplicar() {
        System.out.println("Multiplicación : " + num1 + " * " + num2 + " = " + (num1 * num2));
    }

    /**
     * Realiza la división de num1 entre num2 y muestra el resultado.
     * Con double, dividir entre cero produce Infinity (no lanza excepción).
     */
    void dividir() {
        System.out.println("División       : " + num1 + " / " + num2 + " = " + (num1 / num2));
    }

    public static void main(String[] args) {

        System.out.println("=== Calculadora Aritmética con POO ===\n");

        Scanner sc = new Scanner(System.in);

        // Creamos una instancia de la calculadora
        AritmeticaPoo aritmetica = new AritmeticaPoo();

        // Solicitamos los operandos al usuario
        System.out.print("Ingrese el primer número  (num1): ");
        aritmetica.num1 = sc.nextDouble();

        System.out.print("Ingrese el segundo número (num2): ");
        aritmetica.num2 = sc.nextDouble();

        System.out.println("\n--- Resultados ---");

        // Invocamos cada método de instancia para realizar las operaciones
        aritmetica.sumar();
        aritmetica.restar();
        aritmetica.multiplicar();
        aritmetica.dividir();

        sc.close();
    }
}
