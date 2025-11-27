public class Main {


    public static void main(String[] args) {

        Cliente cliente = new Cliente("João", "111.111.111-11", "31 1111-1111");
        Conta minhaConta = new Conta(cliente, 111, 222222, "Gil", 0.00);

        minhaConta.realizarOperacao('d', 450);
        minhaConta.realizarOperacao('s', 50);
        minhaConta.realizarOperacao('s', 50);
        minhaConta.realizarOperacao('s', 50);

        System.out.println(minhaConta);
    }
}
