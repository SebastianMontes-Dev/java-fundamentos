/**
 * ============================================================
 *  TEMA: Estructuras Condicionales en Java
 *  SECCIÓN: 06 — Condicionales
 *  ARCHIVO: CondicionalMultiple.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La estructura `if - else if - else` permite evaluar MÚLTIPLES condiciones en
 *  secuencia, ejecutando solo el bloque de la PRIMERA condición que sea verdadera.
 *  Si ninguna se cumple, se ejecuta el bloque `else` final. Es la herramienta
 *  fundamental para tomar decisiones con más de dos caminos posibles, como
 *  clasificar edades, notas, niveles de acceso, etc.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - if: primera condición, obligatoria.
 *  - else if: condiciones alternativas (puede haber tantas como necesites).
 *  - else: bloque por defecto cuando ninguna condición anterior se cumple.
 *  - Evaluación en cascada: se evalúa en orden, se ejecuta la primera coincidencia.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  if (condicion1) {
 *      // código si condicion1 es true
 *  } else if (condicion2) {
 *      // código si condicion1 es false Y condicion2 es true
 *  } else {
 *      // código si ninguna condición fue true
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Orden incorrecto de condiciones: poner el caso más específico después del general.
 *  - Usar `if` en vez de `else if` para condiciones mutuamente excluyentes (se evaluarían todas).
 *  - Condiciones solapadas que hacen que un else if nunca se alcance.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html
 * ============================================================
 */
public class CondicionalMultiple {

    public static void main(String[] args) {

        System.out.println("=== Estructura if - else if - else ===\n");

        // Ejemplo: Clasificación de edad en categorías
        var edad = 15;

        System.out.println("Edad a evaluar: " + edad);

        // Se evalúan en orden. La primera condición que sea true gana.
        if (edad >= 18) {
            // Se ejecuta solo si edad >= 18
            System.out.println("Resultado: Eres mayor de edad");

        } else if (edad >= 13 && edad < 18) {
            // Se ejecuta solo si no es >= 18 Y está entre 13 y 17
            System.out.println("Resultado: Eres un adolescente");

        } else {
            // Se ejecuta si ninguna de las condiciones anteriores fue true
            System.out.println("Resultado: Eres menor de 13 años");
        }
    }
}
