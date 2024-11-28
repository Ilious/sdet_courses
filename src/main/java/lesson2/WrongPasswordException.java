package lesson2;

public class WrongPasswordException extends Exception{
    WrongPasswordException(){}
    WrongPasswordException(String message){
        super(message);
    }
}
