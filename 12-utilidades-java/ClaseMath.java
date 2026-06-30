/**
 * ============================================================
 *  TEMA: La Clase Math en Java
 *  SECCIÓN: 12 — Utilidades de Java
 *  ARCHIVO: ClaseMath.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La clase java.lang.Math es una caja de herramientas matemáticas que
 *  viene incluida en Java (no necesitas importar nada). Contiene constantes
 *  como PI y E, y decenas de métodos static para cálculos comunes: máximo,
 *  mínimo, valor absoluto, potencias, raíces, redondeo, logaritmos y
 *  trigonometría. Es una de las clases que más usarás en tu carrera.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - max(a, b) / min(a, b): el mayor/menor de dos valores.
 *  - abs(x): valor absoluto (distancia desde cero).
 *  - pow(base, exponente): potencia.
 *  - sqrt(x): raíz cuadrada.
 *  - round(x): redondeo al entero más cercano (devuelve long/int).
 *  - ceil(x): redondeo hacia arriba.
 *  - floor(x): redondeo hacia abajo.
 *  - random(): número aleatorio entre 0.0 (inclusive) y 1.0 (exclusive).
 *  - hypot(a, b): hipotenusa sin overflow.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int mayor = Math.max(10, 20);      // 20
 *  double raiz = Math.sqrt(25);       // 5.0
 *  long redondeado = Math.round(4.7); // 5
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Math.random() da 0.0 a 0.999..., NO incluye 1.0.
 *  - pow() y sqrt() devuelven double, no int.
 *  - round() de un float devuelve int; round() de double devuelve long.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Math.html
 * ============================================================
 */
public class ClaseMath {

    public static void main(String[] args) {
        System.out.println("=== La Clase Math: Tu Calculadora en Java ===");
        System.out.println();

        // --- CONSTANTES ---
        System.out.println("--- Constantes ---");
        System.out.println("Math.PI  = " + Math.PI);
        System.out.println("Math.E   = " + Math.E);
        System.out.println();

        // --- COMPARACIÓN ---
        System.out.println("--- Comparación ---");
        System.out.println("max(45, 22)  = " + Math.max(45, 22));
        System.out.println("min(45, 22)  = " + Math.min(45, 22));
        System.out.println("max(3.14, 2.71) = " + Math.max(3.14, 2.71));
        System.out.println();

        // --- VALOR ABSOLUTO ---
        System.out.println("--- Valor Absoluto ---");
        System.out.println("abs(-15)     = " + Math.abs(-15));
        System.out.println("abs(-3.14)   = " + Math.abs(-3.14));
        System.out.println("abs(42)      = " + Math.abs(42));
        System.out.println();

        // --- POTENCIAS Y RAÍCES ---
        System.out.println("--- Potencias y Raíces ---");
        System.out.println("pow(2, 8)    = " + Math.pow(2, 8));        // 256.0
        System.out.println("pow(5, 3)    = " + Math.pow(5, 3));        // 125.0
        System.out.println("sqrt(144)    = " + Math.sqrt(144));         // 12.0
        System.out.println("sqrt(2)      = " + Math.sqrt(2));           // 1.414...
        System.out.println("cbrt(27)     = " + Math.cbrt(27));          // 3.0 (raíz cúbica)
        System.out.println();

        // --- REDONDEO ---
        System.out.println("--- Redondeo ---");
        double x = 4.7;
        double y = 4.3;
        double z = -4.7;

        System.out.println("round(4.7)   = " + Math.round(x));     // 5
        System.out.println("round(4.3)   = " + Math.round(y));     // 4
        System.out.println("round(-4.7)  = " + Math.round(z));     // -5
        System.out.println();
        System.out.println("ceil(4.3)    = " + Math.ceil(y));      // 5.0 (hacia arriba)
        System.out.println("ceil(-4.7)   = " + Math.ceil(z));      // -4.0
        System.out.println("floor(4.7)   = " + Math.floor(x));    // 4.0 (hacia abajo)
        System.out.println("floor(-4.7)  = " + Math.floor(z));    // -5.0
        System.out.println();

        // --- ALEATORIOS ---
        System.out.println("--- Aleatorios con Math.random() ---");
        System.out.println("random()     = " + Math.random());
        System.out.println("random()     = " + Math.random());

        // Número aleatorio entre 0 y 99
        int aleatorio0a99 = (int) (Math.random() * 100);
        System.out.println("0 a 99       = " + aleatorio0a99);

        // Número aleatorio entre 1 y 6 (dado)
        int dado = (int) (Math.random() * 6) + 1;
        System.out.println("Dado (1-6)   = " + dado);

        // Número aleatorio entre min y max
        int min = 50, max = 100;
        int aleatorioRango = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println("50 a 100      = " + aleatorioRango);
        System.out.println();

        // --- TRIGONOMETRÍA Y LOGARITMOS ---
        System.out.println("--- Trigonometría y más ---");
        System.out.println("sin(PI/2)    = " + Math.sin(Math.PI / 2));   // 1.0
        System.out.println("cos(0)       = " + Math.cos(0));             // 1.0
        System.out.println("hypot(3,4)   = " + Math.hypot(3, 4));       // 5.0 (hipotenusa)
        System.out.println("log(E)       = " + Math.log(Math.E));         // 1.0
        System.out.println("log10(1000)  = " + Math.log10(1000));         // 3.0
        System.out.println("exp(1)       = " + Math.exp(1));              // 2.718...
    }
}
