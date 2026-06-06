/**
 * ============================================================
 *  TEMA: Estructuras Condicionales en Java
 *  SECCIÓN: 06 — Condicionales
 *  ARCHIVO: SentenciaIf.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La sentencia `if` es la estructura de control de flujo más fundamental: evalúa
 *  una condición booleana y ejecuta un bloque de código SOLO si es verdadera.
 *  Es la base de toda toma de decisiones en programación. Aprenderás su sintaxis
 *  básica, cómo funciona la evaluación de condiciones con operadores relacionales
 *  y la importancia de las llaves {} para delimitar el bloque condicional.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - if (condición): evalúa una expresión booleana; si true, ejecuta el bloque.
 *  - Operadores relacionales: >, <, >=, <=, ==, != para comparar valores.
 *  - Llaves {}: delimitan el bloque de código que pertenece al if.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  if (edad >= 18) {
 *      System.out.println("Eres mayor de edad");
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar = (asignación) en vez de == (comparación) dentro de la condición: `if (x = 5)`
 *    asigna 5 a x y siempre evalúa a true para tipos no booleanos.
 *  - Punto y coma después del if: `if (condicion);` crea un if vacío.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html
 * ============================================================
 */
public class SentenciaIf {

    public static void main(String[] args) {
        int edad = 30;

        System.out.println("=== Sentencia if ===");
        System.out.println("Edad evaluada: " + edad);
        System.out.println();

        // La condición (edad >= 18) evalúa a true, por lo que se imprime el mensaje
        if (edad >= 18) {
            System.out.println("Resultado: eres mayor de edad.");
        }
    }
}
