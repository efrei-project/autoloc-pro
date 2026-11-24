package interfaces;

public interface Insurable {
    double BASE_INSURANCE_RATE = 0.03;
    double calculateInsurancePremium();
    boolean isInsured();
    void subscribeInsurance(double deductibleAmount);
}
