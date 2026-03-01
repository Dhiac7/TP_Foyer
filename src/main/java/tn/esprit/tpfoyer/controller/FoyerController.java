package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
@Tag(name = "Gestion Foyer", description = "CRUD operations for Foyer management")
public class FoyerController {

    IFoyerService foyerService;

    @Operation(summary = "Get all Foyers", description = "Retrieve the list of all Foyers")
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        return foyerService.getAllFoyer();
    }

    @Operation(summary = "Get Foyer by ID", description = "Retrieve a single Foyer by its ID")
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foyerId) {
        return foyerService.getFoyerById(foyerId);
    }

    @Operation(summary = "Add a Foyer", description = "Create a new Foyer")
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.saveFoyer(foyer);
    }

    @Operation(summary = "Remove a Foyer", description = "Delete a Foyer by its ID")
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long foyerId) {
        foyerService.deleteFoyer(foyerId);
    }

    @Operation(summary = "Modify a Foyer", description = "Update an existing Foyer")
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }
}
