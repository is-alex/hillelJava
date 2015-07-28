package lesson04;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ParsingWeight {
    public static void main(String[] args) {

        String input = AskUnits();
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
                } else if ((i > 8) && (i == (fractionLength - 1))) {
                    System.out.print(" picograms ");
                }

            }

        }

    }



    public static String InputChecker () {
        boolean resumeLoop = true;
        BigDecimal n = BigDecimal.ONE;

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please, input weight:");
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

    public static String AskUnits () {

        String inputChecker = InputChecker();

        Scanner scanner = new Scanner(System.in);
        String [] [] units = new String [10] [2];
        units [0] [0] = "fg";
        units [1] [0] = "pg";
        units [2] [0] = "ng";
        units [3] [0] = "mkg";
        units [4] [0] = "mg";
        units [5] [0] = "gr";
        units [6] [0] = "kg";
        units [7] [0] = "t";
        units [8] [0] = "kt";
        units [9] [0] = "mt";

        for (int i = 0; i<units.length; i++) {
            BigDecimal j = new BigDecimal(1000).pow(i);
            units[i][1] = (((new BigDecimal(0.000000000000001).multiply(j))).setScale(8, RoundingMode.HALF_DOWN).toString());
        }


        String input;
        boolean resumeLoop = true;
        int index = 0;
            do {

                System.out.println("Please, input a unit of mass (\"fg\", \"pg\", \"ng\", \"mkg\"," +
                            " \"mg\", \"gr\", \"kg\", \"t\", \"kt\", \"mt\"):");

                input = scanner.next();
                for (int j=0; j < units.length; j++) {

                    if (input.matches(units[j][0])) {
                        index = j;
                        resumeLoop = false;
                    }

                }

            } while (resumeLoop);


        String total = ((new BigDecimal(inputChecker)).multiply(new BigDecimal(units [index][1]))).toString();

        return total;

    }

}
