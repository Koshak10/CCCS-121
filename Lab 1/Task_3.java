import java.util.Scanner;

/**
 *
 * Task #3 - Working with Strings
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
        System.out.println();

        char firstInitial = firstName.charAt(0);
        System.out.println("User's first initial is: " + firstInitial);

        fullName = fullName.toUpperCase();
        System.out.println(fullName);
        System.out.println("Length: " + fullName.length());
        System.out.println();
    }

}
