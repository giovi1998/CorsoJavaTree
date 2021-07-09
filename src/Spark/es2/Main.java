package Spark.es2;

import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Utente> utentiInbaseAlId = new HashMap<>();//id->utente
        Map<String, Spedizione> spedizioniInBaseAlId = new HashMap<>(); //id->Spedizione
        Gson gson = new Gson();


        /*Utente utente1 = new Utente("Giovanni","Cidu","Via Ada negri");
        String stringJson=gson.toJson(utente1,Utente.class);*/

        post("/creaUtente", (request, response) -> {

            String nome = request.queryParams("nome");
            String cognome = request.queryParams("cognome");
            String indirizzo = request.queryParams("indirizzo");

            if (nome.equalsIgnoreCase("")) {
                response.status(400);
                return "Hai Sbagliato a inserire nome";
            }

            if (cognome.equalsIgnoreCase("")) {
                response.status(400);
                return "Hai Sbagliato a inserire cognome";

            }
            if (indirizzo.equalsIgnoreCase("")) {
                response.status(400);
                return "Hai Sbagliato a inserire indirizzo";
            }
            Utente temp = new Utente(nome, cognome, indirizzo);
            utentiInbaseAlId.put(temp.getId(), temp);
            return "Fatto inserito!!";
        });

        post("/creaSpedizione", (request, response) -> {
            String idMittente = request.queryParams("idMittente");
            String idRicevente = request.queryParams("idRicevente");
            double peso = Double.parseDouble(request.queryParams("peso"));

            if (!utentiInbaseAlId.containsKey(idMittente)) {
                return "Hai sbagliato nel inserire id prima persona";
            }
            if (!utentiInbaseAlId.containsKey(idRicevente)) {
                return "Hai sbagliato nel inserire id seconda persona";
            }

            Utente utente1 = utentiInbaseAlId.get(idMittente);
            Utente utente2 = utentiInbaseAlId.get(idRicevente);
            Spedizione temp = new Spedizione(utente1, utente2, peso);
            spedizioniInBaseAlId.put(temp.getIdSpedizone(), temp);
            return "Fatto inserito!!";
        });

        get("/leggiSpedizioniInCorso", (request, response) -> {
            List<Spedizione> utenti = spedizioniInBaseAlId.values().stream().filter(spedizione -> spedizione.getStatoSpedizione().
                    equals(StatoSpedizione.inCosegna)).collect(Collectors.toList());
            response.type("application/json");
            response.status(200);
            return gson.toJson(utenti);
        });

        get("/leggiTutteLeSpedizioni", (request, response) -> {
            response.type("application/json");
            response.status(200);
            List<Spedizione> utenti = new ArrayList<>(spedizioniInBaseAlId.values());
            return gson.toJson(utenti);
        });

        get("/leggiUtenti", (request, response) -> {
            response.type("application/json");
            response.status(200);
            List<Utente> utenti = new ArrayList<>(utentiInbaseAlId.values());
            return gson.toJson(utenti);
        });

        delete("/rimuoviSpedizione", (request, response) -> {
            String idSpedizione = request.queryParams("idSpedizione");
            if (spedizioniInBaseAlId.containsKey(idSpedizione)) {
                Spedizione temp = spedizioniInBaseAlId.get(idSpedizione);
                if (temp.getStatoSpedizione().equals(StatoSpedizione.inCosegna)) {
                    String temporanea = "Hai eliminato " + gson.toJson(temp);
                    spedizioniInBaseAlId.remove(idSpedizione);
                    return temporanea;
                }
            }
            response.status(400);
            return "Hai Sbagliato l'id ";
        });

        post("/consegnaAvvenuta", (request, response) -> {
            String idSpedizione = request.queryParams("idSpedizione");
            if (spedizioniInBaseAlId.containsKey(idSpedizione)) {
                Spedizione temp = spedizioniInBaseAlId.get(idSpedizione);
                temp.setStatoSpedizione(StatoSpedizione.consegnato);

                return "Hai consegnato " + gson.toJson(temp);


            }
            return "Hai Sbagliato l'id ";
        });

        get("/leggiSpedizioniPerUtente", (request, response) -> {
            String idRicevente = request.queryParams("idRicevente");
            List<Spedizione> Spedizioni = spedizioniInBaseAlId.values().stream().
                    filter(spedizione -> spedizione.getRicevente().equals(utentiInbaseAlId.get(idRicevente))).
                    collect(Collectors.toList());
            return gson.toJson(Spedizioni);
        });
    }
}