package students;
import java.sql.*;

public abstract class Students_App {
   private static final String JDBC_DRIVER = "org.postgresql.Driver";
   private static final String DB_URL = "jdbc:postgresql://localhost:5432/students";
   private static final String DB_USERNAME = "postgres";
   private static final String DB_PASSWORD = "1";

    public static void main(String[] args) {
        try {
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection(){
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
}
