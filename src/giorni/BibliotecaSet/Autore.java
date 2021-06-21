package giorni.BibliotecaSet;

import java.util.*;

public class Autore extends HashSet<Autore> {
    String codiceAutore;
    String nome;
    String cognome;
    //dico che voglio un hashSet di Libro
    Set<Libro> libriDelAutore = new HashSet<Libro>();

    public Autore(String codiceAutore, String nome, String cognome) {
        this.codiceAutore = codiceAutore;
        this.nome = nome;
        this.cognome = cognome;
    }

    public Set<Libro> getLibri    () {
        return libriDelAutore;
    }

    public String getCodiceAutore() {
        return codiceAutore;
    }

    public void setCodiceAutore(String codiceAutore) {
        this.codiceAutore = codiceAutore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Set<Libro> getLibriDelAutore() {
        return libriDelAutore;
    }

    public void setLibriDelAutore(Set<Libro> libriDelAutore) {
        this.libriDelAutore = libriDelAutore;
    }

    public void insertLibro(Libro libro) {
        libriDelAutore.add(libro);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Autore autore = (Autore) o;
        return codiceAutore.equals(autore.codiceAutore) && nome.equals(autore.nome) && cognome.equals(autore.cognome) && libriDelAutore.equals(autore.libriDelAutore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codiceAutore, nome, cognome, libriDelAutore);
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", libriDelAutore=" + libriDelAutore +
                '}';
    }


}
