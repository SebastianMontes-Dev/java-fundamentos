/**
 * ============================================================
 *  TEMA: Clases Locales y Anónimas en Java
 *  SECCIÓN: 17 — Clases Internas
 *  ARCHIVO: ClasesAnonimasYLocales.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Las clases LOCALES se definen dentro de un MÉTODO y solo existen ahí.
 *  Son útiles cuando necesitas una clase muy especializada que no merece
 *  su propio archivo. Las clases ANÓNIMAS van un paso más allá: son clases
 *  sin nombre que creas e instancias en una sola línea. Antes de Java 8 y
 *  las lambdas, las anonymous classes eran la forma estándar de pasar
 *  comportamiento como parámetro (callbacks, listeners, comparators).
 *  Hoy conviven con lambdas y son necesarias cuando implementas interfaces
 *  con múltiples métodos o clases abstractas.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Clase local: definida dentro de un método, accede a variables locales
 *    final o effectively final del método que la contiene.
 *  - Clase anónima: `new Interfaz() { ... }` o `new Clase() { ... }`.
 *    Implementa/hereda y se instancia en una sola expresión.
 *  - Ambas tienen acceso a variables del enclosing scope (si son final).
 *  - Las lambdas (Java 8+) reemplazan a las anónimas para interfaces funcionales.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  // Anónima implementando interfaz
 *  Runnable tarea = new Runnable() {
 *      public void run() { System.out.println("Ejecutando"); }
 *  };
 *
 *  // Local class dentro de un método
 *  class LocalHelper { void ayuda() { ... } }
 *  new LocalHelper().ayuda();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Intentar modificar variables locales del método desde la anónima/local.
 *  - Las variables del enclosing scope deben ser final o effectively final.
 *  - Usar anónimas cuando una lambda es suficiente.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
 * ============================================================
 */
public class ClasesAnonimasYLocales {

    public static void main(String[] args) {
        System.out.println("=== Clases Locales y Anónimas ===");
        System.out.println();

        // --- CLASE LOCAL ---
        System.out.println("--- 1. Clase Local (dentro de un método) ---");
        usarClaseLocal(15);
        System.out.println();

        // --- CLASE ANÓNIMA (interfaz) ---
        System.out.println("--- 2. Clase Anónima implementando Interfaz ---");

        // ANTES: clase anónima (lo que se hacía antes de Java 8)
        Runnable saludarAnonimo = new Runnable() {
            @Override
            public void run() {
                System.out.println("  [Anónimo pre-Java 8] Hola desde una clase sin nombre");
            }
        };

        // AHORA: lambda (Java 8+)
        Runnable saludarLambda = () ->
                System.out.println("  [Lambda Java 8+]    Hola desde una lambda");

        saludarAnonimo.run();
        saludarLambda.run();
        System.out.println("La lambda reemplaza a la anónima para interfaces con 1 solo método.");
        System.out.println();

        // --- CLASE ANÓNIMA (clase abstracta) ---
        System.out.println("--- 3. Clase Anónima extendiendo Clase Abstracta ---");

        Animal perro = new Animal("Firulais") {
            @Override
            void hacerSonido() {
                System.out.println("  " + getNombre() + " dice: ¡Guau!");
            }
        };
        perro.hacerSonido();
        System.out.println("(Aquí SÍ necesitas clase anónima: Animal tiene múltiples métodos)");
        System.out.println();

        // --- COMPARATOR COMO ANÓNIMO vs LAMBDA ---
        System.out.println("--- 4. Comparator: Anónimo vs Lambda ---");

        java.util.List<String> nombres = new java.util.ArrayList<>(
                java.util.Arrays.asList("Carlos", "Ana", "Beto"));

        // Estilo anónimo (pre-Java 8)
        java.util.Collections.sort(nombres, new java.util.Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println("  Ordenado (anónimo): " + nombres);

        // Estilo lambda (Java 8+) — mismo resultado, mucho más corto
        nombres = new java.util.ArrayList<>(java.util.Arrays.asList("Carlos", "Ana", "Beto"));
        nombres.sort((a, b) -> a.compareTo(b));
        System.out.println("  Ordenado (lambda):  " + nombres);
        System.out.println();

        // --- VARIABLE EFFECTIVELY FINAL ---
        System.out.println("--- 5. Acceso a variables del método ---");

        String saludo = "Hola"; // effectively final (no se modifica)
        // saludo = "Chau"; // Si descomentas esto, la lambda NO compila

        Runnable tareaConCaptura = () -> {
            // saludo = "otro"; // ERROR: no se puede modificar
            System.out.println("  " + saludo + " Mundo (capturado de la variable local)");
        };
        tareaConCaptura.run();
        System.out.println("(La variable 'saludo' es effectively final: no se reasigna)");
    }

    // Método que usa una clase local
    static void usarClaseLocal(int numero) {
        // Clase definida dentro del método
        class Verificador {
            String analizar(int n) {
                StringBuilder sb = new StringBuilder();
                sb.append("El número ").append(n);
                if (n % 2 == 0) sb.append(" es par");
                else sb.append(" es impar");

                if (n > 0) sb.append(", positivo");
                else if (n < 0) sb.append(", negativo");
                else sb.append(", es cero");

                return sb.toString();
            }
        }

        Verificador v = new Verificador(); // Clase visible solo aquí
        System.out.println("  " + v.analizar(numero));
    }
}

// Clase abstracta para demo de anónima
abstract class Animal {
    private String nombre;

    public Animal(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
    abstract void hacerSonido();
    public void dormir() { System.out.println(nombre + " está durmiendo"); }
}
