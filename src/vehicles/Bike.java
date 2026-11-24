package vehicles;

public class Bike extends Vehicle {
    private int engine;

    public Bike(final String licensePlate, final String brand, final String model, final double dailyRate, final int engine) {
        super(licensePlate, brand, model, dailyRate);

        this.engine = engine;
    }

    public boolean exceeds125cc() {
        return engine > 125;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %d cm3", this.engine);
    }
}
