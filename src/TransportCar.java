class TransportCar extends Car implements ITransportable, IRideable {
    static boolean wing = false;
    private static final String typeOfCar = "minibus";
    static final int speedLimit = 200;
    static final int maxWeight = 3400;

    TransportCar(int weight, int speed) {
        super(weight, speed);
    }

    public static String typeOfCar() {
        return "minibus";
    }

    public static String hasItWing() {
        return wing ? "Yes" : "Nope";
    }

    public String isItTransport(int weightFreight) {
        return getPassengerWeight() * 13 + this.getWeight() + weightFreight <= 3400 ? "Yes" : "Nope";
    }

    public String checkFreight(int weightFreight) {
        if (this.isFreightLoaded()) {
            this.setFreightLoaded(false);
            return "There's no place";
        } else {
            System.out.println("The freight is loading");
            return this.isItTransport(weightFreight);
        }
    }

    public String isItRide() {
        return getPassengerWeight() * 13 + this.getWeight() <= 3400 ? "Yes" : "Nope";
    }

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
}
