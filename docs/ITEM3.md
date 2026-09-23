# Pilares da Programação Orientada a Objetos (POO)

Resumo teórico produzido para a disciplina de Programação Orientada a Objetos, com base nas referências oficiais da biblioteca UCB.

## 📚 Referências

- SANTOS, Rafael. *Introdução à Programação Orientada a Objetos Usando Java*. Rio de Janeiro: Elsevier/Campus.
- MACHADO, Fabrício. *Paradigmas de Programação*.

---

### 1. Encapsulamento

* **Definição:**  
  Consiste em agrupar dados (atributos) e comportamentos (métodos) dentro de uma mesma estrutura (classe), ocultando os detalhes internos de implementação e restringindo o acesso direto ao estado do objeto. O mundo externo interage com o objeto apenas por meio de uma interface pública controlada.

* **Fundamentação Bibliográfica:**  
  > *"Encapsulamento é o processo de esconder todos os detalhes de um objeto que não contribuem para as suas características essenciais. Ele envolve a separação da interface de um objeto de sua implementação."*  
  > — **SANTOS, Rafael.** *Introdução à Programação Orientada a Objetos Usando Java*, Cap. 1, seção 1.4.

  > *"Encapsulamento [...] é um dos benefícios mais palpáveis de programação orientada a objetos."*  
  > — **SANTOS, Rafael.** *Introdução à Programação Orientada a Objetos Usando Java*, Cap. 1, seção 1.4.

* **Como funciona na prática:**  
  * Os atributos são declarados com modificador de acesso restrito (`private`).
  * O acesso e as modificações ocorrem exclusivamente via métodos públicos (*getters*, *setters* ou métodos de regra de negócio).
  * Permite validar os dados antes de alterar o estado do objeto (ex.: impedir depósitos negativos ou saldos inválidos).

* **Exemplo em Java:**
  ```java
  public class ContaBancaria {
      private double saldo; // Atributo privado / encapsulado

      public double getSaldo() {
          return saldo;
      }

      // Método público com validação de regra de negócio
      public void depositar(double valor) {
          if (valor > 0) {
              this.saldo += valor;
          }
      }
  }

**Por que importa:** evita que o estado interno do objeto seja corrompido por acessos externos descontrolados, aumentando a segurança e a manutenibilidade do código.

---

### 2. Herança

* **Definição:**  
  Mecanismo da orientação a objetos que permite que uma classe (subclasse ou classe filha) herde atributos (estado) e métodos (comportamento) de outra classe (superclasse ou classe mãe), estabelecendo uma relação hierárquica do tipo *"é um"* (*is-a*).

* **Fundamentação Bibliográfica:**  
  > *"A herança é um mecanismo que permite a criação de novas classes a partir de classes previamente existentes, herdando seus atributos e métodos, e permitindo a adição de novas funcionalidades ou a modificação do comportamento herdado."*  
  > — **SANTOS, Rafael.** *Introdução à Programação Orientada a Objetos Usando Java*, Cap. 7 (Herança).

* **Como funciona na prática:**  
  * Em Java, a herança é declarada utilizando a palavra-chave `extends`.
  * A subclasse adquire os atributos e métodos não privados da superclasse, podendo reaproveitá-los ou adicionar novas características específicas.
  * A palavra-chave `super` é utilizada para acessar construtores ou métodos da classe mãe.
  * Promove o reuso de código e evita a duplicidade no sistema.

* **Exemplo em Java:**
  ```java
  // Superclasse (Classe Mãe)
  public class Funcionario {
      private String nome;
      protected double salarioBase;

      public Funcionario(String nome, double salarioBase) {
          this.nome = nome;
          this.salarioBase = salarioBase;
      }

      public double calcularSalario() {
          return this.salarioBase;
      }
  }

  // Subclasse (Classe Filha) - herda estado e comportamento e adiciona novos membros
  public class Zelador extends Funcionario {
      private String turno;

      public Zelador(String nome, double salarioBase, String turno) {
          super(nome, salarioBase); // Invoca o construtor da superclasse
          this.turno = turno;
      }

      public String getTurno() {
          return turno;
      }
  }

**Por que importa:** promove reuso de código e organização hierárquica entre entidades relacionadas do domínio do problema.

---

### 3. Polimorfismo

