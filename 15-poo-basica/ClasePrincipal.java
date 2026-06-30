/**
 * ============================================================
 *  TEMA: Programación Orientada a Objetos — Fundamentos
 *  SECCIÓN: 15 — POO Básica
 *  ARCHIVO: ClasePrincipal.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Integrarás todos los conceptos de POO básica en un programa completo: uso de
 *  `new` para crear objetos, invocación de métodos con parámetros y retorno,
 *  y manejo de objetos como ciudadanos de primera clase. Este archivo actúa como
 *  punto de entrada que orquesta varias clases trabajando juntas, simulando
 *  una pequeña aplicación del mundo real.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Clase principal (main): orquesta la creación y uso de otros objetos.
 *  - Métodos con retorno: devuelven un valor calculado al código que los invoca.
 *  - Métodos con parámetros: reciben datos externos para realizar su tarea.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Calculadora calc = new Calculadora();
 *  int resultado = calc.sumar(5, 3); // método con retorno y parámetros
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Ignorar el valor de retorno de un método (si devuelve algo, debes usarlo o guardarlo).
 *  - Crear objetos innecesarios dentro de bucles (impacta el rendimiento).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/usingobject.html
 * ============================================================
 */
public class ClasePrincipal {

    public static void main(String[] args) {

        System.out.println("=== Programa Principal: Integración de POO ===\n");

        // Creamos un objeto Calculadora
        Calculadora calc = new Calculadora();

        // Usamos métodos que reciben parámetros y devuelven valores
        int suma = calc.sumar(15, 27);
        int multiplicacion = calc.multiplicar(6, 8);
        double division = calc.dividir(100, 3);

        // Mostramos los resultados obtenidos
        System.out.println("Resultados de la calculadora:");
        System.out.println("  15 + 27 = " + suma);
        System.out.println("  6  x 8  = " + multiplicacion);
        System.out.printf("  100 / 3 = %.2f%n", division);

        // Creamos un objeto Mensajero y lo usamos
        Mensajero mensajero = new Mensajero();
        String saludoPersonalizado = mensajero.crearSaludo("Sebastián");
        System.out.println("\n" + saludoPersonalizado);
    }
}

class Calculadora {

    // Método con retorno: recibe dos enteros, devuelve su suma
    int sumar(int a, int b) {
        return a + b; // return envía el resultado de vuelta a quien invocó
    }

    // Método que multiplica dos números enteros
    int multiplicar(int a, int b) {
        return a * b;
    }

    // Método que divide y devuelve un double (más preciso que int)
    double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
            return 0;
        }
        return dividendo / divisor;
    }
}

class Mensajero {

    // Método que recibe un nombre y devuelve un saludo formateado
    String crearSaludo(String nombre) {
        return "¡Hola " + nombre + "! Bienvenido al mundo de la programación orientada a objetos.";
    }
}
