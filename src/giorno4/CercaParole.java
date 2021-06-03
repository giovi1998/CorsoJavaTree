package giorno4;

import java.util.Arrays;

public class CercaParole {

    //https://www.w3schools.com/java/ref_string_contains.asp
    //contains vede se hai una parola
    public static void main(String[] argc)
    {

        char[][] matriceDiParole = { {'h', 'd', 'g', 'u', 'p', 'y', 's', 'p', 'a', 'o'}, {'t', 's', 'a', 'k', 'o', 'y', 'o', 'l', 'p', 's'}, {'r', 'c', 'm', 'c', 'n', 'r', 'i', 'a', 'a', 'b'}, {'i', 'o', 'b', 'a', 'i', 's', 'c', 't', 'l', 'a'}, {'g', 'r', 'e', 'l', 'f', 'a', 'c', 'e', 'o', 'l'}, {'l', 'f', 'r', 'a', 'l', 'l', 'u', 's', 'i', 'e'}, {'i', 'a', 'e', 'm', 'e', 'm', 'l', 's', 'l', 'n'}, {'a', 'n', 't', 'a', 'd', 'o', 'c', 'a', 'g', 'a'}, {'j', 'o', 't', 'r', 'b', 'n', 'd', 'g', 'o', 'd'}, {'l', 'y', 'o', 'o', 'u', 'e', 's', 'm', 's', 'm'}};

        for(int i = 0; i < matriceDiParole.length; i++)
        {

            System.out.println(Arrays.toString(matriceDiParole[i]));

        }

        String parola = "ciao";

        System.out.println("parola cercata " + parola + " è stata trovata ? "+ cercaParole(matriceDiParole, parola.toCharArray()));


    }

    public static boolean cercaParole(char[][] matriceDiParole, char[] parola)
    {

        if(parola.length <= matriceDiParole[0].length)
        {

            if (cercaInOrizzontale(matriceDiParole, parola) || cercaInOrizzontale(matriceDiParole, reverseString(parola)))
            {

                return true;

            }

        }

        if(parola.length <= matriceDiParole.length)
        {

            if(cercaInVerticale(matriceDiParole, parola) || cercaInVerticale(matriceDiParole, reverseString(parola)))

                return true;

        }


        return false;

    }

    public static boolean cercaInOrizzontale(char[][] matriceDiParole, char[] parola)
    {

        int indiceRiga;
        String riga;
        String parolaCercata = String.copyValueOf(parola);

        for (indiceRiga = 0; indiceRiga < matriceDiParole.length; indiceRiga++)
        {

            riga = String.copyValueOf(matriceDiParole[indiceRiga]);

            if(riga.contains(parolaCercata))
            {

                return true;

            }

        }

        return false;

    }

    public static boolean cercaInVerticale(char[][] matriceDiParole, char[] parola)
    {

        String[] riga = prendiParoleInVerticale(matriceDiParole);
        String parolaCercata = String.copyValueOf(parola);

        for(String s : riga){

            if(s.contains(parolaCercata))

                return true;

        }

        return false;

    }

    public static String[] prendiParoleInVerticale(char[][] matriceDiParole)
    {

        String[] parole = new String[matriceDiParole[0].length];
        char[][] parolaVerticale = new char[matriceDiParole[0].length][matriceDiParole.length];
        int riga = 0;
        int colonna = 0;

        while (colonna < matriceDiParole[0].length) {

            parolaVerticale[colonna][riga] = matriceDiParole[riga][colonna];

            if (riga < matriceDiParole.length - 1)
            {

                riga++;
                continue;

            }

            else
            {
                riga = 0;
                colonna++;
            }

        }

        for (int i = 0; i < parolaVerticale.length; i++)
        {

            parole[i] = String.copyValueOf(parolaVerticale[i]);

        }

        return parole;

    }

    public static char[] reverseString(char[] primaParola)
    {

        int i;
        char[] reverse = new char[primaParola.length];

        for(i = 0; i < primaParola.length; i++)

            reverse[i] += primaParola[primaParola.length - i - 1];

        return reverse;

    }

}
