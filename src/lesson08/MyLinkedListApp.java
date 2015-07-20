package lesson08;

import java.math.BigDecimal;
import java.util.ArrayList;


public class MyLinkedListApp {
    public static void main(String[] args) {

        int a = 1;
        double b = 2.22;
        String string = "Hello";
        BigDecimal bigDecimal = new BigDecimal(123456789);

        MyLinkedList list = new MyLinkedList();
        list.add(a);
        list.add(b);
        list.add(null);
        list.add(string);
        list.add(bigDecimal);
        list.add(null);
        System.out.println("List1 isEmpty:  " + list.isEmpty());
        System.out.println("Size of list1: " + list.size() + "\n");

        System.out.println("Contains a : " + list.contains(a));
        list.remove(b);
        System.out.print("Add itself (MyLinkedList): " + list.addAll(list) + ";\nResult: ");
        list.print();
        System.out.println("Size of list1: " + list.size() + "\n");
        System.out.println("Head is: " + list.getHead().toString());
        System.out.print("Extracting tail: ");
        list.getTail().print();
        System.out.println("Size of list1: " + list.size() + "\n");

        ArrayList list2  = new ArrayList();
        for (int i=0;i<10;i++) {
            list2.add(i);
        }
        System.out.println("List 2: " +  list2.toString());

        System.out.print("Add all: " + list.addAll(list2) + ";\nResult: ");
        list.print();
        System.out.print("\nPrinting backwards: ");
        list.printBackwards();
        System.out.println("\n");

        System.out.println("Contains all: " + list.containsAll(list2));
        //list.print();

        System.out.println("Retain all : " + list.retainAll(list2));
        //list.print();

        System.out.println("Remove all : " + list.removeAll(list2));
        //list.print();
        //System.out.println("Clearing list 1 ...");
        list.clear();

    }

}
