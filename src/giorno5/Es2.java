package giorno5;

import java.util.Arrays;

//Esercitazione 1
public class Es2 {
    public static void main(String[] args) {
        int[] array = {1,2,0,4,5,6};
        Arrays.sort(array);
        int num=0;
        for (int j=0; j<array.length;j++) {
            if(array[j]!=j){
                num=j;
                break;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("numero " +num);
    }
}
