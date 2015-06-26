package lesson02;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class AverageOfThreeNumbers{
    public static void main(String[] args) {
        System.out.println("The average of three numbers.");

        Scanner scanner = new Scanner(System.in);

        BigDecimal n1 = BigDecimal.ZERO;
        BigDecimal n2 = BigDecimal.ZERO;
        BigDecimal n3 = BigDecimal.ZERO;

        boolean resumeLoop = true;
        do {
            System.out.println("Please, input the first number");
            if (scanner.hasNextBigDecimal()) {
                n1 = scanner.nextBigDecimal();
                System.out.println("Your input " + n1.toPlainString() + " as the 1st number");
                resumeLoop = false;
            } else {
                System.out.println("Incorrect entry " + scanner.next() + ". You must enter numbers. Try again.");
            }
        }
        while (resumeLoop);

        boolean resumeLoop2 = true;
        do {
            System.out.println("Please, input the 2nd number");
            if (scanner.hasNextBigDecimal()) {
                n2 = scanner.nextBigDecimal();
                System.out.println("Your input " + n2.toPlainString() + " as the 2nd number");
                resumeLoop2 = false;
            } else {
                System.out.println("Incorrect entry " + scanner.next() + ". You must enter numbers. Try again.");
            }
        }
        while (resumeLoop2);

        boolean resumeLoop3 = true;
        do {
            System.out.println("Please, input the 3rd number");
            if (scanner.hasNextBigDecimal()) {
                n3 = scanner.nextBigDecimal();
                System.out.println("Your input " + n3.toPlainString() + " as the 3rd number");
                resumeLoop3 = false;
            } else {
                System.out.println("Incorrect entry " + scanner.next() + ". You must enter numbers. Try again.");
            }
        }
        while (resumeLoop3);

        BigDecimal sum = (n1.add(n2));
        BigDecimal sum2 = (sum.add(n3));
        sum2 = sum2.setScale(8, RoundingMode.HALF_DOWN);

        int count = 3;
        BigDecimal average = (sum2.divide(new BigDecimal(count), 8, RoundingMode.HALF_DOWN));

        System.out.println("Average is: " + average.toPlainString());

        scanner.close();
        System.exit(0);
    }
}


