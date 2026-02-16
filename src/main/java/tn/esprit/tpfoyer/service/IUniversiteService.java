package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite saveUniversite(Universite universite);

    void deleteUniversite(Long id);

    Universite getUniversiteById(Long id);

    Universite updateUniversite(Universite universite);

    List<Universite> getAllUniversites();
}
