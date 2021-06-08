package biblioteca;

import java.util.Arrays;
import java.util.Comparator;

public class Biblioteca {
    public Libro [] libri;

    public Biblioteca(Libro[] libri) {
        this.libri = libri;
    }


    public Libro[] getLibri() {
        return libri;
    }

    //libri e indici sono public
    public boolean esisteLibro (int IndiceLibro,int dimensione)
    {
        for(int i=0;i<dimensione;i++){
            if(IndiceLibro == libri[i].indice)return true;
        }

        return false;


    }


//(x)->x.indice lampda expression serve per comparare
    public void ordinaLibri(){
       // Arrays.sort(libri, Comparator.comparingInt(Libro::getIndice));
        Arrays.sort(libri, Comparator.comparingInt((x)-> x.indice));

    }
    public void mergeSortLibri(Libro[] libri, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Libro[] l = new Libro[mid];
        Libro[] r = new Libro[n - mid];

        for (int i = 0; i < mid; i++) {

            l[i] = libri[i];

        }
        for (int i = mid; i < n; i++) {

            r[i - mid] = libri[i];

        }
        mergeSortLibri(l, mid);
        mergeSortLibri(r, n - mid);

        merge(libri, l, r, mid, n - mid);
    }


    public void merge(Libro[] a, Libro[] l, Libro[] r, int left, int right)
    {

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left && j < right) {

            if (l[i].getIndice() <= r[j].getIndice()) {

                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
    public void stampaLibri()
    {
        for(int i=0;i< libri.length;i++){
            System.out.println(libri[i].indice);
        }
    }

}
