public class ContaPoupancaConcreteBuilder implements ContaBancariaBuilder {
    private ContaBancariaProduct conta = new ContaBancariaProduct();

    public ContaPoupancaConcreteBuilder() {
        conta.setTipo("Conta Poupança");
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
        conta.setCartaoCredito(false);
        return this;
    }

    public ContaBancariaBuilder configurarChequeEspecial() {
        conta.setChequeEspecial(false);
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