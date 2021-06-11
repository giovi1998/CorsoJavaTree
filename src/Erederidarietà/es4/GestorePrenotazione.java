package Erederidarietà.es4;


import java.util.Arrays;

public class GestorePrenotazione {


    private int numeriASedere;
    private int interni;
    private int esterni;
    final int interniMax = 35;
    final int esterniMax = 15;
    final int numeroMaxPerSedere = interniMax + esterniMax;
    Prenotazione[] prenotazioni;


    public GestorePrenotazione(Prenotazione[] prenotazioni) {
        this.prenotazioni = prenotazioni;
        this.numeriASedere = getNumeroPrenotazioni();
    }

    public Prenotazione[] getPrenotazioni() {
        return prenotazioni;
    }

    public int getNumeroPrenotazioni() {
        int temp=0;
        for (Prenotazione prenotazione : prenotazioni) {
            if (prenotazione instanceof GruppoPrenotazione) {
               temp =((GruppoPrenotazione) prenotazione).getNumeriDaRiservare()+temp;

            }
            if(prenotazione instanceof SingolaPrenotazione){
                temp=temp+1;
            }
        }
        numeriASedere=temp;
        return this.numeriASedere;
    }

    public void setPrenotazioni(Prenotazione[] prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public int getNumeroMaxPerSedere() {
        return numeroMaxPerSedere;
    }

    public int getNumeriASedere() {
        return numeriASedere;
    }

    public void setNumeriASedere(int numeriASedere) {
        this.numeriASedere = numeriASedere;
    }

    public boolean caricaPrenotazione(Prenotazione prenotazione) {
        if (prenotazioni == null) {

            prenotazioni = new Prenotazione[1];
            prenotazioni[0] = prenotazione;
            return true;
        }

        if (prenotazione instanceof GruppoPrenotazione) {
            if (getNumeroPrenotazioni() <= numeroMaxPerSedere - (((GruppoPrenotazione) prenotazione).getNumeriDaRiservare())) {
                creazioneNuovoArray(prenotazione);
                int temp=getNumeroPrenotazioni();
                this.numeriASedere=temp;
                return true;
            } else {
                return false;
            }
        } else {
            if (getNumeroPrenotazioni() < numeroMaxPerSedere - 1) {
                creazioneNuovoArray(prenotazione);
                int temp=getNumeroPrenotazioni();
                this.numeriASedere=temp;
                return true;
            } else {
                return false;
            }

        }
    }


    public void creazioneNuovoArray(Prenotazione prenotazione) {
        Prenotazione[] newPrenotazione = Arrays.copyOf(getPrenotazioni(), prenotazioni.length + 1);
        newPrenotazione[prenotazioni.length] = prenotazione;
       setPrenotazioni(newPrenotazione);
        return;
    }


    @Override
    public String toString() {
        return "GestorePrenotazione :" +
                "numeri a sedere " + getNumeroMaxPerSedere() +
                " prenotazioni=" + Arrays.toString(prenotazioni) +
                " numero di posti gia occupati " + getNumeriASedere();
    }
}
