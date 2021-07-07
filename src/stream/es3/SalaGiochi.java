package stream.es3;

import java.util.*;
import java.util.stream.Collectors;


public class SalaGiochi {
    Set<Utente> utenti = new HashSet<>();
    Set<VideoGioco> videoGiochi = new HashSet<>();
    Queue<Partita> partiteGiocate = new LinkedList<>();//restituisce tutte le partite

    public void aggiungiUtente(Utente utente) {
        utenti.add(utente);
    }

    public void aggiungiVideoGioco(VideoGioco videoGioco) {
        videoGiochi.add(videoGioco);
    }

    public void aggiungiPartita(Utente utente, VideoGioco videoGioco, double punteggio) {
        if (!utenti.contains(utente) && videoGiochi.contains(videoGioco)) {
            System.out.println("Non è presente l'utente lo inserisco");
            aggiungiUtente(utente);
        }
        if (utenti.contains(utente) && !videoGiochi.contains(videoGioco)) {
            System.out.println("Non è presente il videoGioco lo inserisco");
            aggiungiVideoGioco(videoGioco);
        }


        for (VideoGioco i : videoGiochi) {
            if (i.equals(videoGioco) && utenti.contains(utente)) {
                try {
                    partiteGiocate.add(i.addPartita(utente, punteggio));
                    i.aggiornaClassifica(utente, punteggio);
                } catch (NullPointerException n) {
                    System.out.println(n);

                }

            }
        }


    }

    public List<Partita> topPunteggi(int count) {
        if (count > partiteGiocate.stream().count()) {
            System.out.println("hai sbagliato qualcosa");
        } else {
            return partiteGiocate.stream().limit(count).sorted().collect(Collectors.toList());
        }
        return null;
    }





    //vorrei che restituise quello con il punteggio più alto
    public Optional<Map.Entry<Utente, Partita>> topVideoGiochi() {
        return videoGiochi.stream()
                .map(videoGioco -> videoGioco.storyLocale.entrySet())
                .flatMap(s->s.stream())
                .map(s->Map.entry(s.getKey(), s.getValue().stream().collect(Collectors.toList()).get(0)))
                .sorted((a,b)-> Double.compare(a.getValue().getPunteggio(), b.getValue().getPunteggio()))
                .findFirst();
    /*double max=0;
        for (VideoGioco i : videoGiochi){
            if(i.partite.stream().findFirst().get().getPunteggio()>max)max=i.partite.stream().findFirst().get().getPunteggio();
        }
        return videoGiochi.stream().findFirst().get();*/
    }








    public Set<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(Set<Utente> utenti) {
        this.utenti = utenti;
    }

    public Set<VideoGioco> getVideoGiochi() {
        return videoGiochi;
    }

    public void setVideoGiochi(Set<VideoGioco> videoGiochi) {
        this.videoGiochi = videoGiochi;
    }

    public Queue<Partita> getPartiteGiocate() {
        return partiteGiocate;
    }

    public void setPartiteGiocate(Queue<Partita> partiteGiocate) {
        this.partiteGiocate = partiteGiocate;
    }

    @Override
    public String toString() {
        return "SalaGiochi{" +
                "Numero di partiteGiocate in tutta la sala giochi -> " + partiteGiocate.stream().count() +'}';
    }
}
