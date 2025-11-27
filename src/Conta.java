import java.util.ArrayList;
import java.util.List;

public class Conta {
    private Cliente cliente;
    private int numAgencia;
    private int numConta;
    private String gerente;

    // TODO(#2) REFATORAR: Esse nome não é o ideal para representar o saldo da conta
    private double valor;

    private List<Operacao> operacoes;

    public Conta(Cliente cliente, int numAgencia, int numConta, String gerente, double valor) {
        this.cliente = cliente;
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.gerente = gerente;
        this.valor = valor;

        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(new Cliente(), 0, 0, null, 0);
    }

    // TODO(#3) REFATORAR: Muita responsabilidade para o mesmo método
    public void realizarOperacao(char tipo, int valor) {
        Operacao op = new Operacao(tipo, valor);
        this.operacoes.add(op);

        if (tipo == 'd')
            this.valor += valor;
        else if(tipo == 's')
            this.valor -= valor;
    }

    public String toString() {
        // TODO(#4) REFATORAR: Esses dados não estão relacionados a conta
        String dadosCliente = this.cliente.toString();

        // TODO(#4) REFATORAR: Esses dados não estão relacinados a conta
        String dadosConta = String.format("Ag.: %d\nConta: %d\nGerente: %s\nSaldo: %.2f",
                this.numAgencia, this.numConta, this.gerente, this.valor);

        // TODO(#5) REFATORAR: Essa operação não deveria estar sendo realizada neste método
        String dadosExtrato = "";
        for(Operacao op : this.operacoes) {
            dadosExtrato += op.toString() + "\n";
        }

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
