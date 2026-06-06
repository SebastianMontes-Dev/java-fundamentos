/**
 * ============================================================
 *  TEMA: Herencia en Java
 *  SECCIÓN: 11 — Herencia y Polimorfismo
 *  ARCHIVO: HerenciaBasica.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La herencia es el mecanismo por el cual una clase (subclase) puede adquirir los
 *  atributos y métodos de otra clase (superclase) usando la palabra clave `extends`.
 *  Esto promueve la REUTILIZACIÓN de código y establece una relación "ES-UN" entre
 *  clases. Por ejemplo: un Perro ES-UN Animal, por lo que hereda sus características
 *  generales y puede agregar las suyas propias.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - extends: palabra clave que indica que una clase hereda de otra.
 *  - Superclase (padre): clase de la que se hereda.
 *  - Subclase (hija): clase que hereda y puede extender o especializar.
 *  - super: referencia al constructor o método de la clase padre.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  class Animal {
 *      void comer() { System.out.println("Comiendo..."); }
 *  }
 *  class Perro extends Animal {
 *      void ladrar() { System.out.println("Guau!"); }
 *  }
 *  Perro p = new Perro();
 *  p.comer();  // heredado de Animal
 *  p.ladrar(); // propio de Perro
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Java NO soporta herencia múltiple de clases (una clase solo puede extender UNA clase).
 *  - Olvidar que los constructores NO se heredan; deben definirse en cada subclase.
 *  - Intentar acceder a miembros `private` de la superclase desde la subclase (deben ser `protected`).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
 * ============================================================
 */
public class HerenciaBasica {

    public static void main(String[] args) {

        System.out.println("=== Herencia Básica en Java ===\n");

        // Creamos un objeto de la subclase Perro
        Perro miPerro = new Perro("Max", "Labrador");
        miPerro.comer();   // método heredado de Animal
        miPerro.dormir();  // método heredado de Animal
        miPerro.ladrar();  // método propio de Perro

        System.out.println();

        // Creamos un objeto de la subclase Gato
        Gato miGato = new Gato("Luna", "Gris");
        miGato.comer();    // método heredado de Animal
        miGato.maullar();  // método propio de Gato
    }
}

// Superclase (clase padre)
class Animal {
    String nombre;

    Animal(String nombre) {
        this.nombre = nombre;
    }

    void comer() {
        System.out.println(nombre + " está comiendo.");
    }

    void dormir() {
        System.out.println(nombre + " está durmiendo.");
    }
}

// Subclase Perro que hereda de Animal
class Perro extends Animal {
    String raza;

    Perro(String nombre, String raza) {
        super(nombre); // invoca el constructor de la clase padre (Animal)
        this.raza = raza;
    }

    void ladrar() {
        System.out.println(nombre + " (raza " + raza + ") dice: ¡Guau guau!");
    }
}

// Subclase Gato que hereda de Animal
class Gato extends Animal {
    String color;

    Gato(String nombre, String color) {
        super(nombre);
        this.color = color;
    }

    void maullar() {
        System.out.println(nombre + " (color " + color + ") dice: ¡Miau miau!");
    }
}
