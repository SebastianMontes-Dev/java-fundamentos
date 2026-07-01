import java.util.Arrays;

/**
 * ============================================================
 *  TEMA: Arrays Escalonados (Jagged Arrays) en Java
 *  SECCIÓN: 14 — Arrays 2D
 *  ARCHIVO: MatrizIrregular.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Una matriz en Java es "un arreglo de arreglos", y esto tiene una
 *  consecuencia poderosa: las FILAS pueden tener DIFERENTES longitudes.
 *  Esto se llama "jagged array" o "array escalonado". Es perfecto para
 *  ahorrar memoria cuando tus datos no son un rectángulo perfecto: un
 *  triángulo de Pascal, un calendario (los meses tienen 28-31 días),
 *  o una tabla donde cada fila tiene un número variable de columnas.
 *
 *  Aprenderás a crear y recorrer arrays escalonados, a generar el
 *  Triángulo de Pascal, y a entender por qué Java los permite mientras
 *  que otros lenguajes no.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Declaración: int[][] jagged = new int[filas][];
 *  - Cada fila se inicializa por separado: jagged[i] = new int[tamano];
 *  - matriz.length = filas. matriz[i].length = columnas de la fila i.
 *  - Ahorro de memoria cuando las filas son muy desiguales.
 *  - Cuidado con el acceso: jagged[0][10] si la fila 0 tiene 5 columnas.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int[][] escalonado = new int[3][];
 *  escalonado[0] = new int[2];  // fila 0 tiene 2 columnas
 *  escalonado[1] = new int[5];  // fila 1 tiene 5 columnas
 *  escalonado[2] = new int[3];  // fila 2 tiene 3 columnas
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Acceder a una fila no inicializada: NullPointerException.
 *  - Usar el mismo índice de columna para todas las filas (ArrayIndexOutOfBounds).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/specs/jls/se17/html/jls-10.html
 * ============================================================
 */
public class MatrizIrregular {

    public static void main(String[] args) {
        System.out.println("=== Arrays Escalonados (Jagged Arrays) ===");
        System.out.println();

        // --- CREACIÓN DE ARRAY ESCALONADO ---
        System.out.println("--- 1. Array Escalonado Básico ---");

        int[][] escalonado = new int[4][];
        escalonado[0] = new int[]{1};
        escalonado[1] = new int[]{2, 3};
        escalonado[2] = new int[]{4, 5, 6};
        escalonado[3] = new int[]{7, 8, 9, 10};

        System.out.println("Filas: " + escalonado.length);
        for (int i = 0; i < escalonado.length; i++) {
            System.out.println("  Fila " + i + " (columnas: " + escalonado[i].length + "): "
                    + Arrays.toString(escalonado[i]));
        }
        System.out.println();

        // --- TRIÁNGULO DE PASCAL ---
        System.out.println("--- 2. Triángulo de Pascal ---");

        int[][] pascal = generarPascal(8);
        for (int[] fila : pascal) {
            // Espacios para centrar
            int espacios = (pascal.length - fila.length) * 2;
            System.out.print(" ".repeat(Math.max(0, espacios)));
            for (int valor : fila) {
                System.out.printf("%4d", valor);
            }
            System.out.println();
        }
        System.out.println();

        // --- CASOS DE USO REALES ---
        System.out.println("--- 3. Casos de Uso Reales ---");

        // Calendario: días por mes
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[][] calendario = new int[12][];
        for (int i = 0; i < 12; i++) {
            calendario[i] = new int[diasPorMes[i]];
            for (int j = 0; j < diasPorMes[i]; j++) {
                calendario[i][j] = j + 1;
            }
        }
        System.out.println("Calendario: enero tiene " + calendario[0].length + " días, "
                + "febrero tiene " + calendario[1].length);
        System.out.println("  Enero día 15: " + calendario[0][14]);

        // Matriz identidad solo en memoria
        int[][] identidad = new int[5][5];
        for (int i = 0; i < 5; i++) {
            identidad[i][i] = 1;
        }
        System.out.println("Matriz identidad 5x5 (misma estructura, rectangular):");
        for (int[] fila : identidad) {
            System.out.println("  " + Arrays.toString(fila));
        }
        System.out.println();

        // --- COMPARACIÓN DE MEMORIA ---
        System.out.println("--- 4. Ahorro de Memoria ---");
        System.out.println("Si guardas un triángulo como jagged array:");
        System.out.println("  Filas: N");
        System.out.println("  Elementos: N*(N+1)/2");
        System.out.println("Si usas una matriz rectangular de NxN:");
        System.out.println("  Elementos: N*N");
        System.out.println("Para N=1000, jagged ahorra ~500,000 elementos (~4 MB)");
    }

    static int[][] generarPascal(int filas) {
        int[][] triangulo = new int[filas][];
        for (int i = 0; i < filas; i++) {
            triangulo[i] = new int[i + 1];
            triangulo[i][0] = 1;
            triangulo[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangulo[i][j] = triangulo[i - 1][j - 1] + triangulo[i - 1][j];
            }
        }
        return triangulo;
    }
}
