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

## 2. Herança

**Definição:** Mecanismo que permite que uma classe (subclasse/filha) reaproveite atributos e métodos de outra classe (superclasse/mãe), estabelecendo uma relação hierárquica do tipo "é um" (*is-a*).

**Como funciona na prática:**
- Em Java, usa-se a palavra-chave `extends`
- A subclasse pode sobrescrever (*override*) métodos herdados
- Reduz duplicação de código

```java
public class Animal {
    public void emitirSom() {
        System.out.println("Som genérico de animal");
    }
}

public class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Latido");
    }
}
```

**Por que importa:** promove reuso de código e organização hierárquica entre entidades relacionadas do domínio do problema.

---

## 3. Polimorfismo

**Definição:** Capacidade de um mesmo método/mensagem produzir comportamentos diferentes dependendo do objeto que o executa. A palavra vem do grego e significa "muitas formas".

**Tipos principais:**
- **Sobrescrita (*override*):** subclasses redefinem um método herdado (ver exemplo do `Cachorro` acima)
- **Sobrecarga (*overload*):** vários métodos com o mesmo nome, mas assinaturas diferentes, na mesma classe

```java
public class Calculadora {
    public int somar(int a, int b) {
        return a + b;
    }

    public double somar(double a, double b) {
        return a + b;
    }
}
```

**Por que importa:** permite tratar objetos de tipos diferentes de forma uniforme (via uma superclasse ou interface comum), tornando o código mais flexível e extensível.

---

## 4. Abstração

**Definição:** Processo de focar no que um objeto faz, ocultando os detalhes de como ele faz. Trata-se de modelar apenas os aspectos relevantes para o problema, ignorando particularidades desnecessárias.

**Como se implementa:**
- **Classes abstratas** — não podem ser instanciadas diretamente e podem conter métodos sem implementação
- **Interfaces** — contratos que definem o que uma classe deve fazer, sem dizer como

```java
public abstract class FormaGeometrica {
    public abstract double calcularArea(); // sem implementação
}

public class Retangulo extends FormaGeometrica {
    private double largura, altura;

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}
```

**Por que importa:** simplifica a complexidade do sistema, permitindo pensar em termos de conceitos gerais antes de se preocupar com os detalhes de implementação.

---

## 📖 Citação escolhida

> *"Encapsulamento [...] é um dos benefícios mais palpáveis de programação orientada a objetos." — SANTOS, Rafael. Introdução à Programação Orientada a Objetos usando Java, Cap. 1, seção 1.4 (Encapsulamento).*
