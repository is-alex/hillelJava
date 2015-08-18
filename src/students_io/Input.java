package students_io;

import students.Student;

import java.io.*;

public class Input {

    private String filePath;

    public Input(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Student read() {
        File file = new File(filePath);
        ObjectInputStream ois = null;
        Student student = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            student = (Student)ois.readObject();
        } catch(ClassNotFoundException e) {
            System.err.println("It's not a student");
            e.printStackTrace();
        } catch(IOException e) {
            System.err.println("Can't read from disk!");
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return student;
    }

}
