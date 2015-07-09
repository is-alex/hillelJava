package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class Hamster extends Pet {

    public Hamster(String name, boolean isVaccinated) {
        super(name, isVaccinated);
    }

    public Hamster(int id, int age, double weight, String color, String name, boolean isVaccinated) {
        super(id, age, weight, color, name, isVaccinated);
    }

    public void voice() {
        super.voice("zz-zz!");
    }
}
