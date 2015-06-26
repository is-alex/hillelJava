package lesson02;

import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {

        int n = 0;

        Scanner scanner = new Scanner(System.in);
        boolean resumeLoop = true;
        do {
            System.out.println("Please, input a number:");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                resumeLoop = false;
            } else {
                System.out.println("Incorrect entry " + scanner.next() + ". Try again.");
            }
        }
        while (resumeLoop);

        if (n%2==0) {
            System.out.println(n + " is an even  number");
        } else {
            System.out.println(n + " is an odd  number");
        }
        scanner.close();
        System.exit(0);
    }
}