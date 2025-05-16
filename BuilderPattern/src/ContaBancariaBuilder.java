// BUILDER: Esta classe abstrata ou interface  que define todas
// as etapas que devem ser executadas para criar corretamente o
// produto(definir o titular, ativar ou nao cartao de debito ou
// credito, habilitar internet banking, etc). O método GetConta
// é usado para devolver o produto final.
public interface ContaBancariaBuilder {
        ContaBancariaBuilder setTitular(String nome);
        ContaBancariaBuilder configurarCartaoDebito();
        ContaBancariaBuilder configurarCartaoCredito();
        ContaBancariaBuilder configurarChequeEspecial();
        ContaBancariaBuilder configurarInternetBanking();
        ContaBancariaProduct getConta();
}
