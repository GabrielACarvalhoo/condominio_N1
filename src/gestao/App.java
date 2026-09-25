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
            System.out.println("-> Taxa Intermediária");
        } else {
            System.out.println("-> Taxa Elevada");
        }

        leitura.nextLine(); // limpar buffer

        System.out.println("O condomínio possui portaria 24h? (s/n)");
        String resposta = leitura.nextLine();
        boolean portaria = resposta.equalsIgnoreCase("s");

        // Instanciando objetos de teste pedidos no Exercício 20
        Condominio condominio = new Condominio(nome, 2000.00);
        Unidade unidade101 = new Unidade(101, taxaPadrao);
        Unidade unidade102 = new Unidade(102, taxaPadrao, false);
        Cobertura cobertura201 = new Cobertura(201, taxaPadrao);
        Cobertura cobertura202 = new Cobertura(202, taxaPadrao, true);

        Morador morador101 = new Morador("Carlos Silva", "11111111111", 101);
        Morador morador201 = new Morador("Ana Souza", "98765432111", 201);

        Funcionario funcionario = new Funcionario("Paulo Pedro", 2500.00);
        Zelador zelador = new Zelador("Marcos Souza", 3000.00);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n========== RESIDENCIAL " + condominio.getNome().toUpperCase() + " ==========");
            System.out.println("1 - Consultar condomínio");
            System.out.println("2 - Consultar unidade");
            System.out.println("3 - Consultar morador");
            System.out.println("4 - Calcular taxa de unidade");
            System.out.println("5 - Calcular taxa com multa");
            System.out.println("6 - Registrar pagamento");
            System.out.println("7 - Registrar despesa");
            System.out.println("8 - Consultar funcionário");
            System.out.println("9 - Simular arrecadação");
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
                System.out.printf("Saldo do condomínio: R$ %.2f%n", condominio.getSaldoCaixa());
            } else if (opcao == 2) {
                System.out.println("\n--- LISTA DE UNIDADES ---");
                System.out.println(unidade101);
                System.out.println(unidade102);
                System.out.println(cobertura201);
                System.out.println(cobertura202);
            } else if (opcao == 3) {
                System.out.println("\n--- CONSULTA DE MORADORES ---");
                System.out.println(morador101);
                System.out.println(morador201);
            } else if (opcao == 4) {
                System.out.println("\n--- CÁLCULO DE TAXAS ---");
                System.out.printf("Unidade 101: R$ %.2f%n", unidade101.calcularTaxa());
                System.out.printf("Cobertura 201 (+25%%): R$ %.2f%n", cobertura201.calcularTaxa());
            } else if (opcao == 5) {
                System.out.print("\nDigite o percentual da multa (%): ");
                double percentual = leitura.nextDouble();
                System.out.printf("Unidade 101 com multa: R$ %.2f%n", unidade101.calcularTaxa(percentual));
                System.out.printf("Cobertura 201 com multa: R$ %.2f%n", cobertura201.calcularTaxa(percentual));
            } else if (opcao == 6) {
                System.out.println("\n--- REGISTRAR PAGAMENTO ---");
                double valor = unidade101.calcularTaxa();
                condominio.receberPagamento(valor);
                System.out.println("Unidade: " + unidade101.getNumero());
                System.out.printf("Valor pago: R$ %.2f%n", valor);
                System.out.printf("Saldo do condomínio: R$ %.2f%n", condominio.getSaldoCaixa());
            } else if (opcao == 7) {
                System.out.print("\nDigite o valor da despesa a pagar: R$ ");
                double despesa = leitura.nextDouble();
                condominio.pagarDespesa(despesa);
            } else if (opcao == 8) {
                System.out.println("\n--- QUADRO DE FUNCIONÁRIOS ---");
                System.out.println(funcionario);
                System.out.println(zelador);
            } else if (opcao == 9) {
                System.out.println("\n--- SIMULAÇÃO DE ARRECADAÇÃO ---");
                for (int i = 1; i <= unidades; i++) {
                    System.out.printf("Unidade %d Taxa: R$ %.2f%n", i, taxaPadrao);
                }
                System.out.printf("Arrecadação total estimada: R$ %.2f%n", (unidades * taxaPadrao));
            } else if (opcao == 0) {
                System.out.println("\nSaindo do sistema... Até logo!");
            } else {
                System.out.println("\nOpção inválida! Tente novamente.");
            }
        }

        leitura.close();
    }
}
