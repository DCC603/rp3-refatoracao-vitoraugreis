import java.util.ArrayList;
import java.util.List;

public class Conta {
    private Cliente cliente;
    
    private int numAgencia;
    private int numConta;
    private String gerente;

    private double saldo;

    private List<Operacao> operacoes;

    public Conta(Cliente cliente, int numAgencia, int numConta, String gerente, double saldo) {
        this.cliente = cliente;
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.gerente = gerente;
        this.saldo = saldo;

        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(new Cliente(), 0, 0, null, 0);
    }

    private void depositar(double amount) {
        Operacao op = new Operacao('d', amount);
        this.operacoes.add(op);
        this.saldo += amount;
    }

    private void sacar(double amount) {
        Operacao op = new Operacao('s', amount);
        this.operacoes.add(op);
        this.saldo -= amount;
    }

    public void realizarOperacao(char tipo, double amount) {
        if (tipo == 'd') 
            depositar(amount);
        else if (tipo == 's')
            sacar(amount);
        else
            throw new IllegalArgumentException("Tipo de operação inválido: " + tipo);
    }

    private String gerarDadosConta() {
        return String.format("Ag.: %d\nConta: %d\nGerente: %s\nSaldo: %.2f",
                this.numAgencia, this.numConta, this.gerente, this.saldo);
    }

    private String gerarDadosExtrato() {
        String sb = "";
        for (Operacao op : this.operacoes) {
            sb += op.toString() + "\n";
        }
        return sb.toString();
    }
     
     public String toString() {
         String dadosCliente = this.cliente.toString();
         String dadosConta = gerarDadosConta();
         String dadosExtrato = gerarDadosExtrato();

         return "-----CLIENTE-----\n" +
                 dadosCliente +
                 "\n\n" +
                 "-----CONTA-----\n" +
                 dadosConta +
                 "\n\n" +
                 "-----EXTRATO-----\n" +
                 dadosExtrato +
                 "\n";
     }
 }
