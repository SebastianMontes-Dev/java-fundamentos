/**
 * ============================================================
 *  TEMA: Interfaces en Java
 *  SECCIÓN: 11 — Herencia y Polimorfismo
 *  ARCHIVO: Interfaces.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Una interfaz es un CONTRATO que define QUÉ métodos debe implementar una clase,
 *  pero no CÓMO debe hacerlo. Se declara con `interface` en vez de `class` y
 *  las clases la adoptan con `implements`. A diferencia de la herencia, una clase
 *  puede implementar MÚLTIPLES interfaces, lo que resuelve la limitación de la
 *  herencia simple de Java. Es el pilar del diseño por contrato y la inyección
 *  de dependencias.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - interface: define la firma de métodos sin implementación (contrato).
 *  - implements: palabra clave con la que una clase adopta una interfaz.
 *  - Múltiples interfaces: una clase puede implementar varias interfaces.
 *  - Métodos default (Java 8+): pueden tener implementación en la interfaz.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  interface Volador {
 *      void volar(); // método abstracto implícitamente
 *  }
 *  class Ave implements Volador {
 *      public void volar() { System.out.println("Volando..."); }
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar implementar TODOS los métodos de la interfaz (la clase debe ser abstracta si no).
 *  - No declarar los métodos como `public` en la clase que implementa (no compila).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/IandI/interfaceDef.html
 * ============================================================
 */
public class Interfaces {

    public static void main(String[] args) {

        System.out.println("=== Interfaces en Java ===\n");

        // Creamos objetos de clases que implementan diferentes interfaces
        Pajaro pajaro = new Pajaro("Colibrí");
        Avion avion = new Avion("Boeing 747");
        Pez pez = new Pez("Salmón");

        // Todos implementan Volador (contrato común)
        System.out.println("--- Demostración de la interfaz Volador ---");
        hacerVolar(pajaro);  // polimorfismo con interfaces
        hacerVolar(avion);

        System.out.println("\n--- Demostración de la interfaz Nadador ---");
        hacerNadar(pez);     // solo Pez implementa Nadador

        // ERROR de compilación si se descomenta: Pajaro NO implementa Nadador
        // hacerNadar(pajaro);  // incompatible types: Pajaro cannot be converted to Nadador

        System.out.println("\n--- Un objeto puede implementar MÚLTIPLES interfaces ---");
        Pato pato = new Pato("Donald");
        hacerVolar(pato);  // Pato implementa Volador
        hacerNadar(pato);  // Pato también implementa Nadador
    }

    // Método polimórfico: recibe CUALQUIER objeto que implemente Volador
    static void hacerVolar(Volador v) {
        v.volar();
    }

    // Método polimórfico: recibe CUALQUIER objeto que implemente Nadador
    static void hacerNadar(Nadador n) {
        n.nadar();
    }
}

// Interfaz: define el contrato "todo lo que vuela debe implementar volar()"
interface Volador {
    void volar(); // implícitamente public abstract
}

// Interfaz: define el contrato "todo lo que nada debe implementar nadar()"
interface Nadador {
    void nadar();
}

class Pajaro implements Volador {
    String nombre;

    Pajaro(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void volar() {
        System.out.println(nombre + " (pájaro): Batiendo alas para volar.");
    }
}

class Avion implements Volador {
    String modelo;

    Avion(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void volar() {
        System.out.println(modelo + " (avión): Encendiendo turbinas para despegar.");
    }
}

class Pez implements Nadador {
    String nombre;

    Pez(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void nadar() {
        System.out.println(nombre + " (pez): Moviendo aletas para nadar.");
    }
}

// Esta clase implementa DOS interfaces: puede volar Y nadar
class Pato implements Volador, Nadador {
    String nombre;

    Pato(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void volar() {
        System.out.println(nombre + " (pato): ¡Volando hacia el sur!");
    }

    @Override
    public void nadar() {
        System.out.println(nombre + " (pato): ¡Nadando en el estanque!");
    }
}
