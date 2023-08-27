import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class reportbug {

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
        String fileName = name + ".txt";

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
        // Test the report method
        report();
    }
}
