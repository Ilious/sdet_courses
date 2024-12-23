import lesson2.Login;
    import lesson2.WrongLoginException;
    import lesson2.WrongPasswordException;
import lesson3.Money;
import lesson_4.Lesson4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        new Lesson4();
//        printTasksTill4();
    }

    private static void printTasksTill4(){
        System.out.println(Login.login("user", "_123", "123"));

        Money<Double> moneySavings = new Money<>(333.0, Double::doubleValue);
        System.out.println(moneySavings);

        moneySavings.add(333.0);
        System.out.println(moneySavings);

        moneySavings.multiple(2.0);
        System.out.println(moneySavings);

        moneySavings.getContribution(10,2);
        System.out.println(moneySavings);

        moneySavings.getCredit(1900, 150);
        System.out.println(moneySavings);

        System.out.println(Money.discriminant(4, 5, 1));
    }
}
