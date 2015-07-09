package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class Wolf  extends WildAnimal  {

    public Wolf(boolean isPredator) {
        super(true);
    }

    public Wolf(int id, int age, float weight, String color) {
        super(id, age, weight, color, true);
    }

}
