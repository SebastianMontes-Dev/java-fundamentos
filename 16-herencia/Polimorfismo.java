/**
 * ============================================================
 *  TEMA: Polimorfismo en Java
 *  SECCIÓN: 16 — Herencia y Polimorfismo
 *  ARCHIVO: Polimorfismo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  El polimorfismo (muchas formas) permite tratar objetos de diferentes subclases
 *  como si fueran de la superclase, pero ejecutando el comportamiento específico
 *  de cada uno. Una variable de tipo `Animal` puede contener un `Perro`, un `Gato`
 *  o un `Pajaro`, y al invocar un método sobrescrito se ejecutará la versión
 *  correcta automáticamente. Es la base del principio "programar para interfaces,
 *  no para implementaciones".
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Variable de tipo superclase que referencia objeto de subclase.
 *  - Enlace dinámico (dynamic binding): Java decide en TIEMPO DE EJECUCIÓN qué método llamar.
 *  - instanceof: operador que verifica si un objeto es de un tipo específico.
 *  - Colecciones polimórficas: arreglos/listas del tipo padre que contienen hijos variados.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Animal a = new Perro();  // variable tipo Animal, objeto tipo Perro
 *  a.hacerSonido();          // ejecuta el método de Perro, no el de Animal
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Intentar invocar métodos específicos de la subclase desde una variable del tipo padre
 *    sin hacer casting: `Animal a = new Perro(); a.ladrar();` NO compila.
 *  - Hacer casting incorrecto: `(Gato) objetoPerro` causa ClassCastException.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html
 * ============================================================
 */
public class Polimorfismo {

    public static void main(String[] args) {

        System.out.println("=== Polimorfismo en Java ===\n");

        // Arreglo polimórfico: contiene diferentes tipos de Figura
        // La variable es de tipo Figura, pero cada elemento es una subclase distinta
        Figura[] figuras = new Figura[3];
        figuras[0] = new Circulo(5.0);
        figuras[1] = new Rectangulo(4.0, 6.0);
        figuras[2] = new Triangulo(3.0, 8.0);

        // Recorremos el arreglo: cada objeto ejecuta su PROPIA versión de calcularArea()
        for (Figura figura : figuras) {
            // Enlace dinámico: Java decide en tiempo de ejecución qué método llamar
            figura.calcularArea();

            // Podemos identificar el tipo real con instanceof
            if (figura instanceof Circulo) {
                System.out.println("  -> Esta figura es un Círculo");
            } else if (figura instanceof Rectangulo) {
                System.out.println("  -> Esta figura es un Rectángulo");
            } else if (figura instanceof Triangulo) {
                System.out.println("  -> Esta figura es un Triángulo");
            }
            System.out.println();
        }
    }
}

// Superclase abstracta (no se puede instanciar directamente)
abstract class Figura {

    // Método abstracto: las subclases DEBEN implementarlo
    abstract void calcularArea();
}

class Circulo extends Figura {
    double radio;

    Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    void calcularArea() {
        double area = Math.PI * radio * radio;
        System.out.printf("Área del círculo (radio %.1f): %.2f%n", radio, area);
    }
}

class Rectangulo extends Figura {
    double base, altura;

    Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    void calcularArea() {
        double area = base * altura;
        System.out.printf("Área del rectángulo (%.1f x %.1f): %.2f%n", base, altura, area);
    }
}

class Triangulo extends Figura {
    double base, altura;

    Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    void calcularArea() {
        double area = (base * altura) / 2;
        System.out.printf("Área del triángulo (%.1f x %.1f): %.2f%n", base, altura, area);
    }
}
