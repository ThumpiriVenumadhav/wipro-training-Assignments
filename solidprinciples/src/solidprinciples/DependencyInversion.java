package solidprinciples;

interface ShapeDIP {
    double area();
}

class CircleDIP implements ShapeDIP {
    double radius;

    public CircleDIP(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

class AreaService {
    private ShapeDIP shape;

    public AreaService(ShapeDIP shape) {
        this.shape = shape;
    }

    public void displayArea() {
        System.out.println("Area is: " + shape.area());
    }
}

public class DependencyInversion {
    public static void main(String[] args) {
        ShapeDIP circle = new CircleDIP(5);
        AreaService service = new AreaService(circle);
        service.displayArea();
    }
}
