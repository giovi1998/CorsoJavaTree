package biblioteca;

import static biblioteca.Libro.*;

class Main {
    public static void main(String[] args) {
        Libro [] values = new Libro[7];
        values[0]=new Libro(2);
        values[1]=new Libro(4);
        values[2]=new Libro(33);
        values[3]=new Libro(76);
        values[4]=new Libro(2);
        values[5]=new Libro(63);
        values[6]=new Libro(85);

        Biblioteca library = new Biblioteca(values);

        library.stampaLibri();

        System.out.println(library.esisteLibro(values[3].indice, values.length));

        //library.mergeSortLibri(values, values.length);
        library.ordinaLibri();

        System.out.println("Liberi ordinati");
        library.stampaLibri();

    }
}
