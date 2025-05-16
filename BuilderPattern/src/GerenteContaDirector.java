//A classe director controla o algoritmo que gera o objeto do produto final. Um objeto director é instanciado e seu método Builder é chamado. O método inclui um parâmetro para capturar o objeto específico do ConcreteBuilder que deve ser usado para gerar o produto. O director chama os métodos do ConcreteBuilder na ordem correta para gerar o objeto do produto. Na conclusão do processo, o método GetConta do objeto builder pode ser usado para retornar o produto final.
public class GerenteContaDirector {
    public ContaBancariaProduct construirContaCompleta(ContaBancariaBuilder builder, String titular) {
        return builder
                .setTitular(titular)
                .configurarCartaoDebito()
                .configurarCartaoCredito()
                .configurarChequeEspecial()
                .configurarInternetBanking()
                .getConta();
    }

    public ContaBancariaProduct construirContaSimples(ContaBancariaBuilder builder, String titular) {
        return builder
                .setTitular(titular)
                .configurarCartaoDebito()
                .configurarInternetBanking()
                .getConta();
    }
}
