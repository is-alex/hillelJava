package lesson08;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MyLinkedListApp {
    public static void main(String[] args) {

        int a = 1;
        double b = 2.22;
        String string = "Hello";
        BigDecimal bigDecimal = new BigDecimal(123456789);

        MyLinkedList list = new MyLinkedList();
        list.add(a);
        list.add(b);
        list.add(string);
        list.add(bigDecimal);

        System.out.println("Contains a : " + list.contains(a));
        list.remove(string);
        list.print();

        ArrayList list2  = new ArrayList();
        for (int i=0;i<5;i++) {
            list2.add(a);
        }
        System.out.println("List 2: " +  list2.toString());

        System.out.println("Add all:" + list.addAll(list2));
        list.print();

        System.out.println("Contains all: " + list.containsAll(list2));

        System.out.println("Retain all : " + list.retainAll(list2));
        list.print();


        System.out.println("Remove all : " + list.removeAll(list2));
        list.print();

        System.out.println("Clearing list 1 ..");
        list.clear();
        list.print();

    }

}
