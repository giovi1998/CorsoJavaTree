package Erederidarietà.es3;

public class Caffe extends Prodotto{
    public String nomeProdotto;
    public double costo;
    public Caffe(String nomeProdotto, double numero) {
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
        return "Caffe{" +
                "nomeProdotto='" + nomeProdotto + '\'' +
                ", costo=" + costo +
                '}';
    }
}
