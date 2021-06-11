package Erederidarietà.es4;

public class Main {
    public static void main(String[] args) {



        Prenotazione [] prenotazioni= new Prenotazione[2];
        prenotazioni[0]=new SingolaPrenotazione("sjadhasd",tipoPrenotazione.interno);
        prenotazioni[1]=new GruppoPrenotazione("khsad7320",15);
        GestorePrenotazione miniGestore= new GestorePrenotazione(prenotazioni);
        System.out.println(miniGestore);


        miniGestore.caricaPrenotazione(new SingolaPrenotazione("sa3333",tipoPrenotazione.interno));
        System.out.println(miniGestore);
        System.out.println(miniGestore.caricaPrenotazione(new GruppoPrenotazione("sa3233",20)));
        System.out.println(miniGestore);
        miniGestore.caricaPrenotazione(new GruppoPrenotazione("melvin",10));

    }

}
