/**
 * ============================================================
 *  TEMA: Código Testeable — La Calculadora
 *  SECCIÓN: 33 — Testing con JUnit
 *  ARCHIVO: Calculadora.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Esta es la clase BAJO PRUEBA (system under test). Es una calculadora
 *  simple con suma, resta, multiplicación y división. La división lanza
 *  una excepción si intentas dividir por cero, lo que nos permite
 *  practicar pruebas de excepciones con JUnit.
 *
 *  En el mundo real, esta clase sería parte de tu lógica de negocio y
 *  los tests en TestCalculadora.java verificarían que funciona
 *  correctamente antes de desplegar a producción.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Métodos puros (sin efectos secundarios): fáciles de testear.
 *  - Lanzar excepciones para casos inválidos (mejor que retornar null).
 *  - Separar lógica de negocio de I/O (esta clase no imprime nada).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - JUnit 5 User Guide: https://junit.org/junit5/docs/current/user-guide/
 * ============================================================
 */
public class Calculadora {

    public int sumar(int a, int b) {
        return a + b;
    }

    public int restar(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide a entre b.
     * @throws IllegalArgumentException si b es 0.
     */
    public double dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return (double) a / b;
    }

    /**
     * Calcula el factorial de n (0 <= n <= 12 para evitar overflow).
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para negativos");
        }
        if (n > 12) {
            throw new IllegalArgumentException("n demasiado grande (overflow con long)");
        }
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    /**
     * Verifica si un número es par.
     */
    public boolean esPar(int n) {
        return n % 2 == 0;
    }
}
