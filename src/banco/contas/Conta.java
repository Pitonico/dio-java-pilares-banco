package banco.contas;

import banco.clientes.Cliente;
import banco.utils.exceptions.ValorInsuficienteException;

public abstract class Conta implements IConta{

    private static int sequencial = 1;
    private static final int AGENCIA = 1;
    private int numeroConta;
    private double saldo = 0;
    private Cliente cliente;

    protected Conta(Cliente cliente) {
        this.numeroConta = sequencial++;
        this.cliente = cliente;
    }

    public int getAGENCIA() {
        return AGENCIA;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void sacar(double valor){
        try {
            if (valor > this.saldo) throw new ValorInsuficienteException("Saldo Insuficiente");
            this.saldo -= valor;
        } catch (ValorInsuficienteException e) {
           System.out.println(e.getMessage());
        }
    }

    @Override
    public void depositar(double valor) {
       this.saldo += valor;
    }
    @Override
    public void transferir(double valor, Conta destino) {
        try {
            if (valor > this.saldo) throw new ValorInsuficienteException("Saldo Insuficiente");
            this.sacar(valor);
            destino.depositar(valor);
        } catch (ValorInsuficienteException e) {
            System.out.println(e.getMessage());
        } 
    }

    protected void informacoes() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", Conta.AGENCIA));
        System.out.println(String.format("Numero da Conta: %d", this.numeroConta));
        System.out.println(String.format("Saldo: RS%.2f", this.saldo));
    }

    @Override
    public String toString() {
        return "Conta [numeroConta=" + numeroConta + ", saldo=" + saldo + ", cliente=" + cliente + "]";
    }

    
}
