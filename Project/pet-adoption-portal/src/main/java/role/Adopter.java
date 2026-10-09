
package role;

public class Adopter extends UserRole {

    public Adopter(int userId, String name) {
        super(userId, name);
    }

    @Override
    public void performRole() {
        System.out.println(
                getName() + " applies for pet adoption and books vet appointments.");
    }
}
