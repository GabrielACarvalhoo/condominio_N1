package gestao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SistemaCondominioCollections {
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DE COLLECTIONS NO SISTEMA DE CONDOMÍNIO ===\n");

        
        List<String> historicoEncomendas = new ArrayList<>();
        historicoEncomendas.add("Encomenda recepcionada para a Unidade 101 - Correios");
        historicoEncomendas.add("Encomenda recepcionada para a Cobertura 201 - Amazon");
        historicoEncomendas.add("Encomenda recepcionada para a Unidade 102 - Mercado Livre");

        System.out.println("--- 1. ArrayList (Histórico de Encomendas na Portaria) ---");
        for (String encomenda : historicoEncomendas) {
            System.out.println("-> " + encomenda);
        }

       
        Set<String> cpfsCadastrados = new HashSet<>();
        cpfsCadastrados.add("11111111111");
        cpfsCadastrados.add("98765432111");
        // Tentando inserir um CPF duplicado para testar a restrição do HashSet
        boolean duplicado = cpfsCadastrados.add("11111111111");

        System.out.println("\n--- 2. HashSet (Controle de CPFs Únicos de Moradores) ---");
        System.out.println("Tentativa de adicionar CPF duplicado ('11111111111') foi bem-sucedida? " + duplicado);
        System.out.println("CPFs únicos registrados no sistema:");
        for (String cpf : cpfsCadastrados) {
            System.out.println("-> CPF: " + cpf);
        }

        
        Map<Integer, String> moradoresPorUnidade = new HashMap<>();
        moradoresPorUnidade.put(101, "Carlos Silva");
        moradoresPorUnidade.put(102, "Mariana Costa");
        moradoresPorUnidade.put(201, "Ana Souza");

        System.out.println("\n--- 3. HashMap (Associação Rápida: Unidade -> Morador) ---");
        for (Map.Entry<Integer, String> entry : moradoresPorUnidade.entrySet()) {
            System.out.println("Unidade " + entry.getKey() + " pertence ao morador: " + entry.getValue());
        }

        
        int unidadeBusca = 201;
        System.out.println("\nBusca rápida no HashMap para a Unidade " + unidadeBusca + ":");
        System.out.println("-> Morador encontrado: " + moradoresPorUnidade.get(unidadeBusca));
    }
}
