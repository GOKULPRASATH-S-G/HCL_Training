package model;

public class Pet {

    private int petId;
    private String name;
    private String species;
    private String breed;
    private int age;
    private String status;

    public Pet(int petId, String name, String species,
               String breed, int age, String status) {

        this.petId = petId;
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.status = status;
    }
}