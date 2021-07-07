package stream.es3;

import java.util.*;

public class VideoGioco implements Comparable <VideoGioco>{
    private final String id;
    private String nome;
    private final int coefficienteDiDifficolta;
    Set <Partita> partite=new TreeSet<>();
    Map<Utente,Set<Partita>> storyLocale =new TreeMap<>();//utente->una serie di punteggi


    public VideoGioco(String nome) {
        this.nome = nome;
        Random random = new Random();
        this.coefficienteDiDifficolta = random.nextInt(5);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCoefficienteDiDifficolta() {
        return coefficienteDiDifficolta;
    }


    @Override
    public String toString() {
        return "VideoGiochi{" +
                "nome='" + nome + '\'' +
                ", coefficienteDiDifficoltà=" + coefficienteDiDifficolta +
                ", partite" + partite+
                '}';
    }

    public Partita addPartita(Utente utente, double punteggio){
        return new Partita(punteggio, utente) ;

    }
    public void aggiornaClassifica(Utente utente, double punteggio){
        partite.add(addPartita(utente, punteggio));
        storyLocale.put(utente,partite);
    }

    @Override
    public int compareTo(VideoGioco o) {

        if(getCoefficienteDiDifficolta() > o.getCoefficienteDiDifficolta())

            return -1;


        if(getCoefficienteDiDifficolta() < o.getCoefficienteDiDifficolta())

            return 1;

        else

            return 0;

    }

}

