/**
 * ============================================================
 *  TEMA: Clases Anidadas Estáticas (Static Nested Classes)
 *  SECCIÓN: 17 — Clases Internas
 *  ARCHIVO: ClasesAnidadasStatic.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Una clase anidada estática (static nested class) es una clase definida
 *  dentro de otra por razones de organización, pero sin acceso especial
 *  a la instancia externa. Es el tipo más simple y el más usado en
 *  producción. Se comporta como una clase normal (top-level) pero vive
 *  dentro del namespace de otra clase. Útil para agrupar clases helper
 *  que solo tienen sentido en el contexto de su clase externa: un Builder,
 *  un par clave-valor, o una configuración interna.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Se declara con `static class Nombre` dentro de otra clase.
 *  - NO tiene acceso a `this` de la clase externa (no hay instancia).
 *  - Puede acceder a miembros static de la clase externa.
 *  - Se instancia con `new Outer.Inner()` (sin instancia del outer).
 *  - Comportamiento idéntico a una clase top-level, solo cambia el namespace.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  class Externa {
 *      static class Anidada {
 *          void metodo() { ... }
 *      }
 *  }
 *  Externa.Anidada obj = new Externa.Anidada();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Intentar acceder a miembros no-static del outer desde la static nested.
 *  - Olvidar el `static` y crear accidentalmente una inner class.
 *  - Instanciar la clase externa innecesariamente para usar la anidada.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
 * ============================================================
 */
public class ClasesAnidadasStatic {

    private static String version = "1.0";
    private String nombreApp = "DemoApp";

    // Static nested class: es como una clase top-level
    static class Configuracion {
        private String urlBD;
        private int maxConexiones;

        public Configuracion(String urlBD, int maxConexiones) {
            this.urlBD = urlBD;
            this.maxConexiones = maxConexiones;
        }

        public void mostrar() {
            // Puede acceder a miembros STATIC del outer
            System.out.println("  Versión de la app: " + version);
            // NO puede acceder a nombreApp (no es static)
            // System.out.println(nombreApp); // ERROR de compilación
            System.out.println("  URL BD: " + urlBD);
            System.out.println("  Max conexiones: " + maxConexiones);
        }
    }

    // Otro ejemplo: clase helper para resultados
    static class ResultadoOperacion {
        private boolean exito;
        private String mensaje;

        public ResultadoOperacion(boolean exito, String mensaje) {
            this.exito = exito;
            this.mensaje = mensaje;
        }

        public boolean esExito() { return exito; }
        public String getMensaje() { return mensaje; }

        @Override
        public String toString() {
            return (exito ? "ÉXITO" : "ERROR") + ": " + mensaje;
        }
    }

    // Método que usa la static nested class
    public static ResultadoOperacion validarPassword(String password) {
        if (password == null || password.length() < 8) {
            return new ResultadoOperacion(false, "Debe tener al menos 8 caracteres");
        }
        return new ResultadoOperacion(true, "Contraseña válida");
    }

    public static void main(String[] args) {
        System.out.println("=== Clases Anidadas Estáticas ===");
        System.out.println();

        // Instanciar sin crear objeto del outer
        System.out.println("--- Instanciando directamente ---");
        Configuracion config = new Configuracion("jdbc:postgresql://localhost/app", 20);
        config.mostrar();
        System.out.println();

        // Uso práctico: clase Resultado
        System.out.println("--- Clase helper ResultadoOperacion ---");
        ResultadoOperacion r1 = validarPassword("abc");
        ResultadoOperacion r2 = validarPassword("Segura2026!");

        System.out.println(r1);
        System.out.println(r2);
        System.out.println();

        // Patrón Builder simplicado con static nested class
        System.out.println("--- Patrón con static nested class ---");

        Persona persona = new Persona.Builder()
                .conNombre("Sebastián")
                .conEdad(25)
                .conEmail("sabas@ejemplo.com")
                .build();

        System.out.println(persona);
    }
}

// Ejemplo: Builder con static nested class
class Persona {
    private String nombre;
    private int edad;
    private String email;

    private Persona() {} // Constructor privado: solo se crea desde Builder

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + ", email='" + email + "'}";
    }

    // Static nested class: Builder
    static class Builder {
        private Persona persona = new Persona();

        public Builder conNombre(String nombre) {
            persona.nombre = nombre;
            return this;
        }

        public Builder conEdad(int edad) {
            persona.edad = edad;
            return this;
        }

        public Builder conEmail(String email) {
            persona.email = email;
            return this;
        }

        public Persona build() {
            return persona;
        }
    }
}
