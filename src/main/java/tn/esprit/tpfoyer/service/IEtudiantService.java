package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant saveEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long id);
    Etudiant getEtudiantById(Long id);
    Etudiant updateEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
}
