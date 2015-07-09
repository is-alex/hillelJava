package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class AnimalsApp {
    public static void main(String[] args) {

        Animal animal = new Animal();
        System.out.println("Test animal id: " + animal.getId() + "\n");

        Giraffe giraffe = new Giraffe(1,23,55.83,"orange");
        System.out.println("Giraffe: id " + giraffe.getId() + ", age: " + giraffe.getAge() + ", weight: "
                + giraffe.getWeight() + ", color: " + giraffe.getColor() + "\n");

        Crocodile crocodile = new Crocodile();
        crocodile.setId(2);
        crocodile.setAge(8);
        crocodile.hunt();
        System.out.println("Crocodile: id " + crocodile.getId() + ", age: " + crocodile.getAge() + "\n");


        Dog dog = new Dog("Jack",true);
        System.out.println("Dog's name is: " + dog.getName() + "\n");

        GuideDog guideDog = new GuideDog(99,5,38.255,"white","Oliver",true,true);
        if (guideDog.isTrained()) {
            System.out.println(guideDog.getColor() + " guide dog " + guideDog.getName()+ " is trained.");
            guideDog.takeHome();
        } else {
            System.out.println("Attention! " + guideDog.getColor() + " guide dog " + guideDog.getName() + " is not trained.");
        }




    }
}
