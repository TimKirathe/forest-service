package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SightingTest {

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

    public Sighting setUpSighting() {
        Sighting sighting = new Sighting(1, "Up", "Rodgers");
        return sighting;
    }
}