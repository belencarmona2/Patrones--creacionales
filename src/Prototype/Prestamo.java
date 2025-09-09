package Prototype;

import builder.Usuario;
import factory.Libro;
import java.time.LocalDate;
import java.util.Objects;

public class Prestamo implements Cloneable {
    private Libro libro;
    private Usuario usuario;
    private LocalDate FechaInicio;
    private LocalDate FechaFin;

    // Constructor privado para el Builder
    private Prestamo(Libro libro, Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin) {
        this.libro = libro;
        this.usuario = usuario;
        this.FechaInicio = fechaInicio;
        this.FechaFin = fechaFin;
    }

    // Getters y Setters
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
    }

    // Builder
    public static class PrestamoBuilder {
        private Libro libro;
        private Usuario usuario;
        private LocalDate FechaInicio;
        private LocalDate FechaFin;

        public PrestamoBuilder libro(Libro libro) {
            this.libro = libro;
            return this;
        }

        public PrestamoBuilder usuario(Usuario usuario) {
            this.usuario = usuario;
            return this;
        }

        public PrestamoBuilder FechaInicio(LocalDate fechaInicio) {
            FechaInicio = fechaInicio;
            return this;
        }

        public PrestamoBuilder FechaFin(LocalDate fechaFin) {
            FechaFin = fechaFin;
            return this;
        }

        public Prestamo build() {
            return new Prestamo(libro, usuario, FechaInicio, FechaFin);
        }
    }

    public static PrestamoBuilder builder() {
        return new PrestamoBuilder();
    }

    @Override
    public Prestamo clone() {
        try {
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "++++++++++++++++++++++++\nPrestamo{" +
                "libro=" + libro.getNombre() +
                ", usuario=" + usuario.getNombre() +
                ", FechaInicio=" + this.FechaInicio +
                ", FechaFin=" + this.FechaFin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(libro, prestamo.libro) &&
                Objects.equals(usuario, prestamo.usuario) &&
                Objects.equals(FechaInicio, prestamo.FechaInicio) &&
                Objects.equals(FechaFin, prestamo.FechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libro, usuario, FechaInicio, FechaFin);
    }
}
