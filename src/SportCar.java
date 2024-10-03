class SportCar extends Car implements IRideable, ITransportable {
    private static final String typeOfCar = "sportCar";
    static boolean wing = true;
    static final int speedLimit = 400;
    static final int maxWeight = 1000;

    SportCar(int weight, int speed) {
        super(weight, speed);
    }

    public static String typeOfCar() {
        return "sportCar";
    }

    public static String hasItWing() {
        return wing ? "Yes" : "Nope";
    }

    public String isItTransport(int weightFreight) {
        return getPassengerWeight() * 2 + this.getWeight() + weightFreight <= 1000 ? "Yes" : "Nope";
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
        return this.getWeight() + getPassengerWeight() * 2 <= 1000 ? "Yes" : "Nope";
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
