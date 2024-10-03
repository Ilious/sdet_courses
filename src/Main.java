public class Main {
    public static void main(String[] args) {
        Car myCar = new TransportCar(100, 200);
        myCar.setWeight(400);
        System.out.println(myCar.getWeight());
    }
}