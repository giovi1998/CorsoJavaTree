package giorno4;
import java.util.*;

public class NumeriPrimi {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Inserisci il primo numero che vuoi sapere ");
        int numero = scan.nextInt();
        scan.close();

        vediNumeriPrimi(numero);
    }

    public static void vediNumeriPrimi (int num){
        for (int i = 2; i < num; i++){
            if (checkPrimo(i) == true){
                System.out.println(i);
            }
        }
    }
    public static boolean checkPrimo(int num) {
        int lim = num/2;
        boolean Primo = true;

        for(int div = 2; div <= lim && Primo; div++)
            if (num % div == 0)
                Primo = false;

        return Primo;
    }
}


