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
