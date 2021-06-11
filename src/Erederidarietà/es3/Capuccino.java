package Erederidarietà.es3;

public class Capuccino extends Prodotto {
    public String nomeProdotto;
    public double costo;

    public Capuccino(String nomeProdotto, double numero) {
        super(nomeProdotto, numero);
        this.nomeProdotto=nomeProdotto;
        this.costo =numero;
    }

    @Override
    public String getNomeProdotto() {
        return nomeProdotto;
    }

    @Override
    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    @Override
    public double getCosto() {
        return costo;
    }

    @Override
    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Capuccino{" +
                "nomeProdotto='" + nomeProdotto + '\'' +
                ", costo=" + costo +
                '}';
    }
}
