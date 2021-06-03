package giorno4;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int [] array= {6,5,3,1,8,7,2,4};
        int len=array.length;
        array= MergeSort (array,len);

    }

    public static int [] MergeSort(int [] array, int len)
    {
        int [] arrayCopia =new int [len];
        for(int i=0;i<len;i++)
        {
            arrayCopia[i]=array[i];
        }

        Arrays.sort(arrayCopia);

        for(int i=0;i<len;i++)
        {
            if(arrayCopia[i]==array[i]) {
                return MergeSort(array,(len+1)/2);
            }

        }

        return array;
    }

}
