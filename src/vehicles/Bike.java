package vehicles;

import interfaces.Maintainable;

public class Bike extends Vehicle implements Maintainable {
    private int engine;
    int nextRevisionKm = 0;

    public Bike(final String licensePlate, final String brand, final String model, final double dailyRate, final int engine) {
        super(licensePlate, brand, model, dailyRate);
        System.out.println("Constructeur d'initialisation appelé - BIKE");

        this.engine = engine;
    }

    public boolean exceeds125cc() {
        return engine > 125;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %d cm3", this.engine);
    }

    @Override
    public double rentalRate(int days) {
        return days * super.getDailyRate();
    }

    @Override
    public String getCategory() {
        return "BIKE";
    }

    @Override
    public void scheduleMaintenance(int nextMaintenanceKm) {
        this.nextRevisionKm = nextMaintenanceKm;
    }

    @Override
    public boolean needsMaintenance() {
        return super.getMileage() >= KM_BETWEEN_MAINTENANCES;
    }

    @Override
    public void performMaintenance() {
        super.log("MAINTENANCE");
        super.setCondition(VehiculeCondition.MAINTENANCE);
        nextRevisionKm = super.getMileage() + KM_BETWEEN_MAINTENANCES;

        super.setCondition(VehiculeCondition.AVAILABLE);
    }
}
