package giorni.BibliotecaSet;

import java.util.HashSet;
import java.util.Objects;

public class Libro extends HashSet<Autore>{
    String idLibro;
    String titoloLibro;
    String sinosi;

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitoloLibro() {
        return titoloLibro;
    }

    public void setTitoloLibro(String titoloLibro) {
        this.titoloLibro = titoloLibro;
    }

    public Libro(String idLibro, String titoloLibro, String sinosi) {
        this.idLibro = idLibro;
        this.titoloLibro = titoloLibro;
        this.sinosi = sinosi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Libro autores = (Libro) o;
        return idLibro.equals(autores.idLibro) && titoloLibro.equals(autores.titoloLibro) && sinosi.equals(autores.sinosi);
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idLibro, titoloLibro, sinosi);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titoloLibro='" + titoloLibro + '\'' +
                '}';
    }
}
