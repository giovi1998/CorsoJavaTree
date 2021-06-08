package dittaRiparazione;

import java.util.Arrays;

public class DittaRiparazioni {
    private Tecnico[] tecnici;
    private Riparazione[] riparazioni;


    public DittaRiparazioni(Tecnico[] tecnici, Riparazione[] riparazioneDafare) {
        this.tecnici = tecnici;
        this.riparazioni = riparazioneDafare;
    }

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

    public boolean checkNomeTecnico(Tecnico tecnico) {
        for (Tecnico value : tecnici) {
            if (value.getNomeTecnico().equalsIgnoreCase(tecnico.nomeTecnico)) {
                return false;
            }
        }
        return true;
    }

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
            if (riparazioni[i].stato.equals(StatoRiparazione.inAttesa)) {
                System.out.println("La riparazione n° " + i + " in via: " + riparazioni[i].indirizzo
                        + " di priorità: " + riparazioni[i].priorità + " nello stato: " +
                        riparazioni[i].stato);
            }
        }
    }

    public void stampaRiparazioni() {
        for (int i = 0; i < riparazioni.length; i++) {
            System.out.println("La riparazione n° " + i + " in via: " + riparazioni[i].indirizzo
                    + " di priorità: " + riparazioni[i].priorità + " nello stato: " +
                    riparazioni[i].stato + " è stata presa dal tecnico con l'id " + riparazioni[i].idTecnico);
        }
    }

    public void stampaListaTecnici() {
        System.out.println("Lista Tecnici: ");
        for (int i = 0; i < tecnici.length; i++) {
            System.out.println(i + ")" + tecnici[i].getNomeTecnico() + " stato: " + tecnici[i].occupato + " con l'id " + tecnici[i].idTecnico);
        }
    }


    public void assegnaRiparazione() {
        //scorre riparazioni

        for (int i = 0; i < riparazioni.length; i++) {
            if (riparazioni[i].stato == StatoRiparazione.inAttesa) {
                if (!tecnici[i].occupato) {
                    riparazioni[i].idTecnico = tecnici[i].idTecnico;
                    riparazioni[i].stato = StatoRiparazione.occupata;
                    tecnici[i].occupato = true;
                }
            }
        }
    }

    public void ordinaRipazioneInBaseAPriorita() {

        assegnaRiparazioneUnaPriorita();

    }

    public void assegnaRiparazioneUnaPriorita() {
        int max = 0;
        int i ;
        //ricerca maggiore
        for (i = 0; i < riparazioni.length; i++) {
            if (riparazioni[i].stato == StatoRiparazione.inAttesa && max < riparazioni[i].priorità) {

                max = riparazioni[i].priorità;
            }
        }

        for (i = 0; i < riparazioni.length; i++) {
            if (max == riparazioni[i].priorità) {
                for (int j = 0; j < tecnici.length; j++) {
                    if (!tecnici[j].isOccupato()) {
                        riparazioni[i].idTecnico = tecnici[j].idTecnico;
                        riparazioni[i].stato = StatoRiparazione.occupata;
                        tecnici[j].occupato = true;

                    }

            }
        }
        }

    }

    public void concludiRiparazione() {

    }

    public void mandainFerie() {

    }

}
