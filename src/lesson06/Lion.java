package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class Lion  extends WildAnimal {

    public Lion(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }

    public Lion() {
        super(true);
    }

    public void voice() {
        super.voice("Rr-rr-rr!");
    }
}
