package lesson02;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class AverageOfThreeNumbers{
    public static void main(String[] args) {

        System.out.println("Average calculator. Please, input numbers:");
        int i = 0;
        BigDecimal [] numbers = new BigDecimal [i];

        boolean isLoop = true;
        do  {
             numbers = ExpandArray(numbers, 1);
             numbers[i] = InputBigDecimalChecker((i + 1));

                 if (numbers [i].compareTo(BigDecimal.ZERO) == 0) {
                     isLoop = false;
                 } else {
                     i++;
                 }
            } while (isLoop);

        BigDecimal sum = BigDecimal.ZERO;
        for (i=0; i<numbers.length; i++){
            sum = sum.add(numbers[i]);
            }

        sum = sum.setScale(8, RoundingMode.HALF_DOWN);
        BigDecimal average = (sum.divide(new BigDecimal((numbers.length - 1)), 8, RoundingMode.HALF_DOWN));

        System.out.println("The average is: " + average.toPlainString());

        System.exit(0);
    }

    public static BigDecimal InputBigDecimalChecker(int i) {

        Scanner scanner = new Scanner(System.in);
        BigDecimal n1 = BigDecimal.ZERO;

        boolean resumeLoop = true;
        do {
            System.out.println("Number " + i + ": (or type \"f\" to finish input)");

            if (scanner.hasNext("f")) {
                n1 = BigDecimal.ZERO;
                scanner.close();
                resumeLoop = false;

            } else if (scanner.hasNextBigDecimal()) {
                     n1 = scanner.nextBigDecimal();
                     System.out.println("Ok. Number " + i + " is " + n1.toPlainString());
                resumeLoop = false;

            } else {
                System.out.println("Incorrect entry " + scanner.next() + ". You must enter numbers. Try again.");
            }
        }
        while (resumeLoop);
        return n1;
    }

    public static BigDecimal [] ExpandArray (BigDecimal inArray [], int expandBy) {

        int initLength = inArray.length;
        BigDecimal [] result = new BigDecimal [initLength + expandBy];

        for (int i=0; i < inArray.length; i++) {
            result [i] = inArray [i];
        }
        return result;
    }
}


