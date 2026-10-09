
import role.UserRole;
import role.Admin;
import role.ShelterStaff;
import role.Veterinarian;
import role.Adopter;

public class RoleDemo {

    public static void main(String[] args) {

        UserRole[] roles = {
                new Admin(1, "Admin User"),
                new ShelterStaff(2, "Shelter Staff"),
                new Veterinarian(3, "Dr. Kumar"),
                new Adopter(4, "Pet Owner")
        };

        for (UserRole role : roles) {
            role.performRole();
        }
    }
}
