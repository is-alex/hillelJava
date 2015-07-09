package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class Animal {
    private int id;
    private int age;
    private double weight;
    private String color;


    public Animal(int id, int age, double weight, String color) {
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Animal() {
        this.id = 0;
        this.age = 0;
        this.weight = 0;
        this.color = "";
    }

    public void voice () {
        System.out.println("Hello...");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
