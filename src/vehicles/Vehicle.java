package vehicles;

import constants.GlobalConstants;

import java.util.Objects;

public class Vehicle {
    private static int vehicleCount = 0;

    private final String licensePlate;
    private String brand;
    private String model;
    private int mileage;
    private double dailyRate;
    private boolean available;

    public Vehicle() {
        System.out.println("Constructeur par défaut appelé - VEHICLE");
        this.licensePlate = "N/A";
        this.brand = "N/A";
        this.model = "N/A";
        this.mileage = 0;
        this.dailyRate = 0.0;
        this.available = true;
        vehicleCount++;
    }

    public Vehicle(final String licensePlate, final String brand, final String model, final double dailyRate) {
        System.out.println("Constructeur d'initialisation appelé - VEHICLE");
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.mileage = 0;
        this.dailyRate = isValidDailyRate(dailyRate) ? dailyRate : 0.0;
        this.available = true;
        vehicleCount++;
    }

    public Vehicle(final Vehicle v) {
        this(Objects.requireNonNull(v, "Le véhicule à copier ne peut pas être null").licensePlate,
                v.brand, v.model, v.dailyRate);
        System.out.println("Constructeur de copie appelé - VEHICLE");
        this.mileage = v.mileage;
        this.available = v.available;
    }

    public void drive(int km) {
        if (km < 0) {
            System.out.println("Erreur : la distance parcourue ne peut pas être négative.");
            return;
        }
        this.mileage += km;
    }

    public void displayInfo() {
        System.out.println("Vehicule{" +
                "immatriculation='" + licensePlate + '\'' +
                ", marque='" + brand + '\'' +
                ", modele='" + model + '\'' +
                ", km=" + mileage +
                ", tarif=" + dailyRate +
                ", disponible=" + available +
                '}');
    }

    public static int getVehicleCount() {
        return vehicleCount;
    }

    private static boolean isValidDailyRate(double dailyRate) {
        if (dailyRate < 0) {
            System.out.println("Erreur : le tarif journalier ne peut pas être négatif (valeur ignorée).");
            return false;
        }
        return true;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        if (mileage < 0) {
            System.out.println("Erreur : le kilométrage ne peut pas être négatif (valeur ignorée).");
            return;
        }
        this.mileage = mileage;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        if (isValidDailyRate(dailyRate)) {
            this.dailyRate = dailyRate;
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s %s - %d km - %.2f %s/jour - %s",
                licensePlate,
                brand,
                model,
                mileage,
                dailyRate,
                GlobalConstants.DEVISE,
                available ? "DISPONIBLE" : "INDISPONIBLE"
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle other = (Vehicle) obj;

        return Objects.equals(this.licensePlate, other.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(licensePlate);
    }
}
