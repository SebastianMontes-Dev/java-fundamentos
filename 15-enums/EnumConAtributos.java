/**
 * ============================================================
 *  TEMA: Enums con Atributos, Constructores y Métodos
 *  SECCIÓN: 15 — Enums
 *  ARCHIVO: EnumConAtributos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás que los enums en Java son mucho más que simples
 *  constantes: pueden tener atributos (campos), constructores
 *  privados y métodos propios. Esto los convierte en una
 *  herramienta poderosa para modelar datos con comportamiento.
 *  Trabajaremos con un enum Planeta (masa, radio, gravedad)
 *  y un enum Moneda (país, símbolo, tasa de cambio).
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Los enums pueden tener campos (atributos) como una clase
 *  - Los constructores de enum son SIEMPRE privados (implícitamente)
 *  - Los argumentos del constructor se pasan entre paréntesis
 *  - Los enums pueden tener métodos de instancia y métodos estáticos
 *  - Se pueden implementar interfaces en un enum
 *  - Cada valor del enum puede sobrescribir métodos (cuerpo propio)
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *      enum NombreEnum {
 *          VALOR1(arg1, arg2),
 *          VALOR2(arg1, arg2);   // ← punto y coma obligatorio
 *
 *          private final tipo campo1;
 *          private final tipo campo2;
 *
 *          NombreEnum(tipo param1, tipo param2) {
 *              this.campo1 = param1;
 *              this.campo2 = param2;
 *          }
 *
 *          public tipo getCampo1() { return campo1; }
 *      }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar el punto y coma (;) después del último valor cuando
 *    hay campos/métodos adicionales
 *  - Intentar declarar el constructor como public o protected
 *  - No declarar los campos como final (buena práctica, ya que
 *    los valores de un enum son inmutables)
 *  - Olvidar los paréntesis con los argumentos en cada valor
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 *  - Effective Java (Joshua Bloch), Item 34: Use enums instead of int constants
 * ============================================================
 */

/**
 * Clase que demuestra enums avanzados con atributos,
 * constructores y métodos personalizados.
 */
public class EnumConAtributos {

    // ─────────────────────────────────────────────
    //  1. ENUM CON ATRIBUTOS: PLANETA
    // ─────────────────────────────────────────────

    /**
     * Enum que representa los planetas del sistema solar.
     * Cada planeta tiene masa (kg) y radio (metros).
     * Basado en el ejemplo clásico de la documentación de Java.
     */
    enum Planeta {
        // Cada valor llama al constructor con (masa, radio)
        MERCURIO(3.303e+23, 2.4397e6),
        VENUS   (4.869e+24, 6.0518e6),
        TIERRA  (5.976e+24, 6.37814e6),
        MARTE   (6.421e+23, 3.3972e6),
        JUPITER (1.9e+27,   7.1492e7),
        SATURNO (5.688e+26, 6.0268e7),
        URANO   (8.686e+25, 2.5559e7),
        NEPTUNO (1.024e+26, 2.4746e7);  // ← punto y coma OBLIGATORIO

        // Constante gravitacional universal
        private static final double G = 6.67300E-11;

        // Campos (atributos) del enum
        private final double masa;    // en kilogramos
        private final double radio;   // en metros

        /**
         * Constructor del enum (siempre es privado, incluso sin la palabra clave).
         *
         * @param masa  la masa del planeta en kilogramos
         * @param radio el radio del planeta en metros
         */
        Planeta(double masa, double radio) {
            this.masa = masa;
            this.radio = radio;
        }

        /**
         * Obtiene la masa del planeta.
         *
         * @return la masa en kilogramos
         */
        public double getMasa() {
            return masa;
        }

        /**
         * Obtiene el radio del planeta.
         *
         * @return el radio en metros
         */
        public double getRadio() {
            return radio;
        }

        /**
         * Calcula la gravedad superficial del planeta.
         * Fórmula: g = G * M / R²
         *
         * @return la gravedad superficial en m/s²
         */
        public double gravedadSuperficial() {
            return G * masa / (radio * radio);
        }

