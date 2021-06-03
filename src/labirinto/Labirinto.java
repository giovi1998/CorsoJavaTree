package labirinto;

import java.util.*;

public class Labirinto {

    public static void main(String[] args) {
        char[][] labyrinth = new char[5][5];

        labyrinth = InizializzazioneMatrice(labyrinth);

        StampaMatrix(labyrinth);

        System.out.println("posizione P" + Arrays.toString(PosizioneP(labyrinth)));


        //char c=MuoviPersonaggioWSDA(labyrinth);
        labyrinth=MuoviPersonaggio(labyrinth);
        StampaMatrix(labyrinth);
    }

    public static void StampaMatrix(char[][] labyrinth) {
        for (int i = 0; i < labyrinth.length; i++) {
            System.out.println(Arrays.toString(labyrinth[i]));
        }
    }

    public static char[][] InizializzazioneMatrice(char[][] labyrinth) {
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {

                labyrinth[i][j] = '-';
            }
        }
        labyrinth[0][2] = 'W';
        labyrinth[0][3] = 'W';
        labyrinth[1][1] = 'W';
        labyrinth[1][3] = 'W';
        labyrinth[2][0] = 'P';
        labyrinth[2][1] = 'W';
        labyrinth[2][3] = 'W';
        labyrinth[2][4] = 'W';
        labyrinth[3][2] = 'W';
        labyrinth[3][4] = 'E';
        labyrinth[4][0] = 'W';
        labyrinth[4][4] = 'W';
        return labyrinth;
    }


    public static int[] PosizioneE(char[][] labyrinth) {
        int[] indexE = new int[2];
        int indexI = 0;
        int indexJ = 0;

        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {

                if (labyrinth[i][j] == 'E') {
                    indexI = i;
                    indexJ = j;
                    break;
                }
            }

        }
        indexE[0] = indexI;
        indexE[1] = indexJ;
        return indexE;
    }

    public static int[] PosizioneP(char[][] labyrinth) {
        int[] indexP = new int[2];
        int indexI = 0;
        int indexJ = 0;

        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {

                if (labyrinth[i][j] == 'P') {
                    indexI = i;
                    indexJ = j;
                    break;
                }
            }

        }
        indexP[0] = indexI;
        indexP[1] = indexJ;
        return indexP;
    }

    public static boolean MuoversiSu (char[][] labyrinth)
    {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        //muoversi su
        if (labyrinth[indexRiga +1][indexColonna] != '-' || labyrinth[indexRiga +1][indexColonna] != 'W' || indexRiga == 0) {
            return false;
        }
        return true;
    }

    public static boolean MuoversiGiu (char[][] labyrinth)
    {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        //muoversi giu
        if (labyrinth[indexRiga +1][indexColonna] != '-' || labyrinth[indexRiga +1][indexColonna] == 'W' || indexRiga == labyrinth.length-1) {
            return false;
        }
        return true;
    }

    public static boolean MuoversiADestra (char[][] labyrinth)
    {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        //muoversi a destra
        if (labyrinth[indexRiga][indexColonna +1] != '-' || labyrinth[indexRiga][indexColonna + 1] == 'W' || indexColonna == labyrinth.length) {
            return false;
        }
        return true;
    }

    public static boolean MuoversiASinistra(char[][] labyrinth)
    {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        //muoversi a sinistra
        if (labyrinth[indexRiga][indexColonna -1] != '-' || labyrinth[indexRiga][indexColonna -1] == 'W' || indexColonna == 0) {
            return false;
        }
        return true;
    }

    public static char MuoviPersonaggioWSDA(char[][] labyrinth) {
        //condizione valida per muoversi
        System.out.println("scegli come spostarti schiacciando W A S D");

        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci Char: ");
        char letteraInserita = scan.nextLine().charAt(0);
        scan.close();
        System.out.println("lettera inserita :"+ letteraInserita );
        return letteraInserita;
    }

    public static char [][] MuoviPersonaggio(char[][] labyrinth)
    {
        int[] indexP = PosizioneP(labyrinth);
        int indexI = indexP[0]; //2
        int indexJ = indexP[1]; //0
        char mossa=MuoviPersonaggioWSDA(labyrinth);
        char temp='R';
        if(mossa=='A' && MuoversiASinistra(labyrinth))
        {
            //se è vero non sono caso limite a sinistra scambio due lettere ai due indici
            temp=labyrinth[indexI][indexJ];
            labyrinth[indexI][indexJ]=labyrinth[indexI][indexJ-1];
            labyrinth[indexI][indexJ-1]=temp;

        }else if(mossa=='S' && MuoversiGiu(labyrinth))
        {
            //se è vero non sono caso limite a giu scambio due lettere ai due indici
            temp=labyrinth[indexI][indexJ];
            labyrinth[indexI][indexJ]=labyrinth[indexI+1][indexJ];
            labyrinth[indexI+1][indexJ]=temp;



        }else if(mossa=='D' && MuoversiADestra(labyrinth))
        {
            //se è vero non sono caso limite destra scambio due lettere ai due indici
            temp=labyrinth[indexI][indexJ];
            labyrinth[indexI][indexJ]=labyrinth[indexI][indexJ+1];
            labyrinth[indexI][indexJ+1]=temp;

        }else if(mossa=='W' && !MuoversiSu(labyrinth))//non so perchè
        {
            //se è vero non sono caso limite a su scambio due lettere ai due indici
            temp=labyrinth[indexI][indexJ];
            labyrinth[indexI][indexJ]=labyrinth[indexI-1][indexJ];
            labyrinth[indexI-1][indexJ]=temp;


        }else {
            System.out.println("hai sbagliato rinserisci!!");
        }


        return labyrinth;
    }

//fine classe labirinto
}



