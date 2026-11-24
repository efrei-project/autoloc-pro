package clients;

public class Company extends Client {
    private final String socialReason;
    private final String siret;

    public Company(final String name, final String fullName, final String permitNumber, final String numberPhone, final int birthYear, final String socialReason, final String siret) {
        super(name, fullName, permitNumber, numberPhone, birthYear);
        System.out.println("Constructeur d'initialisation appelé - COMPANY");

        this.socialReason = socialReason;
        this.siret = siret;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public String getSiret() {
        return siret;
    }

    @Override
    public double calculateDiscount() {
        return 0.10;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" - entreprise %s (SIRET %s)", socialReason, siret);
    }
}
