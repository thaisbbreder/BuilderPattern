# Builder
## O QUE É:
O padrão de projeto Builder(criacional), conforme definido pelos autores da Gang of Four, tem como objetivo principal separar a construção de um objeto complexo da sua representação, permitindo que o mesmo processo de construção possa criar diferentes representações. Essa abordagem se mostra especialmente útil quando se deseja desacoplar a lógica de criação da lógica de uso do objeto.

### POR QUE USAR:
O padrão Builder é útil quando a criação de objetos exige um processo complexo, com muitos parâmetros ou a composição de outros objetos. Criar esses objetos diretamente no código cliente pode resultar em construções difíceis de ler e manter. O Builder resolve esse problema ao separar a lógica de construção em uma estrutura dedicada, tornando o código cliente mais limpo e coeso.

Embora o Builder aumente a complexidade do sistema, especialmente quando há muitos Builders ou objetos complexos, essa complexidade é compensada pela melhoria na organização, legibilidade e manutenção do código.

## ESTRUTURA:
![image](https://github.com/user-attachments/assets/a562cf52-24b0-4107-85b7-1ccdb88af7e2)

O padrão de projeto **Builder** tem como principal objetivo **separar a construção de um objeto complexo da sua representação final**, permitindo que o mesmo processo de construção possa criar diferentes representações. A estrutura desse padrão é composta por alguns elementos principais que colaboram entre si para alcançar essa separação de responsabilidades.

A peça central é o **Builder**, que pode ser implementado como uma **interface** ou como uma **classe abstrata**. Independentemente da forma, sua função é **definir um contrato comum para os Builders concretos**, estabelecendo os métodos necessários para construir as partes de um objeto. Por exemplo, caso um objeto deva ser construído em três etapas — A, B e C —, o Builder deve definir esses métodos como obrigatórios para qualquer classe que o implemente. Essa abordagem garante que **todos os Builders concretos seguirão a mesma estrutura de construção**, ainda que cada um a implemente de forma diferente.

Em seguida, há o **ConcreteBuilder**, que representa a **implementação concreta do contrato definido pelo Builder**. Essa classe é responsável pela **lógica específica de construção das partes do objeto** e também por armazenar a montagem progressiva do produto final. É nela que se define o método **GetResult**, que retorna o objeto montado ao final do processo. Esse método **não é definido na interface ou classe abstrata**, pois o tipo e a estrutura do produto final podem variar entre diferentes Builders, o que impossibilita generalizar esse retorno.

O objeto que está sendo construído é representado pela classe **Product**. Ele é o **resultado da composição das partes criadas pelas chamadas aos métodos do Builder**. Sua estrutura pode variar de acordo com a aplicação, sendo flexível e adaptável a diferentes contextos.

Complementando essa estrutura, existe a classe **Director**. Embora seu uso não seja obrigatório, ela tem a função de **orquestrar a construção do objeto**, executando os métodos do Builder na ordem correta. Essa organização é especialmente útil quando há uma sequência de passos que deve ser respeitada para garantir a integridade do objeto final. O uso do Director também contribui para **encapsular o processo de construção**, escondendo-o do código cliente. Assim, em vez de o cliente precisar conhecer todas as etapas necessárias para construir o objeto, basta chamar um método do Director, como **Construct**, que internamente realiza todas as etapas de forma ordenada e consistente.

Essa abordagem traz **flexibilidade e modularidade ao projeto**, tornando o código mais **limpo, reutilizável e fácil de manter**, principalmente quando há **múltiplas variações de construção para um mesmo tipo de objeto**.

## EXPLICAÇÃO DA IMPLEMENTAÇÃO PARA CONTA BANCARIA

## 🏗️ Intenção
O Builder é um padrão de design criacional que permite construir objetos complexos passo a passo, como uma conta bancária.  
O padrão permite criar diferentes tipos e representações de contas usando o mesmo código de construção.

Além disso, ele separa a estrutura da conta (se tem cartão, se tem cheque especial, etc.) do processo de criação.  
Assim, o mesmo processo pode gerar contas diferentes, como Conta Corrente ou Conta Poupança.

## ❗ Problema
Imagine que queremos criar uma classe `ContaBancaria`.  
Para uma conta simples, talvez só precisamos de nome do titular e cartão de débito.  
Mas se for uma conta mais completa, podemos ter:

- Cartão de crédito
- Cheque especial
- Internet banking
- Limite de crédito
- Outros serviços bancários...

Uma solução simples seria criar subclasses como `ContaCorrente`, `ContaPoupanca`, `ContaEmpresarial`, etc.  
Mas isso nos levaria a uma **explosão de subclasses** para cobrir todas as combinações possíveis.

Outra opção seria criar um **grande construtor cheio de parâmetros** na classe `ContaBancaria`, como:

```java
public ContaBancaria(String titular, boolean debito, boolean credito, boolean cheque, boolean online, ...)
```

Mas isso tornaria a classe difícil de usar e manter. Muitos parâmetros nem sempre serão utilizados.
Por exemplo, uma conta poupança geralmente não tem cheque especial nem cartão de crédito. 

**Aplicando o Builder, ficaria assim:**
### **Product (ContaBancaria)**  
A classe `ContaBancaria` define o tipo do objeto complexo que está sendo criado.  
Ela contém os atributos como:

- titular
- tipo da conta
- se tem cartão de débito, crédito, cheque especial, internet banking

Essa classe **não sabe como ela será construída** — apenas define o que ela é.
A construção da ContaBancariaProduct é feita por meio de builders concretos:
- ContaCorrenteConcreteBuilder
- ContaPoupancaConcreteBuilder<br><br>
Esses builders implementam a interface ContaBancariaBuilder, que define os passos de construção. 
O produto final é o mesmo tipo (ContaBancariaProduct), mas com representações diferentes, dependendo de como o builder concreto configura os atributos.

---

### **Builder (ContaBancariaBuilder)**  
É uma **interface** que declara todos os **passos necessários** para montar uma conta bancária.

Esses passos incluem:

- Definir o titular
- Ativar ou não cartão de débito
- Ativar ou não crédito
- Ativar ou não cheque especial
- Habilitar internet banking
- Obter o produto final com `getConta()`

Ela define o **contrato que todos os builders concretos devem seguir**.

---

### **ConcreteBuilder (ContaCorrenteBuilder, ContaPoupancaBuilder)**  
São as classes que **implementam o processo de construção de forma específica**.

Por exemplo:

- `ContaCorrenteBuilder` ativa todos os serviços.
- `ContaPoupancaBuilder` ativa apenas o essencial.

Cada builder monta a `ContaBancaria` de acordo com a **regra de negócio de cada tipo de conta**.

---

### **Director (GerenteConta)**  
A classe `GerenteConta` **coordena o processo de construção**.

Ela chama os métodos do builder na **ordem correta**, e pode ter métodos prontos como:

- `construirContaCompleta(...)`
- `construirContaSimples(...)`

Ela sabe **a sequência dos passos**, mas não os detalhes de cada tipo de conta.  
Assim, podemos criar contas diferentes com a mesma lógica de montagem.
