package paintconsumption;


public class Red extends Color{

    public static final String RED_CODE = "\u001B[31m";

    public Red(double paintConsumption, double price) {
        super("red", RED_CODE, paintConsumption, price);
    }

}
