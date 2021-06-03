package giorno2;

public class Esercizio5 {
    public static void main(String[] args) {
        String a = "Ciao";
        String b = "Ciao";
        String c = "Tree";
        //per ignorare che sia minuscolo o maiuscolo prendo e le rendo tutte maiuscole
        if (a.equalsIgnoreCase(b) && a.equalsIgnoreCase(c))
        {
            System.out.println(3);

        } else if(a.equalsIgnoreCase(b) || a.equalsIgnoreCase(c) || b.equalsIgnoreCase(c))
        {

            System.out.println(2);

        }else
        {
            System.out.println("Sono tutte diverse!!"+a+b+c);
        }
    }
}