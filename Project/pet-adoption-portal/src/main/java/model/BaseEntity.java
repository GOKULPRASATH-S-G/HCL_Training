
package model;

public abstract class BaseEntity {

    private int id;

    public BaseEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "ID must be greater than zero.");
        }

        this.id = id;
    }
}
