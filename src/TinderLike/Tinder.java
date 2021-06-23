package TinderLike;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Tinder {
    Set<Utente> utenti = new HashSet<Utente>();

    public Set<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(Set<Utente> utenti) {
        this.utenti = utenti;
    }

    public void aggiungiUtente(Utente utente, String interessi) {
        if (utenti.contains(utente)) {
            for (Utente i : utenti) {
                if (i.equals(utente)) setUnInteressi(i, interessi);
            }
        } else {
            utenti.add(utente);
            setUnInteressi(utente, interessi);
        }

    }


    public void setUnInteressi(Utente utente, String interessi) {

        utente.setInteressi(interessi);
    }

    public void cancellaUtente(Utente utente) {
        utenti.remove(utente);
    }

    public Utente utenteConPiuInteresse(Utente utente) {
        int count = 0;
        int index = 0;
        int massima = 0;

        for (Utente i : utenti) {
            if(i.equals(utente))continue;
            if (numeroMassimoDiInteressi(utente, i) >= massima) {
                massima = numeroMassimoDiInteressi(utente, i);
                index = count;
            }
            count++;
        }
        count=0;
        for (Utente i : utenti){
            if(index==count){
                return i;
            }
            count++;
        }
        return utente;
    }


    public int numeroMassimoDiInteressi(Utente utente1, Utente utente2) {
        HashSet<String> copia = new HashSet<>();
        copia.addAll(utente1.getInteressi());
        copia.retainAll(utente2.getInteressi());
        return copia.size();

    }

    @Override
    public String toString() {
        return "Tinder{" +
                "utenti=" + getUtenti() +
                '}';
    }
}
