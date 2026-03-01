package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
@Tag(name = "Gestion Universite", description = "CRUD operations for Universite management")
public class UniversiteController {

    IUniversiteService universiteService;

    @Operation(summary = "Get all Universites", description = "Retrieve the list of all Universites")
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        return universiteService.getAllUniversites();
    }

    @Operation(summary = "Get Universite by ID", description = "Retrieve a single Universite by its ID")
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.getUniversiteById(universiteId);
    }

    @Operation(summary = "Add a Universite", description = "Create a new Universite")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.saveUniversite(universite);
    }

    @Operation(summary = "Remove a Universite", description = "Delete a Universite by its ID")
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.deleteUniversite(universiteId);
    }

    @Operation(summary = "Modify a Universite", description = "Update an existing Universite")
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }
}
