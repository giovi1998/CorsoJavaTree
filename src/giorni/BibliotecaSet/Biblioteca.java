package giorni.BibliotecaSet;


import java.util.HashSet;
import java.util.Set;

public class Biblioteca {
    Set<Autore> autori = new HashSet<>();

    public void insertBook(Autore autore, Libro libro) {
        if (autori.isEmpty()) {
            autori.add(autore);
            autore.insertLibro(libro);

        } else if (contains(autore)) {
            autore.insertLibro(libro);
        } else {
            autori.add(autore);
            autore.insertLibro(libro);
        }
    }

    //devo vedere tra i libri tra gli autori devo anche ciclare
    public void removeBook(Libro libro) {

        for (Autore i : autori) {
            i.getLibri().remove(libro);
        }

    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "autori=" + autori +
                '}';
    }


    public boolean contains(Libro libro) {
        for (Autore i : autori) {
            return i.getLibri().contains(libro);
        }
        return false;
    }

    public boolean contains(Autore autore) {
        return autori.contains(autore);
    }

    public boolean contains(String idLibro) {
        for (Autore i : autori) {
            for (Libro j : i.getLibri()) {
                if (j.getIdLibro().equals(idLibro) || j.getTitoloLibro().equals(idLibro)) return true;
            }

        }
        return false;
    }

    public void stampaLibri(Autore autore) {
        if (contains(autore)) autore.stampaLibri();
        else System.out.println("non ho trovato l'autore "+autore);
    }
}

