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

    // Collections integradas ao sistema
    private List<Unidade> unidades;             // ArrayList para armazenar todas as unidades
    private Map<String, Morador> moradoresCpf;   // HashMap para buscar moradores rapidamente por CPF (Chave: CPF, Valor: Morador)
    private Set<String> cpfsRegistrados;         // HashSet para garantir que não haja CPFs duplicados
    private List<Funcionario> funcionarios;     // ArrayList para o quadro de funcionários

    public Condominio(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldoCaixa = saldoInicial >= 0 ? saldoInicial : 0.0;
        this.unidades = new ArrayList<>();
        this.moradoresCpf = new HashMap<>();
        this.cpfsRegistrados = new HashSet<>();
        this.funcionarios = new ArrayList<>();
    }

    // Métodos de gerenciamento integrados
    public void adicionarUnidade(Unidade unidade) {
        this.unidades.add(unidade);
    }

    public boolean cadastrarMorador(Morador morador) {
        // Usa o HashSet para verificar unicidade do CPF
        if (cpfsRegistrados.add(morador.getCpf())) {
            moradoresCpf.put(morador.getCpf(), morador);
            return true;
        }
        return false; // CPF já cadastrado
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

    // Getters para exibição
    public List<Unidade> getUnidades() { return unidades; }
    public Map<String, Morador> getMoradoresCpf() { return moradoresCpf; }
    public List<Funcionario> getFuncionarios() { return funcionarios; }
    public String getNome() { return nome; }
    public double getSaldoCaixa() { return saldoCaixa; }
}