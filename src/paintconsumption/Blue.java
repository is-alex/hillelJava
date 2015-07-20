package paintconsumption;


public class Blue extends Color {

    public static final String BLUE_CODE = "\u001B[34m";

    public Blue(double paintConsumption, double price) {
        super("blue", BLUE_CODE, paintConsumption, price);
    }


}
