package Erederidarietà.es3;

abstract class Prodotto {
    public String nomeProdotto;
    public double costo;

    public Prodotto(String nomeProdotto, double numero) {
        this.nomeProdotto = nomeProdotto;
        this.costo = numero;
    }

    abstract String getNomeProdotto();

    abstract void setNomeProdotto(String nomeProdotto);

    abstract double getCosto();

    abstract void setCosto(int costo);

}
