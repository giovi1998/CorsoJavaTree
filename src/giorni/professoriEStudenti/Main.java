package giorni.professoriEStudenti;

public class Main {
    public static void main(String[] args) {
        /** metodo Per prendere magari una persona
         * ma facevo prima a fare solo una classe?
         * Persona persona1=new Studenti("Giovanni","cidu",123);
         *         System.out.println(persona1.getNome());
         *         ((Studenti)persona1).getId();
         */

        Studenti persona1 = new Studenti("Giovanni" , "cidu", 123, 2001);
        System.out.println(persona1.getCognome());
        persona1.getId();

        Persona persona2 = new Studenti("Giovanni", "cidu", 123, 2011);
        System.out.println(persona2.getNome());
        ((Studenti) persona2).getId();
        ((Studenti) persona2).getLaurea();

    }
}
