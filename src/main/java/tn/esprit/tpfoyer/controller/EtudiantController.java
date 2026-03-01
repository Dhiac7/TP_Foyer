package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
@Tag(name = "Gestion Etudiant", description = "CRUD operations for Etudiant management")
public class EtudiantController {

    IEtudiantService etudiantService;

    @Operation(summary = "Get all Etudiants", description = "Retrieve the list of all Etudiants")
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @Operation(summary = "Get Etudiant by ID", description = "Retrieve a single Etudiant by its ID")
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        return etudiantService.getEtudiantById(etudiantId);
    }

    @Operation(summary = "Add an Etudiant", description = "Create a new Etudiant")
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.saveEtudiant(etudiant);
    }

    @Operation(summary = "Remove an Etudiant", description = "Delete an Etudiant by its ID")
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        etudiantService.deleteEtudiant(etudiantId);
    }

    @Operation(summary = "Modify an Etudiant", description = "Update an existing Etudiant")
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }
}
