package Erederidarietà.es4;

abstract class Prenotazione  {
    private String codice;
    /**
     * costruttore
     * @param codice
     */
    public Prenotazione(String codice) {
        this.codice = codice;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
}
