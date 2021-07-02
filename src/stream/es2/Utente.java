package stream.es2;

import java.util.Objects;
import java.util.TreeMap;

public class Utente<compareTo>  implements Comparable<Utente> {
    private String nome;
    private String cognome;
    private int eta;
    private String codiceFiscale;
    private String indirizzo;

    public Utente(String nome, String cognome, int eta, String codiceFiscale, String indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return codiceFiscale.equals(utente.codiceFiscale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceFiscale);
    }

    @Override
    public int compareTo(Utente o) {

        if(getEta() > o.getEta())

            return -1;


        if(getEta() < o.getEta())

            return 1;

        else

            return 0;

    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}
