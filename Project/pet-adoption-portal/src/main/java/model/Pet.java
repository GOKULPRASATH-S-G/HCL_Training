
package model;

public class Pet extends BaseEntity {

    private String name;
    private String species;
    private String breed;
    private int age;
    private String status;

    public Pet(int petId, String name, String species,
            String breed, int age, String status) {
        super(petId);
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