        /**
         * Calcula el peso de un objeto en la superficie de este planeta.
         *
         * @param masaObjeto la masa del objeto en kilogramos
         * @return el peso en Newtons
         */
        public double pesoEn(double masaObjeto) {
            return masaObjeto * gravedadSuperficial();
        }
    }

    // ─────────────────────────────────────────────
    //  2. ENUM CON ATRIBUTOS: MONEDA
    // ─────────────────────────────────────────────

    /**
     * Enum que representa monedas de diferentes países.
     * Cada moneda tiene país, símbolo y tasa de cambio respecto al USD.
     */
    enum Moneda {
        DOLAR_USD   ("Estados Unidos", "USD", "$",   1.0),
        EURO        ("Unión Europea",  "EUR", "€",   0.92),
        PESO_MXN    ("México",         "MXN", "$",   17.15),
        SOL_PEN     ("Perú",           "PEN", "S/",  3.72),
        PESO_COP    ("Colombia",       "COP", "$",   3950.0),
        PESO_ARS    ("Argentina",      "ARS", "$",   875.0),
        REAL_BRL    ("Brasil",         "BRL", "R$",  4.97);

        private final String pais;
        private final String codigo;
        private final String simbolo;
        private final double tasaCambioUsd;  // cuántas unidades por 1 USD

        /**
         * Constructor de la moneda.
         *
         * @param pais          nombre del país o región
         * @param codigo        código ISO de la moneda
         * @param simbolo       símbolo monetario
         * @param tasaCambioUsd tasa de cambio respecto al USD
         */
        Moneda(String pais, String codigo, String simbolo, double tasaCambioUsd) {
            this.pais = pais;
            this.codigo = codigo;
            this.simbolo = simbolo;
            this.tasaCambioUsd = tasaCambioUsd;
        }

        /**
         * Obtiene el nombre del país.
         *
         * @return el país de origen
         */
        public String getPais() {
            return pais;
        }

        /**
         * Obtiene el código ISO de la moneda.
         *
         * @return el código ISO
         */
        public String getCodigo() {
            return codigo;
        }

        /**
         * Obtiene el símbolo monetario.
         *
         * @return el símbolo
         */
        public String getSimbolo() {
            return simbolo;
        }

        /**
         * Obtiene la tasa de cambio respecto al USD.
         *
         * @return la tasa de cambio
         */
        public double getTasaCambioUsd() {
            return tasaCambioUsd;
        }

        /**
         * Convierte una cantidad de esta moneda a USD.
         *
         * @param cantidad la cantidad en esta moneda
         * @return la cantidad equivalente en USD
         */
        public double convertirAUsd(double cantidad) {
            return cantidad / tasaCambioUsd;
        }

        /**
         * Convierte una cantidad de USD a esta moneda.
         *
         * @param cantidadUsd la cantidad en dólares USD
         * @return la cantidad equivalente en esta moneda
         */
        public double convertirDesdeUsd(double cantidadUsd) {
            return cantidadUsd * tasaCambioUsd;
        }

        /**
         * Convierte una cantidad de esta moneda a otra moneda.
         *
         * @param cantidad     la cantidad a convertir
         * @param monedaDestino la moneda de destino
         * @return la cantidad equivalente en la moneda de destino
         */
        public double convertirA(double cantidad, Moneda monedaDestino) {
            double enUsd = convertirAUsd(cantidad);
            return monedaDestino.convertirDesdeUsd(enUsd);
        }

        /**
         * Formatea un monto con el símbolo de la moneda.
         *
         * @param cantidad la cantidad a formatear
         * @return el monto formateado como String
         */
        public String formatear(double cantidad) {
            return String.format("%s %,.2f %s", simbolo, cantidad, codigo);
        }
    }

    // ─────────────────────────────────────────────
    //  3. ENUM CON MÉTODOS ABSTRACTOS: OPERACIÓN
    // ─────────────────────────────────────────────

