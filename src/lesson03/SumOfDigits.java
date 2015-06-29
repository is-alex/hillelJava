package lesson03;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        long n;
        long sum = 0;

        Scanner scanner = new Scanner(System.in);
        boolean resumeLoop = true;
        do {
            System.out.println("Please, input a positive integer:");
            if (scanner.hasNextLong()) {
                n = scanner.nextLong();
                   if (n < 0) {
                       System.out.println("The integer must be positive. Try again.");
                   } else {
                       System.out.println("done");
                       if (n < 10) {
                           sum = n;
                       } else {
                           while (n!=0) {
                               long lastDigit = n % 10;
                               sum = lastDigit + sum;
                               n = n/10;
                                }
                           }
                       resumeLoop = false;
                       }
               }
            else {
                System.out.println("Incorrect entry " + scanner.next() + ". Try again.");
            }
        }
        while (resumeLoop);
        System.out.println("The sum is " + sum);
        System.exit(0);
    }
}
