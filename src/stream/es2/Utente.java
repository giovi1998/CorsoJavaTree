package stream.es2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utente<compareTo>  implements Comparable<Utente> {
    private String nome;
    private String cognome;
    private int eta;
    private String codiceFiscale;
    private String indirizzo;

    private List<String> figli= new ArrayList<>();
    public Utente(String nome, String cognome, int eta, String codiceFiscale, String indirizzo,List<String> figli) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.figli= figli;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public List<String> getFigli() {
        return figli;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
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
