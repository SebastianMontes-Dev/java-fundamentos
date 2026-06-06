/**
 * ============================================================
 *  TEMA: Operadores y Estructuras Condicionales en Java
 *  SECCIÓN: 06 — Condicionales
 *  ARCHIVO: OperadorTernario.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  El operador ternario `? :` es el único operador de tres operandos en Java.
 *  Funciona como un "if-else compacto" que evalúa una condición y devuelve uno
 *  de dos valores según el resultado. Es ideal para asignaciones condicionales
 *  simples donde un if-else completo resultaría demasiado verboso.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Estructura: `condición ? valorSiTrue : valorSiFalse`
 *  - Evalúa una expresión booleana y retorna un valor.
 *  - Útil para inicializar variables con valores condicionales en una sola línea.
 *  - No reemplaza if-else cuando hay múltiples instrucciones dentro de cada rama.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  String resultado = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
 *  // Equivale a:
 *  // if (edad >= 18) resultado = "Mayor de edad";
 *  // else            resultado = "Menor de edad";
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Anidar ternarios: (a > b) ? "grande" : (a < b) ? "chico" : "igual"
 *    se vuelve ilegible rápidamente; mejor usar if-else.
 *  - Olvidar que el ternario DEBE devolver un valor y asignarse o usarse en una expresión.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
 * ============================================================
 */
public class OperadorTernario {

    public static void main(String[] args) {

        System.out.println("=== Operador Ternario en Java ===\n");

        // Ejemplo 1: Determinar mayoría de edad
        var edad = 18;

        // El ternario evalúa la condición antes del signo ?
        // Si es true → devuelve lo que está después del ?
        // Si es false → devuelve lo que está después de los :
        String resultado = (edad >= 18) ? "eres mayor de edad" : "eres menor de edad";

        System.out.println("Edad: " + edad);
        System.out.println("Resultado: " + resultado);

        // Ejemplo 2: Determinar si un número es par o impar
        var numero = 7;
        String paridad = (numero % 2 == 0) ? "par" : "impar";
        System.out.println("\nEl número " + numero + " es " + paridad);
    }
}
