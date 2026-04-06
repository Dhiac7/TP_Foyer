package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.EtudiantRepository;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    ReservationRepository reservationRepository;
    EtudiantRepository etudiantRepository;


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

    @Override
    public List<Reservation> getReservationsByEtudiantId(Long etudiantId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        if (etudiant == null) {
            return List.of();
        }
        return reservationRepository.findReservationsByEtudiant(etudiant);
    }

    @Override
    public List<Reservation> getReservationsByNomBloc(String nomBloc) {
        return reservationRepository.findReservationsByNomBloc(nomBloc);
    }

    @Override
    public List<Map<String, Object>> getReservationCountByChambre(Long minReservations) {
        List<Object[]> rawStats = reservationRepository.countReservationsByChambre(minReservations);
        List<Map<String, Object>> stats = new ArrayList<>();

        for (Object[] row : rawStats) {
            Map<String, Object> item = new HashMap<>();
            item.put("numeroChambre", row[0]);
            item.put("nombreReservations", row[1]);
            stats.add(item);
        }

        return stats;
    }

}
