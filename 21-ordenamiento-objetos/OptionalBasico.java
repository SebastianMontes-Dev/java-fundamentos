import java.util.*;

/**
 * ============================================================
 *  TEMA: Optional — Eliminando NullPointerException
 *  SECCIÓN: 21 — Ordenamiento y Optional
 *  ARCHIVO: OptionalBasico.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  NullPointerException es el error más famoso (y odiado) de Java.
 *  Ocurre cuando intentas usar una referencia que apunta a null.
 *  Optional<T> es la respuesta de Java: en vez de devolver null,
 *  devuelves un Optional que EXPLÍCITAMENTE dice "este valor puede
 *  o no existir", obligando a quien lo recibe a manejar ambos casos.
 *
 *  Aprenderás los métodos clave: crear Optionals (of/ofNullable),
 *  verificar presencia (isPresent/ifPresent), desempaquetar con
 *  valor por defecto (orElse) o lanzar excepción (orElseThrow),
 *  y transformar datos sin desempaquetar (map/filter).
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Optional.of(valor): crea Optional con valor NO nulo (lanza si es null).
 *  - Optional.ofNullable(valor): crea Optional que puede ser empty.
 *  - Optional.empty(): Optional vacío (alternativa segura a null).
 *  - isPresent(): ¿tiene valor?
 *  - ifPresent(consumer): ejecuta código solo si hay valor.
 *  - orElse(default): desempaqueta con valor por defecto.
 *  - orElseGet(supplier): igual pero lazy (el default se calcula si hace falta).
 *  - orElseThrow(exceptionSupplier): desempaqueta o lanza excepción.
 *  - map(f): transforma el valor si existe (devuelve otro Optional).
 *  - filter(predicate): Optional vacío si no cumple condición.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Optional<String> opt = Optional.ofNullable(puedeSerNull);
 *  String resultado = opt.orElse("Valor por defecto");
 *  opt.ifPresent(valor -> System.out.println(valor));
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Llamar a .get() sin verificar isPresent() (derrota el propósito).
 *  - Usar Optional como campo de clase (está diseñado para valores de RETORNO).
 *  - Pasar null a Optional.of() (usa ofNullable() si puede ser null).
 *  - Usar Optional en parámetros de método.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Optional.html
 *  - Blog Oracle sobre Optional: https://www.oracle.com/technical-resources/articles/java/java8-optional.html
 * ============================================================
 */
public class OptionalBasico {

    public static void main(String[] args) {
        System.out.println("=== Optional: Dile Adiós al NullPointerException ===");
        System.out.println();

        // --- CREACIÓN ---
        System.out.println("--- 1. Crear Optionals ---");

        Optional<String> presente = Optional.of("Hola");           // Valor seguro
        Optional<String> vacio = Optional.empty();                 // Vacío explícito
        Optional<String> quizas = Optional.ofNullable(null);       // Acepta null
        Optional<String> quizasValor = Optional.ofNullable("Mundo");

        System.out.println("presente:     " + presente);
        System.out.println("vacío:        " + vacio);
        System.out.println("quizás(null): " + quizas);
        System.out.println("quizás(valor):" + quizasValor);
        System.out.println();

        // --- VERIFICAR Y DESEMPAQUETAR ---
        System.out.println("--- 2. Verificar y Desempaquetar ---");

        if (presente.isPresent()) {
            System.out.println("presente.isPresent() = true → valor: " + presente.get());
        }

        if (vacio.isEmpty()) {
            System.out.println("vacío.isEmpty() = true (Java 11+)");
        }

        // ifPresent: ejecuta solo si hay valor
        presente.ifPresent(v -> System.out.println("ifPresent: " + v));
        vacio.ifPresent(v -> System.out.println("Esto NO se imprime"));
        System.out.println();

        // --- VALORES POR DEFECTO ---
        System.out.println("--- 3. Valores por Defecto ---");

        String resultado1 = presente.orElse("Default");
        String resultado2 = vacio.orElse("Default");
        String resultado3 = quizas.orElse("No había valor");

        System.out.println("presente.orElse(): " + resultado1);
        System.out.println("vacío.orElse():    " + resultado2);
        System.out.println("quizás.orElse():   " + resultado3);

        // orElseGet: evaluación lazy
        String lazy = vacio.orElseGet(() -> "Calculado bajo demanda: " + System.currentTimeMillis());
        System.out.println("orElseGet (lazy):  " + lazy);
        System.out.println();

        // --- LANZAR EXCEPCIÓN SI VACÍO ---
        System.out.println("--- 4. orElseThrow ---");

        try {
            String valor = presente.orElseThrow(() -> new IllegalArgumentException("No hay valor"));
            System.out.println("orElseThrow con valor: " + valor);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            String valor = vacio.orElseThrow(() -> new IllegalArgumentException("No hay valor"));
        } catch (Exception e) {
            System.out.println("orElseThrow con vacío: " + e.getMessage());
        }
        System.out.println();

        // --- MAP Y FILTER (sin desempaquetar) ---
        System.out.println("--- 5. map() y filter() ---");

        Optional<String> nombre = Optional.of("  Sebas  ");

        Optional<String> procesado = nombre
                .map(String::trim)               // "  Sebas  " → "Sebas"
                .filter(n -> n.length() > 3)     // ¿longitud > 3?
                .map(String::toUpperCase);       // "Sebas" → "SEBAS"

        System.out.println("Original: " + nombre);
        System.out.println("Procesado (trim > filter > uppercase): " + procesado);

        Optional<String> corto = Optional.of("AB");
        Optional<String> filtrado = corto.filter(s -> s.length() > 3);
        System.out.println("'AB' filter len>3: " + filtrado + " (vacío, no pasó el filtro)");
        System.out.println();

        // --- CASO PRÁCTICO: BUSCAR USUARIO ---
        System.out.println("--- 6. Caso Práctico: Buscar Usuario ---");

        Map<String, String> usuarios = new HashMap<>();
        usuarios.put("ana", "ana@ejemplo.com");
        usuarios.put("carlos", "carlos@ejemplo.com");

        String usuarioBuscado = "ana";
        String email = buscarEmail(usuarios, usuarioBuscado);
        System.out.println("Email de '" + usuarioBuscado + "': " + email);

        String noExiste = buscarEmail(usuarios, "pedro");
        System.out.println("Email de 'pedro': " + noExiste);
        System.out.println();

        // --- ANTI-PATRÓN (NO hagas esto) ---
        System.out.println("--- Anti-Patrones con Optional ---");

        // MAL: usar isPresent + get
        Optional<String> opt = Optional.of("valor");
        if (opt.isPresent()) {
            String v = opt.get(); // ¿Para qué Optional si haces esto?
        }

        // BIEN: usar orElse/orElseThrow/ifPresent
        opt.ifPresent(v -> System.out.println("Bien: " + v));
        System.out.println("(Prefiere ifPresent() o map() sobre isPresent()+get())");
    }

    static String buscarEmail(Map<String, String> usuarios, String nombre) {
        return Optional.ofNullable(usuarios.get(nombre))
                .orElse("usuario no encontrado");
    }
}
