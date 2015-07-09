package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class Crocodile extends WildAnimal {

    public Crocodile() {
        super(true);
    }

    public Crocodile(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);

    }

    public void hunt () {
        System.out.println("Hunting...");
    }

}
