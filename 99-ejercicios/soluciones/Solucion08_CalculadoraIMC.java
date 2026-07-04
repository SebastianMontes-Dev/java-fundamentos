import java.util.Scanner;

public class Solucion08_CalculadoraIMC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Peso (kg): ");
        double peso = sc.nextDouble();
        System.out.print("Altura (m): ");
        double altura = sc.nextDouble();
        double imc = peso / (altura * altura);
        String categoria;
        if (imc < 18.5) categoria = "Bajo peso";
        else if (imc < 25) categoria = "Normal";
        else if (imc < 30) categoria = "Sobrepeso";
        else categoria = "Obesidad";
        System.out.printf("IMC: %.1f — %s%n", imc, categoria);
        sc.close();
    }
}
