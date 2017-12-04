package car;

public class Truck extends Car {

    private final static int MAX_TRUCK_SPEED = 80;

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }

    public Truck(int numberOfPassengers) {
        super(TRUCK, numberOfPassengers);
    }
}
