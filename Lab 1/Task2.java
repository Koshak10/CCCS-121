import java.util.Scanner;

/**
 *
 * Task #2 - Using the Scanner Class for User Input
 *
 * This program demonstrates how numeric types and operators behave in Java.
 */
public class NumericTypes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please enter your last name: ");
        String lastName = scanner.nextLine();

        String fullName = firstName + " " + lastName;
        System.out.println(fullName);
    }

}
