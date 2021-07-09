package Spark.es1;

public class Prodotto {
    private String nome;
    private String descrizione;
    private int quantita;

    public Prodotto(String nome, String descrizione, int quantita) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.quantita = quantita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
