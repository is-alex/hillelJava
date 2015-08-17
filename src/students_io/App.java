package students_io;


import maptesting.MapTest;
import students.Student;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "student.dat";
        int minSurnameLength = 1;
        int maxSurnameLength = 50;
        int minNumOfMarks = 0;
        int maxNumOfMarks = 35;

        Output output = new Output(filePath);

        Student student = new Student(1,
                    MapTest.randomSurname(minSurnameLength, maxSurnameLength),
                    MapTest.randomMarks(minNumOfMarks, maxNumOfMarks));

            output.write(student);

        Input input = new Input(filePath);
        System.out.printf(input.read().toString());


    }
}
