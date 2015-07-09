package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class Dog extends Pet {

    public Dog(String name, boolean isVaccinated) {
        super(name, isVaccinated);
    }

    public Dog(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    public void voice() {
        super.voice("Bark!");
    }

}
