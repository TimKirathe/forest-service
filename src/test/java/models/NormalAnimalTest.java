package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalAnimalTest {

    @Test
    void newAnimalIsInitialized() {
        NormalAnimal testAnimal = setUpAnimal();
        assertTrue(testAnimal instanceof NormalAnimal);
    }

    @Test
    void getMethodsWork() {
        NormalAnimal testAnimal = setUpAnimal();
        assertEquals("Lion", testAnimal.getName());
    }

    @Test
    void equalsMethodWorks() {
        NormalAnimal testAnimal1 = setUpAnimal();
        NormalAnimal testAnimal2 = setUpAnimal();
        assertTrue(testAnimal1.equals(testAnimal2));

    }

    public NormalAnimal setUpAnimal() {
        NormalAnimal testAnimal = new NormalAnimal("Lion");
        return testAnimal;
    }
}