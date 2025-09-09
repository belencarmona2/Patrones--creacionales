package abstractFactory;

import Interface.InterfazUI;
import Interface.MetodoEnvio;

public class UsuarioFactory implements AbstractFactory {
    @Override
    public InterfazUI crearUI() {
        return new UsuarioUI();
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
