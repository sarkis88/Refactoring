package car;

import static car.Car.Type.SEDAN;

public class Sedan extends Car {

    private final static int MAX_SEDAN_SPEED = 120;

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }

    Sedan(int numberOfPassengers) {
        super(SEDAN, numberOfPassengers);
    }
}
