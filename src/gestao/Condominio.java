package gestao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Condominio {
    private String nome;
    private double saldoCaixa;

    
    private List<Unidade> unidades;             
    private Map<String, Morador> moradoresCpf;   
    private Set<String> cpfsRegistrados;        
    private List<Funcionario> funcionarios;     

    public Condominio(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldoCaixa = saldoInicial >= 0 ? saldoInicial : 0.0;
        this.unidades = new ArrayList<>();
        this.moradoresCpf = new HashMap<>();
        this.cpfsRegistrados = new HashSet<>();
        this.funcionarios = new ArrayList<>();
    }

    
    public void adicionarUnidade(Unidade unidade) {
        this.unidades.add(unidade);
    }

    public boolean cadastrarMorador(Morador morador) {
       
        if (cpfsRegistrados.add(morador.getCpf())) {
            moradoresCpf.put(morador.getCpf(), morador);
            return true;
        }
        return false; 
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
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

    
    public List<Unidade> getUnidades() { return new ArrayList<>(unidades); }
    public Map<String, Morador> getMoradoresCpf() {  return new HashMap<>(moradoresCpf); }
    public List<Funcionario> getFuncionarios() { return new ArrayList<>(funcionarios); }
    public String getNome() { return nome; }
    public double getSaldoCaixa() { return saldoCaixa; }
}