    /**
     * Enum donde cada valor implementa su propio comportamiento.
     * Cada operación matemática define cómo se calcula.
     * Esto es como tener un mini-polimorfismo dentro del enum.
     */
    enum Operacion {
        SUMA("+") {
            @Override
            public double calcular(double a, double b) {
                return a + b;
            }
        },
        RESTA("-") {
            @Override
            public double calcular(double a, double b) {
                return a - b;
            }
        },
        MULTIPLICACION("×") {
            @Override
            public double calcular(double a, double b) {
                return a * b;
            }
        },
        DIVISION("÷") {
            @Override
            public double calcular(double a, double b) {
                if (b == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return a / b;
            }
        };

        private final String simbolo;

        /**
         * Constructor de la operación.
         *
         * @param simbolo el símbolo matemático
         */
        Operacion(String simbolo) {
            this.simbolo = simbolo;
        }

        /**
         * Obtiene el símbolo de la operación.
         *
         * @return el símbolo matemático
         */
        public String getSimbolo() {
            return simbolo;
        }

        /**
         * Método abstracto que cada valor del enum debe implementar.
         * Realiza el cálculo correspondiente a la operación.
         *
         * @param a primer operando
         * @param b segundo operando
         * @return el resultado de la operación
         */
        public abstract double calcular(double a, double b);

        /**
         * Devuelve una representación formateada de la operación.
         *
         * @param a primer operando
         * @param b segundo operando
         * @return expresión formateada con resultado
         */
        public String expresion(double a, double b) {
            return String.format("%.2f %s %.2f = %.2f",
                    a, simbolo, b, calcular(a, b));
        }
    }

    // ─────────────────────────────────────────────
    //  4. MÉTODO PRINCIPAL
    // ─────────────────────────────────────────────

    /**
     * Punto de entrada del programa. Ejecuta todas las demostraciones.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   ENUMS CON ATRIBUTOS Y MÉTODOS             ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        demostrarPlanetas();
        demostrarMonedas();
        demostrarConversionMonedas();
        demostrarOperaciones();
        demostrarMetodoEstaticoEnEnum();
    }

    // ─────────────────────────────────────────────
    //  5. DEMOSTRACIÓN: PLANETAS
    // ─────────────────────────────────────────────

    /**
     * Demuestra el uso del enum Planeta con sus atributos y métodos.
     */
    public static void demostrarPlanetas() {
        System.out.println("── 1. Enum Planeta ──\n");

        // Acceder a atributos de un planeta específico
        Planeta tierra = Planeta.TIERRA;
        System.out.println("Planeta: " + tierra);
        System.out.printf("  Masa:     %.3e kg%n", tierra.getMasa());
        System.out.printf("  Radio:    %.3e m%n", tierra.getRadio());
        System.out.printf("  Gravedad: %.2f m/s²%n", tierra.gravedadSuperficial());

        System.out.println();

        // Calcular peso en cada planeta (persona de 75 kg)
        double masaPersona = 75.0;
        System.out.printf("Peso de una persona de %.0f kg en cada planeta:%n", masaPersona);
        System.out.println("┌────────────┬──────────────┬──────────────┐");
        System.out.println("│ Planeta    │ Gravedad     │ Peso (N)     │");
        System.out.println("├────────────┼──────────────┼──────────────┤");

        for (Planeta p : Planeta.values()) {
            System.out.printf("│ %-10s │ %8.2f m/s² │ %8.2f N   │%n",
                    p, p.gravedadSuperficial(), p.pesoEn(masaPersona));
        }

        System.out.println("└────────────┴──────────────┴──────────────┘");
        System.out.println();
    }

    // ─────────────────────────────────────────────
    //  6. DEMOSTRACIÓN: MONEDAS
    // ─────────────────────────────────────────────

    /**
     * Demuestra el uso del enum Moneda con sus atributos.
     */
    public static void demostrarMonedas() {
        System.out.println("── 2. Enum Moneda ──\n");

        // Mostrar todas las monedas disponibles
        System.out.println("Monedas disponibles:");
        System.out.println("┌────────────────────┬────────┬────────┬──────────────┐");
        System.out.println("│ País               │ Código │ Símb.  │ Tasa vs USD  │");
        System.out.println("├────────────────────┼────────┼────────┼──────────────┤");

        for (Moneda m : Moneda.values()) {
            System.out.printf("│ %-18s │  %-4s  │  %-3s   │ %10.2f   │%n",
                    m.getPais(), m.getCodigo(), m.getSimbolo(), m.getTasaCambioUsd());
        }

        System.out.println("└────────────────────┴────────┴────────┴──────────────┘");
        System.out.println();
    }

