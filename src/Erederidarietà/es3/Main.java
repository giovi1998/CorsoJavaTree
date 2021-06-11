package Erederidarietà.es3;

public class Main {
    public static void main(String[] args) {
        Prodotto [] prodotti=new Prodotto[3];
        prodotti[0]=new Caffe("caffeMacchiato",0.5);
        prodotti[1]=new Capuccino("capuccino",1.0);
        prodotti[2]=new Caffe("caffe",5);
        Distributtore distributtore= new Distributtore(prodotti);
        System.out.println(distributtore);
        distributtore.caricaProdotto(new Caffe("caffelatte",0.5));
        System.out.println(distributtore);
        System.out.println(distributtore.cercaProdotto("caffelatte"));

        distributtore.saldoAttuale();
        distributtore.inserisciImporto(5);
        distributtore.acquistaProdotto("caffelatte");
        System.out.println(distributtore);
        System.out.println("saldo"+ distributtore.saldoAttuale());
        System.out.println("saldo restituito"+ distributtore.getResto());
        System.out.println("saldo "+ distributtore.saldoAttuale());
    }
}
