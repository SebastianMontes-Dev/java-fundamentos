import java.util.Scanner;

public class Solucion12_CifradoCesar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Texto: ");
        String texto = sc.nextLine();
        System.out.print("Desplazamiento: ");
        int n = sc.nextInt();
        StringBuilder cifrado = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (Character.isUpperCase(c)) {
                cifrado.append((char) ((c - 'A' + n) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                cifrado.append((char) ((c - 'a' + n) % 26 + 'a'));
            } else {
                cifrado.append(c);
            }
        }
        System.out.println("Cifrado: " + cifrado);
        sc.close();
    }
}
