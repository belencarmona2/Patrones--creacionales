package abstractFactory;

import Interface.*;

public class UsuarioUI implements InterfazUI {
    @Override
    public void mostrar() {
        System.out.println("[UI] Vista de Usuario");
    }
}
