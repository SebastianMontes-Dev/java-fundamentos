import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Solucion22_BuscadorArchivos {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Directorio: "); String dir = sc.nextLine();
        System.out.print("Extension (ej .java): "); String ext = sc.nextLine();
        Files.walk(Paths.get(dir)).filter(p -> p.toString().endsWith(ext)).forEach(p -> {
            try { System.out.println(p.toAbsolutePath() + " (" + Files.size(p) + " bytes)"); }
            catch (IOException e) { System.out.println("Error: " + p); }
        });
        sc.close();
    }
}
