package lesson06;

/**
 * Created by gentoo on 7/9/15.
 */
public class AnimalsApp {
    public static void main(String[] args) {

        Animal animal = new Animal();
        System.out.println("Test animal id: " + animal.getId() + "\n");

        Fish fish = new Fish("Teddy",false);

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
            guideDog.voice();
            guideDog.takeHome();
            System.out.println();
        } else {
            System.out.println("Attention! " + guideDog.getColor() + " guide dog " + guideDog.getName() + " is not trained." + "\n");
        }

        Cat cat = new Cat("Finn",true);
        System.out.print("Cat " + cat.getName() + ": ");
        cat.voice();
        System.out.println("\n");

        System.out.println("Corcodile: ");
        speech(crocodile);

        System.out.println("Cat: ");
        speech(cat);

        System.out.println("Giraffe: ");
        speech(giraffe);

        System.out.println("GuideDog: ");
        speech(guideDog);

        System.out.println("Fish: ");
        speech(fish);

    }


    public static void speech (Object a) {

        if ((a instanceof Fish)) {
            System.out.print("...");
        } else {
            System.out.print("Hello, ");
            if ((a instanceof Pet) && (!((Pet) a).getName().equals(""))) {
                System.out.print("my name is " + ((Pet) a).getName() + ". ");
                if (a instanceof Dog) {
                    System.out.print("Woof! ");
                    if ((a instanceof GuideDog) && (((GuideDog) a).isTrained())) {
                        System.out.print("I can take you home.");
                    }
                } else if (a instanceof Cat) {
                    System.out.print("Meow! ");
                }
            } else if (a instanceof WildAnimal) {
                System.out.print("I am a wild animal");
                if (((WildAnimal) a).isPredator()) {
                    System.out.print(" and I am angry. ");
                }

            }
        }
        System.out.println("\n");
    }

}
