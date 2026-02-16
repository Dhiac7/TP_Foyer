package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc saveOrUpdateBloc(Bloc bloc);

    void deleteBloc(Long id);

    Bloc findBlocById(Long id);


    List<Bloc> getAllBlocs();
}
