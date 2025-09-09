package abstractFactory;
import Interface.*;

public class AdminUI implements InterfazUI {
    @Override
    public void mostrar() {
        System.out.println("[UI] Vista de Administrador");
    }
}
