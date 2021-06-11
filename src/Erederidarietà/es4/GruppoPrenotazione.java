package Erederidarietà.es4;

public class GruppoPrenotazione extends Prenotazione{
    private int numeriDaRiservare;

    public GruppoPrenotazione(String codice,int numeriDaRiservare ) {
        super(codice);
        this.numeriDaRiservare=numeriDaRiservare;
    }

    public int getNumeriDaRiservare() {
        return numeriDaRiservare;
    }

    public void setNumeriDaRiservare(int numeriDaRiservare) {
        this.numeriDaRiservare = numeriDaRiservare;
    }

    @Override
    public String toString() {
        return "GruppoPrenotazione"+ " codice: " + getCodice() +
                " posti da riservare = " + numeriDaRiservare;
    }
}
