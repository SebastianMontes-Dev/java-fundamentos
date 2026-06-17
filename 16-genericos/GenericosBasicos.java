/**
 * ============================================================
 *  TEMA: Genéricos en Java
 *  SECCIÓN: 16 — Genéricos
 *  ARCHIVO: GenericosBasicos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás qué son los genéricos en Java y por qué existen.
 *  Antes de los genéricos, se usaba Object para almacenar cualquier
 *  tipo, lo que provocaba errores en tiempo de ejecución al hacer
 *  casting. Los genéricos proporcionan seguridad de tipos en tiempo
 *  de compilación, evitando esos errores.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Genéricos: permiten parametrizar clases, interfaces y métodos
 *    con tipos
 *  - Parámetro de tipo (<T>): es un "placeholder" para un tipo real
 *    que se especifica al usar la clase
 *  - Seguridad de tipos (Type Safety): el compilador verifica los
 *    tipos y detecta errores antes de ejecutar el programa
 *  - Convenciones de nombres: T (Type), E (Element), K (Key),
 *    V (Value), N (Number)
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  // Declarar una clase genérica:
 *  public class NombreClase<T> {
 *      private T atributo;
 *      // ...
 *  }
 *
 *  // Instanciar una clase genérica:
 *  NombreClase<String> obj = new NombreClase<>("Hola");
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar tipos primitivos como argumento de tipo (int, double).
 *    Se deben usar las clases envolventes (Integer, Double)
 *  - Olvidar especificar el tipo al instanciar (usar raw types),
 *    lo que elimina la seguridad de tipos
 *  - Intentar crear instancias de un parámetro de tipo:
 *    new T() NO es válido
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial:
 *    https://docs.oracle.com/javase/tutorial/java/generics/index.html
 * ============================================================
 */

public class GenericosBasicos {

    // ========================================================
    //  PROBLEMA SIN GENÉRICOS: uso de Object (inseguro)
    // ========================================================

    /**
     * Clase que almacena cualquier objeto usando Object.
     * Problema: no hay verificación de tipos en compilación,
     * los errores aparecen en tiempo de ejecución.
     */
    static class CajaSinGenericos {
        private Object contenido;

        /**
         * Almacena un objeto de cualquier tipo.
         *
         * @param contenido el objeto a almacenar
         */
        public void setContenido(Object contenido) {
            this.contenido = contenido;
        }

        /**
         * Devuelve el contenido almacenado.
         *
         * @return el objeto almacenado (requiere casting manual)
         */
        public Object getContenido() {
            return contenido;
        }
    }

    // ========================================================
    //  SOLUCIÓN CON GENÉRICOS: clase Caja<T>
    // ========================================================

    /**
     * Clase genérica que almacena un elemento de tipo T.
     * T es un parámetro de tipo que se reemplaza por un tipo
     * concreto al momento de instanciar la clase.
     *
     * @param <T> el tipo del contenido que almacenará la caja
     */
    static class Caja<T> {
        private T contenido;

        /**
         * Constructor que inicializa la caja con un contenido.
         *
         * @param contenido el elemento a almacenar
         */
        public Caja(T contenido) {
            this.contenido = contenido;
        }

        /**
         * Constructor vacío (caja sin contenido inicial).
         */
        public Caja() {
            this.contenido = null;
        }

        /**
         * Establece el contenido de la caja.
         *
         * @param contenido el nuevo contenido
         */
        public void setContenido(T contenido) {
            this.contenido = contenido;
        }

        /**
         * Obtiene el contenido de la caja.
         * No necesita casting, el tipo ya está definido.
         *
         * @return el contenido de tipo T
         */
        public T getContenido() {
            return contenido;
        }

        /**
         * Verifica si la caja tiene contenido.
         *
         * @return true si la caja no está vacía
         */
        public boolean tieneContenido() {
            return contenido != null;
        }

        @Override
        public String toString() {
            return "Caja{contenido=" + contenido + "}";
        }
    }

    // ========================================================
    //  CLASE GENÉRICA CON DOS PARÁMETROS DE TIPO
    // ========================================================

    /**
     * Clase genérica que almacena un par de valores de tipos
     * diferentes. Útil para asociar dos datos relacionados.
     *
     * @param <K> el tipo de la clave (Key)
     * @param <V> el tipo del valor (Value)
     */
    static class Par<K, V> {
        private K clave;
        private V valor;

        /**
         * Constructor que inicializa el par clave-valor.
         *
         * @param clave la clave del par
         * @param valor el valor asociado a la clave
         */
        public Par(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }

        /**
         * Obtiene la clave del par.
         *
         * @return la clave de tipo K
         */
        public K getClave() {
            return clave;
        }

        /**
         * Obtiene el valor del par.
         *
         * @return el valor de tipo V
         */
        public V getValor() {
            return valor;
        }

