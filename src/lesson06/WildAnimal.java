package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class WildAnimal extends Animal {

    private boolean isPredator;

    public WildAnimal(int id, int age, double weight, String color, boolean isPredator) {
        super(id, age, weight, color);
        this.isPredator = isPredator;
    }

    public WildAnimal(boolean isPredator) {
        this.isPredator = isPredator;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public void setIsPredator(boolean isPredator) {
        this.isPredator = isPredator;
    }
}