    /**
     * Demuestra las conversiones de moneda usando los métodos del enum.
     */
    public static void demostrarConversionMonedas() {
        System.out.println("── 3. Conversión de Monedas ──\n");

        double cantidadUsd = 100.0;

        System.out.printf("Equivalente de $%.2f USD en otras monedas:%n%n", cantidadUsd);
        for (Moneda m : Moneda.values()) {
            if (m != Moneda.DOLAR_USD) {
                double convertido = Moneda.DOLAR_USD.convertirA(cantidadUsd, m);
                System.out.println("  " + m.formatear(convertido));
            }
        }

        System.out.println();

        // Conversión entre dos monedas (no USD)
        double pesosMxn = 5000.0;
        double enSoles = Moneda.PESO_MXN.convertirA(pesosMxn, Moneda.SOL_PEN);
        System.out.printf("  %s → %s%n",
                Moneda.PESO_MXN.formatear(pesosMxn),
                Moneda.SOL_PEN.formatear(enSoles));
        System.out.println();
    }

    // ─────────────────────────────────────────────
    //  7. DEMOSTRACIÓN: OPERACIONES (MÉTODOS ABSTRACTOS)
    // ─────────────────────────────────────────────

    /**
     * Demuestra el enum Operacion donde cada valor tiene su propia
     * implementación del método calcular().
     */
    public static void demostrarOperaciones() {
        System.out.println("── 4. Enum con Métodos Abstractos (Operación) ──\n");

        double a = 10.0;
        double b = 3.0;

        System.out.printf("Operaciones con %.0f y %.0f:%n%n", a, b);

        for (Operacion op : Operacion.values()) {
            System.out.println("  " + op.expresion(a, b));
        }

        System.out.println();

        // Usar una operación específica
        Operacion miOperacion = Operacion.MULTIPLICACION;
        double resultado = miOperacion.calcular(7, 8);
        System.out.println("7 " + miOperacion.getSimbolo() + " 8 = " + resultado);
        System.out.println();
    }

    // ─────────────────────────────────────────────
    //  8. MÉTODO ESTÁTICO PERSONALIZADO EN ENUM
    // ─────────────────────────────────────────────

    /**
     * Demuestra que se pueden agregar métodos estáticos
     * dentro de un enum para búsquedas personalizadas.
     */
    public static void demostrarMetodoEstaticoEnEnum() {
        System.out.println("── 5. Métodos Estáticos en Enums ──\n");

        // Buscar moneda por código (método estático personalizado)
        String codigoBuscado = "MXN";
        Moneda encontrada = buscarMonedaPorCodigo(codigoBuscado);

        if (encontrada != null) {
            System.out.println("Moneda encontrada:");
            System.out.println("  País:    " + encontrada.getPais());
            System.out.println("  Código:  " + encontrada.getCodigo());
            System.out.println("  Símbolo: " + encontrada.getSimbolo());
        } else {
            System.out.println("Moneda con código '" + codigoBuscado + "' no encontrada");
        }

        System.out.println();

        // ─── Resumen ───
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║  RESUMEN: ENUMS CON ATRIBUTOS                   ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║  1. Declara campos como private final           ║");
        System.out.println("║  2. El constructor es siempre privado           ║");
        System.out.println("║  3. Pasa argumentos: VALOR(arg1, arg2);         ║");
        System.out.println("║  4. Agrega getters y métodos de lógica          ║");
        System.out.println("║  5. Puedes tener métodos abstractos             ║");
        System.out.println("║  6. Cada valor puede implementar métodos        ║");
        System.out.println("║  7. Puedes agregar métodos estáticos            ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    /**
     * Busca una moneda por su código ISO.
     * Este es un ejemplo de cómo se podría implementar un
     * método estático auxiliar para búsqueda en enums.
     *
     * @param codigo el código ISO a buscar
     * @return la moneda encontrada o null si no existe
     */
    public static Moneda buscarMonedaPorCodigo(String codigo) {
        for (Moneda m : Moneda.values()) {
            if (m.getCodigo().equalsIgnoreCase(codigo)) {
                return m;
            }
        }
        return null;
    }
}
