package stream.es3;

public class Main {
    public static void main(String[] args) {
        SalaGiochi salaGiochi=new SalaGiochi();
        VideoGioco videoGioco1=new VideoGioco("cod");
        VideoGioco videoGioco2=new VideoGioco("fifa");
        VideoGioco videoGioco3=new VideoGioco("minecraft");
        Utente utente1= new Utente("Gio");
        Utente utente2= new Utente("Dani");
        Utente utente3= new Utente("Rafa");
        salaGiochi.aggiungiVideoGioco(videoGioco1);
        salaGiochi.aggiungiVideoGioco(videoGioco2);
        salaGiochi.aggiungiVideoGioco(videoGioco3);
        salaGiochi.aggiungiUtente(utente1);
        salaGiochi.aggiungiUtente(utente2);
        salaGiochi.aggiungiUtente(utente3);
        //System.out.println(salaGiochi);
        salaGiochi.aggiungiPartita(utente1,videoGioco2,15.7);
        salaGiochi.aggiungiPartita(utente1,videoGioco2,15.7);
        salaGiochi.aggiungiPartita(utente1,videoGioco2,16.7);
        salaGiochi.aggiungiPartita(utente2,videoGioco2,76.7);
        salaGiochi.aggiungiPartita(utente2,videoGioco1,10.7);
        salaGiochi.aggiungiPartita(utente3,videoGioco3,90);
        System.out.println(salaGiochi.videoGiochi);
        System.out.println(salaGiochi);
        System.out.println(salaGiochi.topVideoGiochi());
    }
}
