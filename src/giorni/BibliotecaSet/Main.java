package giorni.BibliotecaSet;

public class Main {

    public static void main(String[] args) {
        Biblioteca library=new Biblioteca();
        Libro b = new Libro(
                "123456",
                "Il signore degli anelli",
                "Il Signore degli Anelli (titolo originale in inglese: " +
                        "The Lord of the Rings) è un romanzo high fantasy epico scritto da J. R. R. Tolkien" +
                        " e ambientato alla fine della Terza Era dell'immaginaria Terra di Mezzo"
        );

        Libro b1 = new Libro(
                "daskjds1",
                "provaLibro",
                "lasjdaslk"
        );

        Autore a = new Autore(
                "abcdef",
                "John Ronald Reuel",
                "Tolkien"
        );
        library.insertBook(a, b);
        Libro b2 = new Libro(
                "111111",
                "Lo Hobbit",
                "Lo Hobbit o la riconquista del tesoro (titolo originale: The Hobbit, sottotitolato" +
                        " There and Back Again, ossia \"Andata e ritorno\")," +
                        " noto anche semplicemente come Lo Hobbit, è un romanzo fantasy scritto da J. R. R. Tolkien."
        );
        library.insertBook(a, b2);


        Libro b3 = new Libro(
                "119929",
                "1984",
                "1984 (Nineteen Eighty-Four) è uno dei più celebri romanzi di George Orwell, " +
                        "pubblicato nel 1949 ma iniziato a scrivere nel" +
                        " 1948 (anno da cui deriva il titolo, ottenuto appunto dall'inversione delle ultime due cifre)."
        );
        Autore a2 = new Autore(
                "aaabbb",
                "George",
                "Orwell"
        );
        Autore a3 = new Autore(
                "aaabbb",
                "Giovanni",
                "Orwell"
        );

        library.removeBook(b);


        library.insertBook(a2, b3);


        Libro b4 = new Libro(
                "454545",
                "La fattoria degli animali",
                "La fattoria degli animali è una novella allegorica di George Orwell pubblicata " +
                        "per la prima volta il 17 agosto 1945. Secondo Orwell, il libro riflette sugli " +
                        "eventi che portarono alla Rivoluzione russa e successivamente all'era staliniana " +
                        "dell'Unione sovietica"
        );
        Libro b5 = new Libro(
                "454245",
                "aaa",
                "La fattoria "
        );
        library.insertBook(a2, b4);
        library.insertBook(a2, b5);

        System.out.println(library.contains(a2));
        library.stampaLibri(a2);
        System.out.println(library);
    }
}
