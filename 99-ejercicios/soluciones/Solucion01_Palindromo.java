import java.util.Scanner;

public class Solucion01_Palindromo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa una palabra: ");
        String palabra = sc.nextLine().toLowerCase().replace(" ", "");
        boolean esPalindromo = true;
        for (int i = 0; i < palabra.length() / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(palabra.length() - 1 - i)) {
                esPalindromo = false;
                break;
            }
        }
        System.out.println(esPalindromo ? "Es palindromo" : "NO es palindromo");
        sc.close();
    }
}
