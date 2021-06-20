package giorni.Supermercato;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //PriorityQueue <Student> studenti=new PriorityQueue<>();
        //studenti.add(new Student(213L,"Giovanni","ciao"));
        Cliente cliente1 = new Cliente("Giovanni", "Cidu", 35);
        Cliente cliente2 = new Cliente("Raffaele", "pippa", 15);
        Cliente cliente3 = new Cliente("Daniele", "pippa", 15);
        Cliente cliente4 = new Cliente("Sandro", "Cidu", 45);
        Cliente cliente5 = new Cliente("Maura", "Cidu", 23);
        Cliente cliente6 = new Cliente("Giacomo", "Cidu", 73);


        Deque <Cliente> coda=new LinkedList<>();
        PriorityQueue <Cliente> queue=new PriorityQueue<>();
        //aggiungi,però se aggiungo più persone si sballa
        queue.offer(cliente1);
        queue.offer(cliente2);
        queue.offer(cliente5);
        queue.offer(cliente3);
        queue.offer(cliente4);
        queue.offer(cliente6);
        int i=0;
        while(queue.size()>i)
        {

            System.out.println(queue.poll());

        }

        /*
        coda.offerLast(cliente1);//doppia lista
        coda.add(cliente2);
        coda.offerFirst(cliente3);*/
        System.out.println(queue);
        //System.out.println(coda);

    }
}
