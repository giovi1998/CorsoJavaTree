package labirinto;

import java.util.*;

public class Labirinto {

    public static void main(String[] args) {

        char[][] labyrinth = InizializzazioneMatrice();
        GuardaDoveStannoEedP(labyrinth);
        int countMosse = 1;


        //muoversi
        while (!CondizioneVittoria(labyrinth)) {
            MuoviPersonaggio(labyrinth);
            if (CondizioneVittoria(labyrinth)) {

                break;
            }
            countMosse = (ContaMosse(countMosse));
            StampaMatrix(labyrinth);
        }
        /*scambia i due indici per dare l'idea di aver passato E
        int[] PosizioneP = PosizioneP(labyrinth);
        int IndexPI = PosizioneP[0];
        int IndexPJ = PosizioneP[1];
        int[] PosizioneE = PosizioneE(labyrinth);
        int IndexEI = PosizioneE[0];
        int IndexEJ = PosizioneE[1];
        labyrinth[IndexPI][IndexPJ] = 'E';
        labyrinth[IndexEI][IndexEJ] = 'P';*/

        System.out.println("HAI VINTO!!! Hai vinto in " + (ContaMosse(countMosse) - 1) + " mossa");

        StampaMatrix(labyrinth);


    }

    public static int ContaMosse(int mosse) {
        return mosse + 1;
    }

    public static void StampaMatrix(char[][] labyrinth) {
        for (char[] chars : labyrinth) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public static void GuardaDoveStannoEedP(char[][] labyrinth) {
        int[] PosizioneP = PosizioneP(labyrinth);
        int IndexPI = PosizioneP[0];
        int IndexPJ = PosizioneP[1];
        int[] PosizioneE = PosizioneE(labyrinth);
        int IndexEI = PosizioneE[0];
        int IndexEJ = PosizioneE[1];
        System.out.println("Posizione P " + IndexPI + "," + IndexPJ);
        System.out.println("Posizione E " + IndexEI + "," + IndexEJ);
        StampaMatrix(labyrinth);

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
        System.out.println("Salve Giocatore scegli!! Prova ad uscire dal mio labirinto ");
        System.out.println("L'obbiettivo è uscire dal uscita (exit->E) tu sei Persona (P) non puoi andare addosso ai muri (W)!!");
        System.out.println("Giocatore scegli quale mappa giocare: 1(predefinita) 2(generata casualmente) ");
        int scelta = scan.nextInt();
        if (scelta == 2) {
            System.out.println("Inserisci dimensione mappa che vuoi giocare per rendere le cose più interessante inserisci dim 3");
            int dim = scan.nextInt();
            if (dim <= 3) {
                InizializzazioneMatrice();
            }
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
        String lettereSostitute = settaDifficolta();
        //in questo modo la P è rinchiusa nelle prime tre colonne e righe
        //mentre la E nelle ultime 3
        int indiceRandomicoRigaP = rand.nextInt(3);
        int indiceRandomicoRigaE = dim - 1 - rand.nextInt(3);
        int indiceRandomicoColonnaE = dim - 1 - rand.nextInt(3);
        int indiceRandomicoColonnaP = rand.nextInt(3);
        char[][] vettoreRis = new char[dim][dim];

        //per non essere uguali
        if (indiceRandomicoRigaP == indiceRandomicoRigaE) {
            if (indiceRandomicoColonnaE == indiceRandomicoColonnaP) {
                return creaMappaGioco(dim);
            }
        }
        //inizializzazione randomica
        vettoreRis = InizializzazioneMatriceRandomica(dim, lettereSostitute, indiceRandomicoRigaP, indiceRandomicoRigaE, indiceRandomicoColonnaE, indiceRandomicoColonnaP);
        return vettoreRis;
    }

    public static char[][] InizializzazioneMatriceRandomica(int dim, String lettereSostitute, int indiceRandomicoRigaP, int indiceRandomicoRigaE, int indiceRandomicoColonnaE, int indiceRandomicoColonnaP) {
        Random rand = new Random();

        char[][] vettoreRis = new char[dim][dim];

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
        if (spostaAutomatico(vettoreRis, PosizioneP(vettoreRis)) && !CondizioneVittoria(vettoreRis)) {
            return vettoreRis;
        }

        return InizializzazioneMatriceRandomica(dim, lettereSostitute, indiceRandomicoRigaP, indiceRandomicoRigaE, indiceRandomicoColonnaE, indiceRandomicoColonnaP);



    }

    /**
     * metodo ricorsivo che permette la risoluzione automatica
     *
     * @param originalMatrice .
     * @param nuovaPosizione  .
     * @return vero se ha trovato la 'E'
     * svolta Da daniele modificata
     */
    public static boolean spostaAutomatico(char[][] originalMatrice, int[] nuovaPosizione) {

        char[][] copiaMatrice = copiaMatrice(originalMatrice);
        if (nuovaPosizione[0] < copiaMatrice.length && nuovaPosizione[1] < copiaMatrice[0].length && nuovaPosizione[0] >= 0 && nuovaPosizione[1] >= 0) {
            if (copiaMatrice[nuovaPosizione[0]][nuovaPosizione[1]] == 'W')
                return false;
            if (copiaMatrice[nuovaPosizione[0]][nuovaPosizione[1]] == '/') {
                return false;
            }
            if (copiaMatrice[nuovaPosizione[0]][nuovaPosizione[1]] == 'E') return true;
            copiaMatrice[nuovaPosizione[0]][nuovaPosizione[1]] = '/';
            if (spostaAutomatico(copiaMatrice, new int[]{nuovaPosizione[0] + 1, nuovaPosizione[1]}))
                return true;
            if (spostaAutomatico(copiaMatrice, new int[]{nuovaPosizione[0] - 1, nuovaPosizione[1]}))
                return true;
            if (spostaAutomatico(copiaMatrice, new int[]{nuovaPosizione[0], nuovaPosizione[1] + 1}))
                return true;
            if (spostaAutomatico(copiaMatrice, new int[]{nuovaPosizione[0], nuovaPosizione[1] - 1}))
                return true;
            copiaMatrice[nuovaPosizione[0]][nuovaPosizione[1]] = '-';
        } else return false;
        return false;
    }


    //in Java se non usi questo vai a sovrascrivere ma tu non vuoi !! in questo modo vai a copiare e restituire la matrice
    public static char[][] copiaMatrice(char[][] originalMatrice) {
        char[][] res = new char[originalMatrice.length][];
        for (int i = 0; i < originalMatrice.length; i++)
            res[i] = originalMatrice[i].clone();
        return res;
    }

    public static String settaDifficolta() {
        System.out.println("inserisci difficoltà giocatore!! 1 facile 2 medio 3 difficile");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        if (num == 3) {

            return "W-";
        } else if (num == 2) {

            return "WW---";
        } else if (num == 1) {

            return "W---";
        } else {
            return settaDifficolta();
        }

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
        int countMossa = 1;
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
            countMossa = ContaMosse(countMossa);
            System.out.println("hai sbagliato rinserisci!!");
        }
    }

//fine classe labirinto
}



