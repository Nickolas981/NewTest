package com.example.ngumeniuk.newtest.geoFragment.data.dataRepository;

import com.example.ngumeniuk.newtest.geoFragment.data.dao.NamesDao;
import com.example.ngumeniuk.newtest.geoFragment.data.dataSource.NamesDataSource;
import com.example.ngumeniuk.newtest.geoFragment.data.models.databaseEntities.CityNameModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class NamesRepository implements NamesDataSource{

    private NamesDao namesDao;

    @Inject
    public NamesRepository(NamesDao namesDao) {
        this.namesDao = namesDao;
    }

    @Override
    public Flowable<List<CityNameModel>> getAll() {
        return namesDao.getAll();
    }

    @Override
    public Completable deleteById(int id) {
        return Completable.fromAction(() -> namesDao.delete(id));
    }

    @Override
    public Completable putCityName(CityNameModel model) {
        return Completable.fromAction(() -> namesDao.putName(model));
    }

    @Override
    public Completable delete(CityNameModel model) {
        return Completable.fromAction(() -> namesDao.delete(model));
    }
}
