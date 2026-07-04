import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ============================================================
 *  TEMA: Tests Parametrizados con JUnit 5
 *  SECCIÓN: 33 — Testing con JUnit
 *  ARCHIVO: TestParametrizado.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  ¿Y si necesitas probar el mismo método con 50 valores diferentes?
 *  Escribir 50 tests iguales es ruido, no testing. Los TESTS
 *  PARAMETRIZADOS ejecutan el mismo método de test múltiples veces
 *  con diferentes argumentos, manteniendo cada ejecución como un
 *  caso de prueba independiente.
 *
 *  @CsvSource te permite definir filas de datos (entradas + esperado),
 *  @ValueSource pasa una lista de valores a un solo parámetro,
 *  @NullSource añade null a los casos de prueba, y @MethodSource
 *  usa un método que genera los argumentos dinámicamente. Esto es
 *  especialmente útil para probar edge cases y validación de entradas.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - @ParameterizedTest: ejecuta el test N veces con diferentes datos.
 *  - @CsvSource: cada fila es un caso (parámetros separados por coma).
 *  - @ValueSource: lista de valores para un solo parámetro.
 *  - @NullSource + @ValueSource: incluir null en los casos de prueba.
 *  - @MethodSource: método que provee los argumentos.
 *  - {0}, {1}: placeholders en @DisplayName para valores dinámicos.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  @ParameterizedTest
 *  @CsvSource({"2, 3, 5", "10, 20, 30", "-1, 1, 0"})
 *  void testSuma(int a, int b, int esperado) {
 *      assertEquals(esperado, calc.sumar(a, b));
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar importar @ParameterizedTest.
 *  - Usar "" dentro de strings de @CsvSource sin escapar.
 *  - Tipos incorrectos entre los parámetros del CsvSource y el método.
 *
 *  REQUISITOS PARA EJECUTAR:
 *  ----------------------------------
 *  JUnit 5 (Jupiter) en el classpath. Ver README de la sección.
 * ============================================================
 */
class TestParametrizado {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    // --- @CsvSource: múltiples parámetros + esperado ---

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "2, 3, 5",
            "10, 20, 30",
            "0, 0, 0",
            "-5, 5, 0",
            "-10, -5, -15",
            "100, 200, 300"
    })
    void suma_parametrizada(int a, int b, int esperado) {
        assertEquals(esperado, calc.sumar(a, b));
    }

    @ParameterizedTest(name = "resta: {0} - {1} = {2}")
    @CsvSource({
            "5, 3, 2",
            "10, 20, -10",
            "0, 5, -5",
            "-5, -3, -2"
    })
    void resta_parametrizada(int a, int b, int esperado) {
        assertEquals(esperado, calc.restar(a, b));
    }

    // --- @ValueSource: un solo parámetro ---

    @ParameterizedTest(name = "¿{0} es par? → true")
    @ValueSource(ints = {0, 2, 4, 10, 100, -6, -200})
    void esPar_numerosPares_retornaTrue(int numero) {
        assertTrue(calc.esPar(numero),
                numero + " debería ser par");
    }

    @ParameterizedTest(name = "¿{0} es par? → false")
    @ValueSource(ints = {1, 3, 7, 11, 99, -5, -101})
    void esPar_numerosImpares_retornaFalse(int numero) {
        assertFalse(calc.esPar(numero),
                numero + " debería ser impar");
    }

    // --- Factorial parametrizado ---

    @ParameterizedTest(name = "factorial({0}) = {1}")
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "6, 720",
            "10, 3628800"
    })
    void factorial_parametrizado(int n, long esperado) {
        assertEquals(esperado, calc.factorial(n));
    }

    // --- @NullAndEmptySource ---

    @ParameterizedTest(name = "División entre cero con diferentes ceros")
    @ValueSource(ints = {0})
    void division_porCero_variantes(int cero) {
        assertThrows(IllegalArgumentException.class,
                () -> calc.dividir(100, cero));
    }

    // --- División parametrizada ---

    @ParameterizedTest(name = "dividir({0}, {1}) = {2}")
    @CsvSource({
            "10, 2, 5.0",
            "7, 2, 3.5",
            "1, 4, 0.25",
            "0, 5, 0.0",
            "-15, 3, -5.0"
    })
    void division_parametrizada(int a, int b, double esperado) {
        assertEquals(esperado, calc.dividir(a, b), 0.0001);
    }
}
