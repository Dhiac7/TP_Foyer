package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.service.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
@Tag(name = "Gestion Chambre", description = "CRUD operations for Chambre management")
public class ChambreController {

    IChambreService chambreService;

    @Operation(summary = "Get all Chambres", description = "Retrieve the list of all Chambres")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        return chambreService.getAllChambres();
    }

    @Operation(summary = "Get Chambres by type", description = "Retrieve Chambres by room type")
    @GetMapping("/retrieve-chambres-by-type/{type-chambre}")
    public List<Chambre> retrieveChambresByType(@PathVariable("type-chambre") TypeChambre typeChambre) {
        return chambreService.getChambresByType(typeChambre);
    }

    @Operation(summary = "Get Chambre by room number", description = "Retrieve a Chambre by its room number")
    @GetMapping("/retrieve-chambre-by-numero/{numero-chambre}")
    public Chambre retrieveChambreByNumero(@PathVariable("numero-chambre") Long numeroChambre) {
        return chambreService.getChambreByNumero(numeroChambre);
    }

    @Operation(summary = "Get Chambre by ID", description = "Retrieve a single Chambre by its ID")
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chambreId) {
        return chambreService.getChambreById(chambreId);
    }

    @Operation(summary = "Add a Chambre", description = "Create a new Chambre")
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.saveChambre(chambre);
    }

    @Operation(summary = "Remove a Chambre", description = "Delete a Chambre by its ID")
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chambreId) {
        chambreService.deleteChambre(chambreId);
    }

    @Operation(summary = "Modify a Chambre", description = "Update an existing Chambre")
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @PostMapping("/ajouter-chambre-et-reservation")
    public Chambre addChambreAndReservation(@RequestBody Chambre chambre) {
        return chambreService.addChambreAndReservationAndAssign(chambre);
    }

    @PutMapping("/affecter-reservation-chambre/{idReservation}/{idChambre}")
    public void assignReservationToChambre(@PathVariable String idReservation,
                                           @PathVariable Long idChambre) {
        chambreService.assignReservationToChambre(idReservation, idChambre);
    }

}
