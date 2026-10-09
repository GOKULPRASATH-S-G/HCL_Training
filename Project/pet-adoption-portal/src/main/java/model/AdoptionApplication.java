package model;

public class AdoptionApplication extends BaseEntity {

    private int petId;
    private String adopterName;
    private String applicationDate;
    private String status;

    public AdoptionApplication(int applicationId, int petId,
            String adopterName, String applicationDate,
            String status) {
        super(applicationId);

        this.petId = petId;
        this.adopterName = adopterName;
        this.applicationDate = applicationDate;
        this.status = status;
    }
}