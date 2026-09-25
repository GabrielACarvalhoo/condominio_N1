# 🏢 Sistema de Gestão de Condomínio — Atividade Avaliativa POO

Documentação central do repositório contendo os artefatos, requisitos e código-fonte desenvolvidos para a unidade curricular de **Programação Orientada a Objetos (POO)**.

---

## 👥 Integrantes do Grupo (Grupo 7)

* Gabriel Andrade Carvalho
* Guilherme Bernardes Camilo
* Erick Gabriel Cardoso Oliveira
* Gabriel Ribeiro Gomes

---

## 📋 Resumo dos Itens da Avaliação

### Item 1 — Business Model Canvas (BMC)
* **Descrição:** Elaboração dos 9 blocos do BMC direcionados ao Sistema de Gestão de Condomínio, estruturando a proposta de valor, segmentos de clientes, fontes de receita e demais pilares do modelo de negócios.

### Item 2 — Wireframes e Prototipagem (Figma)
* **Descrição:** Mapeamento dos perfis de usuário (Síndico, Porteiro, Chefe de Manutenção, Moradores e Visitantes) e criação dos wireframes de baixa fidelidade no Figma, validados para acesso público em aba anônima.

### Item 3 — Pesquisa Bibliográfica em POO
* **Descrição:** Estudo teórico fundamentado nas referências da disciplina sobre os 4 pilares da Orientação a Objetos (*Abstração, Encapsulamento, Herança e Polimorfismo*), acompanhado de citações literais e tópicos para discussão.

### Item 4 — Projeto Java (`gestao-condominio`)
* **Descrição:** Desenvolvimento incremental de 20 exercícios práticos evolutivos em Java, consolidando conceitos de tipos primitivos, estruturas de decisão/repetição, criação de classes, encapsulamento, sobrescrita, sobrecarga e controle do fluxo da aplicação em um menu interativo.

---

## 📂 Estrutura do Repositório

O projeto está estruturado e organizado da seguinte forma:

```text
.
├── docs/                                 # Documentação e artefatos de entrega
│   ├── Business.Model.Canvas.-.Sistem... # Modelo de negócio do sistema
│   ├── ITEM3.md                          # Pesquisa bibliográfica de POO
│   ├── figma.md                          # Links e referências dos wireframes
│   └── grupo_7_docs.pdf                  # Documento oficial consolidado (Itens 1, 2 e 3)
│
├── src/
│   └── gestao/                           # Código-fonte do projeto Java
│       ├── App.java                      # Classe principal (Menu interativo e fluxo)
│       ├── Cobertura.java                # Subclasse especializada de Unidade
│       ├── Condominio.java               # Regras de caixa e recebimentos/despesas
│       ├── Funcionario.java              # Classe base de colaboradores
│       ├── Morador.java                  # Modelo de dados dos moradores
│       ├── Unidade.java                  # Modelo de dados e taxas condominiais
│       └── Zelador.java                  # Subclasse especializada de Funcionario
│
├── .gitignore                            # Arquivos ignorados pelo Git
└── README.md                             # Visão geral do repositório
