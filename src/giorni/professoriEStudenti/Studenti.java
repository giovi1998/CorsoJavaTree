package giorni.professoriEStudenti;

import java.util.Objects;

public class Studenti extends Persona {
    final int id;
    private int laurea;
    public Studenti(String nome, String cognome, int id, int laurea) {
        super(nome , cognome);
        this.id=id;
        this.laurea = laurea;
    }

    public int getId() {
        return id;
    }

    public int getLaurea() {
        return laurea;
    }

    public void setLaurea(int laurea) {
        this.laurea = laurea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studenti studenti = (Studenti) o;
        return id == studenti.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
