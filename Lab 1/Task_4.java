import java.util.Scanner;

/**
 *
 * Task #4 - Using Predefined Math Functions
 *
 * This program demonstrates how numeric types and operators behave in Java.
 */
public class NumericTypes {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the diameter of a sphere: ");
        double diameter = keyboard.nextDouble();

        double radius = diameter / 2;
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        System.out.printf("Volume = %.2f", volume);
    }

}
