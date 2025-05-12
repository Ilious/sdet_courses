import lesson2.Login;
import lesson2.WrongLoginException;
import lesson2.WrongPasswordException;
import lesson3.Money;
import lesson_4.Lesson4;
import lesson_7.JdbcHw;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            JdbcHw.connect();

            JdbcHw.dropIfExists();
            JdbcHw.createTableEx();

            JdbcHw.insertEx("Petr", "Petrovich", 10);
            JdbcHw.readEx();

            JdbcHw.psBatch("Petr", "Petrovich", 12);
            JdbcHw.transactionEx("Petr", "Petrovich", 13);
            JdbcHw.readEx();

            JdbcHw.deleteByIdEx(1);

            JdbcHw.disconnect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
