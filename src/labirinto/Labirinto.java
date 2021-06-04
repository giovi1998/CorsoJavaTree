package labirinto;

import java.util.*;

public class Labirinto {

    public static void main(String[] args) {
        char[][] labyrinth = new char[5][5];
        labyrinth = InizializzazioneMatrice(labyrinth);


        StampaMatrix(labyrinth);

        //System.out.println("posizione P" + Arrays.toString(PosizioneP(labyrinth)));


        //muoversi
        while (!CondizioneVittoria(labyrinth)) {
            labyrinth = MuoviPersonaggio(labyrinth);
            if (CondizioneVittoria(labyrinth)) {
                System.out.println("HAI VINTO!!!");
                break;
            }
            // System.out.println("Condizione di vittoria " + CondizioneVittoria(labyrinth) );

            StampaMatrix(labyrinth);

        }
        int[] PosizioneP = PosizioneP(labyrinth);
        int IndexPI = PosizioneP[0];
        int IndexPJ = PosizioneP[1];
        int[] PosizioneE = PosizioneE(labyrinth);
        int IndexEI = PosizioneE[0];
        int IndexEJ = PosizioneE[1];
        labyrinth[IndexPI][IndexPJ] = 'E';
        labyrinth[IndexEI][IndexEJ] = 'P';
        StampaMatrix(labyrinth);
    }

    public static void StampaMatrix(char[][] labyrinth) {
        for (int i = 0; i < labyrinth.length; i++) {
            System.out.println(Arrays.toString(labyrinth[i]));
        }
    }

    public static boolean CondizioneVittoria(char[][] labyrinth) {
        int[] PosizioneP = PosizioneP(labyrinth);
        int IndexPI = PosizioneP[0];
        int IndexPJ = PosizioneP[1];
        int[] PosizioneE = PosizioneE(labyrinth);
        int IndexEI = PosizioneE[0];
        int IndexEJ = PosizioneE[1];

        if (IndexPI == IndexEI) {//condizione per vedere se si trova a destra o a sinistra
            if (IndexPJ == IndexEJ + 1) {//destra
                //scambia
                return true;
            }
            if (IndexPJ == IndexEJ - 1) //sinistra
            {
                return true;
            }//&& ((IndexPI==IndexEI+1) || (IndexPI==IndexEI-1)))
            return false;
        } else if (IndexPJ == IndexEJ) {
            if ((IndexPI == IndexEI + 1)) {//giu

                return true;
            }
            if (IndexPI == IndexEI - 1) //su
            {
                return true;
            }

        }

        return false;
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

    public static boolean MuoversiSu(char[][] labyrinth) {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        //muoversi su
        if (indexRiga == 0) {
            return false;
        }
        if (labyrinth[indexRiga - 1][indexColonna] != '-' && labyrinth[indexRiga - 1][indexColonna] != 'E' || labyrinth[indexRiga - 1][indexColonna] == 'W') {
            return false;
        }
        return true;
    }

    public static boolean MuoversiGiu(char[][] labyrinth) {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        //muoversi giu
        if (indexRiga == labyrinth.length - 1) {
            return false;
        }
        if (labyrinth[indexRiga + 1][indexColonna] != '-' && labyrinth[indexRiga + 1][indexColonna] != 'E' || labyrinth[indexRiga + 1][indexColonna] == 'W') {
            return false;
        }
        return true;
    }

    public static boolean MuoversiADestra(char[][] labyrinth) {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        if (indexColonna == labyrinth.length - 1) {
            return false;
        }
        //muoversi a destra
        if (labyrinth[indexRiga][indexColonna + 1] != '-' && labyrinth[indexRiga][indexColonna + 1] != 'E' || labyrinth[indexRiga][indexColonna + 1] == 'W') {
            return false;
        }
        return true;
    }

    public static boolean MuoversiASinistra(char[][] labyrinth) {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        //muoversi a sinistra
        if (indexColonna == 0) {
            return false;
        }

        if (labyrinth[indexRiga][indexColonna - 1] != '-' && labyrinth[indexRiga][indexColonna - 1] != 'E' || labyrinth[indexRiga][indexColonna - 1] == 'W') {
            return false;
        }

        return true;
    }

    public static char MuoviPersonaggioWSDA() {
        //condizione valida per muoversi
        System.out.println("scegli come spostarti schiacciando W A S D");

        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci Char: ");
        char letteraInserita = scan.nextLine().toUpperCase().charAt(0);
        System.out.println("lettera inserita :" + letteraInserita);
        return letteraInserita;
    }

    public static char[][] MuoviPersonaggio(char[][] labyrinth) {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        char mossa = MuoviPersonaggioWSDA();
        char temp = ' ';
        if (labyrinth[indexRiga][indexColonna + 1] == 'E') {
            return labyrinth;
        }
        if (mossa == 'A' && MuoversiASinistra(labyrinth)) {
            //se è vero non sono caso limite a sinistra scambio due lettere ai due indici
            temp = labyrinth[indexRiga][indexColonna];
            labyrinth[indexRiga][indexColonna] = labyrinth[indexRiga][indexColonna - 1];
            labyrinth[indexRiga][indexColonna - 1] = temp;


        } else if (mossa == 'S' && MuoversiGiu(labyrinth)) {
            //se è vero non sono caso limite a giu scambio due lettere ai due indici
            temp = labyrinth[indexRiga][indexColonna];
            labyrinth[indexRiga][indexColonna] = labyrinth[indexRiga + 1][indexColonna];
            labyrinth[indexRiga + 1][indexColonna] = temp;


        } else if (mossa == 'D' && MuoversiADestra(labyrinth)) {
            //se è vero non sono caso limite destra scambio due lettere ai due indici
            temp = labyrinth[indexRiga][indexColonna];
            labyrinth[indexRiga][indexColonna] = labyrinth[indexRiga][indexColonna + 1];
            labyrinth[indexRiga][indexColonna + 1] = temp;

        } else if (mossa == 'W' && MuoversiSu(labyrinth))//non so perchè
        {
            //se è vero non sono caso limite a su scambio due lettere ai due indici
            temp = labyrinth[indexRiga][indexColonna];
            labyrinth[indexRiga][indexColonna] = labyrinth[indexRiga - 1][indexColonna];
            labyrinth[indexRiga - 1][indexColonna] = temp;

        } else {
            System.out.println("hai sbagliato rinserisci!!");
        }


        return labyrinth;
    }

//fine classe labirinto
}



