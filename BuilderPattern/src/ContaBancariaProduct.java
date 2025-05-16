//Essa classe é a product, ela define o tipo do objeto complexo que deve ser gerado pelo padrão do construtor.
public class ContaBancariaProduct {
   private String tipo;
    private String titular;
    private boolean cartaoDebito;
    private boolean cartaoCredito;
    private boolean chequeEspecial;
    private boolean internetBanking;

    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setTitular(String titular) { this.titular = titular; }
    public void setCartaoDebito(boolean cartaoDebito) { this.cartaoDebito = cartaoDebito; }
    public void setCartaoCredito(boolean cartaoCredito) { this.cartaoCredito = cartaoCredito; }
    public void setChequeEspecial(boolean chequeEspecial) { this.chequeEspecial = chequeEspecial; }
    public void setInternetBanking(boolean internetBanking) { this.internetBanking = internetBanking; }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "tipo='" + tipo + '\'' +
                ", titular='" + titular + '\'' +
                ", cartaoDebito=" + cartaoDebito +
                ", cartaoCredito=" + cartaoCredito +
                ", chequeEspecial=" + chequeEspecial +
                ", internetBanking=" + internetBanking +
                '}';
    }
}

