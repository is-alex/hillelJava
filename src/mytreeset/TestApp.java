package mytreeset;


import java.math.BigDecimal;
import java.util.HashMap;

public class TestApp {
    public static void main(String[] args) {

        MyTreeSet <BigDecimal> tree = new MyTreeSet<>();
        BigDecimal a = new BigDecimal(10.25);
        BigDecimal b = new BigDecimal(-2015);
        BigDecimal c = new BigDecimal(-40004);
        BigDecimal d = new BigDecimal(800.5);
        BigDecimal e = new BigDecimal(-1562);
        BigDecimal f = new BigDecimal(1098);
        BigDecimal g = new BigDecimal(111112);
        BigDecimal h = new BigDecimal(-1);

        tree.add(a);
        tree.add(b);
//        tree.add(c);
        tree.add(d);
        tree.add(e);
        tree.add(f);
        tree.add(g);
        tree.add(h);


        System.out.println("Contains " + a.toString() + ": " + tree.contains(a));
        System.out.println("Contains " + b.toString() + ": " + tree.contains(b));
        System.out.println("Contains " + c.toString() + ": " + tree.contains(c));
        System.out.println();
        System.out.println(tree.toString());
        System.out.println("Min: " + tree.getMin());
        System.out.println("Max: " + tree.getMax());
        System.out.println("Size: " + tree.size());

        BigDecimal d1 = new BigDecimal(800.6);
        System.out.println("Floor: " + tree.floor(d1));
        System.out.println("Ceiling: " + tree.ceiling(d1));

// testing exceptions
        MyTreeSet treeSet = new MyTreeSet();
        HashMap x = new HashMap();
        HashMap z = new HashMap();

        treeSet.add(x);
//        treeSet.add(z);
//        treeSet.add(null);
//        treeSet.add("test");
//        System.out.println(treeSet.contains(1));
//        System.out.println(treeSet.contains(null));

    }

}
