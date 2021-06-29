package EsThread.es1;


public class Main {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        Generatore gen = new Generatore(array);
        gen.addElementi(array);
        Sommatore s1 = new Sommatore(array,0,500000);
        Sommatore s2 = new Sommatore(array,500000,1000000);
        s1.start();
        int n=500;
        for (int i = 0; i <n ; i++) {

            System.out.println("ciao");
        }

        s2.start();
        

        try {
            s1.join();
            s2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } ;

        int sommaFinale = s1.somma+ s2.somma;
        System.out.println(sommaFinale);
    }
}
