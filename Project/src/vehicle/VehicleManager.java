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
//        if (!file.exists()) {
//            PrintWriter outputFile = new PrintWriter(file);
//            outputFile.close();
//        }

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

                Customer customer = customerManager.getCustomer(customerId);
                customer.setVehicle(vehicle);

                vehicle.setCustomer(customer);
            }

            vehicles.add(vehicle);
        }
        inputFile.close();
    }

    public void add(Vehicle vehicle) throws IOException {
        for (Vehicle v : vehicles) {
            if (v.getModelYear() == vehicle.getModelYear()
                    && v.getMake().equals(vehicle.getMake())
                    && v.getModelName().equals(vehicle.getModelName())
                    && v.getLicensePlate().equals(vehicle.getLicensePlate())) {
                System.out.println("ERROR: Vehicle already exists in the database!");
                return;
            }
        }

        FileWriter fileWriter = new FileWriter("vehicles.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(vehicle);
        printWriter.close();

        System.out.println("SUCCESS: Vehicle was added to Car Rental database!");
    }

    public void remove(String licensePlate) throws IOException {
        Vehicle vehicle = getVehicle(licensePlate);

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

        System.out.println("SUCCESS: Vehicle with license plate: " + licensePlate + " was removed from the database!");
    }

    public void rent(String licensePlate, int customerId) throws IOException {
        Customer customer = customerManager.getCustomer(customerId);

        if (customer == null) {
            System.out.println("ERROR: Customer does not exist in the database!");
            return;
        }

        if (customer.isRentingVehicle()) {
            System.out.println("ERROR: This customer is already renting a vehicle!");
            return;
        }

        Vehicle vehicle = getVehicle(licensePlate);

        if (vehicle == null) {
            System.out.println("ERROR: Vehicle does not exist in the database!");
            return;
        }

        if (!vehicle.isAvailableForRent()) {
            System.out.println("ERROR: This vehicle is already rented to the customer!");
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

        System.out.println("SUCCESS: Rented. Updated details: " + vehicle);
    }

    public void receive(String licensePlate) throws IOException {
        Vehicle vehicle = getVehicle(licensePlate);

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

    private Vehicle getVehicle(String licensePlate) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                return vehicle;
            }
        }

        return null;
    }

}
