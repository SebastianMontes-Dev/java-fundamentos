/**
 * ============================================================
 *  TEMA: Arreglos (Arrays) Unidimensionales en Java
 *  SECCIÓN: 08 — Arrays
 *  ARCHIVO: Arreglos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Los arreglos (arrays) son estructuras que almacenan múltiples valores del mismo
 *  tipo en una sola variable, accediendo a cada elemento mediante un índice numérico.
 *  Aprenderás a declarar un arreglo, asignarle un tamaño fijo, guardar valores en
 *  posiciones específicas y leerlos. Los índices en Java comienzan SIEMPRE en 0.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Declaración: `tipo[] nombre = new tipo[tamaño]` reserva espacio en memoria.
 *  - Índice base cero: el primer elemento está en la posición 0, no en la 1.
 *  - Valores por defecto: los enteros se inicializan en 0 automáticamente.
 *  - Acceso por índice: `nombre[posicion]` para leer o escribir un valor.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int[] numeros = new int[5];      // arreglo de 5 enteros (índices 0 a 4)
 *  numeros[2] = 42;                 // asigna 42 a la posición 2
 *  System.out.println(numeros[2]);  // imprime 42
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - ArrayIndexOutOfBoundsException: intentar acceder a un índice fuera del rango
 *    (ej: arreglo[5] en un arreglo de tamaño 5, cuyos índices son 0 a 4).
 *  - Confundir el tamaño del arreglo con el último índice válido.
 *  - Olvidar que los elementos no inicializados tienen valores por defecto (0, false, null).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
 * ============================================================
 */
public class Arreglos {

    public static void main(String[] args) {

        // Declaramos un arreglo de 5 enteros (índices válidos: 0, 1, 2, 3, 4)
        int[] enteros = new int[5];

        // Asignamos valores en posiciones específicas
        enteros[0] = 10; // primer elemento
        enteros[1] = 25; // segundo elemento
        enteros[3] = 90; // cuarto elemento

        // Los índices 2 y 4 no fueron asignados → conservan su valor por defecto: 0

        // Leemos e imprimimos valores individuales
        System.out.println("Valor en índice 0: " + enteros[0]);
        System.out.println("Valor en índice 1: " + enteros[1]);
        System.out.println("Valor en índice 2 (no asignado): " + enteros[2]);
        System.out.println("Valor en índice 3: " + enteros[3]);
        System.out.println("Valor en índice 4 (no asignado): " + enteros[4]);

        System.out.println("Tamaño del arreglo: " + enteros.length + " elementos");
    }
}
