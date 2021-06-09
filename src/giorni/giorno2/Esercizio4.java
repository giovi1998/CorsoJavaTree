package giorni.giorno2;

public class Esercizio4 {

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "a abc d";
        //System.out.println(a);
        String[] parts = c.split(" ");
        String part1 = parts[0];//a
        String part2 = parts[1];//abc
        String part3 = parts[2];//d
        //System.out.println(part1);
        //System.out.println(part2);

        String nuova = part2.replaceAll("a" ,"b");
        System.out.println("la nuova parte: " + nuova);

        String str3= part1.concat(" " + nuova + " " + part3);
        System.out.println("la nuova stringa :" + str3);

    }

}

