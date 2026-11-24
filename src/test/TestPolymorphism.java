package test;

import clients.Client;
import clients.Company;
import clients.Particular;
import vehicles.Bike;
import vehicles.Car;
import vehicles.LuxeCar;
import vehicles.Utility;
import vehicles.Vehicle;

public class TestPolymorphism {

    public static void main(String[] args) {
        System.out.println("=== Création de la flotte (ordre des constructeurs) ===");
        Vehicle[] fleet = {
                new Car("AA-111-BB", "Peugeot", "308", 45.0, 5, "Essence", false),
                new Bike("AA-222-BB", "Yamaha", "MT-07", 30.0, 689),
                new Utility("AA-333-BB", "Renault", "Master", 60.0, 12.0, 1200),
                new LuxeCar("AA-444-BB", "Mercedes", "Classe S", 250.0, 4, "Essence", true,
                        true, new String[]{"WiFi", "Bar"})
        };

        System.out.println();
        System.out.println("=== Parcours polymorphe de la flotte ===");
        for (Vehicle v : fleet) {
            System.out.println(v);
            if (v instanceof Bike) {
                Bike b = (Bike) v;
                System.out.println("  Permis A2/A requis : " + b.exceeds125cc());
            } else if (v instanceof Utility) {
                Utility u = (Utility) v;
                System.out.println("  Peut transporter 1000 kg : " + u.canTransport(1000));
            }
        }

        System.out.println();
        System.out.println("=== Création des clients (ordre des constructeurs) ===");
        Client[] clients = {
                new Client("Dupont", "Marie", "PERM-001", "0611111111", 1995),
                new Particular("Martin", "Paul", "PERM-002", "0622222222", 1988, true),
                new Company("Durand", "Luc", "PERM-003", "0633333333", 1979, "Durand Transports SAS", "12345678900012")
        };

        System.out.println();
        System.out.println("=== Remise polymorphe des clients ===");
        for (Client c : clients) {
            System.out.println(c);
            System.out.printf("  Remise : %.0f %%%n", c.calculateDiscount() * 100);
            if (c instanceof Company) {
                Company company = (Company) c;
                System.out.println("  Raison sociale : " + company.getSocialReason());
            }
        }
    }
}
