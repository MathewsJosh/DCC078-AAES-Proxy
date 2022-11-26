package padroesestruturais.proxy;

import java.util.List;

public interface InterfaceCliente {
    List<String> obterDadosCadastrais();
    List<Float> obterSaldos(Gerente gerente);
}
