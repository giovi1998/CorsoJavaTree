package dittaRiparazione;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Class
 */
public class DittaRiparazioni {
    Tecnico[] tecnici;
    Riparazione[] riparazioni;

    /**
     * Costruttore
     * @param tecnici
     * @param riparazioni
     */
    public DittaRiparazioni(Tecnico[] tecnici, Riparazione[] riparazioni) {
        this.tecnici = tecnici;
        this.riparazioni = riparazioni;
    }

    /**
     * aggiunge il tecnico
     * @param tecnico
     */
    public void aggiungiTecnico(Tecnico tecnico) {

        if (tecnici == null) {

            tecnici = new Tecnico[1];
            tecnici[0] = tecnico;

        } else {
            if (checkNomeTecnico(tecnico)) {
                Tecnico[] newTecnici = Arrays.copyOf(tecnici, tecnici.length + 1);
                newTecnici[tecnici.length] = tecnico;
                tecnici = newTecnici;
            } else System.out.println("Tecnico già presente");
        }

    }

    /**
     *Guarda il nome del tecnico
     * @param tecnico
     * @return true or false
     */
    public boolean checkNomeTecnico(Tecnico tecnico) {
        for (Tecnico value : tecnici) {
            if (value.getNome().equalsIgnoreCase(tecnico.getNome())) {
                return false;
            }
        }
        return true;
    }

    /**
     * aggiunge una riparazione da fare
     * @param riparazione
     */
    public void aggiungiRiparazione(Riparazione riparazione) {
        if (riparazioni == null) {

            riparazioni = new Riparazione[1];
            riparazioni[0] = riparazione;

        } else {
            Riparazione[] newRiparazioni = Arrays.copyOf(riparazioni, riparazioni.length + 1);
            newRiparazioni[riparazioni.length] = riparazione;
            riparazioni = newRiparazioni;
        }
    }

    public void stampaRiparazioniAttesa() {
        for (int i = 0; i < riparazioni.length; i++) {
            if (riparazioni[i].getStato().equals(StatoRiparazione.inAttesa)) {
                System.out.println("La riparazione in via: " + riparazioni[i].getIndirizzo()
                        + " , di priorità: " + riparazioni[i].getPrioritaIntervento() + " nello stato: " +
                        riparazioni[i].getStato());
            }
        }
    }

    public void stampaRiparazioni() {
        for (int i = 0; i < riparazioni.length; i++) {
            System.out.println("La riparazione in via: " + riparazioni[i].getIndirizzo()
                    + " , di priorità: " + riparazioni[i].getPrioritaIntervento() + " nello stato: " +
                    riparazioni[i].getStato());
        }
    }

    public void stampaListaTecnici() {
        System.out.println("Lista Tecnici: ");
        for (int i = 0; i < tecnici.length; i++) {
            System.out.println(i + ")" + tecnici[i].getNome() + " stato: " + tecnici[i].getStato());
        }
    }


    public void assegnaRiparazioni() {
        Scanner scan = new Scanner(System.in);
        System.out.println("scegli il numero dell'operatore da assegnare tra i seguenti ");
        stampaListaTecnici();
        int sceltaOperatore = scan.nextInt();
        System.out.println("scegli il numero che corrisponde alla riparazione tra quelle in attesa");
        stampaRiparazioniAttesa();
        int sceltaRiparazione = scan.nextInt();
        Arrays.sort(riparazioni, Comparator.comparing(Riparazione::getIndirizzo));
        for (int i = 0; i < tecnici.length; i++) {
            for (int j = 0; j < riparazioni.length; j++) {
                if (sceltaOperatore == i && sceltaRiparazione == j) {
                    if (tecnici[i].getStato().equals(StatoTecnico.libero)) {
                        riparazioni[i].setStato(StatoRiparazione.inEsecuzione);
                        tecnici[i].setStato(StatoTecnico.occupato);
                    }else System.out.println("Operatore già occupato o in ferie ");
                }
            }
        }
        stampaRiparazioniAttesa();
        stampaListaTecnici();

    }
    public void stampaRiparazioneMaggiorePriorita(){
        int max =0;
        for (Riparazione riparazione : riparazioni) {
            if (riparazione.getPrioritaIntervento() > max && riparazione.getStato().equals(StatoRiparazione.inAttesa)) {
                max = riparazione.getPrioritaIntervento();
            }
        }
        System.out.println(max);
        for (Riparazione riparazione : riparazioni) {
            if (riparazione.getPrioritaIntervento() == max && riparazione.getStato().equals(StatoRiparazione.inAttesa)) {
                System.out.println("La riparazione in via: " + riparazione.getIndirizzo() +
                        " è quella con maggiore priorità ");
            }
        }
    }


    public void concludiRiparazioni(Riparazione riparazione) {
        for (Riparazione value : riparazioni) {
            if (value.getIndirizzo().equalsIgnoreCase(riparazione.getIndirizzo())) {
                value.setStato(StatoRiparazione.completata);
            }
        }
    }

    public void mandaInFerieTecnici(Tecnico[] tecnico) {
        for (Tecnico value : tecnici) {
            for (Tecnico item : tecnico) {
                if (value.getNome().equalsIgnoreCase(item.getNome())) {
                    item.setStato(StatoTecnico.inFerie);
                }
            }
        }
    }

}

