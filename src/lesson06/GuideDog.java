package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class GuideDog extends Dog {
    private boolean isTrained;

    public GuideDog(String name, boolean isVaccinated, boolean isTrained) {
        super(name, isVaccinated);
        this.isTrained = isTrained;
    }

    public GuideDog(int id, int age, double weight, String color, String name,
                    boolean isVaccinated, boolean isTrained) {
        super(id, age, weight, color, name, isVaccinated);
        this.isTrained = isTrained;
    }

    public void voice() {
        super.voice("Bark-bark!");
    }

    public void takeHome() {
        System.out.println(getName() + ": Taking home...");
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setIsTrained(boolean isTrained) {
        this.isTrained = isTrained;
    }
}
