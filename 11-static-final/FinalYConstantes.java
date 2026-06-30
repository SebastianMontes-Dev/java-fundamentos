/**
 * ============================================================
 *  TEMA: El Modificador final en Java
 *  SECCIÓN: 11 — Static y Final
 *  ARCHIVO: FinalYConstantes.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  `final` es el modificador de "esto no cambia". Tiene TRES usos distintos
 *  según dónde lo pongas: (1) en una VARIABLE, significa que no puede
 *  reasignarse después de inicializarse; (2) en un MÉTODO, significa que
 *  no puede ser sobrescrito por subclases; (3) en una CLASE, significa que
 *  no puede ser heredada.
 *
 *  La combinación `static final` crea CONSTANTES de clase — valores que
 *  pertenecen a la clase y nunca cambian, como Math.PI. Por convención,
 *  las constantes se escriben en MAYÚSCULAS_CON_GUIONES_BAJOS.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - final en variable: no se puede reasignar (pero el objeto sí puede mutar).
 *  - final en parámetro: garantiza que el método no modifica la referencia.
 *  - final en método: previene la sobrescritura (@Override).
 *  - final en clase: previene la herencia (ej: String es final).
 *  - static final: CONSTANTE de clase. Siempre en MAYÚSCULAS.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  final int MAX_INTENTOS = 3;
 *  public static final double IVA = 0.16;
 *  public final void metodoSeguro() { ... }
 *  public final class ClaseSellada { ... }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir "no reasignable" con "inmutable": `final List<String> lista`
 *    no impide agregar elementos a la lista, solo impide reasignar la variable.
 *  - Olvidar static en constantes de clase (cada instancia tendría su copia).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/IandI/final.html
 * ============================================================
 */
public class FinalYConstantes {
    // Constante de clase
    public static final double IVA = 0.16;
    public static final String NOMBRE_APP = "MiAplicacion";
    public static final int MAX_USUARIOS = 1000;

    public static void main(String[] args) {
        System.out.println("=== final: Variables, Métodos y Clases ===");
        System.out.println();

        // --- FINAL EN VARIABLES ---
        System.out.println("--- 1. Variables final ---");

        final int MAX_INTENTOS = 3;
        System.out.println("MAX_INTENTOS = " + MAX_INTENTOS);
        // MAX_INTENTOS = 5;  // ERROR: no se puede reasignar una variable final

        // Una variable final puede inicializarse después (blank final)
        final int valorCalculado;
        if (MAX_INTENTOS > 2) {
            valorCalculado = 100;
        } else {
            valorCalculado = 50;
        }
        System.out.println("Blank final inicializado = " + valorCalculado);
        System.out.println();

        // --- STATIC FINAL (CONSTANTES) ---
        System.out.println("--- 2. Constantes de Clase (static final) ---");
        System.out.println("IVA = " + IVA);
        System.out.println("App  = " + NOMBRE_APP);
        System.out.println("Max usuarios = " + MAX_USUARIOS);

        double precio = 100;
        double precioConIVA = precio * (1 + IVA);
        System.out.println("Precio con IVA: $" + precioConIVA);
        System.out.println("(Las constantes se escriben en MAYÚSCULAS_CON_GUIONES)");
        System.out.println();

        // --- FINAL EN OBJETOS ---
        System.out.println("--- 3. final con Objetos ---");

        final StringBuilder sb = new StringBuilder("Hola");
        System.out.println("Antes: " + sb);
        sb.append(" Mundo");   // El CONTENIDO sí puede cambiar
        System.out.println("Después de append: " + sb);
        // sb = new StringBuilder("Otro");  // ERROR: la REFERENCIA no puede cambiar
        System.out.println("(final impide reasignar la variable, NO modificar el objeto)");
        System.out.println();

        // --- FINAL EN PARÁMETROS ---
        System.out.println("--- 4. Parámetros final ---");
        imprimirMensaje("Este parámetro no se reasigna dentro del método");
        System.out.println();

        // --- FINAL EN MÉTODOS ---
        System.out.println("--- 5. Métodos final (no sobrescribibles) ---");
        Animal a = new Perro();
        a.hacerSonido();       // Método heredado normal
        a.respirar();          // Método final: no puede ser sobrescrito
        System.out.println();

        // --- FINAL EN CLASES ---
        System.out.println("--- 6. Clases final (no heredables) ---");
        ClaseFinal cf = new ClaseFinal();
        System.out.println(cf);
        System.out.println("(String, Integer, Math son clases final. No puedes extenderlas)");
    }

    public static void imprimirMensaje(final String mensaje) {
        // mensaje = "otro";  // ERROR: parámetro final no se puede reasignar
        System.out.println("Mensaje: " + mensaje);
    }
}

// Demo de método final
class Animal {
    public void hacerSonido() {
        System.out.println("  Animal hace sonido");
    }

    public final void respirar() {
        System.out.println("  Animal respira (método final: ninguna subclase puede cambiarlo)");
    }
}

class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("  Perro ladra (sobrescrito OK)");
    }

    // @Override
    // public void respirar() { }  // ERROR: no se puede sobrescribir un método final
}

// Clase final: no se puede heredar
final class ClaseFinal {
    @Override
    public String toString() {
        return "  Soy una clase final. Nadie puede heredarme.";
    }
}

// class SubClase extends ClaseFinal { }  // ERROR: no se puede heredar una clase final
