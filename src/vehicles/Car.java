package vehicles;

import interfaces.Maintainable;

public class Car extends Vehicle implements Maintainable {
    private int places;
    private String fuelType;
    private boolean automatic;
    private int nextRevisionKm;

    public Car(final String licensePlate, final String brand, final String model, final double dailyRate, final int places, final String fuelType, final boolean automatic) {
        super(licensePlate, brand, model, dailyRate);
        System.out.println("Constructeur d'initialisation appelé - CAR");

        this.places = places;
        this.fuelType = fuelType;
        this.automatic = automatic;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %d places, %s type de carburant, %s", this.places, this.fuelType, this.automatic ? "Automatique" : "Manuelle");
    }

    @Override
    public double rentalRate(int days) {
        double discount = 0.0;

        if (days >= 7) discount = 0.1;
        return days * super.getDailyRate() * (1.0 - discount);
    }

    @Override
    public String getCategory() {
        return "CAR";
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
