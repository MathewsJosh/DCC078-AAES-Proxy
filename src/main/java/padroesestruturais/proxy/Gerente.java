package padroesestruturais.proxy;

public class Gerente {
    private String nome;
    private boolean supervisor;

    public Gerente(String nome, boolean supervisor) {
        this.nome = nome;
        this.supervisor = supervisor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAdministrador() {
        return supervisor;
    }

    public void setAdministrador(boolean supervisor) {
        this.supervisor = supervisor;
    }
}
