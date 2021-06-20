package giorni.BibliotecaSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Autore implements Set<Autore> {
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

    public void insertLibro(Libro libro) {
        libriDelAutore.add(libro);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Autore> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Autore autore) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Autore> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", libriDelAutore=" + libriDelAutore +
                '}';
    }


}
