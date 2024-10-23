    import lesson_1.Car;
    import lesson_1.SportCar;
    import lesson_1.TransportCar;

    public class Main {
    public static void main(String[] args){
        Car myCar = new SportCar(100, 200);
        myCar.setWeight(400);
        myCar.setSpeed(222);
        System.out.println(myCar.getWeight());
        System.out.println(myCar.typeOfCar());
    }
}