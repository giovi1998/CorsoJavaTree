package giorni.giorno4;

public class SommaValoriArray {

    public static void main(String[] args) {
        int [] array = {2,3,4,5};
        int len = array.length;
        int somma;

        somma=somma(array,len);
        System.out.print("questa è la somma " + somma);


    }


    public static int somma(int [] array , int n) {


        if(n==0) {
            return 0;
        }

        int temp=array[n-1];
        return temp+somma(array,n-1);
    }



}
