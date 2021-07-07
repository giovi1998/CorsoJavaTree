package stream.es2;

import java.util.*;
import java.util.stream.Collectors;

public class Anagrafe {
    public Set<Utente> listaPersone;

    public Anagrafe() {
        this.listaPersone= new TreeSet<>();

    }

    public void aggiungiUtente(Utente utente)
    {
        listaPersone.add(utente);
    }

    public void removeif(String codiceFiscale){
        listaPersone.removeIf(ut->ut.getCodiceFiscale().contains(codiceFiscale));
    }
    public Set<Utente> ricercaUtente(String nome){
        //filtro i nomi
        return listaPersone.stream().filter(ut->ut.getNome().toLowerCase(Locale.ROOT).contains(nome.toLowerCase(Locale.ROOT))).collect(Collectors.toSet());

    }
    public Set<Utente> piuVecchi(){
        return listaPersone.stream().sorted().limit(2).collect(Collectors.toSet());
    }
    public List<String> indizirizziInBaseANome(String nome){
        return listaPersone.stream().filter(ut->ut.getNome().equals(nome)).map(Utente::getIndirizzo).collect(Collectors.toList());

    }

    public List figliDiUtente(String nome){
        return listaPersone.stream().filter(ut->ut.getNome().equals(nome)).map(Utente::getFigli).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Anagrafe{" +
                "listaPersone=" + listaPersone +
                '}';
    }
}
