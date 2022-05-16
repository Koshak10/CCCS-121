package vehicle;

import customer.Customer;
import customer.CustomerManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleManager {

    private final CustomerManager customerManager;

    private final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public VehicleManager(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public void setup() throws IOException {
        File file = new File("vehicles.txt");
        Scanner inputFile = new Scanner(file);

        vehicles.clear();

        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            String[] items = str.split(", ");

            int modelYear = Integer.parseInt(items[0]);
            String make = items[1];
            String modelName = items[2];
            String licensePlate = items[3];
            String lastItem = items[4];

            Vehicle vehicle = new Vehicle(modelYear, make, modelName, licensePlate);
            if (!lastItem.equals("Available")) {
                int customerId = Integer.parseInt(lastItem);

                for (Customer customer : customerManager.getCustomers()) {
                    if (customer.getCustomerId() == customerId) {
                        vehicle.setCustomer(customer);
                        break;
                    }
                }
            }

            if (!contains(vehicle)) {
                vehicles.add(vehicle);
            }
        }
        inputFile.close();
    }

    public void add(Vehicle vehicle) throws IOException {
        if (contains(vehicle)) {
            System.out.println("ERROR: Vehicle already exists in the database!");
            return;
        }

        FileWriter fileWriter = new FileWriter("vehicles.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(vehicle);
        printWriter.close();

        vehicles.add(vehicle);
        System.out.println("SUCCESS: Vehicle was added to Car Rental database!");
    }

    public void remove(String licensePlate) throws IOException {
        Vehicle vehicle = null;
        for (Vehicle v : vehicles) {
            if (v.getLicensePlate().equals(licensePlate)) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            System.out.println("ERROR: Vehicle does not exist in the database!");
            return;
        }

        if (!vehicle.isAvailableForRent()) {
            System.out.println("ERROR: The vehicle is currently rented by a customer!");
            System.out.println("ERROR: Make sure to receive the vehicle back first before removing it from the database.");
            return;
        }

        ArrayList<String> lines = new ArrayList<>();

        File file = new File("vehicles.txt");
        Scanner inputFile = new Scanner(file);

        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            String[] items = str.split(", ");

            if (items[3].equals(licensePlate)) {
                continue;
            }

            lines.add(str);
        }
        inputFile.close();

        textFile(lines);
        setup();

        System.out.println("SUCCESS: Vehicle with license plate: " + licensePlate + " was removed from the database!");
    }

    public void rent(String licensePlate, int customerId) throws IOException {
        Customer customer = null;
        for (Customer c : customerManager.getCustomers()) {
            if (c.getCustomerId() == customerId) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            System.out.println("ERROR: Customer does not exist in the database!");
            return;
        }

        Vehicle vehicle = null;
        for (Vehicle v : vehicles) {
            if (v.getLicensePlate().equals(licensePlate)) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            System.out.println("ERROR: Vehicle does not exist in the database!");
            return;
        }

        if (!vehicle.isAvailableForRent()) {
            System.out.println("ERROR: This vehicle is already rented to a customer!");
            return;
        }

        File file = new File("vehicles.txt");
        Scanner inputFile = new Scanner(file);

        ArrayList<String> lines = new ArrayList<>();

        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            String[] items = str.split(", ");

            int modelYear = Integer.parseInt(items[0]);
            String make = items[1];
            String modelName = items[2];

            if (modelYear == vehicle.getModelYear()
                    && make.equals(vehicle.getMake())
                    && modelName.equals(vehicle.getModelName())
                    && items[3].equals(vehicle.getLicensePlate())) {
                vehicle.setCustomer(customer);
                lines.add(vehicle.toString());
                continue;
            }

            lines.add(str);
        }

        inputFile.close();

        textFile(lines);
        setup();

        System.out.println("SUCCESS: Rented. Updated details: " + vehicle);
    }

    public void receive(String licensePlate) throws IOException {
        Vehicle vehicle = null;
        for (Vehicle v : vehicles) {
            if (v.getLicensePlate().equals(licensePlate)) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            System.out.println("ERROR: Vehicle does not exist in the database!");
            return;
        }

        if (vehicle.isAvailableForRent()) {
            System.out.println("ERROR: This vehicle is not rented to any customer!");
            return;
        }

        vehicle.setCustomer(null);

        File file = new File("vehicles.txt");
        Scanner inputFile = new Scanner(file);

        ArrayList<String> lines = new ArrayList<>();

        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            String[] items = str.split(", ");

            int modelYear = Integer.parseInt(items[0]);
            String make = items[1];
            String modelName = items[2];

            if (modelYear == vehicle.getModelYear()
                    && make.equals(vehicle.getMake())
                    && modelName.equals(vehicle.getModelName())
                    && items[3].equals(vehicle.getLicensePlate())) {
                lines.add(vehicle.toString());
                continue;
            }

            lines.add(str);
        }

        inputFile.close();

        textFile(lines);
        setup();

        System.out.println("SUCCESS: Received. Updated details: " + vehicle);
    }

    public void displayVehicles(boolean rented) {
        int count = 1;
        for (Vehicle vehicle : vehicles) {
            if (rented) {
                if (!vehicle.isAvailableForRent()) {
                    System.out.println(" " + count + ". " + vehicle);
                    count++;
                }
            } else {
                if (vehicle.isAvailableForRent()) {
                    System.out.println(" " + count + ". " + vehicle);
                    count++;
                }
            }
        }
    }

    private void textFile(ArrayList<String> lines) throws IOException {
        PrintWriter outputFile = new PrintWriter("vehicles.txt");

        for (String s : lines) {
            outputFile.println(s);
        }

        outputFile.close();
    }

    private boolean contains(Vehicle vehicle) {
        for (Vehicle v : vehicles) {
            if (v.getLicensePlate().equals(vehicle.getLicensePlate())) {
                return true;
            }
        }

        return false;
    }

}
