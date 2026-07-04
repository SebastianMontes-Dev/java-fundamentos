import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ============================================================
 *  TEMA: Inferencia de Tipos con var (Java 10+)
 *  SECCIÓN: 32 — Java Moderno
 *  ARCHIVO: VarEInferencia.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  `var` (Java 10) es inferencia de tipos LOCAL: el compilador deduce el
 *  tipo por el lado derecho de la asignación. NO es dynamic typing como
 *  JavaScript o Python — Java sigue siendo 100% estático. El compilador
 *  simplemente te evita repetir el tipo cuando ya es obvio.
 *
 *  Regla de oro: usa `var` cuando el tipo sea EVIDENTE por el contexto
 *  (`var nombre = "Sebastián"`, `var lista = new ArrayList<String>()`).
 *  Evítalo cuando oscurezca la intención o el tipo no sea claro.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - var es inferencia de tipos LOCAL (solo variables locales).
 *  - El tipo se determina en TIEMPO DE COMPILACIÓN (no en runtime).
 *  - NO se puede usar var para: parámetros, campos de clase, retornos.
 *  - El tipo inferido es inmutable (var lista = new ArrayList<String>();
 *    lista sigue siendo ArrayList<String>).
 *  - Mejora legibilidad cuando el tipo es redundante o muy largo.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  var nombre = "Java";                   // String
 *  var edad = 25;                         // int
 *  var lista = new ArrayList<String>();   // ArrayList<String>
 *  var mapa = new HashMap<String, Integer>();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - var x; sin inicializar (ERROR: no puede inferir el tipo).
 *  - var x = null; (ERROR: null no tiene tipo).
 *  - Usar var cuando el tipo no es obvio (reduce legibilidad).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - JEP 286: https://openjdk.org/jeps/286
 *  - Style guide: https://openjdk.org/projects/amber/guides/lvti-style-guide
 * ============================================================
 */
public class VarEInferencia {

    public static void main(String[] args) {
        System.out.println("=== var: Inferencia de Tipos Local (Java 10+) ===");
        System.out.println();

        // --- USO BÁSICO ---
        System.out.println("--- 1. Uso Básico ---");

        var nombre = "Sebastián";
        var edad = 25;
        var precio = 99.99;
        var activo = true;

        System.out.println("nombre  = " + nombre + "  → tipo: " + nombre.getClass().getSimpleName());
        System.out.println("edad    = " + edad + "    → tipo: int (primitivo)");
        System.out.println("precio  = " + precio + " → tipo: double (primitivo)");
        System.out.println("activo  = " + activo + "  → tipo: boolean (primitivo)");
        System.out.println();

        // --- COLECCIONES (donde var brilla) ---
        System.out.println("--- 2. Colecciones ---");

        var frutas = new ArrayList<String>();
        frutas.add("Manzana");
        frutas.add("Banana");
        System.out.println("var frutas: " + frutas.getClass().getName());

        var usuarios = new HashMap<String, Integer>();
        usuarios.put("Ana", 25);
        usuarios.put("Carlos", 30);
        System.out.println("var usuarios: " + usuarios.getClass().getName());
        System.out.println();

        // --- BUCLE FOR-EACH ---
        System.out.println("--- 3. var en for-each ---");

        var numeros = List.of(10, 20, 30, 40, 50);
        System.out.print("Números: ");
        for (var n : numeros) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println();

        // --- CUÁNDO USAR var Y CUÁNDO NO ---
        System.out.println("--- 4. Buenas Prácticas ---");

        // BIEN: tipo obvio por el lado derecho
        var saludo = "Hola";                        // Obvio que es String
        var contador = 0;                           // int
        var entrada = new java.util.Scanner(System.in);
        var builder = new StringBuilder();

        // BIEN: tipos muy largos
        Map<String, List<Map<Integer, String>>> estructuraCompleja = new HashMap<>();
        var estructuraSimple = new HashMap<String, List<Map<Integer, String>>>();

        System.out.println("Usa var cuando el tipo es OBVIO o es MUY LARGO");
        System.out.println("NO uses var cuando oscurezca el tipo");
        System.out.println();

        // --- LIMITACIONES ---
        System.out.println("--- 5. Limitaciones de var ---");

        // ERROR: var sin inicializar
        // var x; // no compila

        // ERROR: var = null
        // var y = null; // no compila

        System.out.println("var x;         → ERROR: no puede inferir el tipo");
        System.out.println("var x = null;  → ERROR: null no tiene tipo");
        System.out.println("var no se usa en: parámetros, campos de clase, ni retornos");
        System.out.println();

        // --- DATO CURIOSO: el tipo es inmutable ---
        System.out.println("--- 6. El Tipo Inferido es Inmutable ---");

        var miLista = new ArrayList<String>();
        // miLista = new LinkedList<String>(); // ERROR: tipo ya fijado como ArrayList
        System.out.println("Una vez inferido el tipo, no puedes reasignar a otro tipo.");
        System.out.println("(Sigue siendo Java estático, solo que no escribes el tipo)");
    }
}
