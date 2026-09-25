package gestao;

public class Condominio {
    private String nome;
    private double saldoCaixa;

    public Condominio(String nome) {
        this.nome = nome;
        this.saldoCaixa = 0.0;
    }

    public Condominio(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldoCaixa = saldoInicial >= 0 ? saldoInicial : 0.0;
    }

    public void receberPagamento(double valor) {
        if (valor > 0) {
            this.saldoCaixa += valor;
            System.out.printf("Pagamento de R$ %.2f recebido com sucesso!%n", valor);
        } else {
            System.out.println("Erro: O valor do pagamento deve ser positivo.");
        }
    }

    public void pagarDespesa(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor da despesa deve ser positivo.");
        } else if (valor > this.saldoCaixa) {
            System.out.printf("Erro: Saldo insuficiente! Saldo atual: R$ %.2f | Despesa: R$ %.2f%n", this.saldoCaixa, valor);
        } else {
            this.saldoCaixa -= valor;
            System.out.printf("Despesa de R$ %.2f paga com sucesso!%n", valor);
        }
    }

    public String getNome() {
        return nome;
    }

    public double getSaldoCaixa() {
        return saldoCaixa;
    }
}