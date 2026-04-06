package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
@Tag(name = "Gestion Bloc", description = "CRUD operations for Bloc management")
public class BlocController {

    IBlocService blocService;

    @Operation(summary = "Get all Blocs", description = "Retrieve the list of all Blocs")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        return blocService.getAllBlocs();
    }

    @Operation(summary = "Get Blocs without Foyer", description = "Retrieve the list of Blocs not assigned to any Foyer")
    @GetMapping("/retrieve-blocs-sans-foyer")
    public List<Bloc> retrieveBlocsSansFoyer() {
        return blocService.getBlocsSansFoyer();
    }

    @Operation(summary = "Get Blocs by minimum capacity", description = "Retrieve Blocs with capacity greater than a given value")
    @GetMapping("/retrieve-blocs-by-capacite-superieure/{capacite-min}")
    public List<Bloc> retrieveBlocsByCapaciteSuperieure(@PathVariable("capacite-min") Long capaciteMin) {
        return blocService.getBlocsByCapaciteSuperieure(capaciteMin);
    }

    @Operation(summary = "Get Blocs by name prefix", description = "Retrieve Blocs with names starting with a given prefix")
    @GetMapping("/retrieve-blocs-by-nom-prefix/{prefix}")
    public List<Bloc> retrieveBlocsByNomPrefix(@PathVariable String prefix) {
        return blocService.getBlocsByNomPrefix(prefix);
    }

    @Operation(summary = "Get Blocs by name prefix and minimum capacity", description = "Retrieve Blocs matching both name prefix and capacity criteria")
    @GetMapping("/retrieve-blocs-by-nom-prefix-and-capacite-superieure/{prefix}/{capacite-min}")
    public List<Bloc> retrieveBlocsByNomPrefixAndCapaciteSuperieure(@PathVariable String prefix,
                                                                     @PathVariable("capacite-min") Long capaciteMin) {
        return blocService.getBlocsByNomPrefixAndCapaciteSuperieure(prefix, capaciteMin);
    }

    @Operation(summary = "Get Bloc by ID", description = "Retrieve a single Bloc by its ID")
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        return blocService.findBlocById(blocId);
    }

    @Operation(summary = "Add a Bloc", description = "Create a new Bloc")
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.saveOrUpdateBloc(bloc);
    }

    @Operation(summary = "Remove a Bloc", description = "Delete a Bloc by its ID")
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.deleteBloc(blocId);
    }

    @Operation(summary = "Modify a Bloc", description = "Update an existing Bloc")
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc bloc) {
        return blocService.saveOrUpdateBloc(bloc);
    }


}
