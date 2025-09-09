package abstractFactory;

import Interface.*;
import factory.*;
public class EnvioExpress implements MetodoEnvio {

    @Override
    public void EnviarLibro(Libro libro) {
        System.out.println("Se realiza un Envio express, estimado dentro de  1 - 2 dias");
    }
}
