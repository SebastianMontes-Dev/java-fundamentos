/**
 * ============================================================
 *  TEMA: Anotaciones Integradas de Java
 *  SECCIÓN: 31 — Anotaciones y Reflexión
 *  ARCHIVO: AnotacionesBasicas.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a utilizar las anotaciones integradas (built-in) de Java 
 *  como @Override, @Deprecated y @SuppressWarnings. Entenderás para qué 
 *  sirven, cómo ayudan a prevenir errores y cómo se comunican con el compilador.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Anotación: Metadatos añadidos al código que proveen información extra.
 *  - @Override: Indica que un método sobrescribe al de una clase padre.
 *  - @Deprecated: Marca un elemento como obsoleto y desaconseja su uso.
 *  - @SuppressWarnings: Le dice al compilador que ignore ciertas advertencias.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  @Override
 *  public void miMetodo() { ... }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar @Override en un método que realmente no sobrescribe nada (error de compilación).
 *  - Ignorar advertencias importantes usando @SuppressWarnings("all").
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/annotations/
 * ============================================================
 */

import java.util.ArrayList;
import java.util.List;

class Vehiculo {
    public void arrancar() {
        System.out.println("El vehículo está arrancando...");
    }

    /**
     * @deprecated Este método es viejo e inseguro. Usa {@link #arrancarSeguro()} en su lugar.
     */
    @Deprecated
    public void arrancarViejo() {
        System.out.println("Arrancando con un método antiguo...");
    }

    public void arrancarSeguro() {
        System.out.println("Arrancando de forma segura...");
    }
}

class Coche extends Vehiculo {
    
    // @Override le asegura al compilador que este método debe existir en la clase padre
    @Override
    public void arrancar() {
        System.out.println("El coche está arrancando con su motor V8...");
    }
}

public class AnotacionesBasicas {

    // Usamos SuppressWarnings para ignorar advertencias del compilador 
    // en este caso, "deprecation" para ocultar la advertencia por usar arrancarViejo()
    // y "rawtypes", "unchecked" para el uso de List sin tipos genéricos.
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO DE ANOTACIONES BÁSICAS ===");

        Coche miCoche = new Coche();
        
        // 1. Ejemplo de @Override
        System.out.println("\n1. Demostración de @Override:");
        miCoche.arrancar();

        // 2. Ejemplo de @Deprecated
        System.out.println("\n2. Demostración de @Deprecated:");
        // El compilador normalmente mostraría una advertencia aquí si no tuviéramos SuppressWarnings
        miCoche.arrancarViejo();

        // 3. Ejemplo de @SuppressWarnings
        System.out.println("\n3. Demostración de @SuppressWarnings:");
        List listaSinTipo = new ArrayList(); // Uso de Raw Type
        listaSinTipo.add("Un texto");
        System.out.println("Lista creada sin tipo genérico, ignorando advertencia: " + listaSinTipo.get(0));
    }
}
