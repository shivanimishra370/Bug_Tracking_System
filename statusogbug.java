import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class statusogbug {

    // Function to change the status of the Bug
    private static void changeStatus() {
        System.out.println("*************");
        System.out.println("Change status");
        System.out.println("**************");

        Scanner scanner = new Scanner(System.in);
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String name;

        // Bug File name
        System.out.println("Enter file name:");
        name = scanner.nextLine();
        String fileName = name + ".txt";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            System.out.println("\n 1. NOT YET ASSIGNED");
            System.out.println(" 2. IN PROCESS");
            System.out.println(" 3. FIXED");
            System.out.println(" 4. DELIVERED");
            System.out.print("ENTER YOUR CHOICE: ");
            int k = scanner.nextInt();

            writer.write("\n");
            writer.write("DATE AND TIME: " + currentTime.format(formatter) + "\n");
            writer.write("BUG STATUS: ");

            // Changing the status based on the user input
            switch (k) {
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

            System.out.println("Status of the bug changed successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while opening/creating the file.");
            e.printStackTrace();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        // Test the changeStatus method
        changeStatus();
    }
}
