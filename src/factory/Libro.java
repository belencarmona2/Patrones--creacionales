package factory;

import Interface.LibroUso;
import java.util.Objects;

public abstract class Libro implements LibroUso {
    private int idLibro;
    private String nombre;
    private String autor;
    private String genero;
    private int anioPublicacion;

    // Constructores
    public Libro() {}

    public Libro(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    public Libro(int idLibro, String nombre, String autor, String genero, int anioPublicacion) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
    }

    // Getters y Setters
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return idLibro == libro.idLibro &&
                anioPublicacion == libro.anioPublicacion &&
                Objects.equals(nombre, libro.nombre) &&
                Objects.equals(autor, libro.autor) &&
                Objects.equals(genero, libro.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLibro, nombre, autor, genero, anioPublicacion);
    }
}
