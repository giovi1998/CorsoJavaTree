package Erederidarietà.es1;

abstract class FormeGeometriche {
    private double x;
    private double y;
    public FormeGeometriche(double y,double x) {
        this.x=x;
        this.y=y;
    }

    /**
     * ogni classe va a definire il suo getArea e setArea
     * @return
     */
    abstract double getArea();

    abstract void setArea(double y,double x);
    abstract double getPerimetro();

    abstract void setPerimetro(double y,double x);
}
