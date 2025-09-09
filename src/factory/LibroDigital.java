package factory;

public class LibroDigital extends Libro {
    public int a;

    public LibroDigital(String nombre, String autor) {
        super(nombre, autor);
        System.out.println("Libro Digital creado... ");
    }


    @Override
    public void infoLibro() {
        System.out.println("Hola soy un libro DIgital");
    }

}