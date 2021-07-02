package stream.es1;

public class Main {
    public static void main(String[] args) {
        Es1 es1 = new Es1();
        es1.aggiungi("Giovanni");
        //System.out.println(es1.restituisciNumLettere());
        es1.aggiungi("Raffaele");
        es1.aggiungi("Filippo");
        // System.out.println(es1.restituisciNumLettere());

       /* System.out.println(es1);
        System.out.println(es1.restituisciNumLettereTuttaLaLista());*/
        es1.aggiungi("Melvin");
        System.out.println(es1.restituisciNumLettereTuttaLaLista());
        System.out.println(es1.restituisciNumLettere());
        System.out.println(es1);
    }

}
