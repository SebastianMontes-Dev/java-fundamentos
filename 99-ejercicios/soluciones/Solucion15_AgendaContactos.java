import java.util.*;

class Contacto { String nombre, telefono, email; Contacto(String n, String t, String e) { nombre=n; telefono=t; email=e; } }

public class Solucion15_AgendaContactos {
    public static void main(String[] args) {
        ArrayList<Contacto> agenda = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n1.Agregar 2.Buscar 3.Listar 4.Eliminar 5.Salir");
            opcion = sc.nextInt(); sc.nextLine();
            switch (opcion) {
                case 1: System.out.print("Nombre: "); String n=sc.nextLine(); System.out.print("Telefono: "); String t=sc.nextLine(); System.out.print("Email: "); String e=sc.nextLine(); agenda.add(new Contacto(n,t,e)); break;
                case 2: System.out.print("Buscar: "); String buscar=sc.nextLine(); for(Contacto c:agenda) if(c.nombre.equalsIgnoreCase(buscar)) System.out.println(c.telefono+" | "+c.email); break;
                case 3: for(Contacto c:agenda) System.out.println(c.nombre+" | "+c.telefono+" | "+c.email); break;
                case 4: System.out.print("Eliminar: "); String elim=sc.nextLine(); agenda.removeIf(c->c.nombre.equalsIgnoreCase(elim)); break;
            }
        } while (opcion != 5);
        sc.close();
    }
}
