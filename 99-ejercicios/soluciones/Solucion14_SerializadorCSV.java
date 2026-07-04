import java.io.FileWriter;
import java.util.*;

class Persona {
    String nombre, email;
    int edad;
    Persona(String n, String e, int ed) { nombre = n; email = e; edad = ed; }
    String toCsv() { return nombre + "," + email + "," + edad; }
}

public class Solucion14_SerializadorCSV {
    public static void main(String[] args) throws Exception {
        List<Persona> personas = Arrays.asList(
            new Persona("Ana", "ana@mail.com", 25),
            new Persona("Carlos", "carlos@mail.com", 30),
            new Persona("Maria", "maria@mail.com", 22),
            new Persona("Pedro", "pedro@mail.com", 28),
            new Persona("Lucia", "lucia@mail.com", 35)
        );
        StringBuilder csv = new StringBuilder("Nombre,Email,Edad\n");
        for (Persona p : personas) csv.append(p.toCsv()).append("\n");
        try (FileWriter fw = new FileWriter("personas.csv")) { fw.write(csv.toString()); }
        System.out.println("Archivo personas.csv generado:\n" + csv);
    }
}
