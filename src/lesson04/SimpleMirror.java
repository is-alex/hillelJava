package lesson04;

import java.util.Scanner;

public class SimpleMirror {
    public static void main(String[] args) {

            long n = InputChecker();
                System.out.println("The result:");

                while (n>0) {
                    long lastDigit = n % 10;
                    System.out.print(lastDigit);
                    n = n/10;
                }

        System.exit(0);
    }


    public static long InputChecker () {
        boolean resumeLoop = true;
        long n = 0;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please, input a number:");
            if (scanner.hasNextLong()) {
                n = scanner.nextLong();
                if (n <= 0) {
                    System.out.println("The number must be positive. Try again.");
                } else {
                    resumeLoop = false;
                }
            } else {
                    System.out.println("Incorrect entry " + scanner.next() + ". Try again.");
                }
            }
        while (resumeLoop);
        return n;

    }
}
