package clients;

public class Particular extends Client {
    private boolean insuredOverOneYear;

    public Particular(final String name, final String fullName, final String permitNumber, final String numberPhone, final int birthYear, final boolean insuredOverOneYear) {
        super(name, fullName, permitNumber, numberPhone, birthYear);
        System.out.println("Constructeur d'initialisation appelé - PARTICULAR");

        this.insuredOverOneYear = insuredOverOneYear;
    }

    public boolean isInsuredOverOneYear() {
        return insuredOverOneYear;
    }

    public void setInsuredOverOneYear(boolean insuredOverOneYear) {
        this.insuredOverOneYear = insuredOverOneYear;
    }

    @Override
    public double calculateDiscount() {
        return 0.05;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" - particulier, assuré depuis plus d'un an : %s", insuredOverOneYear ? "oui" : "non");
    }
}
