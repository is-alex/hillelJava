package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class Giraffe  extends WildAnimal {

    public Giraffe() {
        super(false);
    }

    public Giraffe(int id, int age, double weight, String color) {
        super(id, age, weight, color, false);
    }

    public void voice() {
        super.voice("uu-uu!");
    }
}
