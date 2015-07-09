package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class Cat extends Pet {
    public Cat(String name, boolean isVaccinated) {
        super(name, isVaccinated);
    }

    public Cat(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }
}
