package giorno2;

public class Esercizio3 {

    public static void main(String[] args) {
        String s = "come stai";
        System.out.println(s);
        String[] parts = s.split( " ");
        String part1 = parts[0];
        String part2 = parts[1];
        System.out.println(part1);
        System.out.println(part2);
        boolean confronta;
        if (part1.equals(part2)==true ) {
            System.out.println("Sono uguali");

        }else {
            String str3= part2.concat(" " + part1);
            System.out.println(str3);
        }
    }

}
