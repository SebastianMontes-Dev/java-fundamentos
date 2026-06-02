/**
 * Demostración de la sentencia condicional if en Java.
 *
 * La sentencia if evalúa una expresión booleana:
 *   - Si la condición es true  → ejecuta el bloque entre llaves.
 *   - Si la condición es false → omite el bloque y continúa.
 *
 * Estructura básica:
 *   if (condición) {
 *       // código que se ejecuta solo cuando la condición es verdadera
 *   }
 *
 * Conceptos practicados:
 *   - Operador relacional >=  (mayor o igual que).
 *   - Evaluación de una condición booleana.
 *   - Flujo de control con if.
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
