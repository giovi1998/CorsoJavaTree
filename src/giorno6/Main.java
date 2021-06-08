package giorno6;

public class Main {

    public static void main(String[] args) {
        Lampadina lamp = new Lampadina();
        System.out.println(lamp.getStato());

        while(lamp.stato!=statoLampadina.rotto){
            lamp.click();

        }


    }
}
