package builder;

import java.util.Objects;

public class Usuario {
    private String nombre;
    private String email;
    private String direccion;

    // Constructor privado para el Builder
    private Usuario(String nombre, String email, String direccion) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    // Builder
    public static class UsuarioBuilder {
        private String nombre;
        private String email;
        private String direccion;

        public UsuarioBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public UsuarioBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UsuarioBuilder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Usuario build() {
            return new Usuario(nombre, email, direccion);
        }
    }

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(direccion, usuario.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, email, direccion);
    }
}

