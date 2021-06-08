package biblioteca;

public class Libro {
    //libro è caratterizzato da un indice
    public int indice;

    public Libro(int indice)
    {
        if(setIndice(indice))
        this.indice = indice;
    }

    public int getIndice()
    {
        System.out.println("indice del libro "+indice);
        return indice;
    }

    public boolean setIndice(int indice)
    {
        if(indice<0)
        {
            System.out.println("hai sbagliato rinserisci");
            return false;
        }return true;
    }
}
