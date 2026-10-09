
package role;

public class Admin extends UserRole {

    public Admin(int userId, String name) {
        super(userId, name);
    }

    @Override
    public void performRole() {
        System.out.println(
                getName() + " manages portal users and system settings.");
    }
}
