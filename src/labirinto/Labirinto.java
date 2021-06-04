package labirinto;

import java.util.*;

public class Labirinto {

    public static void main(String[] args) {
        char[][] labyrinth = InizializzazioneMatrice();
        int[] PosizioneP = PosizioneP(labyrinth);
        int IndexPI = PosizioneP[0];
        int IndexPJ = PosizioneP[1];
        int[] PosizioneE = PosizioneE(labyrinth);
        int IndexEI = PosizioneE[0];
        int IndexEJ = PosizioneE[1];
        System.out.println("Posizione P " +IndexPI + "," +IndexPJ );
        System.out.println("Posizione E " +IndexEI + "," +IndexEJ );

        StampaMatrix(labyrinth);

        //muoversi
        while (!CondizioneVittoria(labyrinth)) {
            MuoviPersonaggio(labyrinth);
            if (CondizioneVittoria(labyrinth)) {
                System.out.println("HAI VINTO!!!");
                break;
            }
            PosizioneP = PosizioneP(labyrinth);
            IndexPI = PosizioneP[0];
            IndexPJ = PosizioneP[1];
            PosizioneE = PosizioneE(labyrinth);
            IndexEI = PosizioneE[0];
            IndexEJ = PosizioneE[1];
            System.out.println("Posizione P " +IndexPI+ "," +IndexPJ );
            System.out.println("Posizione E " +IndexEI+ "," +IndexEJ );
            StampaMatrix(labyrinth);

        }
        PosizioneP = PosizioneP(labyrinth);
        IndexPI = PosizioneP[0];
        IndexPJ = PosizioneP[1];
        PosizioneE = PosizioneE(labyrinth);
        IndexEI = PosizioneE[0];
        IndexEJ = PosizioneE[1];
        labyrinth[IndexPI][IndexPJ] = 'E';
        labyrinth[IndexEI][IndexEJ] = 'P';
        StampaMatrix(labyrinth);
    }

    public static void StampaMatrix(char[][] labyrinth) {
        for (char[] chars : labyrinth) {
            System.out.println(Arrays.toString(chars));
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
            //sinistra
            //&& ((IndexPI==IndexEI+1) || (IndexPI==IndexEI-1)))
            return IndexPJ == IndexEJ - 1;
        } else if (IndexPJ == IndexEJ) {
            if ((IndexPI == IndexEI + 1)) {//giu

                return true;
            }
            //su
            return IndexPI == IndexEI - 1;

        }

        return false;
    }


    public static char[][] InizializzazioneMatrice() {


        Scanner scan = new Scanner(System.in);
        System.out.println("Salve Giocatore scegli!! Prova ad uscire dal mio labirinto");
        System.out.println("Giocatore scegli quale mappa giocare: 1(predefinita) 2(generata casualmente) ");
        int scelta = scan.nextInt();
        if (scelta == 2) {
            System.out.println("Inserisci dimensione mappa che vuoi giocare ");
            int dim = scan.nextInt();
            return creaMappaGioco(dim);
        } else if (scelta == 1) {
            char[][] labyrinth = new char[5][5];
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
        return InizializzazioneMatrice();
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

    //crea MappaGioco
    public static char[][] creaMappaGioco(int dim) {
        Random rand = new Random();
        String lettereSostitute = "W----";
        int indiceRandomicoRigaP = rand.nextInt(dim);
        int indiceRandomicoRigaE = rand.nextInt(dim);
        int indiceRandomicoColonnaE = rand.nextInt(dim);
        int indiceRandomicoColonnaP = rand.nextInt(dim);
        char[][] vettoreRis = new char[dim][dim];

        if (indiceRandomicoRigaP == indiceRandomicoRigaE) {
            if (indiceRandomicoColonnaE == indiceRandomicoColonnaP) {
                return creaMappaGioco(dim);
            }
        }

        for (int i = 0; i < vettoreRis.length; i++) {
            for (int j = 0; j < vettoreRis[0].length; j++) {

                vettoreRis[i][j] = '-';
            }
        }

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (i == indiceRandomicoRigaP && j == indiceRandomicoColonnaP) {
                    vettoreRis[i][j] = 'P';
                    continue;
                }
                if (i == indiceRandomicoRigaE && j == indiceRandomicoColonnaE) {
                    vettoreRis[i][j] = 'E';
                    continue;
                }
                vettoreRis[i][j] = lettereSostitute.charAt(rand.nextInt(lettereSostitute.length()));
            }
        }

        return vettoreRis;
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
        return (labyrinth[indexRiga - 1][indexColonna] == '-' || labyrinth[indexRiga - 1][indexColonna] == 'E') && labyrinth[indexRiga - 1][indexColonna] != 'W';
    }

