package car;

public class Cabriolet extends Car {

    private final static int MAX_CABRIOLET_SPEED = 90;

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }

    public Cabriolet(int numberOfPassengers) {
        super(CABRIOLET, numberOfPassengers);
    }
}
