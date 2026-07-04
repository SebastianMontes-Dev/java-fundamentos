import java.util.Scanner;

public class Solucion03_ContadorVocales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa una frase: ");
        String frase = sc.nextLine().toLowerCase();
        int contador = 0;
        for (char c : frase.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) contador++;
        }
        System.out.println("Vocales: " + contador);
        sc.close();
    }
}
