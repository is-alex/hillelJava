package lesson02;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class MySimpleCalc {

    private static int count = 1;

    private static BigDecimal getNum(){
        Scanner scanner = new Scanner(System.in);
        BigDecimal result = BigDecimal.ZERO;

        boolean resumeLoop = true;
        do {
            System.out.println("Please, input number " + count + ": ");
            if (scanner.hasNextBigDecimal()) {
                result = scanner.nextBigDecimal();
                System.out.println("Your input " + result.toPlainString() + " as number " + count);
                resumeLoop = false;
            } else {
                System.out.println("Incorrect entry " + scanner.nextLine() + ". You must enter numbers. Try again.");
            }
        }
        while (resumeLoop);
        count++;
        return result;

    }

    public static void main(String[] args) {
        System.out.println("mySimpleCalc: Welcome!");

        Scanner scanner = new Scanner(System.in);

        BigDecimal num1 = getNum();

        boolean resumeLoop = true;
        String sign;
        do {
            System.out.println("Please, input the plus sign (+) to add, the minus sign (-) to subtract, \n" +
                    "the asterisk (*) to multiply, the forward slash (/) to divide:");
            sign = scanner.next();
            if (sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) {

                System.out.println("Your input is " + sign);
                resumeLoop = false;
            } else {
                System.out.println("Unknown operator " + sign + ". Try again.");
            }
        }
        while (resumeLoop);

        BigDecimal num2 = getNum();

        BigDecimal sum = (num1.add(num2));
        sum = sum.setScale(8, RoundingMode.HALF_DOWN);

        BigDecimal dif = (num1.subtract(num2));
        dif = dif.setScale(8, RoundingMode.HALF_DOWN);

        BigDecimal mul = (num1.multiply(num2));
        mul = mul.setScale(8, RoundingMode.HALF_DOWN);

        String divOutput;
        if(num2.signum() != 0){
            divOutput = (num1.divide(num2, 8, RoundingMode.HALF_DOWN)).toPlainString();
        } else{
            divOutput = "You can't divide by zero";
        }

        System.out.println("Result(s):");

        if (sign.equals( "+" )) {
            System.out.println("Sum is: " + sum.toPlainString());
        } else if (sign.equals( "-") ) {
            System.out.println("Difference is: " + dif.toPlainString());
        } else if (sign.equals( "*" )) {
            System.out.println("Multiplication is: " + mul.toPlainString());
        } else if (sign.equals( "/" )) {
            System.out.println("Division is: " + divOutput);
        } else  {
            System.out.println("Incorrect entry.");
        }

        scanner.close();
        System.exit(0);
    }
}