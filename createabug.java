import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class createabug{

    // Function to file the Bug into the Bug Tracking System
    private static void fileBug(int id) {
        System.out.println("**********");
        System.out.println("FILING A BUG");
        System.out.println("***********");

        Scanner scanner = new Scanner(System.in);

        // Current Time
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String name, bugtype, bugdescription, bugpriority;
        int bugstatus;

        // User name
        System.out.println("Enter your name:");
        name = scanner.nextLine();
        String fileName = name + id + ".txt";

        // Filename of the Bug
        System.out.println("Filename: " + fileName);

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("DATE AND TIME: " + currentTime.format(formatter) + "\n");
            writer.write("BUG ID: " + id + "\n");
            writer.write("\n");
            System.out.println("BUG ID: " + id);

            writer.write("BUG FILED BY: " + name + "\n");
            writer.write("\n");

            System.out.println("Enter bug type:");
            bugtype = scanner.nextLine();
            writer.write("TYPE OF BUG: " + bugtype + "\n");
            writer.write("\n");

            System.out.println("Enter bug priority:");
            bugpriority = scanner.nextLine();
            writer.write("BUG PRIORITY: " + bugpriority + "\n");
            writer.write("\n");

            System.out.println("Enter the bug description:");
            bugdescription = scanner.nextLine();
            writer.write("BUG DESCRIPTION: " + bugdescription + "\n");
            writer.write("\n");

            System.out.println("Status of bug:");
            System.out.println("1. NOT YET ASSIGNED");
            System.out.println("2. IN PROCESS");
            System.out.println("3. FIXED");
            System.out.println("4. DELIVERED");
            System.out.print("ENTER YOUR CHOICE: ");
            bugstatus = scanner.nextInt();

            writer.write("DATE AND TIME: " + currentTime.format(formatter) + "\n");
            writer.write("BUG STATUS: ");

            // Switching for the Status of the Bug
            switch (bugstatus) {
                case 1:
                    writer.write("NOT YET ASSIGNED\n");
                    break;
                case 2:
                    writer.write("IN PROCESS\n");
                    break;
                case 3:
                    writer.write("FIXED\n");
                    break;
                case 4:
                    writer.write("DELIVERED\n");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println("Bug filed successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while creating the file.");
            e.printStackTrace();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        // Test the fileBug method with an example ID (you can modify this as needed)
        fileBug(1);
    }
}
