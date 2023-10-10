package banco.app;

import banco.Banco;
import banco.clientes.Cliente;
import banco.contas.Conta;
import banco.contas.ContaCorrente;
import banco.contas.ContaPoupanca;
import banco.utils.Endereco;
import banco.utils.EstadosBrasileiros;

public class App {
    public static void main(String[] args) {
        Endereco enderecoBanco = Endereco.builder()
            .setLogradouro("Rua do Banco Pilares")
            .setNumero(100)
            .setCidade("Cidade BP")
            .setEstado(EstadosBrasileiros.PERNAMBUCO)
            .build();

        Banco banco = new Banco("Banco Pilares");
        banco.setEndereco(enderecoBanco);

        Endereco enderecoCliente = Endereco.builder()
            .setLogradouro("Rua do Cliente 1")
            .setNumero(55)
            .setCidade("Cidade A")
            .setEstado(EstadosBrasileiros.SAO_PAULO)
            .build();
       
        Cliente cliente = new Cliente("Diogo", 36);
        cliente.setEndereco(enderecoCliente);

        Conta conta = new ContaCorrente(cliente);
        cliente.setConta(conta);

        enderecoCliente = Endereco.builder()
            .setLogradouro("Rua do Cliente 2")
            .setNumero(110)
            .setCidade("Cidade B")
            .setEstado(EstadosBrasileiros.AMAZONAS)
            .build();
        
        Cliente cliente2 = new Cliente("Daniel", 42);
        cliente2.setEndereco(enderecoCliente);

        Conta conta2 = new ContaPoupanca(cliente2);
        cliente.setConta(conta2);

        banco.setConta(conta);
        banco.setConta(conta2);

        System.out.println("*** Inicio ***");
        System.out.println("Saldo C1: R$" + conta.getSaldo());
        System.out.println("Saldo C2: R$" + conta2.getSaldo());
        System.out.println("*** Depósito de R$50,00 na C1 ***");
        conta.depositar(50);
        System.out.println("Saldo C1: R$" + conta.getSaldo());
        System.out.println("*** Saque de R$15,00 da C1 ***");
        conta.sacar(15);
        System.out.println("Saldo C1: R$" + conta.getSaldo());
        System.out.println("*** Transferência de R$20,00 da C1 para C2 ***");
        conta.transferir(20, conta2);
        System.out.println("Saque C1: R$" + conta.getSaldo());
        System.out.println("Saldo C2: R$" + conta2.getSaldo());     
        System.out.println("** Extrato C1 ***");
        conta.imprimirExtrato();
        System.out.println("** Extrato C2 ***");
        conta2.imprimirExtrato();

        System.out.println(banco.getContas());
        System.out.println(banco.todosClientes());
    }
}
