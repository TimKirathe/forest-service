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

    public EndangeredAnimal setUpAnimal() {
        EndangeredAnimal testAnimal = new EndangeredAnimal("Elephant");
        return testAnimal;
    }

}