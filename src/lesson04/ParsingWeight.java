package lesson04;

import java.math.BigDecimal;
import java.util.Scanner;

public class ParsingWeight {
    public static void main(String[] args) {

        String input = InputChecker();
        String string [] = input.split("\\.");

        if (string.length > 0) {

            char [] integerPart = string[0].toCharArray();
            int integerLength = integerPart.length;

            for (char digit : integerPart) {
                integerLength--;
                System.out.print(digit);
                switch (integerLength) {
                    case 0:
                        System.out.print(" grams ");
                        break;
                    case 3:
                        System.out.print(" kilograms ");
                        break;
                    case 6:
                        System.out.print(" tonnes ");
                        break;
                    case 9:
                        System.out.print(" kilotons ");
                        break;
                    case 12:
                        System.out.print(" megatons ");
                        break;
                    default:
                        System.out.print("");
                        break;
                }

            }

        }

        if (string.length > 1) {

            char [] fractionPart = string[1].toCharArray();
            int fractionLength = fractionPart.length;

            for (int i = 0; i < fractionLength; i++) {
                System.out.print(fractionPart [i]);

                if (i == 2) {
                    System.out.print(" milligrams ");
                } else if (i == 5) {
                    System.out.print(" micrograms ");
                } else if (i == 8) {
                    System.out.print(" nanograms ");
                } else if (i == 11) {
                    System.out.print(" picograms ");
                } else if ((i > 11) && (i == (fractionLength - 1))) {
                    System.out.print(" femtograms ");
                }

            }

        }

    }



    public static String InputChecker () {
        boolean resumeLoop = true;
        BigDecimal n = BigDecimal.ONE;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please, input weight (grams):");
            if (scanner.hasNextBigDecimal()) {
                n = scanner.nextBigDecimal();
                if (n.signum() < 0) {
                    System.out.println("Weight must be positive. Try again.");
                } else {
                    resumeLoop = false;
                }
            } else {
                System.out.println("Incorrect entry " + scanner.next() + ". Try again.");
            }
        }
        while (resumeLoop);
        return String.valueOf(n);

    }

}
