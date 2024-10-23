package lesson_1;

public abstract class Car {
    private boolean freightLoaded;
    private static int passengerWeight = 80;
    private int weight;
    private int speed;
    private String typeOfCar;

    Car(int weight, int speed) {
        this.weight = weight;
        this.speed = speed;
    }

    public static int getPassengerWeight() {
        return passengerWeight;
    }

    public static void setPassengerWeight(int passengerWeight) {
        Car.passengerWeight = passengerWeight;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isFreightLoaded() {
        return this.freightLoaded;
    }

    public void setFreightLoaded(boolean freightLoaded) {
        this.freightLoaded = freightLoaded;
    }

    public String typeOfCar() {
        return typeOfCar;
    }
}
