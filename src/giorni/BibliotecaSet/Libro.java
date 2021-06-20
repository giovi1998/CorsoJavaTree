package giorni.BibliotecaSet;

public class Libro{
    String idLibro;
    String titoloLibro;
    String sinosi;

    public Libro(String idLibro, String titoloLibro, String sinosi) {
        this.idLibro = idLibro;
        this.titoloLibro = titoloLibro;
        this.sinosi = sinosi;
    }

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

    public String getSinosi() {
        return sinosi;
    }

    public void setSinosi(String sinosi) {
        this.sinosi = sinosi;
    }


    @Override
    public String toString() {
        return "Libro{" +
                "titoloLibro='" + titoloLibro + '\'' +
                '}';
    }
}
