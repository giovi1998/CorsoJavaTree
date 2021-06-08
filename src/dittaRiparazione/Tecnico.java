package dittaRiparazione;

public class Tecnico {
    final String nomeTecnico;//non cambia mai!
    public boolean occupato;
    public int idTecnico;


    public Tecnico(String nomeTecnico,int idTecnico)
    {
        this.nomeTecnico = nomeTecnico;
        this.occupato = false;
        this.idTecnico = idTecnico;
    }

    //è solo uno il nome non posso segnarlo
    public String getNomeTecnico() {
        return nomeTecnico;
    }

    //settare e prendere se è occupato o no
    public boolean isOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }
}
