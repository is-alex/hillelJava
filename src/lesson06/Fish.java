package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class Fish extends Pet {

    public Fish(String name, boolean isVaccinated) {
        super(name, isVaccinated);
    }

    public Fish(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }
}