        @Override
        public String toString() {
            return "(" + clave + ", " + valor + ")";
        }
    }

    // ========================================================
    //  MÉTODO PRINCIPAL: demostración de genéricos
    // ========================================================

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     GENÉRICOS BÁSICOS EN JAVA            ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        // ---- EJEMPLO 1: Problema SIN genéricos ----
        System.out.println("── EJEMPLO 1: Problema SIN genéricos ──");

        CajaSinGenericos cajaVieja = new CajaSinGenericos();
        cajaVieja.setContenido("Hola Mundo");

        // ⚠ Necesitamos hacer casting manual (propenso a errores)
        String textoViejo = (String) cajaVieja.getContenido();
        System.out.println("Contenido (con casting): " + textoViejo);

        // Si alguien guarda un Integer pero hacemos casting a String...
        cajaVieja.setContenido(42);
        // La siguiente línea compilaría, pero lanzaría ClassCastException:
        // String error = (String) cajaVieja.getContenido(); // ¡ERROR en ejecución!
        System.out.println("⚠ Sin genéricos, el compilador NO detecta errores de tipo\n");

        // ---- EJEMPLO 2: Caja genérica con String ----
        System.out.println("── EJEMPLO 2: Caja<String> ──");

        Caja<String> cajaTexto = new Caja<>("¡Hola, Genéricos!");
        // No necesitamos casting, el tipo es seguro
        String texto = cajaTexto.getContenido();
        System.out.println("Contenido: " + texto);
        System.out.println("¿Tiene contenido? " + cajaTexto.tieneContenido());
        System.out.println();

        // ---- EJEMPLO 3: Caja genérica con Integer ----
        System.out.println("── EJEMPLO 3: Caja<Integer> ──");

        // Nota: usamos Integer, NO int (los genéricos no aceptan primitivos)
        Caja<Integer> cajaNumero = new Caja<>(42);
        Integer numero = cajaNumero.getContenido();
        System.out.println("Contenido: " + numero);

        // Autoboxing: Java convierte int a Integer automáticamente
        cajaNumero.setContenido(100);
        System.out.println("Nuevo contenido: " + cajaNumero.getContenido());
        System.out.println();

        // ---- EJEMPLO 4: Caja genérica con Double ----
        System.out.println("── EJEMPLO 4: Caja<Double> ──");

        Caja<Double> cajaDecimal = new Caja<>(3.14159);
        System.out.println("Contenido: " + cajaDecimal.getContenido());
        System.out.println();

        // ---- EJEMPLO 5: Caja genérica con tipo personalizado ----
        System.out.println("── EJEMPLO 5: Caja con tipo personalizado ──");

        // Podemos usar cualquier clase como argumento de tipo
        Caja<String[]> cajaArreglo = new Caja<>(new String[]{"Java", "Python", "C++"});
        String[] lenguajes = cajaArreglo.getContenido();
        System.out.print("Lenguajes: ");
        for (String lenguaje : lenguajes) {
            System.out.print(lenguaje + " ");
        }
        System.out.println("\n");

        // ---- EJEMPLO 6: Clase con dos parámetros de tipo ----
        System.out.println("── EJEMPLO 6: Clase Par<K, V> ──");

        Par<String, Integer> edadPersona = new Par<>("Carlos", 25);
        System.out.println("Par: " + edadPersona);
        System.out.println("Clave: " + edadPersona.getClave());
        System.out.println("Valor: " + edadPersona.getValor());
        System.out.println();

        Par<Integer, String> codigoError = new Par<>(404, "No encontrado");
        System.out.println("Código de error: " + codigoError);
        System.out.println();

        // ---- EJEMPLO 7: Operador diamante (<>) ----
        System.out.println("── EJEMPLO 7: Operador diamante ──");

        // Desde Java 7, no es necesario repetir el tipo en el lado derecho
        // Java infiere el tipo automáticamente
        Caja<String> cajaInferida = new Caja<>("Tipo inferido");  // ✓ Correcto
        // Caja<String> cajaCompleta = new Caja<String>("Completa"); // También válido, pero redundante
        System.out.println("Con diamante: " + cajaInferida);
        System.out.println();

        // ---- RESUMEN DE CONVENCIONES ----
        System.out.println("── CONVENCIONES DE PARÁMETROS DE TIPO ──");
        System.out.println("  T → Type (tipo general)");
        System.out.println("  E → Element (usado en colecciones)");
        System.out.println("  K → Key (clave en mapas)");
        System.out.println("  V → Value (valor en mapas)");
        System.out.println("  N → Number (tipo numérico)");
        System.out.println("  S, U → Segundo, tercer tipo adicional");

        System.out.println("\n✅ Los genéricos nos dan seguridad de tipos en compilación");
        System.out.println("✅ Eliminan la necesidad de casting manual");
        System.out.println("✅ Permiten escribir código reutilizable y limpio");
    }
}
