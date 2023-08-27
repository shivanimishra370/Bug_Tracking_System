import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class completecode {

    private static final String FILE_EXTENSION = ".txt";

    // Function to file the Bug into the Bug Tracking System
    private static void fileBug(int id) {
        System.out.println("**********");
        System.out.println("FILING A BUG");
        System.out.println("***********");

        Scanner scanner = new Scanner(System.in);
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String name, bugtype, bugdescription, bugpriority;
        int bugstatus;

        // User name
        System.out.println("Enter your name:");
        name = scanner.nextLine();
        String fileName = name + id + FILE_EXTENSION;

        System.out.println("Filename: " + fileName);

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("DATE AND TIME: " + currentTime.format(formatter) + "\n");
            writer.write("BUG ID: " + id + "\n\n");

            System.out.println("BUG ID: " + id);

            writer.write("BUG FILED BY: " + name + "\n\n");

            System.out.println("Enter bug type:");
            bugtype = scanner.nextLine();
            writer.write("TYPE OF BUG: " + bugtype + "\n\n");

            System.out.println("Enter bug priority:");
            bugpriority = scanner.nextLine();
            writer.write("BUG PRIORITY: " + bugpriority + "\n\n");

            System.out.println("Enter the bug description:");
            bugdescription = scanner.nextLine();
            writer.write("BUG DESCRIPTION: " + bugdescription + "\n\n");

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
        String fileName = name + FILE_EXTENSION;

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

    // Function to report the Bug in the Bug Tracking System
    private static void report() {
        System.out.println("**********");
        System.out.println("REPORT");
        System.out.println("**********");

        Scanner scanner = new Scanner(System.in);
        String name;

        // Asking the Filename to report the bug of the file
        System.out.println("Enter file name:");
        name = scanner.nextLine();
        String fileName = name + FILE_EXTENSION;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            // Read the content of the file and print it to the console
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while opening/reading the file.");
            e.printStackTrace();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("***************");
        System.out.println("BUG TRACKING SYSTEM");
        System.out.println("***************");

        Scanner scanner = new Scanner(System.in);
        int number, i = 1;
        int id = 0;

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
                    System.out.println("\ninvalid entry");
                    break;
            }
        }

        scanner.close();
    }
}
