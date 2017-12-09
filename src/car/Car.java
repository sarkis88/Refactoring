package car;

import java.util.Date;

public abstract class Car {

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private Type type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(Type type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(Type type, int numberOfPassengers) {
        switch (type) {
            case TRUCK:
                return new Truck(numberOfPassengers);
            case SEDAN:
                return new Sedan(numberOfPassengers);
            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);
            default:
                return null;
        }
    }

    public void fill(double numberOfLiters) {
        if (numberOfLiters < 0) throw new RuntimeException();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {
        if (!isSummer(date, summerStart, summerEnd))
            return getWinterConsumption(length);
        return getSummerConsumption(length);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;
        return numberOfPassengers;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        return date.after(summerStart) && date.before(summerEnd);
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable()  && fuel > 0.0;
    }

    public enum Type {
        TRUCK, SEDAN, CABRIOLET
    }
}