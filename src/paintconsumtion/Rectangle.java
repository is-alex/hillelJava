package paintconsumtion;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rectangle extends Shape {
    private double sideA;
    private double sideB;

    public Rectangle(Color color, double sideA, double sideB) {
        super("rectangle", color);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    @Override
    public double getSquare() {
        double square = sideA*sideB;
        return new BigDecimal(square).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }
}
