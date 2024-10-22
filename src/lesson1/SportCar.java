package lesson1;

class SportCar extends Car implements IRideable, ITransportable {
    private static final String typeOfCar = "sportCar";
    private static boolean wing = true;
    private static final int speedLimit = 400;
    private static final int maxWeight = 1000;
    private int numberOfSpeed = 7;
    private static final double timeForOverclocking = 3;
    private String drive = "rear";  // rear / front

    private static boolean possibleToUpgrade = true;

    SportCar(int weight, int speed) {
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
        return getPassengerWeight() * 2 + this.getWeight() + weightFreight <= 1000 ? "Yes" : "Nope";
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
        return this.getWeight() + getPassengerWeight() * 2 <= 1000 ? "Yes" : "Nope";
    }

    @Override
    protected void setSpeed(int speed) {
        super.setSpeed(speed);
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

    public int getNumberOfSpeed(){ return numberOfSpeed;}

    public void setNumberOfSpeed(int numberOfSpeed) {
        this.numberOfSpeed = numberOfSpeed;
    }

    public static double getTimeForOverclocking() {
        return timeForOverclocking;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getDrive() {
        return "drive is " + drive;
    }

    public static String getPossibleToUpgrade() {
        return SportCar.possibleToUpgrade + ", it's possible to upgrade";
    }

    public static void setPossibleToUpgrade(boolean option){
        SportCar.possibleToUpgrade = option;
    }
}
