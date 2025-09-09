package abstractFactory;

import Interface.InterfazUI;
import Interface.MetodoEnvio;

public class AdminFactory implements AbstractFactory {
    @Override
    public InterfazUI crearUI() {
        return new AdminUI();
    }

    @Override
    public MetodoEnvio crearEnvioNormal() {
        return new EnvioNormal();
    }

    @Override
    public MetodoEnvio crearEnvioExpress() {
        return new EnvioExpress();
    }
}
