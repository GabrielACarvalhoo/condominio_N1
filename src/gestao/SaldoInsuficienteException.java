package gestao;

public class SaldoInsuficienteException
        extends Exception {

    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
