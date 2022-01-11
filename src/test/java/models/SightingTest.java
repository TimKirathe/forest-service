package models;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import dao.*;
import org.sql2o.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SightingTest {

    private static sql2oSightingsDao sql2oSightingsDao;
    private static sql2oEndangeredAnimalsDao sql2oEndangeredAnimalsDao;
    private static sql2oNormalAnimalDao sql2oNormalAnimalDao;
    private static Connection conn;

    @BeforeAll
    public static void setUp() {
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
        Sql2o sql2o = new Sql2o(connectionString, null, null);
        sql2oSightingsDao = new sql2oSightingsDao(sql2o);
        sql2oNormalAnimalDao = new sql2oNormalAnimalDao(sql2o);
        sql2oEndangeredAnimalsDao = new sql2oEndangeredAnimalsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void afterEach() {
        sql2oSightingsDao.clearAllSightings();
        sql2oEndangeredAnimalsDao.clearAllAnimals();
        sql2oNormalAnimalDao.clearAllAnimals();
    }

    @AfterAll
    public static void tearDown() {
        conn.createQuery("DELETE FROM animals");
        conn.createQuery("DELETE FROM sightings");
        conn.close();
    }

    @Test
    void sightingIsInitializedProperly() {
        Sighting testSighting = setUpSighting();
        assertTrue(testSighting instanceof Sighting);
    }

    @Test
    void gettersWorkForSighting() {
        Sighting testSighting = setUpSighting();
        assertEquals(1, testSighting.getAnimalId());
    }

    @Test
    void overrideEqualsWorks() {
        Sighting testSighting1 = setUpSighting();
        Sighting testSighting2 = setUpSighting();
        assertTrue(testSighting1.equals(testSighting2));
    }

    @Test
    void sightingIsSavedIntoDB() {
        NormalAnimal testNormalAnimal = new NormalAnimal("Hyena");
        sql2oNormalAnimalDao.save(testNormalAnimal);
        Sighting testSighting = new Sighting(testNormalAnimal.getId(), "Savannah", "Rodgers");
        sql2oSightingsDao.save(testSighting);
        assertEquals(testSighting, sql2oSightingsDao.findById(testSighting.getId()));

    }

    @Test
    void allSightingsAreReturned() {
        NormalAnimal testNormalAnimal = new NormalAnimal("Hyena");
        sql2oNormalAnimalDao.save(testNormalAnimal);
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Snake", "okay", "young");
        sql2oEndangeredAnimalsDao.save(testEndangeredAnimal);
        Sighting testSighting1 = new Sighting(testNormalAnimal.getId(), "Savannah", "Rodgers");
        Sighting testSighting2 = new Sighting(testEndangeredAnimal.getId(), "Hills", "Rodgers");
        sql2oSightingsDao.save(testSighting1);
        sql2oSightingsDao.save(testSighting2);
        List<Sighting> sightings = sql2oSightingsDao.returnAll();
        assertTrue(sightings.contains(testSighting1));
        assertTrue(sightings.contains(testSighting2));
    }

    public Sighting setUpSighting() {
        Sighting sighting = new Sighting(1, "Up", "Rodgers");
        return sighting;
    }
}