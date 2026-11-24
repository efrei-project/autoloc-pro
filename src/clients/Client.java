package clients;

import java.util.Objects;

public class Client {
    private static int clientCount = 0;

    private String name;
    private String fullName;
    private final String permitNumber;
    private String numberPhone;
    private int birthYear;

    public Client() {
        System.out.println("Constructeur par défaut appelé - CLIENT");
        this.name = "N/A";
        this.fullName = "N/A";
        this.permitNumber = "N/A";
        this.numberPhone = "N/A";
        this.birthYear = 2000;
        clientCount++;
    }

    public Client(final String name, final String fullName, final String permitNumber, final String numberPhone, final int birthYear) {
        System.out.println("Constructeur d'initialisation appelé - CLIENT");
        this.name = name;
        this.fullName = fullName;
        this.permitNumber = permitNumber;
        this.numberPhone = numberPhone;
        this.birthYear = birthYear;
        clientCount++;
    }

    public Client(final Client c) {
        this(Objects.requireNonNull(c, "Le client à copier ne peut pas être null").name,
                c.fullName, c.permitNumber, c.numberPhone, c.birthYear);
        System.out.println("Constructeur de copie appelé - CLIENT");
    }

    public int getAge(int currentYear) {
        return currentYear - this.birthYear;
    }

    public double calculateDiscount() {
        return 0.0;
    }

    public static int getClientCount() {
        return clientCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return String.format("%s %s - permis %s - tél. %s - né(e) en %d",
                fullName, name, permitNumber, numberPhone, birthYear);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client other = (Client) obj;

        return Objects.equals(this.permitNumber, other.permitNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(permitNumber);
    }

    public double discount() {
        return 0.0;
    }
}
