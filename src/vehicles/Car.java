package vehicles;

public class Car extends Vehicle {
    private int places;
    private String fuelType;
    private boolean automatic;

    public Car(final String licensePlate, final String brand, final String model, final double dailyRate, final int places, final String fuelType, final boolean automatic) {
        super(licensePlate, brand, model, dailyRate);

        this.places = places;
        this.fuelType = fuelType;
        this.automatic = automatic;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %d places, %s type de carburant, %s", this.places, this.fuelType, this.automatic ? "Automatique" : "Manuelle");
    }
}
