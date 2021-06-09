package giorni.giorno1;
import java.util.Scanner;

public class SumSotMolDiv {
    public static void main(String[] args) {
        /*
        double a;
        double b; */
        //input da tastiera
        System.out.println("Inserisci primo numero: ");
        Scanner input=new Scanner(System.in);
        Double c=input.nextDouble();
        //input.close();

        System.out.println("Inserisci secondo numero: ");
        Scanner input1=new Scanner(System.in);
        Double d=input1.nextDouble();
        input1.close();

        System.out.println("Somma:" + (c+d) );
        System.out.println("Sottrazione: " + (c-d) );
        System.out.println("Moltiplicazione: " + (c*d) );
        System.out.println("Divisione: " + (c/d) );


        /*
        System.out.println("Somma:" + (a+b) );
        System.out.println("Sottrazione: " + (a-b) );
        System.out.println("Moltiplicazione: " + (a*b) );
        System.out.println("Divisione: " + (a/b) );  */
    }
}
