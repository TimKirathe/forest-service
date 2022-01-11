package models;

import java.util.Objects;

public class Sighting {

    private int animalId;
    private String location;
    private String rangerName;

    public Sighting(int animalId, String location, String rangerName) {
        this.animalId = animalId;
        this.location = location;
        this.rangerName = rangerName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return animalId == sighting.animalId && location.equals(sighting.location) && rangerName.equals(sighting.rangerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, location, rangerName);
    }
}
