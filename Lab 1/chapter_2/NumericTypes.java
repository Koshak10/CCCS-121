// TASK #2 Add an import statement for the Scanner class
import java.util.Scanner;

/**
 * This program demonstrates how numeric types and operators
 * behave in Java.
 */
public class NumericTypes {

    public static void main(String[] args) {
        // TASK #2 Create a Scanner object here
        Scanner keyboard = new Scanner(System.in);

        // Identifier declarations
        final int NUMBER = 2; // Number of scores
        final int SCORE1 = 100; // First test score
        final int SCORE2 = 95; // Second test score
        final int BOILING_IN_F = 212; // Boiling temperature
        int fToC; // Temperature Celsius
        double average; // Arithmetic average
        String output; // Line of output

        // TASK #2 declare variables used here
        String firstName, lastName, fullName;

        // TASK #3 declare variables used here
        char firstInitial;

        // TASK #4 declare variables used here
        double diameter, radius, volume;

        // Find an arithmetic average.
        average = SCORE1 + SCORE2 / NUMBER;
        output = SCORE1 + " and " + SCORE2 + " have an average of " + average;
        System.out.println(output);
        // Convert Fahrenheit temperature to Celsius.
        fToC = (BOILING_IN_F - 32) * 5 / 9;
        output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
        System.out.println(output);
        System.out.println(); // To leave a blank line

        // ADD LINES FOR TASK #2 HERE
        System.out.print("Please enter your first name: "); // Prompt the user for first name
        firstName = keyboard.nextLine(); // Read the user's first name
        System.out.print("Please enter your last name: "); // Prompt the user for last name
        lastName = keyboard.nextLine(); // Read the user's last name
        fullName = firstName + " " + lastName; // Concatenate the user's first and last names
        System.out.println(fullName); // Print out the user's full name
        System.out.println(); // To leave a blank line

        // ADD LINES FOR TASK #3 HERE
        firstInitial = firstName.charAt(0); // Get the first character from the user's first name
        System.out.println(firstInitial); // Print out the user's first initial
        fullName = fullName.toUpperCase(); // Convert the user's full name to uppercase
        System.out.println(fullName + " " + fullName.length()); // Print out the user's full name in uppercase

        System.out.println(); // To leave a blank line

        // ADD LINES FOR TASK #4 HERE
        System.out.print("Enter the diameter of a sphere: "); // Prompt the user for a diameter of a sphere
        diameter = keyboard.nextDouble(); // Read the diameter
        radius = diameter / 2; // Calculate the radius
        volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3); // Calculate the volume
        System.out.printf("Volume = %.2f", volume); // Print out the volume
    }

}
