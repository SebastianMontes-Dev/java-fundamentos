import java.util.Scanner;

public class Solucion11_ValidadorPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa una contrasena: ");
        String pass = sc.nextLine();
        boolean largo = pass.length() >= 8, mayus = false, minus = false, digito = false, especial = false;
        for (char c : pass.toCharArray()) {
            if (Character.isUpperCase(c)) mayus = true;
            else if (Character.isLowerCase(c)) minus = true;
            else if (Character.isDigit(c)) digito = true;
            else especial = true;
        }
        if (largo && mayus && minus && digito && especial)
            System.out.println("Contrasena valida");
        else {
            System.out.println("Contrasena INVALIDA. Faltan:");
            if (!largo) System.out.println(" - Minimo 8 caracteres");
            if (!mayus) System.out.println(" - Al menos una mayuscula");
            if (!minus) System.out.println(" - Al menos una minuscula");
            if (!digito) System.out.println(" - Al menos un digito");
            if (!especial) System.out.println(" - Al menos un caracter especial");
        }
        sc.close();
    }
}
