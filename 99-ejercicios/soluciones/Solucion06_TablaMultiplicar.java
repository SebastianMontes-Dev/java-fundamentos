import java.util.Scanner;

public class Solucion06_TablaMultiplicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa un numero: ");
        int n = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %2d = %3d%n", n, i, n * i);
        }
        sc.close();
    }
}
