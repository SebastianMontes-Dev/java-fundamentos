import java.util.Random;

/**
 * Ejercicio: Generación de números aleatorios con la clase Random.
 *
 * La clase Random permite generar valores pseudoaleatorios de distintos tipos.
 *
 * Métodos utilizados:
 *   - nextInt(limite)   : genera un entero aleatorio entre 0 (inclusive) y 'limite' (exclusivo).
 *   - nextFloat(origen, limite) : genera un flotante aleatorio entre 'origen' (inclusive)
 *                                 y 'limite' (exclusivo).
 *
 * Nota: El límite superior nunca se incluye en el resultado.
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
