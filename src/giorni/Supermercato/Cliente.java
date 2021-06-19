package giorni.Supermercato;

import java.util.*;

public class Cliente implements Comparable<Cliente> {
    final private String nome;
    final private String cognome;
    public Integer eta;
    final UUID id =UUID.randomUUID();

    public Cliente(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eta);
    }

    public int compareTo(Cliente cliente) {
        if (eta.equals(cliente.getEta())) {
            return 0;
        } else if (eta < cliente.getEta()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta+
                '}';
    }


}
