package giorni.giorno2;
public class Esercizio7 {

    public static void main(String[] args) {
        char a = 'a';
        String frase = "casa mia è bella";
        int numeroVolte = 0;

        for (int i=0; i < frase.length(); i++){
            if (frase.charAt(i) == a){
                numeroVolte = numeroVolte+1;
            }
        }
        System.out.println(numeroVolte);
    }

}
