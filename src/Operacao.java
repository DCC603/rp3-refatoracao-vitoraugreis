public class Operacao {
    public enum TipoOperacao {
        DEPOSITO('d', "Depósito"),
        SAQUE('s', "Saque");

        private char codigo;
        private String descricao;

        TipoOperacao(char codigo, String descricao) {
            this.codigo = codigo;
            this.descricao = descricao;
        }

        public char getCodigo() { return codigo; }

        public String getDescricao() { return descricao; }

        public static TipoOperacao fromChar(char c) {
            for (TipoOperacao t : values()) {
                if (t.codigo == c) return t;
            }
            throw new IllegalArgumentException("Tipo de operação inválido: " + c);
        }
    }

    private TipoOperacao tipo;
    private double valor;

    public Operacao(TipoOperacao tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public static Operacao fromChar(char c, double valor) {
        return new Operacao(TipoOperacao.fromChar(c), valor);
    }

    public String getTipo() {
        return this.tipo.getDescricao();
    }

    public String toString() {
        return this.getTipo() + ":\t" + this.valor;
    }
}
