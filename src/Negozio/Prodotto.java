package Negozio;
public class Prodotto {
    private int quantita;
    private String nomeProdotto;
    private TipoProdotto tipo; //alimentari o non alimentari
    private float Prezzo;

    /**
     * Costruttore
     * @param quantita del prodotto particolare
     * @param nomeProdotto
     * @param prezzo
     * @param tipo
     */

    public Prodotto(int quantita, String nomeProdotto,float prezzo, TipoProdotto tipo) {
        this.quantita = quantita;
        this.nomeProdotto = nomeProdotto;
        this.tipo = tipo;
        this.Prezzo = prezzo;
    }

    /**
     *
     * @return Prezzo
     */
    public float getPrezzo() {
        return Prezzo;
    }

    /**
     * setta il Prezzo
     * @param prezzo
     */
    public void setPrezzo(int prezzo) {
        Prezzo = prezzo;
    }

    /**
     * Quante ce ne sono di prodotto
     * @return
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * Setta quanti prodotti ci sono
     * @param quantita
     */
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    /**
     *
     * @return nomeProdotto il nome dei prodotto
     */
    public String getNomeProdotto() {
        return nomeProdotto;
    }

    /**
     * mette il prodotto
     * @param nomeProdotto
     */
    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    /**
     * tipo di prodotto
     * @return tipo
     */
    public TipoProdotto getTipo() {
        return tipo;
    }

    /**
     * Setta il tipo
     * @param tipo
     */
    public void setTipo(TipoProdotto tipo) {
        this.tipo = tipo;
    }
}