package giorni.giorno4;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tombola {
    public static void main(String[] args) {
        int[][] cartella = new int[3][5];
        int[] rowCounter = new int[3]; // Array per tenere traccia del costo di match per ogni riga
        int indiceNumeroEstratto = 0;
        boolean tombola = false;

        // Creazione e stampa della cartella
        System.out.println("\nCartella: ");
        creaCartella(cartella);
        for (int[] x : cartella)
            System.out.println(Arrays.toString(x));

        // Controlla che il costo di estrazioni inserito sia compreso tra 20 e 90
        int numeroEstrazioni;
        System.out.print("\nInserire il costo di estrazioni: ");
        do {
            Scanner sc = new Scanner(System.in);
            numeroEstrazioni = sc.nextInt();
            if (numeroEstrazioni < 20 || numeroEstrazioni > 90)
                System.out.print("Inserire un costo compreso tra 20 e 90: ");
        } while (numeroEstrazioni < 20 || numeroEstrazioni > 90);
        int[] numeriEstratti = new int[numeroEstrazioni];

        // Estrazione dei numeri
        System.out.println("\nEstrazioni: ");
        while (indiceNumeroEstratto < numeroEstrazioni && !tombola) {
            tombola = estraiNumero(cartella, rowCounter, numeriEstratti, indiceNumeroEstratto);
            indiceNumeroEstratto++;
        }

        // Controllo tombola
        System.out.println("\nRisultati: ");
        if (tombola)
            System.out.println("TOMBOLA!");
        else // Calcolo costo di ambi, terne, quaterne e cinquine
            calcolaRisultati(rowCounter);
    }

    /**
     * Questo metodo crea una cartella, garantendo i vincoli di ordine e unicità dei numeri al suo interno.
     * @param cartella .
     */
    private static void creaCartella (int[][] cartella){
        int[] arrayCartella = new int[3*5];
        int index = 0;

        // Inizializza un array monodimensionale di dimensione 3*5 contenente i futuri numeri della
        // cartella ordinati in maniera crescente e unici.
        for (int i = 0; i < arrayCartella.length; i++) {
            inserisciNumero(arrayCartella, i);
            if (i == arrayCartella.length - 1)
                Arrays.sort(arrayCartella);
        }
        // Crea, a partire dall'array monodimensionale creato in precedenza, l'array bidimensionale
        // che rappresenta la cartella vera e propria.
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 3; col++) {
                cartella[col][row] = arrayCartella[index++];
            }
        }
    }

    /**
     * Questo metodo inserisce un costo compreso tra 1 e 90 nell'array monodimensionale,
     * controllando che non sia stato già inserito in precedenza.
     * @param arrayCartella .
     * @param i .
     */
    private static void inserisciNumero ( int[] arrayCartella, int i){
        Random random = new Random();
        int numeroEstratto = 1 + random.nextInt(90);

        if (controllaDuplicati(arrayCartella, numeroEstratto))
            inserisciNumero(arrayCartella, i);
        else
            arrayCartella[i] = numeroEstratto;
    }

    /**
     * Questo metodo garantisce che gli elementi di un array monodimensionale siano tutti unici.
     * @param array array dei numeri attualmente estratti
     * @param numeroEstratto .
     * @return true se numeroEstratto è un costo già estratto, false altrimenti.
     */
    private static boolean controllaDuplicati (int[] array, int numeroEstratto){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numeroEstratto)
                return true;
        }
        return false;
    }

    /**
     * Questo metodo simula l'estrazione di un costo, controllando che quest'ultimo
     * non sia già stato estratto in precedenza.
     * @param cartella .
     * @param rowCounter .
     * @param extractedNumbers .
     * @param index .
     * @return true se c'è stata tombola, false altrimenti.
     */
    private static boolean estraiNumero ( int[][] cartella, int[] rowCounter, int[] extractedNumbers, int index){
        Random random = new Random();
        int value = 1 + random.nextInt(90);

        if (controllaDuplicati(extractedNumbers, value))
            estraiNumero(cartella, rowCounter, extractedNumbers, index);
        else {
            System.out.println(index + " -> " + "Numero estratto: " + value);
            extractedNumbers[index] = value;
            for (int row = 0; row < cartella.length; row++) {
                // Se il costo estratto è più piccolo del primo costo della riga e più grande dell'ultimo costo
                // della riga, skippa questa iterazione.
                if (value < cartella[row][0] || value > cartella[row][4])
                    continue;
                for (int col = 0; col < cartella[row].length; col++) {
                    if (cartella[row][col] == value) {
                        System.out.print("Match sulla riga " + row + "!\n");
                        rowCounter[row] += 1;
                        controllaRisultati(rowCounter, row);
                    }
                }
            }
        }
        return rowCounter[0] + rowCounter[1] + rowCounter[2] == 15;
    }

    /**
     * Questo metodo controlla se, dopo l'estrazione di un costo, è stato fatto un ambo, terno, quaterna
     * o cinquina.
     * @param rowCounter .
     * @param row .
     */
    private static void controllaRisultati(int[] rowCounter, int row){
        switch (rowCounter[row]) {
            case 2 -> System.out.println("Ambo!!");
            case 3 -> System.out.println("Terno!!!");
            case 4 -> System.out.println("Quaterna!!!!");
            case 5 -> System.out.println("Cinquina!!!!!!");
        }
    }

    /**
     * Questo metodo calcola, alla fine di tutte le estrazioni, il costo totale di ambi, terne, quaterne e
     * cinquine.
     * @param rowCounter .
     */
    private static void calcolaRisultati(int[] rowCounter){
        int contAmbi, contTerne, contQuaterne, contCinquine;
        contAmbi = contTerne = contQuaterne = contCinquine = 0;

        for (int i = 0; i < 3; i++) {
            switch (rowCounter[i]) {
                case 2 -> contAmbi++;
                case 3 -> contTerne++;
                case 4 -> contQuaterne++;
                case 5 -> contCinquine++;
            }
        }
        System.out.println("Numero di ambi:  " + contAmbi);
        System.out.println("Numero di terne: " + contTerne);
        System.out.println("Numero di quaterne: " + contQuaterne);
        System.out.println("Numero di cinquine:  " + contCinquine);
    }
}