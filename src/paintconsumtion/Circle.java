package paintconsumtion;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends Shape {

    private double radius;

    public Circle(Color color, double radius) {
        super("circle", color);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getSquare() {
        double square = Math.PI * Math.pow(radius,2);
        return new BigDecimal(square).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }

}
