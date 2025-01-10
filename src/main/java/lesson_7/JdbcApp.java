package lesson_7;

import java.sql.*;
import java.util.Arrays;

public class JdbcApp {

    private static Connection connection;
    private static Statement statement;
    public static void main(String[] args) {
        try {
            connect();
            readEx();
            psBatch();
            readEx();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void connect() throws SQLException {
        System.out.println("Открывается соединение с БД");
        connection = DriverManager.getConnection("jdbc:sqlite:javadb.db");
        statement = connection.createStatement();
    }

    private static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Соединение закрыто");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTableEx() throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT, " +
                "score INTEGER" +
                ");");
    }

    private static void dropIfExistsEx() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS;");
    }

    private static void readEx() throws SQLException {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM students;")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " +
                rs.getInt(3));
            }
        }
    }

    private static void clearTableEx() throws SQLException {
        statement.executeUpdate("DELETE FROM students;");
    }

    private static void deleteEx() throws SQLException {
        statement.executeUpdate("DELETE FROM students WHERE name = 'Bob1';");
    }

    private static void insertEx() throws SQLException {
        statement.executeUpdate("INSERT INTO Students (name,score) Values ('Bob4',60);");
        statement.executeUpdate("INSERT INTO Students (name,score) Values ('Jane4',50);");
        statement.executeUpdate("INSERT INTO Students (name,score) Values ('Ira4',30);");
        statement.executeUpdate("INSERT INTO Students (name,score) Values ('Petr4',20);");
    }

    private static void psBatch() {
        try (PreparedStatement prepInsert = connection.prepareStatement("INSERT INTO students(name,score) values(?,?)")) {
            for (int i = 0; i < 10; i++) {
                prepInsert.setString(1, "Bob" + i);
                prepInsert.setInt(2, i * 10 % 100);
                prepInsert.addBatch();
            }

            int[] result = prepInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void transactionEx() throws SQLException {
        connection.setAutoCommit(false);
        try {
            statement.execute("INSERT INTO students (name, score) values ('Walentin', 56)");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }
}