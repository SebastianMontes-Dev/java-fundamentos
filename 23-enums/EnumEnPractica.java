import java.util.Scanner;

/**
 * ============================================================
 *  TEMA: Enums en la Práctica — Menú Interactivo y Máquina de Estados
 *  SECCIÓN: 23 — Enums
 *  ARCHIVO: EnumEnPractica.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a combinar enums con entrada del usuario (Scanner)
 *  para crear aplicaciones prácticas. Verás dos patrones comunes:
 *  (1) un menú interactivo donde las opciones son valores de un enum,
 *  y (2) una máquina de estados tipo semáforo donde las transiciones
 *  están definidas dentro del propio enum. Estos patrones se usan
 *  frecuentemente en aplicaciones reales.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Usar enums para representar opciones de un menú
 *  - Convertir entrada del usuario a valores de enum de forma segura
 *  - Patrón de máquina de estados con enums
 *  - Combinación de enum + switch + Scanner
 *  - Validación de entrada con enums
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *      // Conversión segura de entrada a enum:
 *      try {
 *          MiEnum valor = MiEnum.valueOf(entrada.toUpperCase());
 *      } catch (IllegalArgumentException e) {
 *          System.out.println("Opción no válida");
 *      }
 *
 *      // Máquina de estados:
 *      enum Estado {
 *          ESTADO_A { public Estado siguiente() { return ESTADO_B; } },
 *          ESTADO_B { public Estado siguiente() { return ESTADO_A; } };
 *          public abstract Estado siguiente();
 *      }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - No manejar la excepción de valueOf() al recibir entrada del usuario
 *  - No convertir la entrada a mayúsculas antes de valueOf()
 *  - Olvidar validar la entrada antes de procesarla
 *  - No cerrar el Scanner al finalizar
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 *  - State Pattern con Enums: https://www.baeldung.com/java-enum-simple-state-machine
 * ============================================================
 */

/**
 * Clase que demuestra el uso práctico de enums combinados con
 * Scanner para crear menús interactivos y máquinas de estados.
 */
public class EnumEnPractica {

    // ─────────────────────────────────────────────
    //  1. ENUM: OPCIONES DEL MENÚ PRINCIPAL
    // ─────────────────────────────────────────────

    /**
     * Enum que representa las opciones del menú principal.
     * Cada opción tiene un número, descripción e ícono.
     */
    enum OpcionMenu {
        CONSULTAR_SALDO  (1, "Consultar saldo",         "💰"),
        DEPOSITAR        (2, "Realizar depósito",        "📥"),
        RETIRAR          (3, "Realizar retiro",          "📤"),
        HISTORIAL        (4, "Ver historial",            "📋"),
        CAMBIAR_PIN      (5, "Cambiar PIN",              "🔑"),
        SALIR            (6, "Salir del sistema",        "🚪");

        private final int numero;
        private final String descripcion;
        private final String icono;

        /**
         * Constructor de la opción del menú.
         *
         * @param numero      número de la opción
         * @param descripcion descripción de la opción
         * @param icono       ícono representativo
         */
        OpcionMenu(int numero, String descripcion, String icono) {
            this.numero = numero;
            this.descripcion = descripcion;
            this.icono = icono;
        }

        /**
         * Obtiene el número de la opción.
         *
         * @return el número
         */
        public int getNumero() {
            return numero;
        }

        /**
         * Obtiene la descripción de la opción.
         *
         * @return la descripción
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * Obtiene el ícono de la opción.
         *
         * @return el ícono
         */
        public String getIcono() {
            return icono;
        }

        /**
         * Busca una opción del menú por su número.
         * Este es un patrón muy útil para convertir entrada numérica a enum.
         *
         * @param numero el número de la opción
         * @return la opción encontrada, o null si no existe
         */
        public static OpcionMenu desdeNumero(int numero) {
            for (OpcionMenu opcion : values()) {
                if (opcion.numero == numero) {
                    return opcion;
                }
            }
            return null;
        }
    }

