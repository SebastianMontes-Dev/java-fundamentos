import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.System.out;

/**
 * ============================================================
 *  TEMA: Bloques Static e Import Static
 *  SECCIÓN: 11 — Static y Final
 *  ARCHIVO: StaticBloquesImport.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  A veces necesitas ejecutar código de inicialización ANTES de que se
 *  cree cualquier objeto, por ejemplo para cargar configuraciones o
 *  inicializar pools de conexiones. Los BLOQUES STATIC hacen exactamente
 *  eso: se ejecutan UNA SOLA VEZ cuando la clase se carga en memoria,
 *  antes que cualquier constructor.
 *
 *  El import static permite importar miembros static de una clase para
 *  usarlos sin prefijo: en vez de `Math.PI` simplemente `PI`. Cómodo
 *  para constantes y métodos muy usados, pero puede hacer el código
 *  menos legible si abusas. Úsalo con moderación.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Bloque static { }: se ejecuta cuando la clase se carga.
 *  - Orden: bloques static → constructor → resto del código.
 *  - import static: importa miembros static individuales.
 *  - NO abuses: oscurece la procedencia de los métodos.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  import static java.lang.Math.PI;
 *  double area = PI * radio * radio;
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Lanzar excepciones checked en un bloque static.
 *  - Abusar de import static * (ilegible en proyectos grandes).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
 * ============================================================
 */
public class StaticBloquesImport {

    // Bloque static: se ejecuta al cargar la clase
    static {
        out.println("[BLOQUE STATIC] La clase StaticBloquesImport se ha cargado en memoria");
        out.println("[BLOQUE STATIC] Ideal para inicializar configuraciones, pools de conexiones, etc.");
    }

    public static void main(String[] args) {
        out.println("=== Bloques Static e Import Static ===");
        out.println();

        // --- IMPORT STATIC ---
        out.println("--- Import Static: Usando Math sin el prefijo ---");

        double radio = 5.0;

        // Sin import static: Math.PI, Math.pow, Math.sqrt
        // Con import static: PI, pow, sqrt (directamente)
        double area = PI * pow(radio, 2);
        double perimetro = 2 * PI * radio;
        double hipotenusa = sqrt(pow(3, 2) + pow(4, 2));

        out.println("Área del círculo (radio=5): " + area);
        out.println("Perímetro del círculo: " + perimetro);
        out.println("Hipotenusa (catetos 3 y 4): " + hipotenusa);
        out.println("(Gracias a import static, escribimos PI en vez de Math.PI)");
        out.println();

        // --- BLOQUE STATIC EN ACCIÓN ---
        out.println("--- Orden de Inicialización ---");

        Configuracion c1 = new Configuracion("App1");
        Configuracion c2 = new Configuracion("App2");

        out.println("URL de BD: " + Configuracion.URL_BASE_DATOS);
    }
}

class Configuracion {
    static String URL_BASE_DATOS;
    static int contadorInstancias;

    // Bloque static: se ejecuta UNA SOLA VEZ cuando la clase se carga
    static {
        out.println("  [static] Cargando configuración del sistema...");
        URL_BASE_DATOS = "jdbc:postgresql://localhost:5432/mi_app";
        out.println("  [static] URL_BASE_DATOS inicializada: " + URL_BASE_DATOS);
    }

    private String nombreApp;

    public Configuracion(String nombreApp) {
        this.nombreApp = nombreApp;
        contadorInstancias++;
        out.println("  [constructor] App creada: " + nombreApp + " (instancia #" + contadorInstancias + ")");
    }
}
