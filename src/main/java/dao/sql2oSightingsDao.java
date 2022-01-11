package dao;

import models.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

public class sql2oSightingsDao implements sightingsDao {

    private final Sql2o sql2o;

    public sql2oSightingsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void save(Sighting sighting) {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO sightings (animalid, location, ranger_name, sighted_at) VALUES (:animalId, :location, :rangerName, now())";
            int id = (int) con.createQuery(sql)
                    .bind(sighting)
                    .addParameter("animalId", sighting.getAnimalId())
                    .addParameter("location", sighting.getLocation())
                    .addParameter("rangerName", sighting.getRangerName())
                    .executeUpdate().getKey();
            sighting.setId(id);
        }
    }

    @Override
    public Sighting findById(int id) {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
        }
    }

    @Override
    public List<Sighting> returnAll() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM sightings";
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }

    @Override
    public void clearAllSightings() {
        try (Connection con = sql2o.open()) {
            String sql = "DELETE FROM sightings";
            con.createQuery(sql).executeUpdate();
        }
    }

    @Override
    public void addSightingAndAnimal(int sightingId, int animalId ) {
        try(Connection con = sql2o.open()) {
            String sql = "INSERT INTO sightings_animals (sightingid, animalid) VALUES (:sightingId, :animalId)";
            con.createQuery(sql)
                    .addParameter("sightingId", sightingId)
                    .addParameter("animalId", animalId)
                    .executeUpdate();
        }
    }

    @Override
    public List<Object> showAnimalsSighted(int sightingId) {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT animalid FROM sightings_animals WHERE sightingid = :sightingId";
            List<Integer> animalIds = con.createQuery(sql)
                    .addParameter("sightingId", sightingId)
                    .executeAndFetch(Integer.class);

            List<Object> animals = new ArrayList<>();

            String sql2 = "SELECT * FROM animals WHERE id = :id";
            for(Integer animalId : animalIds) {
                animals.add(con.createQuery(sql2).addParameter("id", animalId).executeAndFetchFirst(Object.class));
            }
            return animals;
        }
    }
}
