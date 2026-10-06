public class WeeklyUsageData {
    public static void main(String[] args) {

        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        int[] petsListed = {
                3, 2, 4, 3, 5, 6, 2
        };

        int[] adoptionApplications = {
                2, 3, 1, 4, 3, 5, 2
        };

        int[] vetAppointments = {
                4, 5, 3, 6, 4, 7, 3
        };

        System.out.println("Weekly Sample Data");
        System.out.println("------------------");

        for (int i = 0; i < days.length; i++) {
            System.out.println(
                    days[i]
                            + " | Pets Listed: " + petsListed[i]
                            + " | Applications: " + adoptionApplications[i]
                            + " | Vet Appointments: " + vetAppointments[i]);
        }
    }
}
