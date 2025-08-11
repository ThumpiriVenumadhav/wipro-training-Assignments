package solidprinciples;



class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}


class AreaPrinter {
    public void print(double area) {
        System.out.println("Area: " + area);
    }
}

public class SingleRes {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        double area = circle.calculateArea();

        AreaPrinter printer = new AreaPrinter();
        printer.print(area);
    }
}

