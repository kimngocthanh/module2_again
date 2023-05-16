package ss6;

public class Circle {
    private double radius;
    private String color;
    //ko kế thừa
    public Circle(){

    }
    // được kế thừa
    // overload
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    //đc kế thừa
    // overload
    public double getRadius() {
        return radius;
    }
    // đc kế thừa

    public void setRadius(double radius) {
        this.radius = radius;
    }
    // đc kế thừa

    public String getColor() {
        return color;
    }
    //đc kế thừa

    public void setColor(String color) {
        this.color = color;
    }
    //đc kế thừa

    public double getArea() {
        return Math.pow(this.getRadius(), 2)* Math.PI;
    }
    // đc kế thừa

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
    //đc kế thừa
    // override
}
