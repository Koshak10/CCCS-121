import java.util.Scanner;

/**
 * This program demonstrates static methods
 */
public class Geometry {

    public static void main(String[] args) {
        double value;
        char letter;
        double radius;
        double length;
        double width;
        double height;
        double base;

        Scanner keyboard = new Scanner(System.in);
        do {
            printMenu();

            int choice = keyboard.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the radius of the circle: ");
                    radius = keyboard.nextDouble();
                    value = circleArea(radius);
                    System.out.println("The area of the circle is " + value);
                }
                case 2 -> {
                    System.out.print("Enter the length of the rectangle: ");
                    length = keyboard.nextDouble();
                    System.out.print("Enter the width of the rectangle: ");
                    width = keyboard.nextDouble();
                    value = rectangleArea(length, width);
                    System.out.println("The area of the rectangle is " + value);
                }
                case 3 -> {
                    System.out.print("Enter the height of the triangle: ");
                    height = keyboard.nextDouble();
                    System.out.print("Enter the base of the triangle: ");
                    base = keyboard.nextDouble();
                    value = triangleArea(base, height);
                    System.out.println("The area of the triangle is " + value);
                }
                case 4 -> {
                    System.out.print("Enter the radius of the circle: ");
                    radius = keyboard.nextDouble();
                    value = circleCircumference(radius);
                    System.out.println("The circumference of the circle is " + value);
                }
                case 5 -> {
                    System.out.print("Enter the length of the rectangle: ");
                    length = keyboard.nextDouble();
                    System.out.print("Enter the width of the rectangle: ");
                    width = keyboard.nextDouble();
                    value = rectanglePerimeter(length, width);
                    System.out.println("The perimeter of the rectangle is " + value);
                }
                case 6 -> {
                    System.out.print("Enter the length of side 1 of the triangle: ");
                    double side1 = keyboard.nextDouble();
                    System.out.print("Enter the length of side 2 of the triangle: ");
                    double side2 = keyboard.nextDouble();
                    System.out.print("Enter the length of side 3 of the triangle: ");
                    double side3 = keyboard.nextDouble();
                    value = trianglePerimeter(side1, side2, side3);
                    System.out.println("The perimeter of the triangle is " + value);
                }
                default -> System.out.println("You did not enter a valid choice.");
            }

            keyboard.nextLine();

            System.out.println("Do you want to exit the program (Y/N)?: ");
            String answer = keyboard.nextLine();
            letter = answer.charAt(0);
        } while (letter != 'Y' && letter != 'y');
    }

    /**
     * A menu of options for the user to choose from.
     *
     */
    private static void printMenu() {
        System.out.println(
                """
                        This is a geometry calculator
                        Choose what you would like to calculate
                        1.  Find the area of a circle
                        2.  Find the area of a rectangle
                        3.  Find the area of a triangle
                        4.  Find the circumference of a circle
                        5.  Find the perimeter of a rectangle
                        6.  Find the perimeter of a triangle"""
        );
        System.out.print("Enter the number of your choice: ");
    }

    /**
     * This method takes in the radius of the circle and calculates the area.
     *
     * @param radius This is the radius of the circle.
     * @return The area.
     */
    private static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    /**
     * Calculate the area of the rectangle by multiplying
     * the width and height of the rectangle.
     *
     * @param length The length of the rectangle.
     * @param width The width of the rectangle.
     * @return The area.
     */
    private static double rectangleArea(double length, double width) {
        return length * width;
    }

    /**
     * Calculates area of a triangle using base and vertical height.
     *
     * @param height The vertical height of the triangle.
     * @param base The base of the triangle.
     * @return The area.
     */
    private static double triangleArea(double height, double base) {
        return (height * base) / 2;
    }

    /**
     * This method takes in the radius of the circle and calculates the circumference.
     * The circumference is the perimeter of a circle.
     *
     * @param radius The length of the rectangle.
     * @return The circumference.
     */
    private static double circleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    /**
     * This method takes in the length and the width of the rectangle
     * and returns the perimeter of the rectangle using the formula.
     *
     * @param length The length of the rectangle.
     * @param width The width of the rectangle.
     * @return The perimeter.
     */
    private static double rectanglePerimeter(double length, double width) {
        return 2 * (length + width);
    }

    /**
     * This method takes in the lengths of the three sides of the triangle
     * and returns the perimeter of the triangle which is calculated
     * by adding up the three sides.
     *
     * @param side1 Side A.
     * @param side2 Side B.
     * @param side3 side C.
     * @return The perimeter.
     */
    private static double trianglePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

}
