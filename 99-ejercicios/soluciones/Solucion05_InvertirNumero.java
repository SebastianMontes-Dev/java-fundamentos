import java.util.Scanner;

public class Solucion05_InvertirNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa un numero positivo: ");
        int n = sc.nextInt(), invertido = 0;
        while (n > 0) {
            invertido = invertido * 10 + n % 10;
            n /= 10;
        }
        System.out.println("Invertido: " + invertido);
        sc.close();
    }
}
