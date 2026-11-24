package vehicles;

import interfaces.Maintainable;

public class Utility extends Vehicle implements Maintainable {
    final private double volume;
    final private double capacity;
    private int nextRevisionKm;
    public Utility(final String licensePlate, final String brand, final String model, final double dailyRate, final double volume, final double capacity) {
        super(licensePlate, brand, model, dailyRate);
        System.out.println("Constructeur d'initialisation appelé - UTILITY");

        this.volume = volume;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %.1f m3 et %.0f kg de capacité", this.volume, this.capacity);
    }

    @Override
    public double rentalRate(int days) {
        return days * super.getDailyRate() + 20;
    }

    @Override
    public String getCategory() {
        return "";
    }

    public boolean canTransport(double mass) {
        return mass <= this.capacity;
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
