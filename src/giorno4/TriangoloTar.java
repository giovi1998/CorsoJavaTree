package giorno4;

public class TriangoloTar {

    public static void main(String[] args) {
        int num=3;
        int [] array =new int[num+1];
        int [] arrayPre=new int [num];
        int countTriangolo=0;
        int i=0;

        triangle(num);

        for(i=0;i<num+1;i++)
        {
            System.out.print(array[i]);
        }




    }
    public static void triangle(int maxRows) {
        int r, num;
        for (int i = 0; i <= maxRows; i++) {
            num = 1;
            r = i + 1;
            for (int col = 0; col <= i; col++) {
                if (col > 0) {
                    num = num * (r - col) / col;
                }
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}




