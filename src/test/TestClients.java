package test;

import clients.Client;

public class TestClients {

    public static void main(String[] args) {
        final int currentYear = 2026;

        System.out.println("=== Client complet ===");
        Client client = new Client("Dupont", "Marie", "PERM-123456", "0612345678", 1995);
        System.out.println(client);
        System.out.println("Âge : " + client.getAge(currentYear) + " ans");

        System.out.println();
        System.out.println("=== Copie du client ===");
        Client copy = new Client(client);
        System.out.println(copy);
        System.out.println("Âge : " + copy.getAge(currentYear) + " ans");

        System.out.println();
        System.out.println("=== Test == / equals() / hashCode() ===");
        Client c1 = new Client("Martin", "Paul", "PERM-777", "0600000001", 1990);
        Client c2 = new Client("Martin", "Pauline", "PERM-777", "0600000002", 1992);
        Client c3 = new Client("Martin", "Paul", "PERM-888", "0600000001", 1990);
        System.out.println("c1 == c2        : " + (c1 == c2));
        System.out.println("c1.equals(c2)   : " + c1.equals(c2));
        System.out.println("hashCode égaux  : " + (c1.hashCode() == c2.hashCode()));
        System.out.println("c1.equals(c3)   : " + c1.equals(c3));
        System.out.println("client.equals(copy) : " + client.equals(copy));

        System.out.println();
        System.out.println("=== Compteur ===");
        System.out.println("Nombre de clients créés : " + Client.getClientCount());
    }
}
