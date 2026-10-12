
package service;

import model.Pet;
import model.AdoptionApplication;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import java.util.Queue;

public class PortalCollectionService {

    // List: keeps the pets and applications in insertion order.
    private final List<Pet> pets = new ArrayList<>();
    private final List<AdoptionApplication> applications = new ArrayList<>();

    // Set: prevents duplicate application IDs.
    private final Set<Integer> applicationIds = new LinkedHashSet<>();

    // Queue: processes applications in FIFO order.
    private final Queue<AdoptionApplication> reviewQueue = new ArrayDeque<>();

    // Queue: holds approved applications awaiting home visits.
    private final Queue<AdoptionApplication> homeVisitQueue = new ArrayDeque<>();

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    // FR1: staff list pets and their status.
    public void listPets() {
        System.out.println("\n=== Pet Listings ===");

        for (Pet pet : pets) {
            System.out.println(
                    "ID: " + pet.getId()
                            + ", Name: " + pet.getName()
                            + ", Species: " + pet.getSpecies()
                            + ", Breed: " + pet.getBreed()
                            + ", Age: " + pet.getAge()
                            + ", Status: " + pet.getStatus());
        }
    }

    // FR2: adopters filter available pets by species.
    public void filterAvailablePets(String species) {
        System.out.println("\n=== Available " + species + " Pets ===");

        for (Pet pet : pets) {
            if ("AVAILABLE".equalsIgnoreCase(pet.getStatus())
                    && pet.getSpecies().equalsIgnoreCase(species)) {
                System.out.println(
                        pet.getId() + " - " + pet.getName()
                                + " (" + pet.getBreed() + ")");
            }
        }
    }

    // FR2: adopter submits an application.
    public void applyForAdoption(int applicationId, int petId,
            String adopterName, String date) {

        Pet pet = findPet(petId);

        if (pet == null
                || !"AVAILABLE".equalsIgnoreCase(pet.getStatus())) {
            System.out.println("Application rejected: pet is unavailable.");
            return;
        }

        if (!applicationIds.add(applicationId)) {
            System.out.println("Application ID already exists.");
            return;
        }

        AdoptionApplication application = new AdoptionApplication(
                applicationId, petId, adopterName, date, "SUBMITTED");

        applications.add(application);
        reviewQueue.offer(application);

        System.out.println(
                "Application submitted successfully. ID: " + applicationId);
    }

    // FR3: staff review the next application.
    public void reviewNextApplication(boolean approve) {
        AdoptionApplication application = reviewQueue.poll();

        if (application == null) {
            System.out.println("No applications awaiting review.");
            return;
        }

        if (approve) {
            application.setStatus("APPROVED_FOR_HOME_VISIT");
            homeVisitQueue.offer(application);

            System.out.println(
                    "Application approved for home visit: "
                            + application.getId());
        } else {
            application.setStatus("REJECTED");

            System.out.println(
                    "Application rejected: " + application.getId());
        }
    }

    // FR3: schedule the next home visit.
    public void scheduleNextHomeVisit() {
        AdoptionApplication application = homeVisitQueue.poll();

        if (application == null) {
            System.out.println("No home visits awaiting scheduling.");
            return;
        }

        application.setStatus("HOME_VISIT_SCHEDULED");

        System.out.println(
                "Home visit scheduled for "
                        + application.getAdopterName()
                        + ", application ID: " + application.getId());
    }

    public void listApplications() {
        System.out.println("\n=== Adoption Applications ===");

        for (AdoptionApplication application : applications) {
            System.out.println(
                    "Application ID: " + application.getId()
                            + ", Pet ID: " + application.getPetId()
                            + ", Adopter: " + application.getAdopterName()
                            + ", Status: " + application.getStatus());
        }
    }

    private Pet findPet(int petId) {
        for (Pet pet : pets) {
            if (pet.getId() == petId) {
                return pet;
            }
        }

        return null;
    }
}
