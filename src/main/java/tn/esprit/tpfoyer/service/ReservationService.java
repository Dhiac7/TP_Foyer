package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    ReservationRepository reservationRepository;


    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation desaffecterReservationFromChambre(String reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        reservation.setChambre(null);   // annuler la réservation côté relation
        return reservationRepository.save(reservation);
        /*Chambre chambre = reservation.getChambre();
        if (chambre != null) {
            chambre.getReservations().remove(reservation);
        }
        reservation.setChambre(null);*/
    }

}
