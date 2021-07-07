package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Singleton {

    private static List<Singleton> instances;

    private Singleton(){


    }

    public static Singleton getIstance(int numeroDiIstanza) {

        if (numeroDiIstanza > 3 || numeroDiIstanza <= 0) {

            System.out.println("ERRORE ISTANZA NON DISPONIBILE");
            return null;

        }

        if(instances == null){

            instances = new ArrayList<>(3);
            instances.add(null);

        }

        try {

            if (instances.get(numeroDiIstanza) == null) {

                instances.set(numeroDiIstanza, new Singleton());
                return instances.get(numeroDiIstanza);

            }
            else{
                System.out.println("La istanza è gia presente");
                return instances.get(numeroDiIstanza);
            }



        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {

            System.out.println("L'istanza cercata non è presente, inizializzo l'istanza: "+ (instances.size()));
            instances.add(new Singleton());

        }

        return instances.get(instances.size()-1);

    }
}