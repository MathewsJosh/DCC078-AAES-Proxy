package padroesestruturais.proxy;

import java.util.List;

public class ClienteProxy implements InterfaceCliente {

    private Cliente cliente;

    private Integer cpf;

    public ClienteProxy(Integer cpf) {
        this.cpf = cpf;
    }

    @Override
    public List<String> obterDadosCadastrais() {
        if (this.cliente == null) {
            this.cliente = new Cliente(this.cpf);
        }
        return this.cliente.obterDadosCadastrais();
    }

    @Override
    public List<Float> obterSaldos(Gerente gerente) {
        if (!gerente.isAdministrador()) {
            throw new IllegalArgumentException("Gerente não autorizado");
        }
        if (this.cliente == null) {
            this.cliente = new Cliente(this.cpf);
        }
        return this.cliente.obterSaldos(gerente);
    }
}
