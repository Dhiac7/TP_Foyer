package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class BlocService implements IBlocService {

    BlocRepository blocRepository;

    @Override
    public Bloc saveOrUpdateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }

    @Override
    @Scheduled(cron = "*/15 * 8-12 * * MON-FRI")
    public List<Bloc> getAllBlocs() {
        log.info("getAllBlocs");
        return blocRepository.findAll();
    }

    @Override
    public Bloc findBlocById(Long id) {
        return blocRepository.findById(id).get();
    }

    @Override
    public List<Bloc> getBlocsSansFoyer() {
        return blocRepository.findByFoyerIsNull();
    }

    @Override
    public List<Bloc> getBlocsByCapaciteSuperieure(Long capaciteMin) {
        return blocRepository.findByCapaciteBlocGreaterThan(capaciteMin);
    }

    @Override
    public List<Bloc> getBlocsByNomPrefix(String prefix) {
        return blocRepository.findByNomBlocStartingWith(prefix);
    }

    @Override
    public List<Bloc> getBlocsByNomPrefixAndCapaciteSuperieure(String prefix, Long capaciteMin) {
        return blocRepository.findByNomBlocStartingWithAndCapaciteBlocGreaterThan(prefix, capaciteMin);
    }





}
