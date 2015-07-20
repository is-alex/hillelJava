package paintconsumption;


public abstract class Color {

    private String name;
    private String colorCode;
    private double paintConsumption;
    private double price;

    public Color(String name, String colorCode, double paintConsumption, double price) {
        this.name = name;
        this.colorCode = colorCode;
        this.paintConsumption = paintConsumption;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getColorCode() {
        return colorCode;
    }

    public double getPaintConsumption() {
        return paintConsumption;
    }

    public double getPrice() {
        return price;
    }

    public void setPaintConsumption(double paintConsumption) {
        this.paintConsumption = paintConsumption;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
