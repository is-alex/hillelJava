package lesson03;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {

        long sum = calculateSum();
        System.out.println("The sum is " + sum);
        System.exit(0);

    }

    private static long calculateSum() {
        long sum = 0;
        long number = inputChecker();
        System.out.println("done");
        if (number < 10) {
            sum = number;
        } else {
            while (number != 0) {
                long lastDigit = number % 10;
                sum = lastDigit + sum;
                number = number / 10;
            }
        }

        return sum;
    }

    private static long inputChecker() {

        long n = 0;
        Scanner scanner = new Scanner(System.in);
        boolean resumeLoop = true;

        do {
            System.out.println("Please, input a positive integer:");
            if (scanner.hasNextLong()) {
                n = scanner.nextLong();
                if (n < 0) {
                    System.out.println("The integer must be positive. Try again.");
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
