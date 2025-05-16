public class Main {
    public static void main(String[] args) {
        GerenteContaDirector gerente = new GerenteContaDirector();

        ContaBancariaProduct contaCorrente = gerente.construirContaCompleta(
                new ContaCorrenteConcreteBuilder(), "João da Silva"
        );
        System.out.println(contaCorrente);

        ContaBancariaProduct contaPoupanca = gerente.construirContaSimples(
                new ContaPoupancaConcreteBuilder(), "Maria Oliveira"
        );
        System.out.println(contaPoupanca);
    }
}