    // ─────────────────────────────────────────────
    //  2. ENUM: ESTADOS DEL SEMÁFORO
    // ─────────────────────────────────────────────

    /**
     * Enum que implementa una máquina de estados para un semáforo.
     * Cada estado sabe cuál es su siguiente estado y su duración.
     * Este patrón evita usar condicionales complejos.
     */
    enum EstadoSemaforo {
        VERDE("Verde - Avanzar", 30) {
            @Override
            public EstadoSemaforo siguiente() {
                return AMARILLO;
            }

            @Override
            public String representacion() {
                return "[ ● ]  [   ]  [   ]";
            }
        },
        AMARILLO("Amarillo - Precaución", 5) {
            @Override
            public EstadoSemaforo siguiente() {
                return ROJO;
            }

            @Override
            public String representacion() {
                return "[   ]  [ ● ]  [   ]";
            }
        },
        ROJO("Rojo - Detenerse", 20) {
            @Override
            public EstadoSemaforo siguiente() {
                return VERDE;
            }

            @Override
            public String representacion() {
                return "[   ]  [   ]  [ ● ]";
            }
        };

        private final String instruccion;
        private final int duracionSegundos;

        /**
         * Constructor del estado del semáforo.
         *
         * @param instruccion      instrucción para el conductor
         * @param duracionSegundos duración del estado en segundos
         */
        EstadoSemaforo(String instruccion, int duracionSegundos) {
            this.instruccion = instruccion;
            this.duracionSegundos = duracionSegundos;
        }

        /**
         * Obtiene la instrucción para el conductor.
         *
         * @return la instrucción
         */
        public String getInstruccion() {
            return instruccion;
        }

        /**
         * Obtiene la duración del estado.
         *
         * @return la duración en segundos
         */
        public int getDuracionSegundos() {
            return duracionSegundos;
        }

        /**
         * Devuelve el siguiente estado del semáforo.
         * Cada valor implementa su propia transición.
         *
         * @return el siguiente estado
         */
        public abstract EstadoSemaforo siguiente();

        /**
         * Devuelve una representación visual del semáforo.
         *
         * @return la representación como String
         */
        public abstract String representacion();
    }

    // ─────────────────────────────────────────────
    //  3. ENUM: ESTADO DE UN PEDIDO (ejemplo e-commerce)
    // ─────────────────────────────────────────────

    /**
     * Enum que modela el ciclo de vida de un pedido en línea.
     * Demuestra transiciones válidas e inválidas entre estados.
     */
    enum EstadoPedido {
        PENDIENTE("Pedido recibido, esperando confirmación") {
            @Override
            public EstadoPedido avanzar() {
                return CONFIRMADO;
            }

            @Override
            public boolean puedeCancelarse() {
                return true;
            }
        },
        CONFIRMADO("Pedido confirmado, preparando envío") {
            @Override
            public EstadoPedido avanzar() {
                return EN_CAMINO;
            }

            @Override
            public boolean puedeCancelarse() {
                return true;
            }
        },
        EN_CAMINO("Pedido en camino al destino") {
            @Override
            public EstadoPedido avanzar() {
                return ENTREGADO;
            }

            @Override
            public boolean puedeCancelarse() {
                return false; // Ya no se puede cancelar en camino
            }
        },
        ENTREGADO("Pedido entregado exitosamente") {
            @Override
            public EstadoPedido avanzar() {
                return this; // Estado final, no avanza más
            }

            @Override
            public boolean puedeCancelarse() {
                return false;
            }
        },
        CANCELADO("Pedido cancelado") {
            @Override
            public EstadoPedido avanzar() {
                return this; // Estado final
            }

            @Override
            public boolean puedeCancelarse() {
                return false;
            }
        };

        private final String descripcion;

        /**
         * Constructor del estado del pedido.
         *
         * @param descripcion descripción del estado
         */
        EstadoPedido(String descripcion) {
            this.descripcion = descripcion;
        }

