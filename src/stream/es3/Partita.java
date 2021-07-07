package stream.es3;

import java.util.Objects;

public class Partita implements Comparable<Partita>{
    double punteggio;
    Utente utente;

    public Partita(double punteggio, Utente utente) {
        setPunteggio(punteggio);
        this.utente = utente;
    }

    public double getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(double punteggio) {
        this.punteggio = punteggio;
    }

    @Override
    public int compareTo(Partita o) {

        if(getPunteggio() > o.getPunteggio())

            return -1;


        if(getPunteggio() < o.getPunteggio())

            return 1;

        else

            return 0;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partita partita = (Partita) o;
        return Double.compare(partita.punteggio, punteggio) == 0 && Objects.equals(utente, partita.utente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(punteggio, utente);
    }

    @Override
    public String toString() {
        return "Partita{" +
                "punteggio=" + punteggio +
                ", utente=" + utente.getNome() +
                '}';
    }
}
