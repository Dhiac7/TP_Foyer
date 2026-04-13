package tn.esprit.tpfoyer.service;

import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc saveOrUpdateBloc(Bloc bloc);

    void deleteBloc(Long id);

    Bloc findBlocById(Long id);

    List<Bloc> getAllBlocs();

    List<Bloc> getBlocsSansFoyer();

    List<Bloc> getBlocsByCapaciteSuperieure(Long capaciteMin);

    List<Bloc> getBlocsByNomPrefix(String prefix);

    List<Bloc> getBlocsByNomPrefixAndCapaciteSuperieure(String prefix, Long capaciteMin);
}
