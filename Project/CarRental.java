import customer.Customer;
import customer.CustomerManager;
import vehicle.Vehicle;
import vehicle.VehicleManager;

import java.io.IOException;
import java.util.Scanner;

public class CarRental {

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        CustomerManager customerManager = new CustomerManager();
        customerManager.setup();

        VehicleManager vehicleManager = new VehicleManager(customerManager);
        vehicleManager.setup();

        OptionsPane.printMainMenu();
        System.out.print("> ");

        int choice = keyboard.nextInt();
        switch (choice) {
            case 1 -> customerMenu(customerManager);
            case 2 -> vehicleMenu(vehicleManager);
            case 0 -> System.exit(0);
            default -> System.out.println("Invalid choice! Please try again.");
        }

        keyboard.close();
    }

    public static void customerMenu(CustomerManager customerManager) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        OptionsPane.printCustomerOptions();
        System.out.print("> ");

        int choice = keyboard.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter the new customer ID: ");
                int id = keyboard.nextInt();

                keyboard.nextLine();

                System.out.print("Enter the new customer name: ");
                String name = keyboard.nextLine();

                System.out.print("Enter the new customer phone number: ");
                String phoneNumber = keyboard.nextLine();

                Customer customer = new Customer(id, name, phoneNumber);
                customerManager.newRecord(customer);
            }
            case 2 -> customerManager.viewRecords();
            case 3 -> {
                System.out.print("Enter the customer ID: ");
                int customerId = keyboard.nextInt();

                customerManager.deleteRecord(customerId);
            }
            case 0 -> main(null);
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }

    public static void vehicleMenu(VehicleManager vehicleManager) throws IOException {
        Scanner keyboard = new Scanner(System.in);

        OptionsPane.printVehicleOptions();
        System.out.print("> ");

        int choice = keyboard.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.print("Enter the new vehicle's model year: ");
                int modelYear = keyboard.nextInt();

                keyboard.nextLine();

                System.out.print("Enter the new vehicle's maker: ");
                String make = keyboard.nextLine();

                System.out.print("Enter the new vehicle's model name: ");
                String modelName = keyboard.nextLine();

                System.out.print("Enter the new vehicle's license plate: ");
                String licensePlate = keyboard.nextLine();

                Vehicle vehicle = new Vehicle(modelYear, make, modelName, licensePlate);
                vehicleManager.add(vehicle);
            }
            case 2 -> {
                System.out.print("Enter the registered customer's id: ");
                int customerId = keyboard.nextInt();

                keyboard.nextLine();

                System.out.print("Enter the vehicle's license plate: ");
                String licensePlate = keyboard.nextLine();

                vehicleManager.rent(licensePlate, customerId);
            }
            case 3 -> {
                keyboard.nextLine();

                System.out.print("Enter the vehicle's license plate: ");
                String licensePlate = keyboard.nextLine();

                vehicleManager.receive(licensePlate);
            }
            case 4 -> {
                System.out.println("List of all rented vehicles:");
                vehicleManager.displayVehicles(true);
            }
            case 5 -> {
                System.out.println("List of all available vehicles:");
                vehicleManager.displayVehicles(false);
            }
            case 6 -> {
                keyboard.nextLine();

                System.out.print("Enter the vehicle license plate: ");
                String licensePlate = keyboard.nextLine();

                vehicleManager.remove(licensePlate);
            }
            case 0 -> main(null);
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }

}
