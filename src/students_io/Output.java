package students_io;


import students.Student;

import java.io.*;

public class Output {

    private String filePath;

    public Output(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public void write(Student student) throws IOException {
        File file = new File(filePath);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            oos.writeObject(student);
            oos.flush();
        } catch(IOException e) {
            System.err.println("Can't write to disk!");
            e.printStackTrace();
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }
}
