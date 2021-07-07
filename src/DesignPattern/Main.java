package DesignPattern;

public class Main {
    public static void main(String[] args) {
        Singleton s1=Singleton.getIstance(1);
        Singleton s2= Singleton.getIstance(2);
        Singleton s3=Singleton.getIstance(3);
        Singleton s4=Singleton.getIstance(3);
        System.out.println(s1);

    }
}
