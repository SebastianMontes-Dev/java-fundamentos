import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME) @interface Columna { String nombre(); }
@Retention(RetentionPolicy.RUNTIME) @interface Tabla { String nombre(); }
@Tabla(nombre="usuarios")
class Usuario { @Columna(nombre="id") Long id; @Columna(nombre="nombre") String nombre; @Columna(nombre="email") String email;
    Usuario(){}
    Usuario(Long i, String n, String e) { id=i; nombre=n; email=e; }
    public String toString() { return id+": "+nombre+" <"+email+">"; }
}

public class Solucion24_MiniORM {
    static Connection conn;
    public static void main(String[] args) throws Exception {
        conn = DriverManager.getConnection("jdbc:sqlite::memory:");
        conn.createStatement().execute("CREATE TABLE usuarios (id INTEGER PRIMARY KEY, nombre TEXT, email TEXT)");
        guardar(new Usuario(1L, "Ana", "ana@mail.com"));
        guardar(new Usuario(2L, "Carlos", "carlos@mail.com"));
        System.out.println("Buscar ID 1: "+buscarPorId(Usuario.class, 1L));
        System.out.println("Todos: "+listarTodos(Usuario.class));
        conn.close();
    }
    static <T> void guardar(T ent) throws Exception {
        Class<?> c = ent.getClass(); String tabla = c.getAnnotation(Tabla.class).nombre();
        StringBuilder cols=new StringBuilder(), vals=new StringBuilder();
        for(Field f:c.getDeclaredFields()) { f.setAccessible(true); Columna col=f.getAnnotation(Columna.class);
            if(col!=null) { if(cols.length()>0){cols.append(",");vals.append(",");} cols.append(col.nombre()); vals.append("?"); } }
        try(PreparedStatement ps=conn.prepareStatement("INSERT INTO "+tabla+" ("+cols+") VALUES ("+vals+")")) {
            int i=1; for(Field f:c.getDeclaredFields()) { f.setAccessible(true); if(f.getAnnotation(Columna.class)!=null) ps.setObject(i++,f.get(ent)); }
            ps.executeUpdate();
        }
    }
    static <T> T buscarPorId(Class<T> c, Long id) throws Exception {
        String tabla=c.getAnnotation(Tabla.class).nombre(); T obj=c.getDeclaredConstructor().newInstance();
        try(PreparedStatement ps=conn.prepareStatement("SELECT * FROM "+tabla+" WHERE id=?")) { ps.setLong(1,id); ResultSet rs=ps.executeQuery();
            if(rs.next()) { for(Field f:c.getDeclaredFields()) { f.setAccessible(true); Columna col=f.getAnnotation(Columna.class);
                if(col!=null) f.set(obj,rs.getObject(col.nombre())); } } }
        return obj;
    }
    static <T> List<T> listarTodos(Class<T> c) throws Exception {
        List<T> lista=new ArrayList<>(); String tabla=c.getAnnotation(Tabla.class).nombre();
        ResultSet rs=conn.createStatement().executeQuery("SELECT * FROM "+tabla);
        while(rs.next()) { T obj=c.getDeclaredConstructor().newInstance(); for(Field f:c.getDeclaredFields()) { f.setAccessible(true); Columna col=f.getAnnotation(Columna.class);
            if(col!=null) f.set(obj,rs.getObject(col.nombre())); } lista.add(obj); }
        return lista;
    }
}