* **Definição:**  
  Capacidade de um mesmo método produzir comportamentos diferentes dependendo da instância do objeto que o executa em tempo de execução. Derivado do grego ("muitas formas"), permite tratar objetos de subclasses distintas de maneira genérica e uniforme por meio de uma referência comum da superclasse ou interface.

* **Fundamentação Bibliográfica:**  
  > *"Polimorfismo é a capacidade de um mesmo método ser executado de maneiras diferentes dependendo da classe do objeto ao qual a mensagem é enviada em tempo de execução."*  
  > — **SANTOS, Rafael.** *Introdução à Programação Orientada a Objetos Usando Java*, Cap. 8.

* **Como funciona na prática:**  
  * É implementado principalmente por meio da **sobrescrita de métodos** (`@Override`), na qual a subclasse redefine a implementação de um método herdado da superclasse.
  * Permite o uso de **ligação dinâmica** (*dynamic binding*): a JVM decide qual versão do método executar apenas no momento da execução, com base no objeto real instanciado na memória, e não no tipo da variável declarada.
  * *Nota explicativa:* Embora a sobrecarga de métodos (*overload*) seja por vezes categorizada como polimorfismo estático, o pilar fundamental da POO assenta no polimorfismo dinâmico via sobrescrita.

* **Exemplo em Java:**
  ```java
  // Superclasse
  public class Funcionario {
      protected double salarioBase;

      public Funcionario(double salarioBase) {
          this.salarioBase = salarioBase;
      }

      public double calcularSalario() {
          return this.salarioBase;
      }
  }

  // Subclasse redefine/sobrescreve o comportamento
  public class Zelador extends Funcionario {
      public Zelador(double salarioBase) {
          super(salarioBase);
      }

      @Override
      public double calcularSalario() {
          return super.calcularSalario() * 1.10; // Adicional de 10%
      }
  }

  // Demonstração do Polimorfismo na prática
  public class TestePolimorfismo {
      public static void main(String[] args) {
          // Referência do tipo da superclasse recebendo uma instância da subclasse
          Funcionario f = new Zelador(3000.0);
          
          // O método executado será o do Zelador (com adicional), decidido em tempo de execução
          System.out.println(f.calcularSalario()); // Saída: 3300.0
      }
  }


**Por que importa:** permite tratar objetos de tipos diferentes de forma uniforme (via uma superclasse ou interface comum), tornando o código mais flexível e extensível.

---

### 4. Abstração

* **Definição:**  
  Processo mental de isolar as características e comportamentos essenciais de uma entidade do mundo real relevantes para o contexto do sistema, ignorando detalhes irrelevantes ou particularidades de implementação. Foca-se no *"o que"* o objeto faz, em vez de *"como"* ele faz.

* **Fundamentação Bibliográfica:**  
  > *"Abstração é a capacidade de representar as características essenciais de um objeto do mundo real no contexto da aplicação, ignorando os detalhes acidentais ou irrelevantes para o problema em questão."*  
  > — **SANTOS, Rafael.** *Introdução à Programação Orientada a Objetos Usando Java*, Cap. 1.

* **Como se implementa na prática:**  
  * **Classes Abstratas:** Estruturas base que não podem ser instanciadas diretamente (`new`) e que servem como modelos para subclasses, podendo conter métodos abstratos (sem corpo) e métodos concretos.
  * **Interfaces:** Contratos puros de comportamento que definem o conjunto de métodos que uma classe concreta obrigatoriamente deve implementar.

* **Exemplo em Java:**
  ```java
  // Classe abstrata - define o modelo genérico (não pode ser instanciada diretamente)
  public abstract class FormaGeometrica {
      // Método abstrato: define O QUE deve ser feito, sem implementar COMO
      public abstract double calcularArea();
  }

  // Classe concreta - fornece a implementação específica do conceito abstrato
  public class Retangulo extends FormaGeometrica {
      private double largura;
      private double altura;

      public Retangulo(double largura, double altura) {
          this.largura = largura;
          this.altura = altura;
      }

      @Override
      public double calcularArea() {
          return this.largura * this.altura;
      }
  }

**Por que importa:** simplifica a complexidade do sistema, permitindo pensar em termos de conceitos gerais antes de se preocupar com os detalhes de implementação.

---
