package lesson_7;

import lesson_7.model.DBConnection;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

public class JdbcHw {

    private static String stringConnection;
    private static Statement statement;
    private static Connection connection;

    public static void connect() throws SQLException {
        System.out.println("Выполняется подключение к БД");
        stringConnection = DBConnection.getConnection();
        connection = DriverManager.getConnection(stringConnection);
        statement = connection.createStatement();
    }

    public static void disconnect() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createTableEx() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS users" +
                "(Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstName TEXT," +
                "lastName TEXT," +
                "dateOfCreating TIMESTAMP," +
                "age INTEGER" +
                ");");
    }

    public static void dropIfExists() throws SQLException {
        statement.executeUpdate("DELETE FROM users;");
    }

    public static void insertEx(String firstName, String lastName, int age) throws SQLException {

        String query = "INSERT INTO users(firstName, lastName, dateOfCreating, age) values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = statement.getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, time());
            preparedStatement.setInt(4, age);
            preparedStatement.executeUpdate();
        }
    }

    public static void deleteByIdEx(int id) throws SQLException {
        statement.executeUpdate(String.format("DELETE FROM users WHERE id = %d;", id));
    }

    public static void readEx() throws SQLException {
        try (var rs = statement.executeQuery("SELECT * from users;")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getInt(1)
                        + " dateOfCreating:" + rs.getString(4) + " " + rs.getInt(5) + "years old");
            }
        }
    }

    public static void psBatch(String firstName, String lastName, int age) {
        
        try (PreparedStatement prepInsert = connection.prepareStatement
                ("INSERT INTO users(firstName, lastName, dateOfCreating, age) values(?,?,?,?)")
        ) {
            for (int i = 0; i < 5; i++) {
                prepInsert.setString(1, firstName);
                prepInsert.setString(2, lastName);
                prepInsert.setString(3,  time());
                prepInsert.setInt(4, age + i);
                prepInsert.addBatch();
            }

            int[] result = prepInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void transactionEx(String firstName, String lastName, int age) throws SQLException {
        connection.setAutoCommit(false);
        try {
            statement.execute(String.format("INSERT INTO users (firstName, lastName, dateOfCreating, age)" +
                    " values ('%s', '%s', '%s', %d);", firstName, lastName, time(),  age));
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    private static String time() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();

        Timestamp timestamp = Timestamp.valueOf(formatter.format(localDateTime));

        localDateTime = timestamp.toLocalDateTime();
        return localDateTime.toString().replace("T", " ");
    }
}
