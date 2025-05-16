//CONCRETE BUILDER: Poderão haver várias classes de builder concretas herdadas do builder ou que implementam a interface builder. Essas classes contêm a funcionalidade para criar um produto complexo específico, ou seja, implementam o processo de construção de forma específica.
//Cada builder monta a ContaBancaria de acordo com a regra de negócio de cada tipo de conta.

public class ContaCorrenteConcreteBuilder implements ContaBancariaBuilder {
    private ContaBancariaProduct conta = new ContaBancariaProduct();

    public ContaCorrenteConcreteBuilder() {
        conta.setTipo("Conta Corrente");
    }

    public ContaBancariaBuilder setTitular(String nome) {
        conta.setTitular(nome);
        return this;
    }

    public ContaBancariaBuilder configurarCartaoDebito() {
        conta.setCartaoDebito(true);
        return this;
    }

    public ContaBancariaBuilder configurarCartaoCredito() {
        conta.setCartaoCredito(true);
        return this;
    }

    public ContaBancariaBuilder configurarChequeEspecial() {
        conta.setChequeEspecial(true);
        return this;
    }

    public ContaBancariaBuilder configurarInternetBanking() {
        conta.setInternetBanking(true);
        return this;
    }

    public ContaBancariaProduct getConta() {
        return conta;
    }
}
