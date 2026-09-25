package gestao;

public class Cobertura extends Unidade{
    public Cobertura(int numero, double taxaBase) {
        super(numero, taxaBase);
    }

    public Cobertura(int numero, double taxaBase, boolean ocupada) {
        super(numero, taxaBase, ocupada);
    }


    @Override
    public double calcularTaxa(){
        double taxaBase = super.calcularTaxa();
        return taxaBase * 1.25;
    }

    @Override
    public String toString() {
        String status = isOcupada() ? "Ocupada" : "Desocupada";
        return String.format("Cobertura %d | Taxa (+25%%): R$ %.2f | Status: %s", getNumero(), calcularTaxa(), status);
    }


}
