/**
 * ============================================================
 *  TEMA: Estructuras de Control — Bucles en Java
 *  SECCIÓN: 07 — Bucles
 *  ARCHIVO: CicloFor.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  El bucle `for` es la estructura de repetición más utilizada cuando sabes
 *  exactamente cuántas veces quieres iterar. Se compone de tres partes:
 *  inicialización, condición y actualización. Es ideal para recorrer arreglos,
 *  generar secuencias numéricas o ejecutar una operación un número fijo de veces.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Inicialización: se ejecuta UNA sola vez al comenzar el bucle (var i = 1).
 *  - Condición: se evalúa ANTES de cada iteración; si es false, el bucle termina.
 *  - Actualización: se ejecuta al FINAL de cada iteración (i++).
 *  - Cuerpo del bucle: código entre llaves que se repite mientras la condición sea true.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  for (inicialización; condición; actualización) {
 *      // código a repetir
 *  }
 *  // Ejemplo: for (var i = 0; i < 5; i++) { System.out.println(i); }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Punto y coma después del paréntesis del for: for (var i = 0; i < 5; i++);
 *    eso crea un bucle vacío y el bloque siguiente solo se ejecuta una vez.
 *  - Error "off-by-one": usar <= en vez de <, o viceversa, causando una iteración de más o de menos.
 *  - Olvidar declarar la variable de control con su tipo (o var).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html
 * ============================================================
 */
public class CicloFor {

    public static void main(String[] args) {

        // La variable i se inicializa en 1, se ejecuta mientras i <= 3
        // y al final de cada vuelta i aumenta en 1
        for (var i = 1; i <= 3; i++) {
            // Esta línea se ejecuta 3 veces: con i = 1, 2 y 3
            System.out.println("Iteración número: " + i);
        }

        // Cuando la condición (i <= 3) se vuelve false, el programa sale del for
        System.out.println("¡Bucle finalizado!");
    }
}
