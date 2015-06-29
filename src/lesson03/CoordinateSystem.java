package lesson03;

import java.util.Scanner;

public class CoordinateSystem {
    public static void main (String[] args) {
        int i;
        int j;
        int x;
        int y;

        System.out.println("Please, input the Y coordinate of the top left point: (0;__)");
        i = InputCoordinates();
        int [] ox = new int[(i+1)];
        ox = FillArray(ox);
        System.out.println("the coordinates of the top left point: (0; " + i + ")");

        System.out.println("Please, input the X coordinate of the bottom right point: (__;0)");
        j = InputCoordinates();
        int [] oy = new int[(j+1)];
        oy = FillArray(oy);
        System.out.println("the coordinates of the bottom right point: (" + j + "; 0)");

        System.out.println("Please, input the X coordinate of the point you'd like to check");
        x = InputCoordinates();

        System.out.println("Please, input the Y coordinate of the point you'd like to check");
        y = InputCoordinates();

        boolean rx = ArrayCheck(ox, x);
        boolean ry = ArrayCheck(oy, y);

        if (rx && ry) {
            System.out.println("The point is inside the rectangle.");
        } else {
            System.out.println("The point is outside the rectangle.");
        }

        System.exit(0);

    }


    public static boolean ArrayCheck (int [] array, int value) {
        for (int s: array) {
            if (s == (value))
                return true;
        }
        return false;
    }


    public static int [] FillArray (int [] array) {

        for (int i=0; i < array.length; i++) {
            array [i] = i;
        }
        return array;
    }


    public static int InputCoordinates () {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        boolean resumeLoop = true;
        do {
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n < 0) {
                    System.out.println("The integer must be positive. Try again.");
                } else {
                    System.out.println("Your input: " + n);
                    resumeLoop = false;
                }
            }
            else {
                System.out.println("Incorrect entry " + scanner.next() + ". Try again.");
            }
        }
        while (resumeLoop);
        return n;
    }

}
