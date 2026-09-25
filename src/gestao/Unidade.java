package gestao;

public class Unidade {
    private int numero;
    private double taxaBase;
    private boolean ocupada;

    public Unidade(int numero, double taxaBase) {
        this(numero, taxaBase, true);
    }

    public Unidade(int numero, double taxaBase, boolean ocupada) {
        this.numero = numero;
        setTaxaBase(taxaBase);
        this.ocupada = ocupada;
    }

    public double calcularTaxa() {
        return this.taxaBase;
    }

    public double calcularTaxa(double percentualMulta) {
        double valorNormal = calcularTaxa();
        return valorNormal + (valorNormal * (percentualMulta / 100));
    }

    public void exibirSituacao() {
        String status = ocupada ? "Ocupada" : "Desocupada";
        System.out.printf("Unidade %d | Taxa Base: R$ %.2f | Status: %s%n", numero, taxaBase, status);
    }

    public int getNumero() {
        return numero;
    }

    public double getTaxaBase() {
        return taxaBase;
    }

    public void setTaxaBase(double taxaBase) {
        if (taxaBase < 0) {
            System.out.println("Erro: A taxa condominial não pode ser negativa!");
            this.taxaBase = 0;
        } else {
            this.taxaBase = taxaBase;
        }
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    @Override
    public String toString() {
        String status = ocupada ? "Ocupada" : "Desocupada";
        return String.format("Unidade %d | Taxa: R$ %.2f | Status: %s", numero, calcularTaxa(), status);
    }
}
