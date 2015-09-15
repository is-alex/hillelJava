package students;

import maptesting.MapTest;
import java.sql.*;
import java.util.Arrays;

public abstract class Students_App {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/students";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "1";
    private static final int minSurnameLength = 1;
    private static final int maxSurnameLength = 50;
    private static final int minNumOfMarks = 0;
    private static final int maxNumOfMarks = 35;

    public static void main(String[] args) {

        try {
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 4; i++) {
            Student student = createRandomStudent(i);
            try {
                saveStudentToDB(student);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (int j = 1; j<4; j++) {
            try {
                Student newStudent = getStudentFromDB(j);

                if (newStudent != null) {
                    System.out.println(newStudent.toString());
                } else {
                    System.out.println("student with id "+j+" does not exist.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static void createTable() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        String createTable = "DROP TABLE IF EXISTS students;\n" +
                "CREATE TABLE students (" +
                "id int," +
                "surname varchar(100)," +
                "marks varchar(10000)," +
                "PRIMARY KEY (id)" +
                ");";
        try {
            connection = getConnection();
            statement = connection.createStatement();

            statement.execute(createTable);
            System.out.println("Table created!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void saveStudentToDB(Student student) throws SQLException {
        Connection connection = null;
        Statement statement = null;

        String saveStudent = "INSERT INTO students (id, surname, marks) VALUES \n"
                + "(" + student.getId()
                + ", '" + student.getSurname() + "', '"
                + Arrays.toString(student.getMarks()) + "');";

        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.execute(saveStudent);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static Student getStudentFromDB(int id) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Student student = null;
        String getStudent = ("SELECT surname, marks FROM students WHERE id = "+id+";");

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(getStudent);

            while (resultSet.next()) {
                String surname = resultSet.getString("surname");
                String marksString = resultSet.getString("marks");

                int[] marks = Arrays.stream(marksString.substring(1, marksString.length()-1).split(", "))
                        .mapToInt(Integer::parseInt).toArray();
                student = new Student(id,surname,marks);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return student;
    }

    

    private static Student createRandomStudent(int id) {
        return new Student(id,
                MapTest.randomSurname(minSurnameLength, maxSurnameLength),
                MapTest.randomMarks(minNumOfMarks, maxNumOfMarks));
    }
}