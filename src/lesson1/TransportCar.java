package lesson1;

class TransportCar extends Car implements ITransportable, IRideable {
    static boolean wing = false;
    private static final String typeOfCar = "minibus";
    private static final int speedLimit = 200;
    private static final int maxWeight = 3400;
    private boolean trailer = true;
    private boolean bodyTruck = false;
    private int freightBody = 400;


    public TransportCar(int weight, int speed) {
        super(weight, speed);
    }

    @Override
    public String typeOfCar() {
        return typeOfCar;
    }

    public static String hasItWing() {
        return wing ? "Yes" : "Nope";
    }
    @Override

    public String isItTransport(int weightFreight) {
        return getPassengerWeight() * 13 + this.getWeight() + weightFreight <= 3400 ? "Yes" : "Nope";
    }

    @Override
    public String checkFreight(int weightFreight) {
        if (this.isFreightLoaded()) {
            this.setFreightLoaded(false);
            return "There's no place";
        } else {
            System.out.println("The freight is loading");
            return this.isItTransport(weightFreight);
        }
    }
    @Override

    public String isItRide() {
        return getPassengerWeight() * 13 + this.getWeight() <= 3400 ? "Yes" : "Nope";
    }
    @Override

    public String boostSpeed(int maxSpeed) {
        if (this.getSpeed() >= maxSpeed) {
            return "You're already too fast";
        } else {
            while(this.getSpeed() < maxSpeed) {
                this.setSpeed(this.getSpeed() + 7);
            }

            return "Speed boosted";
        }
    }

    public void setTrailer(boolean trailer) {
        this.trailer = trailer;
    }

    public boolean hasTrailer() {
        return trailer;
    }

    public static int getMaxFreight(){
        return maxWeight;
    }

    public boolean hasBodyTruck() {
        return bodyTruck;
    }

    public void setBodyTruck(boolean bodyTruck) {
        this.bodyTruck = bodyTruck;
    }

    public int getFreightBody(){
        return freightBody;
    }

    public void setFreightBody(int freightBody){
        if (hasBodyTruck()) this.freightBody = freightBody;
    }
}
