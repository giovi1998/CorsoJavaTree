package giorni.giorno3;

import java.util.Arrays;

/**
 * Da dispari a pari Scrivete una funzione che dato un array di valori ne restituisce una copia dove i
 numeri dispari sono stati moltiplicati per 2.
 * @author Giovanni
 *
 */
public class Es {

    public static void main(String[] args) {
        int []array= {3,4,5,6};
        array=pariDispari(array);
        System.out.print(Arrays.toString(array));

    }

    public static int [] pariDispari(int [] array)
    {
        for(int i=0;i<array.length;i++)
        {
            if((array[i]%2)==0)
            {
                //System.out.print(array[i]);
                //continue;
            }else
            {
                array[i]*=2;
            }
        }
        return array;



    }
}
