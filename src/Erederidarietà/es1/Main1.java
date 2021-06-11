package Erederidarietà.es1;

public class Main1 {
    public static void main(String[] args) {
        double x=3.0;
        double y=4.0;

        Rettangolo rettangolo = new Rettangolo(y,x);
        Quadrato quadrato = new Quadrato(y,x);

        System.out.println(quadrato.getArea());
        System.out.println(rettangolo.getArea());
    }

}
