package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService{


    FoyerRepository foyerRepository;
    BlocRepository blocRepository;

    @Override
    public Foyer saveFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return foyerRepository.findById(id).get();
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    @Scheduled(cron = "0 15,45 8 * * MON")
    public List<Foyer> getAllFoyer() {
        log.info("Foyerrr");
        return foyerRepository.findAll();
    }

    public Foyer addFoyerAndBlocAndAssign(Foyer foyer) {
        // foyer contient déjà un ou plusieurs blocs dans son JSON
        return foyerRepository.save(foyer);
    }

    public void assignBlocToFoyer(Long blocId, Long foyerId) {
        Bloc bloc = blocRepository.findById(blocId).get();
        Foyer foyer = foyerRepository.findById(foyerId).get();
        // on set le fils dans le parent ou l’inverse selon ton mapping
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
    }

    public Bloc desaffecterBlocFromFoyer(Long blocId) {
        Bloc bloc = blocRepository.findById(blocId).get();
        bloc.setFoyer(null);
        return blocRepository.save(bloc);
    }


}
