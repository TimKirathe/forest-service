package dao;

import models.Sighting;

import java.util.List;

public interface sightingsDao {

    void save(Sighting sighting);

    Sighting findById(int id);

    List<Sighting> returnAll();

    void clearAllSightings();
}
