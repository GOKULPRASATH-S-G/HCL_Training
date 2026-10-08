package model;

public class AdoptionApplication {

    private int applicationId;
    private int petId;
    private String adopterName;
    private String applicationDate;
    private String status;

    public AdoptionApplication(int applicationId, int petId,
                               String adopterName, String applicationDate,
                               String status) {

        this.applicationId = applicationId;
        this.petId = petId;
        this.adopterName = adopterName;
        this.applicationDate = applicationDate;
        this.status = status;
    }
}