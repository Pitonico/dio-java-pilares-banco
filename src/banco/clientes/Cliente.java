package banco.clientes;

import banco.contas.Conta;
import banco.utils.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco;
    private Conta conta;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", idade=" + idade + ", endereco=" + endereco + "]";
    }   
}
