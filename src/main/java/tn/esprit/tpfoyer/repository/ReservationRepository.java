package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

    @Query("SELECT r FROM Reservation r WHERE :etudiant MEMBER OF r.etudiantList")
    List<Reservation> findReservationsByEtudiant(@Param("etudiant") Etudiant etudiant);

    @Query("""
	    SELECT r
	    FROM Reservation r
	    JOIN r.chambre c
	    JOIN c.bloc b
	    WHERE b.nomBloc = :nomBloc
	    """)
    List<Reservation> findReservationsByNomBloc(@Param("nomBloc") String nomBloc);

    @Query("""
	    SELECT c.numeroChambre, COUNT(r)
	    FROM Reservation r
	    JOIN r.chambre c
	    GROUP BY c.numeroChambre
	    HAVING COUNT(r) >= :minReservations
	    """)
    List<Object[]> countReservationsByChambre(@Param("minReservations") Long minReservations);
}
