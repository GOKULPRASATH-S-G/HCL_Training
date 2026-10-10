package service;

import exception.InvalidAppointmentException;
import exception.PetUnavailableException;

public class PortalRules {

    public static final String STATUS_AVAILABLE = "AVAILABLE";

    public static void validatePetAvailability(String status) throws PetUnavailableException {
        if (status == null || !STATUS_AVAILABLE.equalsIgnoreCase(status.trim())) {
            throw new PetUnavailableException("Pet is not available for adoption. Current status: " + status);
        }
    }

    public static void validatePetAvailability(int petId, String status) throws PetUnavailableException {
        if (status == null || !STATUS_AVAILABLE.equalsIgnoreCase(status.trim())) {
            throw new PetUnavailableException(
                "Pet with ID " + petId + " is not available for adoption. Current status: " + status
            );
        }
    }

    public static void validateAppointment(int petId, String ownerName, String veterinarianName, String appointmentDate)
            throws InvalidAppointmentException {
        if (petId <= 0) {
            throw new InvalidAppointmentException("Invalid appointment: Pet ID must be greater than zero.");
        }
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new InvalidAppointmentException("Invalid appointment: Owner name cannot be null or empty.");
        }
        if (veterinarianName == null || veterinarianName.trim().isEmpty()) {
            throw new InvalidAppointmentException("Invalid appointment: Veterinarian name cannot be null or empty.");
        }
        if (appointmentDate == null || appointmentDate.trim().isEmpty()) {
            throw new InvalidAppointmentException("Invalid appointment: Appointment date cannot be null or empty.");
        }
    }

    public void checkPetAvailability(String status) throws PetUnavailableException {
        validatePetAvailability(status);
    }

    public void checkPetAvailability(int petId, String status) throws PetUnavailableException {
        validatePetAvailability(petId, status);
    }

    public void checkAppointment(int petId, String ownerName, String veterinarianName, String appointmentDate)
            throws InvalidAppointmentException {
        validateAppointment(petId, ownerName, veterinarianName, appointmentDate);
    }
}
