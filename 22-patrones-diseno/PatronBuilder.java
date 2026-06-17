/**
 * ============================================================
 *  TEMA: Patrón de Diseño Builder
 *  SECCIÓN: 22 — Patrones de Diseño Básicos
 *  ARCHIVO: PatronBuilder.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a usar el patrón Builder para construir objetos complejos
 *  paso a paso. Verás cómo resuelve el problema del "telescoping constructor"
 *  (constructores anidados con múltiples parámetros) y cómo implementar
 *  una interfaz fluida (method chaining).
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Clase compleja con múltiples atributos opcionales.
 *  - Clase estática interna 'Builder' con los mismos atributos.
 *  - Métodos en el Builder que retornan 'this' para permitir encadenamiento.
 *  - Método 'build()' final que retorna la instancia de la clase principal.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Usuario user = new Usuario.Builder("juan123")
 *                      .setEdad(25)
 *                      .setCiudad("Madrid")
 *                      .build();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar hacer privado el constructor de la clase principal para forzar el uso del Builder.
 *  - No retornar 'this' en los métodos de configuración del Builder, rompiendo la interfaz fluida.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Refactoring.guru (Builder): https://refactoring.guru/es/design-patterns/builder
 * ============================================================
 */

public class PatronBuilder {

    public static void main(String[] args) {
        System.out.println("--- Demostración del Patrón Builder ---");

        // Construcción de una computadora básica usando el Builder (interfaz fluida)
        Computadora pcBasica = new Computadora.Builder("Intel Core i3", "8GB DDR4")
                                    .setDiscoDuro("500GB HDD")
                                    .build();
                                    
        System.out.println("PC Básica construida: " + pcBasica);

        // Construcción de una computadora Gamer usando el Builder
        Computadora pcGamer = new Computadora.Builder("AMD Ryzen 9", "32GB DDR5")
                                    .setDiscoDuro("2TB NVMe SSD")
                                    .setTarjetaGrafica("NVIDIA RTX 4090")
                                    .setFuentePoder("1000W 80+ Gold")
                                    .setRefrigeracionLiquida(true)
                                    .build();

        System.out.println("\nPC Gamer construida: " + pcGamer);
        
        System.out.println("\nVentaja del Builder:");
        System.out.println("Evitamos tener un constructor gigante con parámetros que a veces pueden ser nulos:");
        System.out.println("new Computadora(\"Ryzen 9\", \"32GB\", \"2TB\", \"RTX 4090\", \"1000W\", true); // Difícil de leer");
    }
}

class Computadora {
    
    // Parámetros requeridos
    private final String procesador;
    private final String memoriaRAM;
    
    // Parámetros opcionales
    private final String discoDuro;
    private final String tarjetaGrafica;
    private final String fuentePoder;
    private final boolean refrigeracionLiquida;

    // El constructor es privado, solo el Builder puede instanciar la clase
    private Computadora(Builder builder) {
        this.procesador = builder.procesador;
        this.memoriaRAM = builder.memoriaRAM;
        this.discoDuro = builder.discoDuro;
        this.tarjetaGrafica = builder.tarjetaGrafica;
        this.fuentePoder = builder.fuentePoder;
        this.refrigeracionLiquida = builder.refrigeracionLiquida;
    }

    @Override
    public String toString() {
        return "Computadora [CPU=" + procesador + ", RAM=" + memoriaRAM 
                + ", Almacenamiento=" + discoDuro + ", GPU=" + tarjetaGrafica 
                + ", Fuente=" + fuentePoder + ", Ref. Líquida=" + refrigeracionLiquida + "]";
    }

    // Clase interna estática Builder
    public static class Builder {
        
        // Atributos requeridos
        private final String procesador;
        private final String memoriaRAM;
        
        // Atributos opcionales (inicializados con valores por defecto si aplica)
        private String discoDuro = "Sin almacenamiento";
        private String tarjetaGrafica = "Gráficos integrados";
        private String fuentePoder = "Fuente genérica 500W";
        private boolean refrigeracionLiquida = false;

        /**
         * Constructor del Builder con los parámetros requeridos.
         * 
         * @param procesador El procesador de la computadora.
         * @param memoriaRAM La memoria RAM de la computadora.
         */
        public Builder(String procesador, String memoriaRAM) {
            this.procesador = procesador;
            this.memoriaRAM = memoriaRAM;
        }

        // Métodos de configuración para parámetros opcionales (devuelven 'this')
        
        public Builder setDiscoDuro(String discoDuro) {
            this.discoDuro = discoDuro;
            return this;
        }

        public Builder setTarjetaGrafica(String tarjetaGrafica) {
            this.tarjetaGrafica = tarjetaGrafica;
            return this;
        }

        public Builder setFuentePoder(String fuentePoder) {
            this.fuentePoder = fuentePoder;
            return this;
        }

        public Builder setRefrigeracionLiquida(boolean refrigeracionLiquida) {
            this.refrigeracionLiquida = refrigeracionLiquida;
            return this;
        }

        /**
         * Método final que construye el objeto y lo devuelve.
         * @return Una instancia inmutable de Computadora.
         */
        public Computadora build() {
            return new Computadora(this);
        }
    }
}
