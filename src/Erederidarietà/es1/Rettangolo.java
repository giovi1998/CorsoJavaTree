package Erederidarietà.es1;

import Erederidarietà.es1.FormeGeometriche;

public class Rettangolo extends FormeGeometriche {

    private double x;
    private double y;
    private double area;
    private double perimetro;


    public Rettangolo(double y, double x) {
        super(y, x);
        this.x=x;
        this.y=y;
    }

    public double getArea() {

        return x*y;
    }

    public void setArea(double y,double x) {
        this.area=x*y;
    }


    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double y,double x) {
        this.perimetro = 2*y+2*x;
    }
}
