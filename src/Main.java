import lesson2.Login;
import lesson2.WrongLoginException;
import lesson2.WrongPasswordException;


public class Main {
    public static void main(String[] args) {
            System.out.println(Login.login("user", "_123", "123"));
    }
}
