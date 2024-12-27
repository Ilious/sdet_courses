package lesson3;

import java.sql.SQLOutput;
import java.util.function.Function;
import java.util.function.Predicate;

public class Money<T extends Number> implements IComputable<T>, ICountable{
    T savings;
    Function<Double, T> converter;

    public Money(T num, Function<Double, T> converter){
        this.savings = num;
        this.converter = converter;
    }

    @Override
    public String toString(){
        return "total money: "+this.savings;
    }

    @Override
    public void add (T moneyBag){
        this.savings = converter.apply(moneyBag.doubleValue() + this.savings.doubleValue());
    }

    @Override
    public void multiple (T moneyBag){
        this.savings = converter.apply(moneyBag.doubleValue() * this.savings.doubleValue());
    }

    @Override
    public void subtract (T moneyBag){
        this.savings = converter.apply(this.savings.doubleValue() - moneyBag.doubleValue());
    }

    @Override
    public void divide (T moneyBag){
        this.savings = converter.apply(this.savings.doubleValue() / moneyBag.doubleValue());
    }

    @Override
    public void getContribution(double percentage, int years) {
        int year = 0;
        while (year != years) {
            year++;
            this.savings = converter.apply(this.savings.doubleValue() + this.savings.doubleValue() *
                    percentage / 100);
            System.out.printf("%d year ---> %s \n", year, this);
        }
    }

    @Override
    public void getCredit(double sum, double payPerMonth) {
        int months = 0;
        double neededSum = sum > this.savings.doubleValue() ? sum - this.savings.doubleValue() :
                0;
        this.savings = sum > this.savings.doubleValue() ? converter.apply(0.0) :
                converter.apply(this.savings.doubleValue() - sum);

        while (neededSum > 0){
            System.out.printf("%d month needed sum ----> %s \n", ++months, neededSum);
            neededSum -= payPerMonth;
        }
    }

    public boolean isDivided13(){
        Predicate<Double> division = x -> x % 13 == 0;
        return  division.test(this.savings.doubleValue());
    }

    @FunctionalInterface
    interface TriFunction<A, B, C, R>{
        R apply(A a, B b, C c);
    }

    public static double discriminant(double num1, double num2, double num3){
        TriFunction <Double, Double, Double, Double> discriminant = (a, b, c) -> b * b - 4 * a * c;
        return discriminant.apply(num1, num2, num3);
    }
}
