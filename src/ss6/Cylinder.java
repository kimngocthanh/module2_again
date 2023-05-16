package ss6;

public class Cylinder extends Circle {
    private double height;
    // ko kế thừa
    public Cylinder(){

    }
    //đc kế thừa
    //overload

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }
    // đc kế thừa
    //overload

    public double getHeight() {
        return height;
    }
    // đc kế thừa

    public void setHeight(double height) {
        this.height = height;
    }
    // đc kế thừa

    public double getVolume(){
        return super.getArea()*this.height;
    }
    // đc kế thừa

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                "which is a subclass of " +
                super.toString() +
                '}';
    }
    //đc kế thừa
    // override
}
