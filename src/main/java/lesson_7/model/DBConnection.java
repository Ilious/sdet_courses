package lesson_7.model;

public class DBConnection {

    private final static String connection = "jdbc:sqlite:javahwdb.db";

    public static String getConnection()
    {
        return connection;
    }
}
