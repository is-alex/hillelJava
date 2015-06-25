package lesson02;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class SimpleDepositCalc{
    public static void main(String[] args) {

        System.out.println("A very simple deposit calculator:");

        Scanner scanner = new Scanner(System.in);

        BigDecimal depositAmount = BigDecimal.ZERO;
        BigDecimal yrInterestRate = BigDecimal.ZERO;
        int term = 0;

        boolean resumeLoop = true;
        do {
            System.out.println("Please, enter the deposit amount (UAH):");
            if (scanner.hasNextBigDecimal()) {
                depositAmount = scanner.nextBigDecimal();
                depositAmount = depositAmount.setScale(2, RoundingMode.HALF_DOWN);

                if (depositAmount.signum()>0) {
                    System.out.println("The deposit amount is " + depositAmount.toPlainString() + " UAH");
                    resumeLoop = false;
                } else {
                    System.out.println("The deposit amount can't be less than zero. Try again.");
                }

            } else {
                System.out.println("Incorrect entry " + scanner.next() + ". Try again.");
            }
        }
        while (resumeLoop);

        boolean resumeLoop2 = true;
        do {
            System.out.println("Please, input the interest rate (%)");
            if (scanner.hasNextBigDecimal()) {
                yrInterestRate = scanner.nextBigDecimal();

                if (yrInterestRate.signum()>0) {
                    System.out.println("The interest rate is " + yrInterestRate.toPlainString() + " %");
                    yrInterestRate = yrInterestRate.divide(new BigDecimal("100"), 4, RoundingMode.HALF_DOWN);
                    resumeLoop2 = false;
                } else {
                    System.out.println("The interest rate can't be less than zero. Try again.");
                }

            } else {
                System.out.println("Incorrect entry " + scanner.next() + ". Try again.");
            }
        }
        while (resumeLoop2);

        boolean resumeLoop3 = true;
        do {
            System.out.println("Please, input the term of the deposit (years):");
            if (scanner.hasNextInt()) {
                term = scanner.nextInt();

                if (term>0) {
                    System.out.println("The term of the deposit is " + term + " years");
                    resumeLoop3 = false;
                } else {
                    System.out.println("The term of the deposit can't be less than zero. Try again");
                }

            } else {
                System.out.println("Incorrect entry " + scanner.next() + ". Try again.");
            }
        }
        while (resumeLoop3);

        BigDecimal dividends, accumulatedSum;

        for (int i = 1; i<=term;i++) {
            int i2 = (i - 1);
            System.out.println("Year " + i);

            accumulatedSum = depositAmount.multiply(yrInterestRate.add(BigDecimal.ONE).pow(i));
            accumulatedSum = accumulatedSum.setScale(2, RoundingMode.HALF_DOWN);

            dividends = depositAmount.multiply((yrInterestRate.add(BigDecimal.ONE).pow(i)).subtract(yrInterestRate.add(BigDecimal.ONE).pow(i2)));
            dividends = dividends.setScale(2, RoundingMode.HALF_DOWN);

            System.out.println("Yearly dividends: " + dividends.toPlainString());
            System.out.println("Total accumulated sum: " + accumulatedSum.toPlainString() + "\n");

        }

        scanner.close();
        System.exit(0);
    }
}
