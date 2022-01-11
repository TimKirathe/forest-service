package models;

import java.util.Objects;

public class Sighting {

    private int id;
    private int animalId;
    private String location;
    private String ranger_name;

    public Sighting(int animalId, String location, String rangerName) {
        this.animalId = animalId;
        this.location = location;
        this.ranger_name = rangerName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return ranger_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return animalId == sighting.animalId && location.equals(sighting.location) && ranger_name.equals(sighting.ranger_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, location, ranger_name);
    }
}
