package paintconsumption;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle extends Shape{
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(Color color, double sideA, double sideB, double sideC) {
        super("triangle", color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    @Override
    public double getSquare() {
        double p = (sideA + sideB + sideC) / 2;
        double square = (Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC)));
        return new BigDecimal(square).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }
}
