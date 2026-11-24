package interfaces;

import clients.Client;

public interface Reservable {
    boolean isAvailableForReservation();
    void reserve(Client client, int durationDays);
    void releaseReservation();
}
