package giorni.BibliotecaSet;


import java.util.HashSet;
import java.util.Set;

public class Biblioteca {
    Set<Autore> autori = new HashSet<Autore>();

    public void insertBook(Autore autore, Libro libro) {
        if (autori.isEmpty()) {
            autore.insertLibro(libro);
            autori.add(autore);

        } else {
            autori.add(autore);
            autore.insertLibro(libro);
        }
    }

    public void removeBook(Libro libro) {
        if (autori.contains(libro)) {
            autori.remove(libro);

        }
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "autori=" + autori +
                '}';
    }

    public boolean contains(Libro libro) {
        return autori.contains(libro);
    }
}

