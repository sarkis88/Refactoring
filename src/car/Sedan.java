package car;

public class Sedan extends Car {

    private final static int MAX_SEDAN_SPEED = 120;

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }

    public Sedan(int numberOfPassengers) {
        super(SEDAN, numberOfPassengers);
    }
}
