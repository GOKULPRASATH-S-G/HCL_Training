
package role;

public class Veterinarian extends UserRole {

    public Veterinarian(int userId, String name) {
        super(userId, name);
    }

    @Override
    public void performRole() {
        System.out.println(
                getName() + " manages veterinary appointments and vaccination records.");
    }
}
