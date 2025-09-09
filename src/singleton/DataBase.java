package singleton;
import java.util.ArrayList;
import java.util.List;
import factory.Libro;

public enum DataBase {
    INSTANCE;

    private final List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        if (libro != null) {
            libros.add(libro);
        }
    }

    public List<Libro> getLibros() {
        libros.removeIf(lib -> lib == null);
        System.out.println("+++++++++++++++++++++++");
        for (Libro lib : libros) {
            System.out.println(lib);
        }
        return libros;
    }
}