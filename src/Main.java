import lesson2.Login;
    import lesson2.WrongLoginException;
    import lesson2.WrongPasswordException;
import lesson3.Money;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
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