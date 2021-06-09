package giorni.giorno4;
import java.util.*;

public class StringaPalindromaRicorsivo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci parola: ");
        String parola = scan.nextLine();
        parola.toLowerCase(Locale.ROOT);
        char[] parolaArray = parola.toCharArray();
        System.out.println(Arrays.toString(parolaArray));
        int dimensione = parolaArray.length;
        System.out.println("palindroma " + palindromaRic(parolaArray, 0, dimensione));
    }

    public static boolean palindromaRic(char[] parola, int i, int dimensione) {
        if (dimensione == 1) {
            return true;
        } else {
            if (parola[i] != parola[dimensione - 1]) {
                System.out.println(dimensione);
                return false;
            } else
                System.out.println(dimensione);
            return palindromaRic(parola, ++i, --dimensione);
        }
    }
}
