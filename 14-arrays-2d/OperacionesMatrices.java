import java.util.Arrays;

/**
 * ============================================================
 *  TEMA: Operaciones con Matrices en Java
 *  SECCIÓN: 14 — Arrays 2D
 *  ARCHIVO: OperacionesMatrices.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Una vez que sabes crear matrices, lo siguiente es operar con ellas.
 *  Implementarás las tres operaciones más comunes: SUMA de matrices
 *  (elemento a elemento, mismas dimensiones), TRANSPUESTA (intercambiar
 *  filas por columnas), y PRODUCTO escalar (multiplicar cada elemento
 *  por un número). Estas operaciones son la base del álgebra lineal
 *  aplicada en gráficos 3D, machine learning y procesamiento de imágenes.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Suma: A[i][j] + B[i][j], requiere mismas dimensiones.
 *  - Transpuesta: filas ↔ columnas. transpuesta[j][i] = original[i][j].
 *  - Matriz cuadrada: mismo número de filas y columnas.
 *  - Producto escalar: multiplicar cada elemento por una constante.
 *  - Simetría: una matriz cuadrada que es igual a su transpuesta.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int[][] suma = new int[filas][columnas];
 *  suma[i][j] = a[i][j] + b[i][j];
 *
 *  int[][] transpuesta = new int[cols][filas];
 *  transpuesta[j][i] = original[i][j];
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Sumar matrices de diferentes dimensiones (ArrayIndexOutOfBounds).
 *  - Olvidar que la transpuesta invierte dimensiones.
 *  - Crear transpuesta del mismo tamaño que la original (solo para cuadradas).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
 * ============================================================
 */
public class OperacionesMatrices {

    public static void main(String[] args) {
        System.out.println("=== Operaciones con Matrices ===");
        System.out.println();

        int[][] a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] b = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        System.out.println("--- Matriz A ---");
        imprimir(a);
        System.out.println("--- Matriz B ---");
        imprimir(b);
        System.out.println();

        // --- SUMA ---
        System.out.println("--- 1. Suma de Matrices (A + B) ---");
        int[][] suma = sumar(a, b);
        imprimir(suma);
        System.out.println();

        // --- TRANSPUESTA ---
        System.out.println("--- 2. Transpuesta de A (filas ↔ columnas) ---");
        int[][] transpuesta = transponer(a);
        imprimir(transpuesta);
        System.out.println();

        // --- PRODUCTO ESCALAR ---
        System.out.println("--- 3. Producto Escalar (A * 3) ---");
        int[][] escalar = productoEscalar(a, 3);
        imprimir(escalar);
        System.out.println();

        // --- MATRIZ SIMÉTRICA ---
        System.out.println("--- 4. ¿Es simétrica? ---");

        int[][] simetrica = {
            {1, 2, 3},
            {2, 5, 4},
            {3, 4, 9}
        };
        System.out.println("Matriz simétrica:");
        imprimir(simetrica);
        System.out.println("¿Es simétrica? " + esSimetrica(simetrica));
        System.out.println();

        // --- TABLERO DE AJEDREZ ---
        System.out.println("--- 5. Generar Tablero 8x8 ---");

        int[][] tablero = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = (i + j) % 2;
            }
        }
        imprimirTablero(tablero);
    }

    static int[][] sumar(int[][] a, int[][] b) {
        int filas = a.length;
        int cols = a[0].length;
        int[][] resultado = new int[filas][cols];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                resultado[i][j] = a[i][j] + b[i][j];
            }
        }
        return resultado;
    }

    static int[][] transponer(int[][] original) {
        int filas = original.length;
        int cols = original[0].length;
        int[][] transpuesta = new int[cols][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                transpuesta[j][i] = original[i][j];
            }
        }
        return transpuesta;
    }

    static int[][] productoEscalar(int[][] matriz, int escalar) {
        int filas = matriz.length;
        int cols = matriz[0].length;
        int[][] resultado = new int[filas][cols];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                resultado[i][j] = matriz[i][j] * escalar;
            }
        }
        return resultado;
    }

    static boolean esSimetrica(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void imprimir(int[][] matriz) {
        for (int[] fila : matriz) {
            System.out.println("  " + Arrays.toString(fila));
        }
    }

    static void imprimirTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            System.out.print("  ");
            for (int celda : fila) {
                System.out.print(celda == 0 ? ". " : "# ");
            }
            System.out.println();
        }
    }
}
