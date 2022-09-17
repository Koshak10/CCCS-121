import java.util.Scanner;

public class Mileage {

    public static void main(String[] args) {
        System.out.println("This program will calculate gas mileage in miles per gallon.");
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the amount of miles driven: ");
        double milesDriven = keyboard.nextDouble();

        System.out.print("Enter the amount of gallons used: ");
        double gallons = keyboard.nextDouble();

        double milesPerGallon = milesDriven / gallons;
        System.out.printf("Miles per gallon = %.2f", milesPerGallon);
    }
}
