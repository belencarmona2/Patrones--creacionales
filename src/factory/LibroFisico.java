package factory;

public class LibroFisico extends Libro {

    public LibroFisico(String nombre, String autor) {
        super(nombre, autor);
        System.out.println("Libro Fisico creado... ");
    }

    @Override
    public void infoLibro() {
        System.out.println("Hola soy un libro fisico");
    }
}
