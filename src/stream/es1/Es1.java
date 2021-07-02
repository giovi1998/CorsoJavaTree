package stream.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class Es1 {
   List <String>nomi=new ArrayList<>();
   public void aggiungi(String nome){
       nomi.add(nome);
   }

    public List<String> getNomi() {
        return nomi;
    }

    @Override
    public String toString() {
        return "Es1{" +
                "nomi=" + getNomi() +
                '}';
    }

    public long restituisciNumLettere(){
       /*che contiene "f"
       return nomi.stream().filter(s->s.toLowerCase(Locale.ROOT).contains("m")).map(String::length).reduce(0, Integer::sum);
       */
        return nomi.stream().filter(s->s.toLowerCase(Locale.ROOT).startsWith("f")).map(String::length).reduce(0, Integer::sum);
    }

    public long restituisciNumLettereTuttaLaLista(){
       return nomi.stream().collect(Collectors.joining()).length();
    }
}