        /**
         * Obtiene la descripción del estado.
         *
         * @return la descripción
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * Avanza al siguiente estado en el ciclo de vida.
         *
         * @return el siguiente estado
         */
        public abstract EstadoPedido avanzar();

        /**
         * Indica si el pedido puede cancelarse en este estado.
         *
         * @return true si es cancelable
         */
        public abstract boolean puedeCancelarse();
    }

    // ─────────────────────────────────────────────
    //  4. MÉTODO PRINCIPAL
    // ─────────────────────────────────────────────

    /**
     * Punto de entrada del programa.
     * Ejecuta las demostraciones de enums en la práctica.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   ENUMS EN LA PRÁCTICA                       ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        Scanner sc = new Scanner(System.in);

        demostrarMenuInteractivo(sc);
        demostrarSemaforo();
        demostrarCicloVidaPedido(sc);

        sc.close();
    }

    // ─────────────────────────────────────────────
    //  5. MENÚ INTERACTIVO CON ENUM + SCANNER
    // ─────────────────────────────────────────────

    /**
     * Demuestra un menú interactivo donde las opciones están
     * definidas por un enum. El usuario selecciona con números.
     *
     * @param sc el Scanner para leer entrada del usuario
     */
    public static void demostrarMenuInteractivo(Scanner sc) {
        System.out.println("── 1. Menú Interactivo (Cajero Automático) ──\n");

        // Simular un saldo para la demostración
        double saldo = 5000.00;
        boolean ejecutando = true;

        while (ejecutando) {
            // Mostrar el menú usando el enum
            mostrarMenu();

            System.out.print("Seleccione una opción: ");

            // Validar que sea un número
            if (!sc.hasNextInt()) {
                System.out.println("⚠ Por favor, ingrese un número válido.\n");
                sc.next(); // Limpiar entrada inválida
                continue;
            }

            int seleccion = sc.nextInt();

            // Convertir el número a una opción del enum
            OpcionMenu opcion = OpcionMenu.desdeNumero(seleccion);

            if (opcion == null) {
                System.out.println("⚠ Opción no válida. Intente de nuevo.\n");
                continue;
            }

            // Procesar la opción seleccionada usando switch
            switch (opcion) {
                case CONSULTAR_SALDO:
                    System.out.printf("%n  💰 Su saldo actual es: $%,.2f%n%n", saldo);
                    break;

                case DEPOSITAR:
                    System.out.print("  Ingrese monto a depositar: $");
                    if (sc.hasNextDouble()) {
                        double deposito = sc.nextDouble();
                        if (deposito > 0) {
                            saldo += deposito;
                            System.out.printf("  ✓ Depósito exitoso. Nuevo saldo: $%,.2f%n%n", saldo);
                        } else {
                            System.out.println("  ✗ El monto debe ser positivo.\n");
                        }
                    } else {
                        System.out.println("  ✗ Monto no válido.\n");
                        sc.next();
                    }
                    break;

                case RETIRAR:
                    System.out.print("  Ingrese monto a retirar: $");
                    if (sc.hasNextDouble()) {
                        double retiro = sc.nextDouble();
                        if (retiro > 0 && retiro <= saldo) {
                            saldo -= retiro;
                            System.out.printf("  ✓ Retiro exitoso. Nuevo saldo: $%,.2f%n%n", saldo);
                        } else if (retiro > saldo) {
                            System.out.println("  ✗ Fondos insuficientes.\n");
                        } else {
                            System.out.println("  ✗ El monto debe ser positivo.\n");
                        }
                    } else {
                        System.out.println("  ✗ Monto no válido.\n");
                        sc.next();
                    }
                    break;

                case HISTORIAL:
                    System.out.println("\n  📋 Historial de transacciones:");
                    System.out.println("  (Funcionalidad simulada)");
                    System.out.println("  ─ 01/06 Depósito   +$1,000.00");
                    System.out.println("  ─ 02/06 Retiro     -$250.00");
                    System.out.println("  ─ 03/06 Depósito   +$500.00\n");
                    break;

                case CAMBIAR_PIN:
                    System.out.println("\n  🔑 Cambio de PIN:");
                    System.out.println("  (Funcionalidad simulada)");
                    System.out.println("  ✓ PIN actualizado exitosamente.\n");
                    break;

                case SALIR:
                    System.out.println("\n  🚪 Gracias por usar nuestro cajero. ¡Hasta pronto!\n");
                    ejecutando = false;
                    break;
            }
        }
    }

