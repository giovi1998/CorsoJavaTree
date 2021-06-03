package giorno4;
import java.util.*;

public class CifrarioDiCesare {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci Parola da cifrare: ");
        String parola = scan.nextLine();
        System.out.println("Inserisci chiave di cifratura: ");
        int chiave = scan.nextInt();
        scan.close();


        char [] parolaVett = parola.toCharArray();
        char [] parolaCifrata = cifrarioDiCesareCrittografia(parolaVett, chiave, 0);
        System.out.println("La parola cifrata risulta: " + Arrays.toString(parolaCifrata));
        char [] parolaDecifrata = cifrarioDiCesareDecrittografia(parolaCifrata, chiave, 0);
        System.out.println("La parola decifrata risulta: " + Arrays.toString(parolaDecifrata));


    }


    public static char[] cifrarioDiCesareCrittografia(char[] parola, int chiave, int i){

        if(i == parola.length ) {

            return parola;//caso base

        } else{
            //trasformo in char la parola e diventa + chiave quindi 96 che è la "a"+6 diventa "g"
            parola[i] = (char) (Character.toLowerCase(parola[i]) + chiave);

            if(parola[i] > 122){
                /*se esce dal range 96-122 torna indietro esempio
                 * z=122 +6 =128 quindi la parola deve essere sovrascritta
                 * 96-122=26
                 * 128-26=102 che è f
                 */

                parola[i] = (char) (parola[i]-26 );


            }

            return cifrarioDiCesareCrittografia(parola, chiave, ++i);

        }

    }

    public static char[] cifrarioDiCesareDecrittografia(char[] parola, int chiave, int i){

        if(i == parola.length ) {

            return parola;

        } else{

            parola[i] = (char) (Character.toLowerCase(parola[i]) - chiave);

            if(parola[i] < 97)
            {

                parola[i] = (char) (26+parola[i]);


            }

            return cifrarioDiCesareDecrittografia(parola, chiave, ++i);

        }

    }
}



