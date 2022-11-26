package padroesestruturais.proxy;

import java.util.Arrays;
import java.util.List;

public class Cliente implements InterfaceCliente {

    private Integer cpf;
    private String nome;
    private String cidade;
    private Float conta_corrente;
    private Float conta_poupanca;

    public Cliente(int cpf) {
        this.cpf = cpf;
        Cliente objeto = BD.getCliente(cpf);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.conta_corrente = objeto.conta_corrente;
        this.conta_poupanca = objeto.conta_poupanca;
    }

    public Cliente(Integer cpf, String nome, String cidade, Float conta_corrente, Float conta_poupanca) {
        this.cpf = cpf;
        this.nome = nome;
        this.cidade = cidade;
        this.conta_corrente = conta_corrente;
        this.conta_poupanca = conta_poupanca;
    }

    public Integer getCpf() {
        return cpf;
    }

    @Override
    public List<String> obterDadosCadastrais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<Float> obterSaldos(Gerente gerente) {
        return Arrays.asList(this.conta_corrente, this.conta_poupanca);
    }
}
