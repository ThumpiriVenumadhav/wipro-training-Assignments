package solidprinciples;

interface AreaCalculable {
    double area();
}

interface Drawable {
    void draw();
}

class CircleIS implements AreaCalculable, Drawable {
    double radius;

    public CircleIS(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public void draw() {
        System.out.println("Drawing a circle...");
    }
}

class SquareIS implements AreaCalculable {
    double side;

    public SquareIS(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }
}

public class InterfaceSegregation {
    public static void main(String[] args) {
        AreaCalculable circle = new CircleIS(5);
        AreaCalculable square = new SquareIS(4);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Square Area: " + square.area());
    }
}
