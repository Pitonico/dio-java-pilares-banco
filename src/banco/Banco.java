package banco;

import java.util.ArrayList;
import java.util.List;

import banco.contas.Conta;
import banco.utils.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Banco {
    @Setter private String nome;
    @Setter private Endereco endereco;
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public List<String> todosClientes() {
        return contas.stream().map(conta -> conta.getCliente().getNome()).toList();
    }

    @Override
    public String toString() {
        return "Banco [nome=" + nome + ", endereco=" + endereco + "]";
    }
}
