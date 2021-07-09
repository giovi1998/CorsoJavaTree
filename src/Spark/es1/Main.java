package Spark.es1;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.route.HttpMethod.*;
/*
public class Main {
    Gson gson = new Gson();
    Map<String, Prodotto> prodotti = new HashMap<>();
    path("/ecommerce" , () ->{
        path("/product", ()->{
            put("/add", (request, response) -> {

                Prodotto prodotto = gson.fromJson(request.body(), Prodotto.class);

                if(prodotti.containsKey(prodotto.getNome())){

                    response.status(400);
                    return "Prodotto già esistente";

                }

                prodotti.put(prodotto.getNome(), prodotto);
                response.status(200);
                return "Prodotto aggiunto correttamente";

            });

            delete("/remove", (request, response) -> {

                String nomeProdotto = request.queryParams("nome");

                if(!prodotti.containsKey(nomeProdotto)){

                    response.status(400);
                    return "Errore prodotto non presente";

                }

                prodotti.remove(nomeProdotto);
                response.status(200);
                return "Prodotto rimosso correttamente";


            });

            get("/available", (request, response) -> {

                response.type("application/json");
                response.status(200);
                return gson.toJson(prodotti);

            });

            post("/buy", (request, response) -> {

                String nomePorodotto = request.queryParams("nome");
                int quantita = Integer.parseInt(request.queryParams("quantita"));

                if (!prodotti.containsKey(nomePorodotto)) {

                    response.status(400);
                    return "Prodotto non presente";

                }

                if (prodotti.get(nomePorodotto).getQuantita() < quantita) {

                    response.status(400);
                    return "Quantità non disponibile";

                }

                prodotti.get(nomePorodotto).setQuantita(prodotti.get(nomePorodotto).getQuantita() - quantita);

                if (prodotti.get(nomePorodotto).getQuantita() == 0)

                    prodotti.remove(nomePorodotto);

                response.status(200);
                return "Prodotto acquistato";


            });


            get("/FindFor", (request, response) -> {

                String nomeProdotto = request.queryParams("nome");
                String descrizione = request.queryParams("descrizione");

                Map<String, Prodotto> prodottiSelezionati = prodotti.entrySet().stream().filter(stringProdottoEntry -> stringProdottoEntry.getKey().toLowerCase(Locale.ROOT).startsWith(nomeProdotto.toLowerCase(Locale.ROOT))).filter(stringProdottoEntry -> stringProdottoEntry.getValue().getDescrizione().toLowerCase(Locale.ROOT).startsWith(descrizione.toLowerCase(Locale.ROOT))).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

                response.status(200);
                response.type("application/json");
                return gson.toJson(prodottiSelezionati);

            });

            Spark.internalServerError("""
                        <body>
                        \t<h2>Devi inserire tutti i parametri!</h2>
                        </body>""");

        });
    });

}*/
