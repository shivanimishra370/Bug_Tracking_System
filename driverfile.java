import java.util.Scanner;

public class driverfile {
    public static void main(String[] args) {
        System.out.println("***************");
        System.out.println("BUG TRACKING SYSTEM");
        System.out.println("***************");

        int number, i = 1;
        int id = 0;

        Scanner scanner = new Scanner(System.in);

        while (i != 0) {
            System.out.println("\n1. FILE A NEW BUG");
            System.out.println("2. CHANGE THE STATUS OF THE BUG");
            System.out.println("3. GET BUG REPORT");
            System.out.println("4. EXIT");
            System.out.print("\nENTER YOUR CHOICE: ");

            number = scanner.nextInt();

            switch (number) {
                case 1:
                    id++;
                    // Creating a New Bug
                    fileBug(id);
                    break;
                case 2:
                    // Change Status of Bug
                    changeStatus();
                    break;
                case 3:
                    // Report the Bug
                    report();
                    break;
                case 4:
                    i = 0;
                    break;
                default:
                    System.out.println("\nInvalid entry");
                    break;
            }
        }

        scanner.close();
    }

    private static void fileBug(int id) {
        // Implement the logic for filing a new bug here
        System.out.println("Bug filed with ID: " + id);
    }

    private static void changeStatus() {
        // Implement the logic for changing the status of a bug here
        System.out.println("Bug status changed");
    }

    private static void report() {
        // Implement the logic for reporting a bug here
        System.out.println("Bug reported");
    }
}
