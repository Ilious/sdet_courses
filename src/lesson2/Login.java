package lesson2;

import java.util.Arrays;

public class Login {
    public static boolean login(String login, String password, String confirmPassword){
        try{
            if (!login.matches("^[a-zA-Z0-9_]+$")) return false;
            else if (login.length() >= 20) throw new WrongLoginException("length of login is more than 19");
            else if (password.length() >= 20 || !password.matches("^[a-zA-Z0-9_]+$")) return false;
            else if (!password.equals(confirmPassword)) throw new WrongPasswordException("fields of passwords don't " +
                    "match");
        }
        catch(WrongLoginException | WrongPasswordException exception){
            System.out.println(Arrays.toString(exception.getStackTrace()));
            return false;
        }
        return true;
    }
}
