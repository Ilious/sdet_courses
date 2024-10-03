abstract class Car {
    private boolean freightLoaded;
    private static int passengerWeight = 80;
    private int weight;
    private int speed;

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

    protected int getWeight() {
        return this.weight;
    }

    protected void setWeight(int weight) {
        this.weight = weight;
    }

    protected int getSpeed() {
        return this.speed;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isFreightLoaded() {
        return this.freightLoaded;
    }

    public void setFreightLoaded(boolean freightLoaded) {
        this.freightLoaded = freightLoaded;
    }
}
