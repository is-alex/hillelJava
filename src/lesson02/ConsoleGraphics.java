package lesson02;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ConsoleGraphics {
    public static void main(String[] args) {

        int height = 0, width = 0;
        int i, j;

        Scanner scanner = new Scanner(System.in);
        boolean resumeLoop = true;
        do {
            System.out.println("Please, input the height of a rectangle:");
            if (scanner.hasNextInt()) {
                height = scanner.nextInt();

                if (height>0) {
                    System.out.println("The height of a rectangle is " + height);
                    resumeLoop = false;
                } else {
                    System.out.println("The height of a rectangle  can't be less than zero." +
                            " Try again");
                }

            } else {
                System.out.println("Incorrect entry " + scanner.next() + ". Try again.");
            }
        }
        while (resumeLoop);


        boolean resumeLoop2 = true;
        do {
            System.out.println("Please, input the width of a rectangle:");
            if (scanner.hasNextInt()) {
                width = scanner.nextInt();

                if (width>0) {
                    System.out.println("The width of a rectangle is " + width);
                    resumeLoop2 = false;
                } else {
                    System.out.println("The width of a rectangle  can't be less than zero." +
                            " Try again");
                }

            } else {
                System.out.println("Incorrect entry " + scanner.next() + ". Try again.");
            }
        }
        while (resumeLoop2);


        BigDecimal d = new BigDecimal((double)width/height);
        d = d.setScale(0, RoundingMode.HALF_UP);
        int k = d.intValue();

        System.out.println("A) A rectangle");

        for (i = 0; i < height; i++) {
            for (j = 0; j < width; j++) {
                if ((i == 0) || (i == height - 1) || (j == 0) || (j == width - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


        System.out.println("B) An envelope");
        for (i = 0; i < height; i++) {
            for (j = 0; j < width; j++) {
                if ((i == 0) || (i == height - 1) || (j == 0) || (j == width - 1 )) {
                    System.out.print("*");
                } else if ((j == (i*k)) || (j == (width-i*k-1))) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }



        System.out.println("C) Chequerwise");

        for (i = 0; i < height; i++) {
            for (j = 0; j < width; j++) {
                if ((i+j)%2==0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        scanner.close();
        System.exit(0);
    }
}

