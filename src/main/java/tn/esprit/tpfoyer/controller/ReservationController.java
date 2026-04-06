package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
@Tag(name = "Gestion Reservation", description = "CRUD operations for Reservation management")
public class ReservationController {

    IReservationService reservationService;

    @Operation(summary = "Get all Reservations", description = "Retrieve the list of all Reservations")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }

    @Operation(summary = "Get Reservation by ID", description = "Retrieve a single Reservation by its ID")
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String reservationId) {
        return reservationService.getReservationById(reservationId);
    }

    @Operation(summary = "Add a Reservation", description = "Create a new Reservation")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @Operation(summary = "Remove a Reservation", description = "Delete a Reservation by its ID")
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String reservationId) {
        reservationService.deleteReservation(reservationId);
    }

    @Operation(summary = "Modify a Reservation", description = "Update an existing Reservation")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @PutMapping("/annuler-reservation/{idReservation}")
    public Reservation annulerReservation(@PathVariable String idReservation) {
        return reservationService.desaffecterReservationFromChambre(idReservation);
    }

    @Operation(summary = "JPQL MEMBER OF", description = "Trouver les réservations d'un étudiant via MEMBER OF")
    @GetMapping("/jpql/member-of/etudiant/{etudiant-id}")
    public List<Reservation> getReservationsByEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        return reservationService.getReservationsByEtudiantId(etudiantId);
    }

    @Operation(summary = "JPQL Double JOIN", description = "Trouver les réservations liées à un nom de bloc")
    @GetMapping("/jpql/double-join/bloc/{nom-bloc}")
    public List<Reservation> getReservationsByNomBloc(@PathVariable("nom-bloc") String nomBloc) {
        return reservationService.getReservationsByNomBloc(nomBloc);
    }

    @Operation(summary = "JPQL GROUP BY", description = "Compter les réservations par chambre avec un seuil minimum")
    @GetMapping("/jpql/group-by/chambres")
    public List<Map<String, Object>> getReservationStatsByChambre(
            @RequestParam(name = "minReservations", defaultValue = "1") Long minReservations) {
        return reservationService.getReservationCountByChambre(minReservations);
    }

}
