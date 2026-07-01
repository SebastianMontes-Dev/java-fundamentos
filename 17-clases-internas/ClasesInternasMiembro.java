/**
 * ============================================================
 *  TEMA: Clases Internas de Miembro (Member Inner Classes)
 *  SECCIÓN: 17 — Clases Internas
 *  ARCHIVO: ClasesInternasMiembro.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Una inner class (clase interna de miembro) se define sin `static` y
 *  tiene acceso TOTAL a los atributos de la instancia externa, incluso
 *  los privados. Esto es posible porque cada inner class contiene una
 *  referencia implícita al objeto externo que la creó, accesible con
 *  `Outer.this`. Son perfectas para implementar iteradores, listeners
 *  de eventos, o cualquier lógica que necesite manipular el estado
 *  interno de otra clase sin exponerlo al mundo.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Se declara sin `static`: `class Inner { }`.
 *  - Tiene acceso a TODOS los miembros del outer, incluso private.
 *  - Outer.this: referencia al objeto externo que contiene esta inner.
 *  - Se instancia con `outer.new Inner()` (necesitas una instancia del outer).
 *  - No puede tener miembros static (excepto constantes static final).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  class Externa {
 *      private int dato = 42;
 *      class Interna {
 *          void acceder() { System.out.println(dato); } // acceso directo
 *      }
 *  }
 *  Externa e = new Externa();
 *  Externa.Interna i = e.new Interna();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Intentar `new Outer.Inner()` sin instancia del outer (necesitas outer.new).
 *  - Olvidar que la inner mantiene una referencia al outer (memory leak si el outer
 *    debería ser garbage-collected).
 *  - Declarar campos static en una inner class (solo permitidos si son final).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/innerclasses.html
 * ============================================================
 */
public class ClasesInternasMiembro {

    public static void main(String[] args) {
        System.out.println("=== Clases Internas de Miembro ===");
        System.out.println();

        // --- ITERADOR PERSONALIZADO ---
        System.out.println("--- Iterador personalizado con inner class ---");

        ColeccionSimple frutas = new ColeccionSimple(3);
        frutas.agregar("Manzana");
        frutas.agregar("Banana");
        frutas.agregar("Naranja");

        ColeccionSimple.Iterador iter = frutas.iterador();
        int idx = 0;
        while (iter.tieneSiguiente()) {
            System.out.println("  Elemento " + idx + ": " + iter.siguiente());
            idx++;
        }
        System.out.println();

        // --- DEMOSTRACIÓN DE ACCESO A PRIVADOS ---
        System.out.println("--- Acceso a atributos privados del outer ---");

        Banco cuenta = new Banco("Sebastián", 1000.0);

        // La inner class puede modificar el saldo privado
        Banco.Transaccion trans = cuenta.new Transaccion();
        trans.depositar(500.0);
        trans.retirar(200.0);
        trans.mostrarSaldo();

        System.out.println();
        System.out.println("(La inner class Transaccion accede al saldo PRIVADO");
        System.out.println(" de Banco sin getters ni setters públicos)");
    }
}

// Colección simple con iterador como inner class
class ColeccionSimple {
    private String[] elementos;
    private int cantidad;

    public ColeccionSimple(int capacidad) {
        elementos = new String[capacidad];
        cantidad = 0;
    }

    public void agregar(String elemento) {
        if (cantidad < elementos.length) {
            elementos[cantidad++] = elemento;
        }
    }

    // Inner class: tiene acceso a `elementos` y `cantidad` privados
    class Iterador {
        private int indice = 0;

        public boolean tieneSiguiente() {
            return indice < cantidad;
        }

        public String siguiente() {
            return elementos[indice++]; // Acceso directo a elemento privado
        }
    }

    public Iterador iterador() {
        return new Iterador();
    }
}

// Banco con transacciones como inner class
class Banco {
    private String titular;
    private double saldo; // ATRIBUTO PRIVADO

    public Banco(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Inner class: accede y modifica `saldo` directamente
    class Transaccion {
        public void depositar(double monto) {
            saldo += monto; // Acceso directo a atributo PRIVADO del outer
            System.out.println("  Depósito: $" + monto + " → Saldo: $" + saldo);
        }

        public void retirar(double monto) {
            if (monto <= saldo) {
                saldo -= monto;
                System.out.println("  Retiro: $" + monto + " → Saldo: $" + saldo);
            }
        }

        public void mostrarSaldo() {
            // Outer.this referencia al objeto Banco que contiene esta transacción
            System.out.println("  Titular: " + Banco.this.titular);
            System.out.println("  Saldo final: $" + saldo);
        }
    }
}
