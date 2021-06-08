package dittaRiparazione;

public class Riparazione {
    public String indirizzo;
    public int priorità;
    public StatoRiparazione stato;
    public int idTecnico;

    public Riparazione(String riparazioneIndirizzo,int priorità) {
        this.priorità=priorità;
        this.stato =StatoRiparazione.inAttesa;
        this.indirizzo = riparazioneIndirizzo;
        this.idTecnico=0;
    }

    //getter e setter
    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


    public int getPriorità() {
        return priorità;
    }

    public void setPriorità(int priorità) {
        this.priorità = priorità;
    }

    public StatoRiparazione getStato() {
        return stato;
    }

    public void setStato(StatoRiparazione stato) {
        this.stato = stato;
    }

}
