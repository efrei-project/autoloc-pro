package vehicles;

public class LuxeCar extends Car {
    private boolean driver;
    private String[] options;

    public LuxeCar(String licensePlate, String brand, String model, double dailyRate, int places, String fuelType, boolean automatic, final boolean driver, final String[] options) {
        super(licensePlate, brand, model, dailyRate, places, fuelType, automatic);
        System.out.println("Constructeur d'initialisation appelé - LUXE_CAR");

        this.driver = driver;
        this.options = options;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", chauffeur %s, options : %s", this.driver ? "inclus" : "non inclus", String.join(", ", this.options));
    }

    @Override
    public double rentalRate(int days) {
        double total = super.rentalRate(days) * 1.5;

        if (this.driver) total += 80 * days;

        return total;
    }
}
