package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void newAnimalIsInitialized() {
        Animal testAnimal = setUpAnimal();
        assertTrue(testAnimal instanceof Animal);
    }

    @Test
    void getMethodsWork() {
        Animal testAnimal = setUpAnimal();
        assertEquals("Lion", testAnimal.getName());
    }

    public Animal setUpAnimal() {
        Animal testAnimal = new Animal("Lion");
        return testAnimal;
    }
}