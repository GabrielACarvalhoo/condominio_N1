# 🏢 Sistema de Gestão de Condomínio

Sistema desenvolvido para auxiliar na administração de condomínios, centralizando informações e automatizando processos operacionais, de portaria, áreas comuns, manutenções, finanças e gestão de moradores[cite: 1].

---

## 👥 Grupo (POO N1-7)
* Gabriel Andrade[cite: 1]
* Gabriel Ribeiro[cite: 1]
* **Guilherme Bernardes**[cite: 1]
* Erick Gabriel[cite: 1]

---

## 🚀 Sobre o Projeto
O objetivo principal é otimizar a comunicação entre moradores e a administração, proporcionando um controle rigoroso de acesso, gerenciamento de encomendas, reservas de espaços comuns, controle de veículos/vagas, além de demandas financeiras e de infraestrutura[cite: 1].

O projeto está dividido em **12 módulos principais** estruturados em 6 agrupamentos lógicos[cite: 3]:

1. **Gestão de Acesso e Portaria:**
   * Controle e autorização de visitantes[cite: 1].
   * Gestão e rastreio de encomendas[cite: 1].
   * Registro de ocorrências da portaria[cite: 1].
2. **Gestão de Áreas Comuns e Lazer:**
   * Cadastro de espaços compartilhados (regras e capacidade)[cite: 1].
   * Sistema de reservas, aprovação e consulta de disponibilidade[cite: 1, 2].
3. **Gestão de Garagem:**
   * Cadastro de veículos e controle de vagas[cite: 2].
4. **Gestão de Manutenção e Infraestrutura:**
   * Abertura de chamados de reparos e manutenção[cite: 2].
   * Histórico de serviços executados e atualização de status[cite: 2].
5. **Gestão Administrativa:**
   * Gestão de moradores, inquilinos e unidades residenciais[cite: 2].
   * Gestão de funcionários e cargos[cite: 2].
   * Publicação de comunicados e disponibilização de documentos[cite: 2].
6. **Gestão Financeira:**
   * Consulta de taxas condominiais, acompanhamento de pagamentos e controle de inadimplência[cite: 2, 3].

---

## 🗄️ Modelagem de Dados (Banco de Dados Relacional)
O modelo físico e conceitual foi estruturado utilizando o **MySQL Workbench**, contemplando todas as tabelas normalizadas para suportar os módulos do sistema (incluindo chaves estrangeiras, restrições e regras de integridade).

* **Principais entidades:** `usuario`, `perfil`, `unidade`, `usuario_unidade`, `funcionario`, `cargo`, `visitante`, `autorizacao_visitante`, `registro_acesso`, `encomenda`, `ocorrencia`, `espaco_comum`, `reserva`, `vaga`, `veiculo`, `solicitacao_manutencao`, `servico_manutencao`, `comunicado`, `documento`, `taxa_condominial`, `pagamento` e `despesa`.

---

## 🛠️ Tecnologias Utilizadas
* **Banco de Dados:** MySQL / MySQL Workbench[cite: 9]
* **Linguagem (Backend / Lógica):** Java (Programação Orientada a Objetos - POO)[cite: 1, 14]
* **Controle de Versão:** Git & GitHub[cite: 14]

---

## 📋 Como Executar o Projeto

### 1. Banco de Dados (MySQL)
1. Certifique-se de ter o **MySQL** e o **MySQL Workbench** instalados.
2. Execute o script SQL estrutural do projeto para criar a base de dados `gestao_condominio` e todas as suas tabelas e relacionamentos iniciais[cite: 9].

### 2. Código em Java (Collections / POO)
Para executar as classes e estruturas desenvolvidas com Collections em Java (`ArrayList`, `HashSet`, `HashMap`)[cite: 14]:
1. Abra o projeto em sua IDE de preferência (como IntelliJ IDEA ou Eclipse).
2. Compile e execute o arquivo `.java` correspondente à entrega solicitada[cite: 14].

---

*Universidade Católica de Brasília (UCB) — Engenharia de Software*
