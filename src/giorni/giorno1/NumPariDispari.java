package giorni.giorno1;
import java.util.Scanner;

public class NumPariDispari {
    public static void main(String[] args) {
        System.out.println("Inserisci costo: ");
        //inserimento dato da tastiera
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        input.close();

        boolean pariodispari=(x%2)==0;

        if (pariodispari) {
            System.out.println("Il costo è pari.");
        } else {
            System.out.println("Il costo è dispari.");
        }
    }
}
