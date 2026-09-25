package gestao;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o nome do condomínio:");
        String nome = leitura.nextLine();

        System.out.println("Quantidade de Blocos:");
        int blocos = leitura.nextInt();

        System.out.println("Quantidade de Unidades:");
        int unidades = leitura.nextInt();

        System.out.println("Digite o valor da Taxa Padrão:");
        double taxaPadrao = leitura.nextDouble();

        if (taxaPadrao <= 400) {
            System.out.println("-> Taxa Econômica");
        } else if (taxaPadrao <= 700) {
            System.out.println("-> Taxa intermediária");
        } else {
            System.out.println("-> Taxa Elevada");
        }

        double valorTotal = unidades * taxaPadrao;

        leitura.nextLine(); //limpar o buffer

        System.out.println("O condomínio possui portaria 24h? (s/n)");
        String resposta = leitura.nextLine();
        boolean portaria = resposta.equalsIgnoreCase("s");

        // Instanciando objetos das nossas classes para usar no sistema
        Condominio condominio = new Condominio(nome, 2000.00);
        Unidade unidade101 = new Unidade(101, taxaPadrao);
        Unidade unidade102 = new Unidade(102, taxaPadrao, false);
        Cobertura cobertura201 = new Cobertura(201, taxaPadrao);
        Cobertura cobertura202 = new Cobertura(202, taxaPadrao, true);
        Morador morador1 = new Morador("Carlos Silva", "123.456.789-00", 101);
        Morador morador2 = new Morador("Ana Souza", "987.654.321-11", 201);
        Morador morador3 = new Morador("Roberto Lima", "456.789.123-22", 202);
        Funcionario func1 = new Funcionario("João Pedro", 1800.00); // Funcionário comum
        Funcionario func2 = new Funcionario("Maria Oliveira", 2100.00);
        Zelador zelador1 = new Zelador("Marcos Souza", 2500.00);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1 - Dados do condomínio");
            System.out.println("2 - Simular arrecadação");
            System.out.println("3 - Listar Unidades (Com toString)");
            System.out.println("4 - Consultar Morador e Funcionário");
            System.out.println("5 - Registrar Pagamento de Condomínio");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = leitura.nextInt();

            if (opcao == 1) {
                System.out.println("\n===== CONDOMÍNIO =====");
                System.out.println("Nome: " + condominio.getNome());
                System.out.println("Blocos: " + blocos);
                System.out.println("Unidades: " + unidades);
                System.out.printf("Taxa padrão: R$ %.2f%n", taxaPadrao);
                System.out.println("Portaria 24h: " + portaria);
                System.out.printf("Saldo Atual em Caixa: R$ %.2f%n", condominio.getSaldoCaixa());
                System.out.println("======================");
            } else if (opcao == 2) {
                System.out.println("\n--- DETALHAMENTO DAS UNIDADES ---");
                for (int i = 1; i <= unidades; i++) {
                    System.out.printf("Unidade %d Taxa: R$ %.2f%n", i, taxaPadrao);
                }
                System.out.printf("O condomínio arrecadaria no total: R$ %.2f%n", valorTotal);
            } else if (opcao == 3) {
                System.out.println("\n--- TODAS AS UNIDADES CADASTRADAS ---");
                System.out.println(unidade101);
                System.out.println(unidade102);
                System.out.println(cobertura201);
                System.out.println(cobertura202);
            } else if (opcao == 4) {
                System.out.println("\n--- LISTA DE MORADORES ---");
                System.out.println(morador1);
                System.out.println(morador2);
                System.out.println(morador3);

                System.out.println("\n--- QUADRO DE FUNCIONÁRIOS ---");
                System.out.println(func1);
                System.out.println(func2);
                System.out.println(zelador1);
            } else if (opcao == 5) {
                System.out.println("\n--- RECEBER PAGAMENTO ---");
                double taxaCobertura = cobertura201.calcularTaxa();
                condominio.receberPagamento(taxaCobertura);
                System.out.printf("Novo saldo do caixa: R$ %.2f%n", condominio.getSaldoCaixa());
            } else if (opcao == 0) {
                System.out.println("\nSaindo do sistema... Até logo!");
            } else {
                System.out.println("\nOpção inválida! Tente novamente.");
            }
        }

        leitura.close();
    }
}