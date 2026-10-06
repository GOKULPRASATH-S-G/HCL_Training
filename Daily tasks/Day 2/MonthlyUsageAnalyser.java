public class MonthlyUsageAnalyser{
    public static void main(String[] args){
        final int MONTHS =12;
        int[] monthlyUsage ={
            120, 150, 180, 200,
            250, 300, 280, 320,
            220, 190, 160, 140
        };
        int total = 0;
        for (int usage : monthlyUsage) {
            total += usage;
        }
        double average = (double) total / MONTHS;

        int max = monthlyUsage[0];
        int min = monthlyUsage[0];

        for (int usage : monthlyUsage) {
            if (usage > max) {
                max = usage;
            }

            if (usage < min) {
                min = usage;
            }
        }

        char grade = average >= 200 ? 'A' : 'B';

        System.out.println("Monthly Usage Analysis");
        System.out.println("----------------------");
        System.out.println("Total Usage    : " + total);
        System.out.println("Average Usage  : " + average);
        System.out.println("Maximum Usage  : " + max);
        System.out.println("Minimum Usage  : " + min);
        System.out.println("Usage Grade    : " + grade);

        System.out.println();
System.out.println("Overflow Demonstration");

int intValue = 2_000_000_000;
int intResult = intValue + intValue;

long longValue = 2_000_000_000L;
long longResult = longValue + longValue;

System.out.println("int result  : " + intResult);
System.out.println("long result : " + longResult);

System.out.println();
System.out.println("2-D Array - House Usage");

int[][] houseUsage = {
    {120, 150, 180, 200},
    {200, 220, 250, 270},
    {150, 180, 210, 230}
};

for (int i = 0; i < houseUsage.length; i++) {
    System.out.print("House " + (i + 1) + ": ");

    for (int j = 0; j < houseUsage[i].length; j++) {
        System.out.print(houseUsage[i][j] + " ");
    }

    System.out.println();
}
    }
}