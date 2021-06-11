package Erederidarietà.es3;

import java.util.Arrays;

public class Distributtore {
    private int numeroProdotto;
    private Prodotto[] prodotti;
    private double soldi;

    /**
     * soliti metodi di default
     *
     * @param prodotti in ingresso
     */
    public Distributtore(Prodotto[] prodotti) {
        this.numeroProdotto = prodotti.length;
        this.prodotti = prodotti;
    }

    public int getNumeroProdotto() {
        return numeroProdotto;
    }

    public void setNumeroProdotto(int numeroProdotto) {
        this.numeroProdotto = numeroProdotto;
    }

    public Prodotto[] getProdotti() {
        return prodotti;
    }

    public void setProdotti(Prodotto[] prodotti) {
        this.prodotti = prodotti;
    }

    public double saldoAttuale() {
        if (soldi == 0) {
            System.out.println("Non hai inserito soldi!!");
        }
        return soldi;
    }


    public void inserisciImporto(double soldi) {
        System.out.println("Quanti soldi vuoi inserire?");
        this.soldi = soldi;
    }

    public double getResto(){
        double temp=soldi;
        soldi=0;
        return temp;

    }
    /**
     * AGGIUNGE UN PRODOTTO TRA CAFFE E LATTE
     *
     */
    public void caricaProdotto(Prodotto prodotto) {
        if (prodotti == null) {

            prodotti = new Prodotto[1];
            prodotti[0] = prodotto;

        } else {
            Prodotto[] newProdotti = Arrays.copyOf(getProdotti(), prodotti.length + 1);
            newProdotti[prodotti.length] = prodotto;
            setProdotti(newProdotti);
            numeroProdotto++;
        }
    }

    public void eliminaProdotto(String nome)
    {
        if (prodotti == null) {
            System.out.println("non abbiamo prodotti");

        } else {
            Prodotto[] newProdotti = Arrays.copyOf(prodotti, prodotti.length -1);

            for(int i=0;i<prodotti.length;i++)
            {
                if(cercaProdotto(nome)){
                    continue;
                }
                newProdotti[i]=prodotti[i];
            }
            prodotti=newProdotti;
            setNumeroProdotto(numeroProdotto-1);
        }
    }

    public boolean cercaProdotto(String nome)
    {
        for (int i = 0; i < numeroProdotto; i++) {
            if (prodotti[i].nomeProdotto.equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public double cercaCostoProdotto(String nome) {
        for (int i = 0; i < numeroProdotto; i++) {
            if (prodotti[i].nomeProdotto.equals(nome)) {
                return prodotti[i].costo;
            }
        }
        return 0.0;
    }

    public void acquistaProdotto(String nome){
        if(cercaProdotto(nome) && cercaCostoProdotto(nome)!=0.0 && cercaCostoProdotto(nome)<= saldoAttuale()){
            System.out.println("hai comprato il "+ nome+" decremento il saldo...");
            this.soldi=soldi-cercaCostoProdotto(nome);
            eliminaProdotto(nome);
        }
    }

    @Override
    public String toString() {
        return "Distributtore{" +
                Arrays.toString(prodotti) +
                '}' + " numero prodotti " + getNumeroProdotto();
    }
}
