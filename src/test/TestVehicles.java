package test;

import vehicles.Vehicle;

import java.util.Scanner;

public class TestVehicles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Test constructeur par défaut ===");
        Vehicle defaultVehicle = new Vehicle();
        defaultVehicle.displayInfo();

        System.out.println();
        System.out.println("=== Test constructeur d'initialisation ===");
        System.out.print("Marque : ");
        String brand = scanner.nextLine();
        System.out.print("Modèle : ");
        String model = scanner.nextLine();
        Vehicle vehicle = new Vehicle("AB-123-CD", brand, model, 35.0);
        vehicle.displayInfo();

        System.out.println();
        System.out.println("=== Test trajet de 250 km ===");
        System.out.print("Avant 250 km : ");
        vehicle.displayInfo();
        vehicle.drive(250);
        System.out.print("Après 250 km : ");
        vehicle.displayInfo();

        System.out.println();
        System.out.println("=== Test constructeur de copie ===");
        Vehicle copy = new Vehicle(vehicle);
        copy.displayInfo();

        System.out.println();
        System.out.println("=== Test toString() ===");
        System.out.println(vehicle);

        System.out.println();
        System.out.println("=== Test validations des setters ===");
        vehicle.setDailyRate(-10.0);
        vehicle.setMileage(-500);
        System.out.println("Après valeurs négatives (inchangé) : " + vehicle);
        vehicle.setDailyRate(40.0);
        System.out.println("Après tarif = 40.0 : " + vehicle);

        System.out.println();
        System.out.println("=== Test == / equals() / hashCode() ===");
        Vehicle v1 = new Vehicle("XY-999-ZZ", "Peugeot", "208", 30.0);
        Vehicle v2 = new Vehicle("XY-999-ZZ", "Citroën", "C3", 32.0);
        Vehicle v3 = new Vehicle("ZZ-000-AA", "Peugeot", "208", 30.0);
        System.out.println("v1 == v2        : " + (v1 == v2));
        System.out.println("v1.equals(v2)   : " + v1.equals(v2));
        System.out.println("hashCode égaux  : " + (v1.hashCode() == v2.hashCode()));
        System.out.println("v1.equals(v3)   : " + v1.equals(v3));

        System.out.println();
        System.out.println("=== Tableau de 3 véhicules (for-each) ===");
        Vehicle[] fleet = {
                new Vehicle("AA-111-BB", "Renault", "Clio", 35.0),
                new Vehicle("AA-222-BB", "Toyota", "Yaris", 38.5),
                new Vehicle("AA-333-BB", "Tesla", "Model 3", 90.0)
        };
        for (Vehicle v : fleet) {
            System.out.println(v);
        }

        System.out.println();
        System.out.println("=== Compteur ===");
        System.out.println("Nombre de véhicules créés : " + Vehicle.getVehicleCount());

        scanner.close();
    }
}
