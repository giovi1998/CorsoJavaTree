package giorni.giorno2;

import java.util.*;
public class Esercizio8 {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        stringReverse(a);
    }

    static void stringReverse(String s) {
        /*String reverse = new StringBuilder(s).reverse().toString();*/
        char ch[]=s.toCharArray();
        String rev="";

        for(int i=ch.length-1;i>=0;i--){
            rev+=ch[i];
        }

        System.out.print(rev);
        //fatto per l'ultimo es palindroma
        if(rev.equalsIgnoreCase(s)) {
            System.out.print("\nla parola e' palindrome");
        }

    }


}
		/*


		System.out.println(reverse);
		System.out.println(string);
		 */


