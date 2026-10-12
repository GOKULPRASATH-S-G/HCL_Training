
import model.Pet;
import service.PortalCollectionService;

public class PortalCollectionsDemo {

    public static void main(String[] args) {

        PortalCollectionService portal = new PortalCollectionService();

        portal.addPet(new Pet(
                1, "Buddy", "Dog", "Labrador", 2, "AVAILABLE"));

        portal.addPet(new Pet(
                2, "Milo", "Cat", "Persian", 1, "AVAILABLE"));

        portal.addPet(new Pet(
                3, "Rocky", "Dog", "Indie", 3, "ADOPTED"));

        // FR1: list pets.
        portal.listPets();

        // FR2: filter available pets and apply.
        portal.filterAvailablePets("Dog");
        portal.applyForAdoption(
                101, 1, "Anu", "2026-10-12");

        // FR3: review and schedule a home visit.
        portal.reviewNextApplication(true);
        portal.scheduleNextHomeVisit();

        portal.listApplications();
    }
}
