package vehicles;

public class LuxeCar extends Car {
    private boolean driver;
    private String[] options;

    public LuxeCar(String licensePlate, String brand, String model, double dailyRate, int places, String fuelType, boolean automatic, final boolean driver, final String[] options) {
        super(licensePlate, brand, model, dailyRate, places, fuelType, automatic);

        this.driver = driver;
        this.options = options;
    }
}
