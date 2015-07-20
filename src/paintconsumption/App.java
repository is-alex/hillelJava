package paintconsumption;


public class App {


    public static void main(String[] args) {
        Red red = new Red(0.84, 18.09);
        Green green = new Green(1.00, 10.00);
        Blue blue = new Blue(0.5, 25.33);

        Circle circle = new Circle(blue,10);
        System.out.print("Circle 1: ");
        circle.printResult();

        Circle circle2 = new Circle(green,2.7);
        System.out.print("Circle 2: ");
        circle2.printResult();

        Rectangle rectangle = new Rectangle(red,15.25,8.12);
        System.out.print("Rectangle 1: ");
        rectangle.printResult();

        Triangle triangle = new Triangle(green,3,4,5);
        System.out.print("Triangle 1: ");
        triangle.printResult();

        Triangle triangle2 = new Triangle(red,7,15,12);
        System.out.print("Triangle 2: ");
        triangle2.printResult();

        System.out.println();
        CollectionOfShapes collection = new CollectionOfShapes();
        collection.add(circle);
        collection.add(circle2);
        collection.add(rectangle);
        collection.add(triangle);
        collection.add(triangle2);
        System.out.println("Total cost: $" + collection.getTotalCost());
        System.out.println("Total paint volume (liters): " + collection.getTotalAmount());
        System.out.println("Total square (m\u00B2): " + collection.getTotalSquare());


    }
}
