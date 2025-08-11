package solidprinciples;

interface Shape {
    double area();
}

class CircleOC implements Shape {
    double radius;

    public CircleOC(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

class RectangleOC implements Shape {
    double length, width;

    public RectangleOC(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }
}

public class OpenClosed {
    public static void main(String[] args) {
        Shape circle = new CircleOC(5);
        Shape rectangle = new RectangleOC(4, 6);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Rectangle Area: " + rectangle.area());
    }
}

