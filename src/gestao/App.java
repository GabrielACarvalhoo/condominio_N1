package gestao;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o nome do condomínio:");
        String nomeCondominio = leitura.nextLine();

       
        Condominio condominio = new Condominio(nomeCondominio, 2000.00);

        
        condominio.adicionarUnidade(new Unidade(101, 450.00));
        condominio.adicionarUnidade(new Unidade(102, 450.00, false));
        condominio.adicionarUnidade(new Cobertura(201, 450.00));
        condominio.adicionarUnidade(new Cobertura(202, 450.00, true));

        Morador m1 = new Morador("Carlos Silva", "11111111111", 101);
        Morador m2 = new Morador("Ana Souza", "98765432111", 201);
        condominio.cadastrarMorador(m1);
        condominio.cadastrarMorador(m2);

        condominio.adicionarFuncionario(new Funcionario("Paulo Pedro", 2500.00));
        condominio.adicionarFuncionario(new Zelador("Marcos Souza", 3000.00));

            for (Unidade unidade : condominio.getUnidades()) {
            
                System.out.println(
                    "Unidade " + unidade.getNumero()
                );
            
                System.out.printf(
                    "Taxa calculada: R$ %.2f%n",
                    unidade.calcularTaxa()
                );
            }        

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n========== RESIDENCIAL " + condominio.getNome().toUpperCase() + " ==========");
            System.out.println("1 - Consultar resumo do condomínio");
            System.out.println("2 - Listar todas as unidades (ArrayList)");
            System.out.println("3 - Consultar moradores cadastrados (HashMap / HashSet)");
            System.out.println("4 - Listar quadro de funcionários");
            System.out.println("5 - Registrar pagamento de taxa de unidade");
            System.out.println("6 - Pagar despesa do condomínio");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = leitura.nextInt();

            if (opcao == 1) {
                System.out.println("\n===== CONDOMÍNIO =====");
                System.out.println("Nome: " + condominio.getNome());
                System.out.printf("Saldo do condomínio: R$ %.2f%n", condominio.getSaldoCaixa());
                System.out.println("Total de Unidades cadastradas: " + condominio.getUnidades().size());
                System.out.println("Total de Moradores cadastrados: " + condominio.getMoradoresCpf().size());
            } else if (opcao == 2) {
                System.out.println("\n--- LISTA DE UNIDADES (Via ArrayList) ---");
                for (Unidade u : condominio.getUnidades()) {
                    System.out.println(u);
                }
            } else if (opcao == 3) {
                System.out.println("\n--- CONSULTA DE MORADORES (Via HashMap) ---");
                for (Morador morador : condominio.getMoradoresCpf().values()) {
                    System.out.println(morador);
                }
            } else if (opcao == 4) {
                System.out.println("\n--- QUADRO DE FUNCIONÁRIOS ---");
                for (Funcionario f : condominio.getFuncionarios()) {
                    System.out.println(f);
                }
            } else if (opcao == 5) {
                System.out.println("\n--- REGISTRAR PAGAMENTO ---");
                System.out.println("Unidades disponíveis:");
                for (int i = 0; i < condominio.getUnidades().size(); i++) {
                    Unidade u = condominio.getUnidades().get(i);
                    System.out.printf("[%d] Unidade %d (Taxa: R$ %.2f)%n", i, u.getNumero(), u.calcularTaxa());
                }
                System.out.print("Escolha o índice da unidade: ");
                int index = leitura.nextInt();

                if (index >= 0 && index < condominio.getUnidades().size()) {
                    Unidade unidadeEscolhida = condominio.getUnidades().get(index);
                    double valor = unidadeEscolhida.calcularTaxa();
                    condominio.receberPagamento(valor);
                    System.out.printf("Novo saldo em caixa: R$ %.2f%n", condominio.getSaldoCaixa());
                } else {
                    System.out.println("Índice inválido!");
                }
            } else if (opcao == 6) {
                System.out.print("\nDigite o valor da despesa a pagar: R$ ");
                double despesa = leitura.nextDouble();
                condominio.pagarDespesa(despesa);
            } else if (opcao == 0) {
                System.out.println("\nSaindo do sistema... Até logo!");
            } else {
                System.out.println("\nOpção inválida! Tente novamente.");
            }
        }

        leitura.close();
    }
}
