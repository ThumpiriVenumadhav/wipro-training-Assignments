package solidprinciples;

abstract class BaseShape {
    public abstract double area();
}

class CircleLSP extends BaseShape {
    double radius;

    public CircleLSP(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

class RectangleLSP extends BaseShape {
    double length, width;

    public RectangleLSP(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }
}

public class Liskov {
    public static void main(String[] args) {
        BaseShape shape1 = new CircleLSP(5);
        BaseShape shape2 = new RectangleLSP(4, 6);

        System.out.println("Circle Area: " + shape1.area());
        System.out.println("Rectangle Area: " + shape2.area());
    }
}

