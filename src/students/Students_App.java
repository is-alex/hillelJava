package students;

import maptesting.MapTest;

import java.security.SecureRandom;
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

        for (int i = 0; i < 3; i++) {
            Student student = createRandomStudent();
            try {
                saveStudentToDB(student);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            getStudentsFromDB();
        } catch (SQLException e) {
            e.printStackTrace();
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
                "CREATE TABLE students (\n" +
                "id int,\n" +
                "surname varchar(100),\n" +
                "marks varchar(10000),\n" +
                "PRIMARY KEY (id)\n" +
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

    private static void getStudentsFromDB() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String getStudent = "SELECT id, surname, marks FROM students";

        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(getStudent);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String surname = resultSet.getString("surname");
                String marks = resultSet.getString("marks");
                System.out.println("id: " + id + ", surname: " + surname + ", marks " + marks);
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
    }

    private static Student createRandomStudent() {
        SecureRandom random = new SecureRandom();
        return new Student(random.nextInt(Integer.MAX_VALUE),
                MapTest.randomSurname(minSurnameLength, maxSurnameLength),
                MapTest.randomMarks(minNumOfMarks, maxNumOfMarks));
    }
}