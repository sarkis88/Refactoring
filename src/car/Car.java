package car;

import java.util.Date;

import static car.Car.CarType.CABRIOLET;
import static car.Car.CarType.SEDAN;
import static car.Car.CarType.TRUCK;

public abstract class Car {

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private CarType type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(CarType type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(CarType type, int numberOfPassengers) {
        if (type == TRUCK)
            return new Truck(numberOfPassengers);
        if (type == SEDAN)
            return new Sedan(numberOfPassengers);
        if (type == CABRIOLET)
            return new Cabriolet(numberOfPassengers);
        return null;
    }

    public void fill(double numberOfLiters) {
        if (numberOfLiters < 0) throw new RuntimeException();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (!isSummer(date, SummerStart, SummerEnd)) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length);
        }
        return consumption;
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

    enum CarType {
        TRUCK, SEDAN, CABRIOLET
    }
}