    public static boolean MuoversiGiu(char[][] labyrinth) {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        //muoversi giu
        if (indexRiga == labyrinth.length - 1) {
            return false;
        }
        return (labyrinth[indexRiga + 1][indexColonna] == '-' || labyrinth[indexRiga + 1][indexColonna] == 'E') && labyrinth[indexRiga + 1][indexColonna] != 'W';
    }

    public static boolean MuoversiADestra(char[][] labyrinth) {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        if (indexColonna == labyrinth.length - 1) {
            return false;
        }
        //muoversi a destra
        return (labyrinth[indexRiga][indexColonna + 1] == '-' || labyrinth[indexRiga][indexColonna + 1] == 'E') && labyrinth[indexRiga][indexColonna + 1] != 'W';
    }

    public static boolean MuoversiASinistra(char[][] labyrinth) {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        //muoversi a sinistra
        if (indexColonna == 0) {
            return false;
        }

        return (labyrinth[indexRiga][indexColonna - 1] == '-' || labyrinth[indexRiga][indexColonna - 1] == 'E') && labyrinth[indexRiga][indexColonna - 1] != 'W';
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

    public static void MuoviPersonaggio(char[][] labyrinth) {
        int[] indexP = PosizioneP(labyrinth);
        int indexRiga = indexP[0]; //2
        int indexColonna = indexP[1]; //0
        char mossa = MuoviPersonaggioWSDA();

        if (mossa == 'A' && MuoversiASinistra(labyrinth)) {
            //se è vero non sono caso limite a sinistra scambio due lettere ai due indici
            char temp = labyrinth[indexRiga][indexColonna];
            labyrinth[indexRiga][indexColonna] = labyrinth[indexRiga][indexColonna - 1];
            labyrinth[indexRiga][indexColonna - 1] = temp;


        } else if (mossa == 'S' && MuoversiGiu(labyrinth)) {
            //se è vero non sono caso limite a giu scambio due lettere ai due indici
            char temp = labyrinth[indexRiga][indexColonna];
            labyrinth[indexRiga][indexColonna] = labyrinth[indexRiga + 1][indexColonna];
            labyrinth[indexRiga + 1][indexColonna] = temp;


        } else if (mossa == 'D' && MuoversiADestra(labyrinth)) {
            //se è vero non sono caso limite destra scambio due lettere ai due indici
            char temp = labyrinth[indexRiga][indexColonna];
            labyrinth[indexRiga][indexColonna] = labyrinth[indexRiga][indexColonna + 1];
            labyrinth[indexRiga][indexColonna + 1] = temp;

        } else if (mossa == 'W' && MuoversiSu(labyrinth))//non so perchè
        {
            //se è vero non sono caso limite a su scambio due lettere ai due indici
            char temp = labyrinth[indexRiga][indexColonna];
            labyrinth[indexRiga][indexColonna] = labyrinth[indexRiga - 1][indexColonna];
            labyrinth[indexRiga - 1][indexColonna] = temp;

        } else {
            System.out.println("hai sbagliato rinserisci!!");
        }
    }

//fine classe labirinto
}



