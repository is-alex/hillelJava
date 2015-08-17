package students_io;

import maptesting.MapTest;
import students.Student;

import javax.swing.*;
import java.io.IOException;
import java.security.SecureRandom;


public class Test extends JFrame {
    private JButton createRandomStudent;
    private JButton addStudent;
    private JButton showStudent;
    private JFormattedTextField display;
    private JPanel panel;
    private JButton exit;
    private JButton button2;
    int minSurnameLength = 1;
    int maxSurnameLength = 50;
    int minNumOfMarks = 0;
    int maxNumOfMarks = 35;
    private String filePath = "";
    Student student = null;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    Test() throws IOException, ClassNotFoundException {
        createUIComponents();
    }

    private void createUIComponents() throws IOException, ClassNotFoundException {
        setTitle("Student");
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 300);
        setResizable(false);
        setVisible(true);
        display.setText("");
        display.setSize(1200, 50);
        addStudent.setEnabled(false);
        showStudent.setEnabled(false);

        createRandomStudent.addActionListener(actionEvent -> {
            student = createRandomStudent();
            addStudent.setEnabled(true);
            this.setFilePath(student.getId() + ".dat");
            display.setText("A random student created");
        });

        addStudent.addActionListener(actionEvent -> {
            display.setText("");
            Output output = new Output(getFilePath());
            try {
                output.write(student);
            } catch (IOException e) {
                e.printStackTrace();//FIXME
            }
            display.setText("A student added");
            showStudent.setEnabled(true);
        });

        showStudent.addActionListener(actionEvent -> {
            display.setText("");
            Input input = new Input(filePath);

            try {
                display.setText(input.read().toString());
            } catch (IOException e) {
                e.printStackTrace();//FIXME
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            addStudent.setEnabled(false);

        });

        exit.addActionListener(actionEvent -> System.exit(0));
    }

    private Student createRandomStudent(){
        SecureRandom random = new SecureRandom();
        return new Student(random.nextInt(Integer.MAX_VALUE),
                MapTest.randomSurname(minSurnameLength, maxSurnameLength),
                MapTest.randomMarks(minNumOfMarks, maxNumOfMarks));
    }
}
