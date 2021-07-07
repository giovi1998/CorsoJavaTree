package stream.es3;

import java.util.Objects;
import java.util.UUID;

public class Utente implements Comparable<Utente> {
    private String nome;
    private String id;
    private int punteggioGlobale = 0;

    public Utente(String nome) {
        this.nome = nome;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public int getPunteggioGlobale() {
        return punteggioGlobale;
    }

    public void setPunteggioGlobale(int punteggioGlobale) {
        this.punteggioGlobale += punteggioGlobale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(id, utente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", punteggioGlobale=" + punteggioGlobale +
                '}';
    }

    @Override
    public int compareTo(Utente o) {
        return getId().compareTo(o.getId());

    }
}
