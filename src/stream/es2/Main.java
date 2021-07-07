package stream.es2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Map<Utente,Integer> listaPersone= new TreeMap<>();
        List <String> figli= new ArrayList<>();
        figli.add("filippo");
        figli.add("Giacomo");
        List <String> figli1= new ArrayList<>();
        figli1.add("rafaele");
        figli1.add("Giacomo");
        List <String> figli2= new ArrayList<>();
        figli2.add("rafaele");
        figli2.add("Melvin");
        Utente utente1 = new Utente("Giovanni", "Cidu", 22, "sajhd", "via Roma",figli);
        Utente utente2 = new Utente("Raffaele", "Cidu", 30, "ssdhncd", "via Roma",figli1);
        Utente utente3 = new Utente("Daniele", "Cidu", 62, "asopfakpdskd", "via Roma",figli2);
        Utente utente4 = new Utente("Melvin", "Cidu", 65, "dadadosilk", "via Roma",figli);
        Anagrafe anagrafe = new Anagrafe();
        anagrafe.aggiungiUtente(utente1);
        anagrafe.aggiungiUtente(utente2);
        anagrafe.aggiungiUtente(utente3);
        anagrafe.aggiungiUtente(utente4);

       // anagrafe.removeif("sajhd");
        System.out.println(anagrafe+ " stampa anagrafe");
        System.out.println(anagrafe.piuVecchi());
        System.out.println("Giovanni ->"+anagrafe.indizirizziInBaseANome("Giovanni"));
        System.out.println("Figli di Giovanni ->" + anagrafe.figliDiUtente("Giovanni"));
        //System.out.println(anagrafe.ricercaUtente("daniele"));



    }
}
