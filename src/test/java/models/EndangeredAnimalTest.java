package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndangeredAnimalTest {

    @Test
    void newAnimalIsInitialized() {
        EndangeredAnimal testAnimal = setUpAnimal();
        assertTrue(testAnimal instanceof EndangeredAnimal);
    }

    @Test
    void getMethodsWork() {
        EndangeredAnimal testAnimal = setUpAnimal();
        assertEquals("Elephant", testAnimal.getName());
    }

    @Test
    void uniqueVariablesEqualTheConstantsCreated() {
        EndangeredAnimal testAnimal = setUpAnimal();
        assertEquals(testAnimal.getHealth(), EndangeredAnimal.AV_HEALTH);
    }

    public EndangeredAnimal setUpAnimal() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("Elephant", "okay", "young");
        return testAnimal;
    }

}