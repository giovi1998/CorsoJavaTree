package giorno3;

/**
        *Esercizio somma diagonale
        *
        *-Scrivete una funzione che data una matrice quadrata in input, restituisce la
        *	somma della diagonale da sinistra a destra.
        * -Scrivete una seconda funzione che presa una matrice quadrata e un booleano a
        * seconda del valore del booleano restituisce o la somma della diagonale da sinistra
        * a destra o quella da destra a sinistra.
        * - Hint: usate la prima funzione nella seconda!
        *
        */
public class Es2 {

    public static void main(String[] args) {
        int [][] matrix= new int [3][3];

        //inizializzazione
        for(int i=0; i<matrix.length;i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                matrix[i][j]=j+5;
            }
        }

        for(int i=0; i<matrix.length;i++)
        {
            for(int j=0; j<matrix[i].length; j++)
            {
                System.out.print(matrix[i][j]);

            }
        }
        System.out.println("questa è la somma" + somma(matrix));
    }

    public static int somma (int [][]matrix)
    {
        int somma = 0;

        for(int i=0; i<matrix.length;i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(i==j)
                {
                    somma+=matrix[i][j];
                }else continue;
            }
        }
        return somma;
    }


}
