import java.util.*;

public class Solucion13_Romanos {
    public static void main(String[] args) {
        Map<Character, Integer> valores = Map.of(
            'I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000
        );
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero romano: ");
        String romano = sc.nextLine().toUpperCase();
        int total = 0;
        for (int i = 0; i < romano.length(); i++) {
            int actual = valores.get(romano.charAt(i));
            int siguiente = (i + 1 < romano.length()) ? valores.get(romano.charAt(i + 1)) : 0;
            total += (actual < siguiente) ? -actual : actual;
        }
        System.out.println(romano + " = " + total);
        sc.close();
    }
}
