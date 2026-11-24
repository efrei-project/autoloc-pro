package vehicles;

public class Utility extends Vehicle {
    final private double volume;
    final private double capacity;

    Utility(final String licensePlate, final String brand, final String model, final int dailyRate, final double volume, final double capacity) {
        super(licensePlate, brand, model, dailyRate);

        this.volume = volume;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %f cm3 et %f de capacité", this.volume, this.capacity);
    }

    public boolean canTransport(double mass) {
        return mass <= this.capacity;
    }
}
