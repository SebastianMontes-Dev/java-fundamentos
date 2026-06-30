/**
 * ============================================================
 *  TEMA: Herencia en Java — Sobrescritura de Métodos
 *  SECCIÓN: 16 — Herencia y Polimorfismo
 *  ARCHIVO: SobrescrituraMetodos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La sobrescritura (@Override) permite que una subclase proporcione su propia
 *  implementación de un método que ya existe en la superclase. La anotación
 *  `@Override` le dice al compilador "estoy sobrescribiendo un método del padre,
 *  avísame si me equivoco en la firma". Es fundamental para el polimorfismo
 *  y para especializar comportamientos heredados.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - @Override: anotación que verifica que el método realmente sobrescribe uno del padre.
 *  - Misma firma: el método debe tener el mismo nombre, parámetros y tipo de retorno.
 *  - super.metodo(): invoca la versión original del método en la clase padre.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  @Override
 *  void hacerSonido() {
 *      System.out.println("Sonido específico de la subclase");
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Cambiar accidentalmente el nombre o parámetros y creer que se está sobrescribiendo.
 *  - Olvidar @Override: no es obligatorio pero sí una buena práctica que evita errores.
 *  - Reducir la visibilidad del método (ej: de public a private) — no está permitido.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/IandI/override.html
 * ============================================================
 */
public class SobrescrituraMetodos {

    public static void main(String[] args) {

        System.out.println("=== Sobrescritura de Métodos (@Override) ===\n");

        Vehiculo generico = new Vehiculo("Vehículo genérico");
        generico.arrancar();
        generico.detener();

        System.out.println();

        // Coche sobrescribe arrancar() con un comportamiento específico
        Coche miCoche = new Coche("Toyota Corolla", 4);
        miCoche.arrancar(); // usa la versión sobrescrita de Coche
        miCoche.detener();  // usa la versión heredada de Vehiculo

        System.out.println();

        // Moto sobrescribe arrancar() con otro comportamiento
        Moto miMoto = new Moto("Harley Davidson", true);
        miMoto.arrancar();  // usa la versión sobrescrita de Moto
    }
}

class Vehiculo {
    String modelo;

    Vehiculo(String modelo) {
        this.modelo = modelo;
    }

    void arrancar() {
        System.out.println(modelo + ": Arrancando de forma genérica...");
    }

    void detener() {
        System.out.println(modelo + ": Deteniendo el vehículo.");
    }
}

class Coche extends Vehiculo {
    int numPuertas;

    Coche(String modelo, int numPuertas) {
        super(modelo);
        this.numPuertas = numPuertas;
    }

    @Override // Indica que estamos sobrescribiendo el método de Vehiculo
    void arrancar() {
        System.out.println(modelo + " (" + numPuertas + " puertas): Girando llave... ¡Motor encendido!");
    }
}

class Moto extends Vehiculo {
    boolean tieneSidecar;

    Moto(String modelo, boolean tieneSidecar) {
        super(modelo);
        this.tieneSidecar = tieneSidecar;
    }

    @Override
    void arrancar() {
        String extra = tieneSidecar ? "con sidecar" : "sin sidecar";
        System.out.println(modelo + " (" + extra + "): Pateando el arranque... ¡Brum brum!");
    }
}
