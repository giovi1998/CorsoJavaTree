package giorno6;

public class Main {

    public static void main(String[] args) {
        Lampadina lamp = new Lampadina();

        while(lamp.stato!=statoLampadina.rotto)
        {
            lamp.click();
        }


    }
}
