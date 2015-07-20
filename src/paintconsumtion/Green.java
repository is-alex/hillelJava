package paintconsumtion;


public class Green extends Color {

    public static final String GREEN_CODE = "\u001B[32m";

    public Green(double paintConsumption, double price) {
        super("green", GREEN_CODE, paintConsumption, price);
    }

}
