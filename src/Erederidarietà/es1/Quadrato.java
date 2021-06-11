package Erederidarietà.es1;

import Erederidarietà.es1.FormeGeometriche;

public class Quadrato extends FormeGeometriche {

    private double x;
    private double y;
    private double area;
    private double perimetro;


    public Quadrato(double y, double x) {
        super(y, x);
        this.y=x;
        this.x=x;
    }

    public double getArea() {

        return x*y;
    }

    public void setArea(double y,double x) {
        this.area=x*x;
    }



    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double y,double x) {
        this.perimetro = 4*x;
    }
    public void setPerimetro(double x) {
        this.perimetro = 4*x;
    }

}
