public class OptionsPane {

    public static void printMainMenu() {
        System.out.println();
        System.out.println("--- Car Rental Application ---");
        System.out.println(" 1 - Manage customer database");
        System.out.println(" 2 - Manage vehicle database");
        System.out.println(" 0 - End program");
    }

    public static void printCustomerOptions() {
        System.out.println();
        System.out.println("--- Manage customer database ---");
        System.out.println(" 1 - Register new customer");
        System.out.println(" 2 - View all registered customers");
        System.out.println(" 3 - Delete a registered customer");
        System.out.println(" 0 - Go back");
    }

    public static void printVehicleOptions() {
        System.out.println();
        System.out.println("--- Manage vehicle database ---");
        System.out.println(" 1 - Add a new vehicle");
        System.out.println(" 2 - Rent a car to a registered customer");
        System.out.println(" 3 - Receive rented car back from customer");
        System.out.println(" 4 - View all rented vehicles in the database");
        System.out.println(" 5 - View all available vehicles in the database");
        System.out.println(" 6 - Delete a vehicle");
        System.out.println(" 0 - Go back");
    }

}
