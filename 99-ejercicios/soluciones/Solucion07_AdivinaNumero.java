import java.util.Random;
import java.util.Scanner;

public class Solucion07_AdivinaNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int secreto = rand.nextInt(100) + 1, intento, intentos = 0;
        System.out.println("Adivina el numero entre 1 y 100");
        do {
            System.out.print("Tu intento: ");
            intento = sc.nextInt();
            intentos++;
            if (intento < secreto) System.out.println("Mas alto");
            else if (intento > secreto) System.out.println("Mas bajo");
        } while (intento != secreto);
        System.out.println("Correcto en " + intentos + " intentos");
        sc.close();
    }
}
