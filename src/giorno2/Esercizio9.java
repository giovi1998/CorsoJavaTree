package giorno2;

public class Esercizio9 {

    public static void main(String[] args) {
        int numero=10;
        boolean prime=true;

        for(int i = 2; i < numero; i++)
        {
            if(numero % i == 0)
            {
                prime=false;
            }
        }

        if(prime)
        {
            System.out.print("numero primo");

        }else
        {
            System.out.print("numero non primo");
        }

    }

}
