package banco;

import java.util.ArrayList;
import java.util.List;

import banco.contas.Conta;
import banco.utils.Endereco;

public class Banco {
    private String nome;
    private Endereco endereco;
    private List<Conta> contas = new ArrayList<>();

    public Banco() {
    }

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setConta(Conta conta) {
        this.contas.add(conta);
    }

    public List<String> todosClientes() {
        return contas.stream().map(conta -> conta.getCliente().getNome()).toList();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Banco [nome=" + nome + ", endereco=" + endereco + "]";
    }
}
