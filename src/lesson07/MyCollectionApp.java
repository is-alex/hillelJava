package lesson07;

import java.math.BigDecimal;

public class MyCollectionApp {
    public static void main(String[] args) {

        int a = 2;
        String b = "bb";
        BigDecimal c = new BigDecimal(2);

        MyCollection test = new MyCollection(33);
        MyCollection test2 = new MyCollection();

        System.out.println("Size is: " + test.size());

        System.out.println("Is empty: " + test.isEmpty());

        System.out.println("Add BigDecimal c: " + test.add(c));
        System.out.println("Add String b: " + test.add(b));

        System.out.println("Contains BigDecimal c: " + test.contains(c));
        System.out.println("Contains int a " + test.contains(a));
        System.out.println("Contains null: " + test.contains(null));

        System.out.println("Remove String b: " + test.remove(b));

        test2.add(b);
        System.out.println("Size is: " + test.size());
        test.addAll(test2);
        System.out.println("Size is: " + test.size());
        test.clear();

    }
}