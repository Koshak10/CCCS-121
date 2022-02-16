import java.util.Scanner;

public class PizzaOrder {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        final double TAX_RATE = .08;
        boolean discount = false; // Flag for discount
        String crust = "Hand-tossed"; // Name of crust
        String toppings = "Cheese "; // List of toppings
        int numberOfToppings = 0; // Number of toppings

        // TASK 1
        System.out.println("Welcome to Mike and Diane's Pizza");
        System.out.print("Enter your first name: ");
        String firstName = keyboard.nextLine();

        if (firstName.equalsIgnoreCase("Mike") || firstName.equalsIgnoreCase("Diane")) {
            discount = true;
        }

        // TASK 2
        System.out.println("Pizza Size (inches)   Cost");
        System.out.println("	10	$10.99");
        System.out.println("	12	$12.99");
        System.out.println("	14	$14.99");
        System.out.println("	16	$16.99");
        System.out.println("What size pizza would you like?");
        System.out.print("10, 12, 14, or 16 (Enter the number only): ");
        int inches = keyboard.nextInt();

        double cost;
        if (inches == 10) {
            cost = 10.99;
        } else if (inches == 12) {
            cost = 12.99;
        } else if (inches == 14) {
            cost = 14.99;
        } else if (inches == 16) {
            cost = 16.99;
        } else {
            System.out.println("The user input was not one of the choices, so a 12-inch pizza will be made.");
            inches = 12;
            cost = 12.99;
        }

        keyboard.nextLine();

        // TASK 3
        System.out.println("What type of crust do you want?");
        System.out.print("(H) Hand-tossed, (T) Thin-crust, or (D) Deep-dish (Enter H, T, or D): ");
        String input = keyboard.nextLine();

        char crustType = input.charAt(0);
        switch (crustType) {
            case 'H', 'h' -> crust = "Hand-tossed";
            case 'T', 't' -> crust = "Thin-crust";
            case 'D', 'd' -> crust = "Deep-dish";
            default -> System.out.println("Input was not one the choices, so a Hand-tossed crust will be made!");
        }

        System.out.println("All pizzas come with cheese.");
        System.out.println("Additional toppings are $1.25 each, choose from:");
        System.out.println("Pepperoni, Sausage, Onion, Mushroom");

        System.out.print("Do you want Pepperoni? (Y/N): ");
        input = keyboard.nextLine();
        char choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings = toppings + "Pepperoni ";
        }

        System.out.print("Do you want Sausage? (Y/N): ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings = toppings + "Sausage ";
        }

        System.out.print("Do you want Onion? (Y/N): ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings = toppings + "Onion ";
        }

        System.out.print("Do you want Mushroom? (Y/N): ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings = toppings + "Mushroom ";
        }

        cost = cost + (1.25 * numberOfToppings);

        System.out.println();
        System.out.println("Your order is as follows: ");
        System.out.println(inches + " inch pizza");
        System.out.println(crust + " crust");
        System.out.println(toppings);

        // TASK 4
        if (discount) {
            System.out.println("You're eligible for a $2.00 discount!");
            cost = cost - 2;
        }

        System.out.printf("The cost of your order is: $%.2f\n", cost);

        double tax = cost * TAX_RATE;
        System.out.printf("The tax is: $%.2f\n", tax);
        System.out.printf("The total due is: $%.2f\n", (tax + cost));
        System.out.println("Your order will be ready for pickup in 30 minutes.");
    }

}
