/**
 * ============================================================
 *  TEMA: Programación Orientada a Objetos — Operador this con Aritmética
 *  SECCIÓN: 15 — POO Básica
 *  ARCHIVO: OperadorThis2.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  El operador `this` también se usa dentro del constructor para diferenciar
 *  los parámetros recibidos de los atributos de la clase cuando tienen el mismo
 *  nombre. En este ejemplo construirás una clase de aritmética donde el constructor
 *  inicializa dos operandos usando `this.num1 = num1` y luego los métodos de
 *  instancia (suma, resta) operan directamente sobre esos atributos.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - this en constructor: diferencia parámetro de atributo cuando comparten nombre.
 *  - Constructor por defecto: constructor sin parámetros que Java usa si no defines uno.
 *  - Sobrecarga de constructores: tener múltiples constructores con distintas firmas.
 *  - Métodos de instancia: operan sobre los atributos del objeto que los invoca.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  class MiClase {
 *      int valor;
 *      MiClase(int valor) {
 *          this.valor = valor;  // this.valor = atributo, valor = parámetro
 *      }
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar `this.` y asignar el parámetro a sí mismo (num1 = num1 no hace nada útil).
 *  - No definir un constructor por defecto cuando se necesita instanciar sin argumentos.
 *  - Usar int en vez de double si se necesitan resultados con decimales.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
 *  - Guía de constructores: https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html
 * ============================================================
 */
public class OperadorThis2 {

    // Atributos de instancia: almacenan los operandos
    double num1;
    double num2;

    /**
     * Constructor por defecto: no recibe parámetros.
     * Los atributos quedan con su valor por defecto (0.0 para double).
     */
    public OperadorThis2() {
        // Constructor vacío: útil si queremos asignar los valores después
    }

    /**
     * Constructor con parámetros: usa `this` para diferenciar atributos de parámetros.
     *
     * @param num1 primer operando (se asigna a this.num1)
     * @param num2 segundo operando (se asigna a this.num2)
     */
    public OperadorThis2(int num1, int num2) {
        System.out.println("Ejecutando constructor con parámetros...");
        this.num1 = num1;  // this.num1 = atributo, num1 = parámetro
        this.num2 = num2;  // this.num2 = atributo, num2 = parámetro
    }

    /**
     * Realiza la suma de los dos operandos almacenados.
     */
    void suma() {
        double resultado = num1 + num2;
        System.out.println("El resultado de la suma sería: " + resultado);
    }

    /**
     * Realiza la resta de los dos operandos almacenados.
     */
    void resta() {
        double resultado = num1 - num2;
        System.out.println("El resultado de la resta sería: " + resultado);
    }

    public static void main(String[] args) {

        System.out.println("=== Uso de this con aritmética ===\n");

        // Primer objeto: creado con constructor parametrizado
        System.out.println("--- Operación con (10, 20) ---");
        OperadorThis2 aritmetica = new OperadorThis2(10, 20);
        aritmetica.suma();    // 10 + 20 = 30
        aritmetica.resta();   // 10 - 20 = -10

        System.out.println();

        // Segundo objeto: valores negativos para ver cómo se comportan
        System.out.println("--- Operación con (-20, -9) ---");
        OperadorThis2 aritmetica2 = new OperadorThis2(-20, -9);
        aritmetica2.suma();   // -20 + (-9) = -29
        aritmetica2.resta();  // -20 - (-9) = -11
    }
}