    /**
     * Muestra el menú en pantalla usando los valores del enum.
     * Las opciones se generan automáticamente del enum,
     * así que si agregas un nuevo valor al enum, el menú se actualiza solo.
     */
    public static void mostrarMenu() {
        System.out.println("┌──────────────────────────────────────┐");
        System.out.println("│       CAJERO AUTOMÁTICO JAVA         │");
        System.out.println("├──────────────────────────────────────┤");

        for (OpcionMenu opcion : OpcionMenu.values()) {
            System.out.printf("│  %s  %d. %-28s │%n",
                    opcion.getIcono(), opcion.getNumero(), opcion.getDescripcion());
        }

        System.out.println("└──────────────────────────────────────┘");
    }

    // ─────────────────────────────────────────────
    //  6. MÁQUINA DE ESTADOS: SEMÁFORO
    // ─────────────────────────────────────────────

    /**
     * Demuestra una máquina de estados usando el enum EstadoSemaforo.
     * El semáforo avanza automáticamente por sus estados (sin intervención
     * del usuario, para que sea una demostración limpia).
     */
    public static void demostrarSemaforo() {
        System.out.println("── 2. Máquina de Estados: Semáforo ──\n");

        EstadoSemaforo estado = EstadoSemaforo.VERDE;
        int ciclos = 6; // Simular 6 cambios de estado

        System.out.println("Simulación del semáforo (" + ciclos + " cambios):\n");

        for (int i = 1; i <= ciclos; i++) {
            System.out.printf("  Paso %d:%n", i);
            System.out.println("    Semáforo: " + estado.representacion());
            System.out.println("    Estado:   " + estado.name());
            System.out.println("    Acción:   " + estado.getInstruccion());
            System.out.println("    Duración: " + estado.getDuracionSegundos() + " segundos");

            // Transición al siguiente estado
            estado = estado.siguiente();
            System.out.println("    → Siguiente: " + estado.name());
            System.out.println();
        }

        // Demostrar el ciclo completo
        System.out.println("  El semáforo forma un ciclo: VERDE → AMARILLO → ROJO → VERDE → ...");
        System.out.println();
    }

    // ─────────────────────────────────────────────
    //  7. CICLO DE VIDA DE UN PEDIDO
    // ─────────────────────────────────────────────

