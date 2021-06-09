package giorni.giorno2;

public class Esercizio11 {

    public static void main(String[] args) {
        double num=5;
        //num=3*2
        double harmonica = 1;
        for (double i = 2; i <= num; i++){

            harmonica =(1/i)+harmonica;


        }
        System.out.print(harmonica);

    }

}
