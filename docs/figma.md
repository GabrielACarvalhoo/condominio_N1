# 🏢 Sistema de Gestão Condominial — Documentação de UX/UI & Wireframes

## 🎨 Protótipo e Wireframes no Figma

🔗 **Acesse o projeto completo no Figma:** [https://www.figma.com/make/Uc0TzOa6sKBdSimsg0rgEi/Wireframes-para-Gest%C3%A3o-de-Condom%C3%ADnio](https://www.figma.com/make/Uc0TzOa6sKBdSimsg0rgEi/Wireframes-para-Gest%25C3%25A3o-de-Condom%25C3%25ADnio?code-node-id=0-6&p=f&t=bWOWpZj4oX4qri3u-0&fullscreen=1)

---

## 🖥️ Mapeamento e Detalhamento das Telas

### 1. Painel do Síndico / Gestão Executiva (Web Dashboard - Desktop)

O **Dashboard do Síndico** centraliza os principais indicadores financeiros e pendências operacionais em uma interface limpa e intuitiva, permitindo decisões rápidas.

<img width="979" height="615" alt="image" src="https://github.com/user-attachments/assets/7615ba49-5e8d-4f15-92f6-4aa02cf5fd75" />

#### 🔍 Principais Funcionalidades e Componentes:

* **Métricas Financeiras no Topo (KPIs):**

  * **Receitas do Mês:** Exibição do total arrecadado (ex: *R$ 48.320,00* com variação percentual vs. mês anterior).
  * **Despesas do Mês:** Acompanhamento dos custos operacionais (*R$ 31.750,00*).
  * **Taxa de Inadimplência:** Indicador em tempo real (*8,4% - 12 unidades em aberto*).
* **Distribuição de Despesas:** Gráfico de rosca detalhando os custos por categoria (Manutenção: 35%, Pessoal: 40%, Consumo: 25%).
* **Mural de Avisos Recentes:** Atalho para criar novos comunicados (*Manutenção do Elevador, Regras da Piscina, Assembleia Geral*).
* **Pendências de Aprovação:** Tabela de solicitações de compras e serviços (ex: *Materiais, Pintura, Jardinagem*) com ações diretas de **Aprovar** ou **Rejeitar**.

---

### 2. Aplicativo do Morador (Mobile App - iOS/Android)

O **App do Morador** foca em autonomia e autoatendimento, reunindo os serviços essenciais na palma da mão para evitar chamados desnecessários à administração.

<p align="center">
<img width="866" height="589" alt="image" src="https://github.com/user-attachments/assets/385c25c4-7c1b-40c2-ad2c-348417c011b2" />

</p>

#### 🔍 Principais Funcionalidades e Componentes:

* **Card Financeiro em Destaque:** Exibição do próximo boleto a vencer (ex: *R$ 680,00*), botão direto para **Pagar via Pix/Boleto** ou **Copiar Código de Barras**.
* **Mural de Avisos Urgentes:** Notificações em tempo real sobre interrupções de serviços no prédio (ex: *Interrupção no fornecimento de água*).
* **Grade de Acesso Rápido (Grid de Serviços):**

  * 📅 **Reservas:** Solicitação de salão de festas e churrasqueiras.
  * 📦 **Encomendas:** Notificação de pacotes recebidos na portaria.
  * ⚠️ **Ocorrências:** Registro e acompanhamento de chamados.
  * 👥 **Assembleias:** Participação e votações virtuais.
  * 🚗 **Visitantes:** Liberação prévia de convidados e prestadores.
  * 📹 **Câmeras:** Visualização ao vivo do circuito interno.
* **Navegação Inferior (Tab Bar):** Navegação fluida entre *Início, Financeiro, Serviços e Perfil*.

---

### 3. Terminal da Portaria (Web Terminal - Tablet/Desktop)

O **Terminal de Portaria** foi desenvolvido para ser operado com rapidez e precisão pelos porteiros, focado em segurança e registro instantâneo de movimentações.

<img width="902" height="592" alt="image" src="https://github.com/user-attachments/assets/34b43967-3688-41f4-b620-108e26e30416" />

#### 🔍 Principais Funcionalidades e Componentes:

* **Controle de Visitantes (Entrada/Saída):**

  * Tabela com horário, nome do visitante, unidade/apartamento e status.
  * Ações rápidas para registrar **Entrada** ou **Registrar Saída** com um clique.
  * Busca global por nome ou documento.
* **Registro Digital de Encomendas (Correspondências):**

  * Lista de pacotes e cartas pendentes de retirada.
  * Notificação direta ao condômino e botão de **Confirmar Entrega** ao morador.
* **Módulo de Emergência:**

  * **Botão de Pânico:** Destaque em caso de ocorrências ou urgências de segurança no condomínio.

---

## 🛠️ Tecnologias e Ferramentas

* **Prototipação & UX/UI:** [Figma](https://figma.com)
* **Modelagem de Negócio:** Business Model Canvas (BMC)
* **Documentação & Versionamento:** Markdown, Git, GitHub



