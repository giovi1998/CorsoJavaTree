package giorni.giorno6;

import java.util.Arrays;

//Progettare un'interfaccia Iterabile che permette di fare le seguenti operazioni
//
//Object next() che permette di ottenere il prossimo elemento
//boolean hasNext() che indica se è presente un prossimo elemento nella sequenza
//void reset() che fa resetta l'iterazione
//Progettare due classi ListaDiInteri, costruita con un array di interi, e MiaStringa, costruita con una stringa, che usano l'interfaccia Iterabile e ne implementano i metodi (Considerare una stringa come una sequenza di char)
//
//Usare il codice di test per verificare le funzioni
public interface Iterable {

    public Object next();

    public boolean hasNext();

    public void reset();

}
class MiaStringa implements Iterable{

    char[] stringa;
    int posizioneElemento;

    public MiaStringa(String stringa){

        this.stringa = stringa.toCharArray();
        posizioneElemento = 0;

    }


    @Override
    public Object next() {

        if(hasNext()){

            posizioneElemento++;
            return stringa[posizioneElemento];

        }

        return null;

    }

    @Override
    public boolean hasNext() {

        if(posizioneElemento >= stringa.length){

            return false;

        }

        return true;

    }

    @Override
    public String toString() {
        return "MiaStringa{" +
                "stringa=" + Arrays.toString(stringa) +
                '}';
    }

    @Override
    public void reset() {

        posizioneElemento = 0;


    }
}
class ListaDiInteri implements Iterable {

    private int[] array;
    private int posizioneElemento;

    public ListaDiInteri(int[] array){

        this.array = array;
        posizioneElemento = 0;

    }


    @Override
    public Object next() {

        if(hasNext()) {

            posizioneElemento++;
            return array[posizioneElemento];

        }

        return null;

    }

    @Override
    public boolean hasNext() {

        if(posizioneElemento >= array.length-1)

            return false;

        return true;

    }

    @Override
    public void reset() {

        posizioneElemento = 0;
        return;

    }

    @Override
    public String toString() {
        return "ListaDiInteri{" +
                "array=" + Arrays.toString(array) +
                ", posizioneElemento=" + posizioneElemento +
                '}';
    }
}