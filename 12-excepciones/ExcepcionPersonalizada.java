/**
 * ============================================================
 *  TEMA: Manejo de Excepciones en Java
 *  SECCIÓN: 12 — Excepciones
 *  ARCHIVO: ExcepcionPersonalizada.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Java permite crear tus PROPIAS excepciones extendiendo `Exception` (excepciones
 *  verificadas) o `RuntimeException` (no verificadas). Esto te da la capacidad de
 *  representar errores específicos de tu dominio de negocio y lanzarlos con `throw`
 *  cuando se violan reglas de negocio. Es una práctica profesional que hace tu
 *  código más expresivo y mantenible.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - throw: lanza una excepción (seguido de una instancia de Exception).
 *  - throws: declara que un método PUEDE lanzar una excepción (en la firma).
 *  - Excepción personalizada: clase que extiende Exception o RuntimeException.
 *  - Excepciones verificadas vs no verificadas: checked (obliga a manejar) / unchecked.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  class SaldoInsuficienteException extends Exception {
 *      public SaldoInsuficienteException(String msg) { super(msg); }
 *  }
 *  throw new SaldoInsuficienteException("Fondos insuficientes");
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir `throw` (lanzar excepción) con `throws` (declarar que puede lanzar).
 *  - Crear excepciones sin mensaje descriptivo.
 *  - Usar excepciones para control de flujo normal (son para situaciones excepcionales).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/essential/exceptions/creating.html
 * ============================================================
 */
public class ExcepcionPersonalizada {

    public static void main(String[] args) {

        System.out.println("=== Excepciones Personalizadas en Java ===\n");

        Cuenta cuenta = new Cuenta("ES001", 500.00);
        System.out.println("Cuenta: " + cuenta.getNumero());
        System.out.printf("Saldo inicial: $%.2f%n%n", cuenta.getSaldo());

        // Intentamos retirar una cantidad válida
        try {
            System.out.println("Intentando retirar $200.00...");
            cuenta.retirar(200.00);
            System.out.printf("Retiro exitoso. Saldo actual: $%.2f%n", cuenta.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println();

        // Intentamos retirar más de lo que hay → lanza nuestra excepción personalizada
        try {
            System.out.println("Intentando retirar $1000.00...");
            cuenta.retirar(1000.00);
        } catch (SaldoInsuficienteException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.printf("Saldo disponible: $%.2f — fondos insuficientes.%n", cuenta.getSaldo());
        }

        System.out.println("\nPrograma finalizado. La cuenta no quedó en negativo.");
    }
}

/**
 * Excepción personalizada: representa el error de negocio "saldo insuficiente".
 * Extiende Exception → es una excepción VERIFICADA (checked).
 */
class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String mensaje) {
        super(mensaje); // pasa el mensaje a la clase padre Exception
    }
}

class Cuenta {
    private String numero;
    private double saldo;

    public Cuenta(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * Retira dinero de la cuenta.
     * Si el monto supera el saldo, lanza una excepción personalizada.
     *
     * @throws SaldoInsuficienteException si el monto a retirar es mayor al saldo
     */
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            // throw lanza una NUEVA instancia de nuestra excepción personalizada
            throw new SaldoInsuficienteException(
                    "No se puede retirar $" + monto + ". Saldo disponible: $" + saldo);
        }
        saldo -= monto;
    }
}
