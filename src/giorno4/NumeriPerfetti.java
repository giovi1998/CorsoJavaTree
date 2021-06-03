package giorno4;


import java.util.*;

public class NumeriPerfetti {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci numero: ");
        int numero = scan.nextInt();
        scan.close();
        stampaPerfetti(numero);

    }

    public static boolean checkPerfetto(int num) {
        int somma = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                somma += i;
            }
        }
        if (somma == num) {

            return  true;

        } else {

            return false;

        }

    }

    public static void stampaPerfetti(int n){
        for (int i =1; i <n ; i++){
            if(checkPerfetto(i)){
                System.out.println(i);
            }
        }
    }

}