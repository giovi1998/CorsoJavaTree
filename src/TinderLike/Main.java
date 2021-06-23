package TinderLike;

public class Main {
    public static void main(String[] args) {
        Utente utente1=new Utente("calcetto");
        Utente utente2=new Utente("tennis");
        Utente utente3=new Utente("basket");
        Tinder tinder=new Tinder();

        tinder.aggiungiUtente(utente1,"daniele");
        tinder.aggiungiUtente(utente2,"calcetto");
        tinder.aggiungiUtente(utente3,"sda");
        tinder.aggiungiUtente(utente1,"raffaele");
        tinder.aggiungiUtente(utente2,"daniele");
        tinder.aggiungiUtente(utente3,"yari");



        System.out.println(utente1.getInteressi());
        System.out.println(utente2.getInteressi());
        System.out.println(utente3.getInteressi());
        System.out.println(tinder);

        System.out.println(tinder.utenteConPiuInteresse(utente1));
        tinder.cancellaUtente(utente1);


        System.out.println(tinder);
    }


}
