import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ============================================================
 *  TEMA: Tests Unitarios con JUnit 5
 *  SECCIÓN: 33 — Testing con JUnit
 *  ARCHIVO: TestCalculadora.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  JUnit 5 es el estándar para testing en Java. Este archivo contiene
 *  tests unitarios para Calculadora usando las anotaciones y assertions
 *  más importantes. La estructura AAA (Arrange-Act-Assert) es el patrón
 *  universal: preparas los datos, ejecutas el método bajo prueba, y
 *  verificas que el resultado sea el esperado.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - @Test: marca un método como test.
 *  - @BeforeEach: se ejecuta ANTES de cada test (preparar estado).
 *  - @AfterEach: se ejecuta DESPUÉS de cada test (limpiar).
 *  - @DisplayName: nombre descriptivo legible en reportes.
 *  - assertEquals(expected, actual): el assertion más común.
 *  - assertThrows(Exception.class, () -> ...): verifica excepciones.
 *  - assertTrue / assertFalse: para condiciones booleanas.
 *  - assertNotNull / assertNull: para verificar null.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  @Test
 *  void test_suma_positivos() {
 *      int resultado = calc.sumar(2, 3);  // Arrange + Act
 *      assertEquals(5, resultado);         // Assert
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar @Test: el método no se ejecuta como test.
 *  - Usar System.out en vez de assertions (no es testing real).
 *  - No limpiar recursos en @AfterEach.
 *
 *  REQUISITOS PARA EJECUTAR:
 *  ----------------------------------
 *  JUnit 5 (Jupiter) en el classpath. Ver README de la sección.
 * ============================================================
 */
class TestCalculadora {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
        System.out.println("  [BeforeEach] Nueva instancia de Calculadora creada");
    }

    @AfterEach
    void tearDown() {
        calc = null;
        System.out.println("  [AfterEach] Calculadora liberada");
    }

    // --- TESTS DE SUMA ---

    @Test
    @DisplayName("Suma de dos números positivos")
    void suma_dosPositivos_retornaSumaCorrecta() {
        // Arrange

        // Act
        int resultado = calc.sumar(2, 3);

        // Assert
        assertEquals(5, resultado);
    }

    @Test
    @DisplayName("Suma con cero como identidad")
    void suma_conCero_retornaMismoNumero() {
        assertEquals(7, calc.sumar(7, 0));
        assertEquals(7, calc.sumar(0, 7));
    }

    @Test
    @DisplayName("Suma de números negativos")
    void suma_conNegativos_retornaCorrecto() {
        assertEquals(-5, calc.sumar(-2, -3));
        assertEquals(1, calc.sumar(5, -4));
    }

    // --- TESTS DE RESTA ---

    @Test
    @DisplayName("Resta de dos números positivos")
    void resta_dosPositivos_retornaCorrecto() {
        assertEquals(2, calc.restar(5, 3));
    }

    @Test
    @DisplayName("Resta con resultado negativo")
    void resta_resultadoNegativo_esCorrecto() {
        assertEquals(-3, calc.restar(2, 5));
    }

    // --- TESTS DE DIVISIÓN ---

    @Test
    @DisplayName("División exacta de dos enteros")
    void division_exacta_retornaDecimalCorrecto() {
        assertEquals(2.5, calc.dividir(5, 2), 0.001);
    }

    @Test
    @DisplayName("División por cero lanza IllegalArgumentException")
    void division_porCero_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.dividir(10, 0);
        });
    }

    @Test
    @DisplayName("División por cero incluye mensaje descriptivo")
    void division_porCero_mensajeCorrecto() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> calc.dividir(5, 0));
        assertTrue(ex.getMessage().contains("No se puede dividir por cero"));
    }

    // --- TESTS DE FACTORIAL ---

    @Test
    @DisplayName("Factorial de 0 es 1")
    void factorial_deCero_retornaUno() {
        assertEquals(1, calc.factorial(0));
    }

    @Test
    @DisplayName("Factorial de 5 es 120")
    void factorial_de5_retorna120() {
        assertEquals(120, calc.factorial(5));
    }

    @Test
    @DisplayName("Factorial de número negativo lanza excepción")
    void factorial_negativo_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(-1));
    }

    // --- TESTS DE ESPAR ---

    @Test
    @DisplayName("Números pares son detectados correctamente")
    void esPar_numerosPares_retornaTrue() {
        assertTrue(calc.esPar(0));
        assertTrue(calc.esPar(2));
        assertTrue(calc.esPar(100));
        assertTrue(calc.esPar(-4));
    }

    @Test
    @DisplayName("Números impares son detectados correctamente")
    void esPar_numerosImpares_retornaFalse() {
        assertFalse(calc.esPar(1));
        assertFalse(calc.esPar(3));
        assertFalse(calc.esPar(99));
        assertFalse(calc.esPar(-7));
    }
}
