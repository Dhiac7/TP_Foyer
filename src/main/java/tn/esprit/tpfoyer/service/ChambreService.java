package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.repository.ChambreRepository;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreService implements IChambreService{

    ChambreRepository chambreRepository;
    ReservationRepository reservationRepository;

    @Override
    public Chambre saveChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre getChambreById(Long id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public List<Chambre> getChambresByType(TypeChambre typeC) {
        return chambreRepository.findByTypeC(typeC);
    }

    @Override
    public Chambre getChambreByNumero(Long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }

    public Chambre addChambreAndReservationAndAssign(Chambre chambre) {
        // Le JSON de chambre contient déjà une reservation
        return chambreRepository.save(chambre);
    }

    public void assignReservationToChambre(String reservationId, Long chambreId) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        Chambre chambre = chambreRepository.findById(chambreId).get();
        reservation.setChambre(chambre);          // on set le fils dans le parent
        reservationRepository.save(reservation);
    }


}
