package lesson3;

public interface IComputable<T> {
        void add (T moneyBag);
        void multiple (T moneyBag);
        void subtract (T moneyBag);
        void divide (T moneyBag);
}
