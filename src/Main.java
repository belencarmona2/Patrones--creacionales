import Prototype.Prestamo;
import builder.Usuario;
import factory.*;
import singleton.*;
import abstractFactory.*;
import Interface.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Factory Method: Creación de Libros ===");
        Libro lib3 = LogicaLibro.crearLibro("Digital","Aprende Conmigo","AdventureStudio");
        Libro lib4 = LogicaLibro.crearLibro("Fisico","Como amanecer cad dia","Julian Morris");
        Libro lib5 = LogicaLibro.crearLibro("li","Entusiasmo","James Gessard"); // tipo inválido, devuelve null
        Libro lib1 = new LibroDigital("Alquimia1","Vesperta A.");
        Libro lib2 = new LibroDigital("Como armar muebles","GobiernoAyuda");
        System.out.println("=== Singleton: DataBase ===");
        DataBase data1 = DataBase.INSTANCE;
        System.out.println("Agregando libros a la DataBase...");
        data1.agregarLibro(lib1);
        data1.agregarLibro(lib2);
        data1.agregarLibro(lib4);
        data1.agregarLibro(lib5); // se ignora si es null
        data1.agregarLibro(lib3);

        System.out.println("Mostrando libros almacenados en DataBase:");
        data1.getLibros();

        System.out.println("Mostrando info individual de cada libro:");
        lib1.infoLibro();
        lib2.infoLibro();
        if (lib3 != null) lib3.infoLibro();
        if (lib4 != null) lib4.infoLibro();
        if (lib5 != null) lib5.infoLibro();
        System.out.println("lib5 es null, no se puede mostrar info.");

        // === Builder ===
        System.out.println("\n=== Builder: Usuario 1 ===");
        Usuario u1 = Usuario.builder()
                .nombre("Bel")
                .email("carmolu243@gmail.com")
                .direccion("calle loc 34")
                .build();
        System.out.println("Usuario creado con builder: " + u1);

        System.out.println("\n=== Builder: Usuario 2 ===");
        Usuario u2 = Usuario.builder()
                .nombre("Carmen")
                .email("carmen@gmail.com")
                .direccion("Calle 123")
                .build();
        System.out.println("Usuario creado con builder: " + u2);

        // === Abstract Factory: Usuario ===
        System.out.println("\n=== Abstract Factory: Usuario ===");
        AbstractFactory usuarioFactory = new UsuarioFactory();
        InterfazUI uiUsuario = usuarioFactory.crearUI();
        MetodoEnvio envioNormalUsuario = usuarioFactory.crearEnvioNormal();
        MetodoEnvio envioExpressUsuario = usuarioFactory.crearEnvioExpress();

        System.out.println("Mostrando interfaz de Usuario:");
        uiUsuario.mostrar();

        Libro libroParaUsuario = (lib3 != null) ? lib3 : lib1;
        if (libroParaUsuario != null) {
            System.out.println("Enviando libro como Usuario con Envío Normal:");
            envioNormalUsuario.EnviarLibro(libroParaUsuario);

            System.out.println("Enviando libro como Usuario con Envío Express:");
            envioExpressUsuario.EnviarLibro(libroParaUsuario);
        }

        // === Abstract Factory: Admin ===
        System.out.println("\n=== Abstract Factory: Admin ===");
        AbstractFactory adminFactory = new AdminFactory();
        InterfazUI uiAdmin = adminFactory.crearUI();
        MetodoEnvio envioNormalAdmin = adminFactory.crearEnvioNormal();
        MetodoEnvio envioExpressAdmin = adminFactory.crearEnvioExpress();

        System.out.println("Mostrando interfaz de Admin:");
        uiAdmin.mostrar();

        Libro libroParaAdmin = (lib4 != null) ? lib4 : lib2;
        if (libroParaAdmin != null) {
            System.out.println("Enviando libro como Admin con Envío Normal:");
            envioNormalAdmin.EnviarLibro(libroParaAdmin);

            System.out.println("Enviando libro como Admin con Envío Express:");
            envioExpressAdmin.EnviarLibro(libroParaAdmin);
        }
        Prestamo p1 = Prestamo.builder()
                .libro(lib1)
                .usuario(u1)
                .FechaInicio(LocalDate.now())
                .FechaFin(LocalDate.now().plusDays(14))
                .build();
        System.out.println(p1.toString());
        Prestamo prestamo1= p1.clone();
        prestamo1.setUsuario(u2);

        Prestamo prestamo2= p1.clone();
        prestamo2.setFechaFin(LocalDate.now().plusDays(30));

        //Realizamos la comparacion entre el clon y el orginal
        System.out.println(prestamo1.getUsuario().getNombre());
        System.out.println(p1.getUsuario().getNombre());
        System.out.println(prestamo2.getFechaFin());
        System.out.println(p1.getFechaFin());
    }
}
