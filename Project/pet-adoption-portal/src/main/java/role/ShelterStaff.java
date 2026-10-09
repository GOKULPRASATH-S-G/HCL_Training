
package role;

public class ShelterStaff extends UserRole {

    public ShelterStaff(int userId, String name) {
        super(userId, name);
    }

    @Override
    public void performRole() {
        System.out.println(
                getName() + " manages pet listings and adoption applications.");
    }
}
