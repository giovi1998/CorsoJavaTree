package giorni.professoriEStudenti;

import java.util.Objects;

public class Prof extends Persona{
    private int idProf;
    public Prof(String nome, String cognome,int idProf) {
        super(nome, cognome );
        this.idProf=idProf;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prof prof = (Prof) o;
        return idProf == prof.idProf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProf);
    }
}
