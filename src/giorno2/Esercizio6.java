package giorno2;

import java.util.*;

public class Esercizio6 {

    public static void main(String[] args) {
        //riempio la string
        boolean number=false;
        String a="ciao";
        String [] str= {"ciao","Giovanni"};

        //for(tipo var: array); l'array non e' una stringa

        for(String num : str)
        {
            System.out.println(num);
            if(num.equalsIgnoreCase(a)) {
                number=true;
            }
        }
        if(number)
        {
            System.out.println("c'e' ciao");
        }
    }

}
