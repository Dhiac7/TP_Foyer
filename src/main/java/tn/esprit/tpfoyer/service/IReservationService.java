package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation saveReservation(Reservation reservation);

    void deleteReservation(String id);

    Reservation getReservationById(String id);

    Reservation updateReservation(Reservation reservation);

    List<Reservation> getAllReservations();
    Reservation desaffecterReservationFromChambre(String reservationId);
}
