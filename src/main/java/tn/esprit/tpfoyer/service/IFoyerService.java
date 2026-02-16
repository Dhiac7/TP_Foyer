package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer saveFoyer(Foyer foyer);

    void deleteFoyer(Long id);

    Foyer getFoyerById(Long id);

    Foyer updateFoyer(Foyer foyer);

    List<Foyer> getAllFoyer();
}
