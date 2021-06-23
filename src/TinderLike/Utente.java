package TinderLike;

import java.util.*;

public class Utente extends HashSet<String> {
    UUID idUtente;
    HashSet<String> interessi = new HashSet<>();

    public Utente(String interessi) {
        this.idUtente = UUID.randomUUID();
        this.interessi.add(interessi);
    }

    public Utente() {
        this.idUtente = UUID.randomUUID();
    }

    public UUID getIdUtente() {
        return idUtente;
    }

    public HashSet<String> getInteressi() {
        return interessi;
    }


    public void setInteressi(String interessi) {
        this.interessi.add(interessi);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Utente utente = (Utente) o;
        return idUtente.equals(utente.idUtente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idUtente);
    }

    @Override
    public String toString() {
        return "Utente{" +
                "idUtente=" + getIdUtente() +
                ", interessi='" + getInteressi() + '\'' +
                '}';
    }
}
