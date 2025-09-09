package abstractFactory;

import Interface.InterfazUI;
import Interface.MetodoEnvio;

public interface AbstractFactory {
    InterfazUI crearUI();
    MetodoEnvio crearEnvioNormal();
    MetodoEnvio crearEnvioExpress();
}
