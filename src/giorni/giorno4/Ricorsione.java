package giorni.giorno4;

public class Ricorsione {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int findElement = 7;

        System.out.println("trovato il num " + findElement + " " +ricercaBinaria(array, 0, array.length / 2, array.length, findElement));

    }

    public static boolean ricercaBinaria(int[] array, int first, int middle, int last, int findNumber){

        if(first >= last){

            if(array[first] == findNumber)

                return true;

            else

                return false;

        }

        if(array[middle] == findNumber)

            return true;


        else{

            if(array[middle] < findNumber ) {

                first = middle + 1;
                middle = (first + last) / 2;
                return ricercaBinaria(array, first, middle, last, findNumber);

            }

            else
            {

                last = middle - 1;
                middle = (first + last) / 2;
                return ricercaBinaria(array, first, middle, last, findNumber);

            }
        }

    }
}
