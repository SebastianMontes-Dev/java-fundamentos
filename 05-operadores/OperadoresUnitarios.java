/**
 * Demostración de los operadores unitarios (unarios) en Java.
 *
 * Operadores cubiertos:
 *   +a  → signo positivo: confirma el valor (no modifica nada)
 *   -a  → negación aritmética: invierte el signo del valor
 *   ++a → pre-incremento: incrementa a en 1 y luego asigna el nuevo valor
 *   --a → pre-decremento: decrementa a en 1 y luego asigna el nuevo valor
 *   a++ → post-incremento: asigna el valor actual y luego incrementa a en 1
 *   a-- → post-decremento: asigna el valor actual y luego decrementa a en 1
 *
 * Diferencia clave entre pre y post:
 *   - Pre  (++a / --a): el cambio ocurre ANTES de usar el valor en la expresión.
 *   - Post (a++ / a--): el cambio ocurre DESPUÉS de usar el valor en la expresión.
 */
public class OperadoresUnitarios {

    public static void main(String[] args) {
        int a;
        int resultado;

        System.out.println("=== Operadores Unitarios ===");
        System.out.println("Valor base: a = 6");
        System.out.println();

        // Signo positivo: devuelve el valor sin modificarlo
        a = 6;
        resultado = +a;
        System.out.println("+a           → resultado = " + resultado + ", a = " + a);

        // Negación: invierte el signo del valor
        a = 6;
        resultado = -a;
        System.out.println("-a           → resultado = " + resultado + ", a = " + a);

        // Pre-incremento: a pasa a 7, resultado recibe 7
        a = 6;
        resultado = ++a;
        System.out.println("resultado = ++a → resultado = " + resultado + ", a = " + a);

        // Pre-decremento: a pasa a 5, resultado recibe 5
        a = 6;
        resultado = --a;
        System.out.println("resultado = --a → resultado = " + resultado + ", a = " + a);

        // Post-incremento: resultado recibe 6 (valor actual), luego a pasa a 7
        a = 6;
        resultado = a++;
        System.out.println("resultado = a++ → resultado = " + resultado + ", a = " + a);

        // Post-decremento: resultado recibe 6 (valor actual), luego a pasa a 5
        a = 6;
        resultado = a--;
        System.out.println("resultado = a-- → resultado = " + resultado + ", a = " + a);
    }
}
