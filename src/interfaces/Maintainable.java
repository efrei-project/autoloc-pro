package interfaces;

public interface Maintainable {
    int KM_BETWEEN_MAINTENANCES = 10000;
    void scheduleMaintenance(int nextMaintenanceKm);
    boolean needsMaintenance();
    void performMaintenance();
}
