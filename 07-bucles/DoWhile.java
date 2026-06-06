/**
 * ============================================================
 *  TEMA: Estructuras de Control — Bucles en Java
 *  SECCIÓN: 07 — Bucles
 *  ARCHIVO: DoWhile.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  El bucle `do-while` garantiza que el bloque de código se ejecute AL MENOS UNA VEZ,
 *  porque la condición se evalúa DESPUÉS de cada iteración, no antes. Es ideal para
 *  menús interactivos, validación de entrada de usuario o cualquier escenario donde
 *  necesites ejecutar la acción primero y preguntar después.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Ejecución garantizada: el cuerpo se ejecuta mínimo 1 vez, siempre.
 *  - Condición al final: se verifica después de cada iteración completa.
 *  - Punto y coma: el while final LLEVA punto y coma `while (condición);`
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  do {
 *      // código que se ejecuta al menos una vez
 *  } while (condición);
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar el punto y coma después del while(condición) del do-while.
 *  - Usar do-while cuando while bastaría, ejecutando código innecesariamente.
 *  - No actualizar la variable de control dentro del cuerpo.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html
 * ============================================================
 */
public class DoWhile {

    public static void main(String[] args) {

        var contador = 1;

        // El bloque se ejecuta PRIMERO, luego se evalúa la condición
        do {
            System.out.println("Valor del contador: " + contador);
            contador++; // Incrementamos para avanzar hacia la condición de salida
        } while (contador <= 3); // ¡Ojo! Aquí SÍ lleva punto y coma

        System.out.println("El do-while terminó porque contador = " + contador
                + " ya no es <= 3");
    }
}
