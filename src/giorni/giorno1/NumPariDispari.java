package giorni.giorno1;
import java.util.Scanner;

public class NumPariDispari {
    public static void main(String[] args) {
        System.out.println("Inserisci numero: ");
        //inserimento dato da tastiera
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        input.close();

        boolean pariodispari=(x%2)==0;

        if (pariodispari) {
            System.out.println("Il numero è pari.");
        } else {
            System.out.println("Il numero è dispari.");
        }
    }
}
