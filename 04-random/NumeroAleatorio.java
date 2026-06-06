import java.util.Random;

/**
 * ============================================================
 *  TEMA: Generación de Números Aleatorios con Random
 *  SECCIÓN: 04 — Random
 *  ARCHIVO: NumeroAleatorio.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La clase Random del paquete java.util genera números PSEUDOaleatorios (no son
 *  verdaderamente aleatorios, pero sí lo suficientemente impredecibles para la
 *  mayoría de aplicaciones). Aprenderás a generar enteros y flotantes dentro de
 *  un rango específico, donde el límite superior es EXCLUSIVO (nunca se incluye).
 *  Esencial para juegos, simulaciones, generación de IDs y testing.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Random(): constructor que inicializa el generador con una semilla basada en el reloj.
 *  - nextInt(limite): entero entre 0 (inclusive) y limite (exclusive).
 *  - nextFloat(origen, limite): flotante entre origen (inclusive) y limite (exclusive).
 *  - Límite exclusivo: el valor máximo NUNCA se incluye en el resultado.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Random rand = new Random();
 *  int dado = rand.nextInt(6) + 1;      // número entre 1 y 6
 *  float aleatorio = rand.nextFloat(0, 10); // entre 0.0 y 9.999...
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar sumar 1 al resultado para incluir el límite superior: `nextInt(6)` da 0-5, no 1-6.
 *  - Crear múltiples instancias de Random en un bucle (gasta memoria innecesariamente).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Random.html
 * ============================================================
 */
public class NumeroAleatorio {

    public static void main(String[] args) {
        Random random = new Random();

        // Entero aleatorio entre 0 y 10 (el 11 es exclusivo, por lo que el máximo es 10)
        int numeroAleatorio = random.nextInt(11);
        System.out.println("Número entero aleatorio: " + numeroAleatorio);

        // Flotante aleatorio entre 0.0 y 10.0
        float flotanteAleatorio = random.nextFloat(0, 10);
        System.out.println("Número flotante aleatorio: " + flotanteAleatorio);
    }
}
