package Erederidarietà.es4;

public class SingolaPrenotazione extends Prenotazione {
    tipoPrenotazione scelta;
    public SingolaPrenotazione(String codice,tipoPrenotazione scelta) {
        super(codice);
        this.scelta=scelta;
    }

    public tipoPrenotazione getScelta() {
        return scelta;
    }

    public void setScelta(tipoPrenotazione scelta) {
        this.scelta = scelta;
    }

    @Override
    public String toString() {
        return "SingolaPrenotazione"+ " codice: " + getCodice() +
                "scelta = " + getScelta();
    }

}
