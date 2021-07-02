package stream.es2;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Utente,Integer> listaPersone= new TreeMap<>();
        Utente utente1=new Utente("Giovanni","Cidu",22,"sajhd","via Roma");
        Utente utente2=new Utente("Raffaele","Cidu",30,"ssdhncd","via Roma");
        Utente utente3=new Utente("Daniele","Cidu",62,"asopfakpdskd","via Roma");
        listaPersone.put(utente1,utente1.getEta());
        listaPersone.put(utente2,utente2.getEta());
        listaPersone.put(utente3,utente3.getEta());
        System.out.println(listaPersone);
    }
}
