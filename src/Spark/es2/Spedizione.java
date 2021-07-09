package Spark.es2;

import java.util.UUID;

public class Spedizione {
    private Utente mittente;
    private Utente ricevente;
    private double peso;
    private String idSpedizone;
    private StatoSpedizione statoSpedizione= StatoSpedizione.inCosegna;

    public Spedizione(Utente mittente, Utente ricevente, double peso) {
        this.mittente = mittente;
        this.ricevente = ricevente;
        this.peso = peso;
        this.idSpedizone= UUID.randomUUID().toString();
    }

    public StatoSpedizione getStatoSpedizione() {
        return statoSpedizione;
    }

    public void setStatoSpedizione(StatoSpedizione statoSpedizione) {
        this.statoSpedizione = statoSpedizione;
    }

    public Utente getMittente() {
        return mittente;
    }

    public void setMittente(Utente mittente) {
        this.mittente = mittente;
    }

    public Utente getRicevente() {
        return ricevente;
    }

    public void setRicevente(Utente ricevente) {
        this.ricevente = ricevente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getIdSpedizone() {
        return idSpedizone;
    }
}
enum StatoSpedizione{
    inCosegna,consegnato;
}
