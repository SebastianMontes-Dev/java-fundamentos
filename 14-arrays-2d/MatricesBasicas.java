import java.util.Arrays;

/**
 * ============================================================
 *  TEMA: Matrices (Arrays Bidimensionales) en Java
 *  SECCIÓN: 14 — Arrays 2D
 *  ARCHIVO: MatricesBasicas.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Una matriz en Java se declara como `int[][]` y es literalmente un
 *  "arreglo de arreglos": cada fila es un arreglo independiente. Aprenderás
 *  a declarar matrices de varias formas, inicializarlas con valores,
 *  recorrerlas con bucles for anidados y for-each, y usar métodos útiles
 *  como deepToString() para imprimirlas de forma legible.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Declaración: int[][] matriz = new int[filas][columnas];
 *  - Inicialización rápida: int[][] m = {{1,2}, {3,4}};
 *  - matriz.length = número de FILAS.
 *  - matriz[fila].length = número de COLUMNAS de esa fila.
 *  - Recorrido con for anidado: for(i) { for(j) { matriz[i][j] } }
 *  - Arrays.deepToString(): imprime matrices de forma bonita.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int[][] matriz = new int[3][4];           // 3 filas, 4 columnas
 *  int[][] datos = {{1,2,3}, {4,5,6}};      // 2 filas, 3 columnas
 *  matriz[i][j] = valor;                    // acceso
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir matriz.length (filas) con columnas.
 *  - Usar matriz.toString() en vez de Arrays.deepToString().
 *  - ArrayIndexOutOfBoundsException por índices fuera de rango.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
 * ============================================================
 */
public class MatricesBasicas {

    public static void main(String[] args) {
        System.out.println("=== Matrices (Arrays 2D) ===");
        System.out.println();

        // --- DECLARACIÓN ---
        System.out.println("--- 1. Declaración e Inicialización ---");

        // Forma 1: con valores explícitos
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Matriz 3x3:");
        imprimirMatriz(matriz);
        System.out.println();

        // Forma 2: con new (vacía, llena de 0s)
        int[][] ceros = new int[2][3];
        System.out.println("Matriz 2x3 de ceros:");
        imprimirMatriz(ceros);
        System.out.println();

        // --- TAMAÑO ---
        System.out.println("--- 2. Dimensiones ---");
        System.out.println("Filas:    " + matriz.length);
        System.out.println("Columnas: " + matriz[0].length);
        System.out.println("Total elementos: " + (matriz.length * matriz[0].length));
        System.out.println("Elemento [1][1]: " + matriz[1][1] + " (centro)");
        System.out.println("Elemento [2][0]: " + matriz[2][0] + " (esquina inferior izquierda)");
        System.out.println();

        // --- RECORRIDO CON FOR ANIDADO ---
        System.out.println("--- 3. Recorrido con for anidado ---");

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Fila " + i + ": ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // --- RECORRIDO CON FOR-EACH ---
        System.out.println("--- 4. Recorrido con for-each ---");
        System.out.print("Todos los elementos: ");
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
        }
        System.out.println();
        System.out.println();

        // --- RECORRIDO POR COLUMNAS ---
        System.out.println("--- 5. Recorrido por columnas ---");

        for (int j = 0; j < matriz[0].length; j++) {
            System.out.print("Columna " + j + ": ");
            for (int i = 0; i < matriz.length; i++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // --- DIAGONALES ---
        System.out.println("--- 6. Diagonales ---");

        System.out.print("Diagonal principal: ");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + " ");
        }
        System.out.println();

        System.out.print("Diagonal secundaria: ");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][matriz.length - 1 - i] + " ");
        }
        System.out.println();
        System.out.println();

        // --- deepToString ---
        System.out.println("--- 7. deepToString() ---");
        System.out.println("toString():   " + matriz.toString() + "  (no sirve para matrices)");
        System.out.println("deepToString: " + Arrays.deepToString(matriz));
    }

    static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            System.out.println("  " + Arrays.toString(fila));
        }
    }
}
