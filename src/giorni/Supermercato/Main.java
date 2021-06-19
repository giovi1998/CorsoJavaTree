package giorni.Supermercato;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue <Student> studenti=new PriorityQueue<>();
        studenti.add(new Student(213L,"Giovanni","ciao"));
        Cliente cliente1 = new Cliente("Giovanni", "Cidu", 35);
        Cliente cliente2 = new Cliente("Raffaele", "pippa", 15);
        Cliente cliente3 = new Cliente("Daniele", "pippa", 15);
        Cliente cliente4 = new Cliente("Sandro", "Cidu", 45);
        Cliente cliente5 = new Cliente("Maura", "Cidu", 23);
        Cliente cliente6 = new Cliente("Giacomo", "Cidu", 73);


        Deque <Cliente> coda=new LinkedList<>();
        PriorityQueue <Cliente> queue=new PriorityQueue<>();
        //aggiungi,però se aggiungo più persone si sballa
        queue.add(cliente1);
        queue.add(cliente2);
        queue.add(cliente5);
        queue.add(cliente3);
        queue.add(cliente4);
        queue.add(cliente6);



        coda.offerLast(cliente1);//doppia lista
        coda.add(cliente2);
        coda.offerFirst(cliente3);
        System.out.println(queue);
        //System.out.println(coda);

    }
}
