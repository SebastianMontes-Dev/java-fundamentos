class SaldoInsuficienteException extends Exception { SaldoInsuficienteException(String msg) { super(msg); } }
abstract class Cuenta { protected String titular; protected double saldo; Cuenta(String t, double s) { titular=t; saldo=s; }
    void depositar(double m) { saldo+=m; System.out.println(titular+" deposito $"+m+" | Saldo: $"+saldo); }
    abstract void retirar(double m) throws SaldoInsuficienteException; }
class CuentaAhorro extends Cuenta { double tasa; CuentaAhorro(String t, double s, double ta) { super(t,s); tasa=ta; }
    void aplicarInteres() { saldo+=saldo*tasa; System.out.println("Interes aplicado: $"+saldo); }
    void retirar(double m) throws SaldoInsuficienteException { if(m>saldo) throw new SaldoInsuficienteException("Saldo insuficiente"); saldo-=m; System.out.println(titular+" retiro $"+m+" | Saldo: $"+saldo); } }
class CuentaCorriente extends Cuenta { double limite; CuentaCorriente(String t, double s, double l) { super(t,s); limite=l; }
    void retirar(double m) throws SaldoInsuficienteException { if(m>saldo+limite) throw new SaldoInsuficienteException("Excede limite de sobregiro"); saldo-=m; System.out.println(titular+" retiro $"+m+" | Saldo: $"+saldo); } }

public class Solucion19_SistemaBancario {
    public static void main(String[] args) throws Exception {
        CuentaAhorro ahorro = new CuentaAhorro("Ana", 1000, 0.05);
        CuentaCorriente corriente = new CuentaCorriente("Carlos", 500, 200);
        ahorro.depositar(200); ahorro.retirar(100); ahorro.aplicarInteres();
        corriente.retirar(600); try { corriente.retirar(200); } catch(SaldoInsuficienteException e) { System.out.println("ERROR: "+e.getMessage()); }
    }
}
