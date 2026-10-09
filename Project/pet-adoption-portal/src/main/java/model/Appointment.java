package model;

public class Appointment extends BaseEntity {

    private int petId;
    private String ownerName;
    private String veterinarianName;
    private String appointmentDate;
    private String status;

    public Appointment(int appointmentId, int petId,
            String ownerName, String veterinarianName,
            String appointmentDate, String status) {
        super(appointmentId);

        this.petId = petId;
        this.ownerName = ownerName;
        this.veterinarianName = veterinarianName;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }
}