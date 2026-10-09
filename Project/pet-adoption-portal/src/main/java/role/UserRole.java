
package role;

public abstract class UserRole {

    private int userId;
    private String name;

    public UserRole(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public abstract void performRole();
}
