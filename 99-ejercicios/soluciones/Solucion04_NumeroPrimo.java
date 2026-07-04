import java.util.Scanner;

public class Solucion04_NumeroPrimo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa un numero: ");
        int n = sc.nextInt();
        boolean esPrimo = n > 1;
        for (int i = 2; i <= Math.sqrt(n) && esPrimo; i++) {
            if (n % i == 0) esPrimo = false;
        }
        System.out.println(n + (esPrimo ? " es primo" : " NO es primo"));
        sc.close();
    }
}
