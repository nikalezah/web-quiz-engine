import java.util.Scanner; // do not remove the import

class Circle implements Measurable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        return Math.PI * Math.pow(radius, 2);
    }
}

// do not change the interface
interface Measurable {
    double square();
}