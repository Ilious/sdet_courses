import lesson2.Login;
    import lesson2.WrongLoginException;
    import lesson2.WrongPasswordException;

    import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
            System.out.println(Login.login("user", "_123", "123"));
    }
}