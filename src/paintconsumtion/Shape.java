package paintconsumtion;


import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Shape {


    private String name;
    private Color color;
    private double square = 0;


    public Shape(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getTotalCostOfPainting() {
        double totalCostOfPainting = this.getPaintAmount() * this.color.getPrice();
        return new BigDecimal(totalCostOfPainting).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }

    public double getPaintAmount() {
        double paintAmount = color.getPaintConsumption() * this.getSquare();
        return new BigDecimal(paintAmount).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }

    public double getSquare() {
        return square;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void printResult() {

        System.out.println("The square of this " + this.getName() + " is " + this.getSquare() +
                " m\u00B2, you need " + this.getPaintAmount() +
                " liters of " + this.getColor().getColorCode()  + this.getColor().getName() +
                "\u001B[0m" + " paint. The total cost of painting will be $"
                + this.getTotalCostOfPainting());
    }

}