    /**
     * Demuestra el enum EstadoPedido como máquina de estados,
     * simulando el ciclo de vida de un pedido de e-commerce.
     * El usuario decide si avanzar o cancelar el pedido.
     *
     * @param sc el Scanner para leer entrada del usuario
     */
    public static void demostrarCicloVidaPedido(Scanner sc) {
        System.out.println("── 3. Ciclo de Vida de un Pedido ──\n");

        EstadoPedido estadoActual = EstadoPedido.PENDIENTE;
        String numeroPedido = "PED-2024-001";
        boolean pedidoActivo = true;

        System.out.println("  Pedido: " + numeroPedido);
        System.out.println("  Estado inicial: " + estadoActual.name());
        System.out.println("  " + estadoActual.getDescripcion());
        System.out.println();

        while (pedidoActivo) {
            // Mostrar estado actual
            mostrarEstadoPedido(estadoActual);

            // Verificar si es un estado final
            if (estadoActual == EstadoPedido.ENTREGADO || estadoActual == EstadoPedido.CANCELADO) {
                System.out.println("  ── El pedido ha llegado a su estado final ──\n");
                pedidoActivo = false;
                continue;
            }

            // Mostrar opciones disponibles
            System.out.println("  Opciones:");
            System.out.println("    1. Avanzar al siguiente estado");
            if (estadoActual.puedeCancelarse()) {
                System.out.println("    2. Cancelar pedido");
            }
            System.out.println("    0. Terminar simulación");

            System.out.print("  Selección: ");

            if (!sc.hasNextInt()) {
                System.out.println("  ⚠ Ingrese un número válido.\n");
                sc.next();
                continue;
            }

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    EstadoPedido anterior = estadoActual;
                    estadoActual = estadoActual.avanzar();
                    System.out.printf("%n  ✓ Transición: %s → %s%n%n",
                            anterior.name(), estadoActual.name());
                    break;

                case 2:
                    if (estadoActual.puedeCancelarse()) {
                        System.out.printf("%n  ✗ Pedido cancelado (estaba en: %s)%n%n",
                                estadoActual.name());
                        estadoActual = EstadoPedido.CANCELADO;
                    } else {
                        System.out.println("\n  ⚠ El pedido no puede cancelarse en este estado.\n");
                    }
                    break;

                case 0:
                    System.out.println("\n  Simulación terminada.\n");
                    pedidoActivo = false;
                    break;

                default:
                    System.out.println("\n  ⚠ Opción no válida.\n");
            }
        }

        // ─── Resumen final ───
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║  RESUMEN: PATRONES PRÁCTICOS CON ENUMS              ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║                                                      ║");
        System.out.println("║  1. MENÚ INTERACTIVO                                 ║");
        System.out.println("║     → Define opciones como enum                      ║");
        System.out.println("║     → Usa desdeNumero() para convertir entrada       ║");
        System.out.println("║     → El menú se auto-genera con values()            ║");
        System.out.println("║                                                      ║");
        System.out.println("║  2. MÁQUINA DE ESTADOS                               ║");
        System.out.println("║     → Cada estado define su transición (siguiente())  ║");
        System.out.println("║     → No necesitas if/else complejos                 ║");
        System.out.println("║     → El enum encapsula la lógica de transición      ║");
        System.out.println("║                                                      ║");
        System.out.println("║  3. VALIDACIÓN                                       ║");
        System.out.println("║     → Usa métodos como puedeCancelarse()             ║");
        System.out.println("║     → El enum define las reglas del negocio           ║");
        System.out.println("║                                                      ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    /**
     * Muestra visualmente el estado actual del pedido
     * con una barra de progreso.
     *
     * @param estado el estado actual del pedido
     */
    public static void mostrarEstadoPedido(EstadoPedido estado) {
        System.out.println("  ┌────────────────────────────────────────────┐");
        System.out.printf("  │  Estado: %-33s │%n", estado.name());
        System.out.printf("  │  %s%-30s │%n", "  ", estado.getDescripcion());
        System.out.println("  ├────────────────────────────────────────────┤");

        // Barra de progreso visual
        String[] estados = {"PENDIENTE", "CONFIRMADO", "EN_CAMINO", "ENTREGADO"};
        StringBuilder barra = new StringBuilder("  │  ");

        if (estado == EstadoPedido.CANCELADO) {
            barra.append("  ✗ ── CANCELADO ──                        ");
        } else {
            for (int i = 0; i < estados.length; i++) {
                if (estados[i].equals(estado.name())) {
                    barra.append("[●]");
                } else if (estado.ordinal() > i && estado != EstadoPedido.CANCELADO) {
                    barra.append("[✓]");
                } else {
                    barra.append("[ ]");
                }
                if (i < estados.length - 1) {
                    barra.append("──");
                }
            }
            // Rellenar con espacios para alinear
            while (barra.length() < 49) {
                barra.append(" ");
            }
        }

        barra.append("│");
        System.out.println(barra);
        System.out.printf("  │  ¿Cancelable? %-29s │%n",
                estado.puedeCancelarse() ? "Sí" : "No");
        System.out.println("  └────────────────────────────────────────────┘");
    }
}
