package customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManager {

    private final ArrayList<Customer> customers = new ArrayList<>();

    public void setup() throws IOException {
        File file = new File("customers.txt");
        Scanner inputFile = new Scanner(file);

        customers.clear();

        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            String[] items = str.split(", ");

            int customerId = Integer.parseInt(items[0]);
            String name = items[1];
            String phoneNumber = items[2];

            Customer customer = new Customer(customerId, name, phoneNumber);

            customers.add(customer);
        }

        inputFile.close();
    }

    public void newRecord(Customer customer) throws IOException {
        for (Customer c : customers) {
            if (c.getCustomerId() == customer.getCustomerId()) {
                System.out.println("ERROR: Customer with this ID is already registered in the database!");
                return;
            }
        }

        FileWriter fileWriter = new FileWriter("customers.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(customer);
        printWriter.close();

        System.out.println("SUCCESS: Customer registered to Car Rental database!");
    }

    public void deleteRecord(int customerId) throws IOException {
        File file = new File("vehicles.txt");
        Scanner inputFile = new Scanner(file);

        boolean found = false;

        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            String[] items = str.split(", ");

            if (!items[4].equals("Available")
                    && Integer.parseInt(items[4]) == customerId) {
                found = true;
                break;
            }
        }
        inputFile.close();

        if (found) {
            System.out.println("ERROR: This customer is currently renting a vehicle!");
            System.out.println("ERROR: Make sure to receive the vehicle back first before removing the customer from the database.");
            return;
        }

        file = new File("customers.txt");
        inputFile = new Scanner(file);

        Customer customer = new Customer();

        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            String[] items = str.split(", ");

            int id = Integer.parseInt(items[0]);

            if (id == customerId) {
                found = true;

                String name = items[1];
                String phoneNumber = items[2];

                customer.setCustomerId(id);
                customer.setName(name);
                customer.setPhoneNumber(phoneNumber);
            }
        }

        inputFile.close();

        if (!found) {
            System.out.println("ERROR: Customer does not exist in the database!");
            return;
        }

        inputFile = new Scanner(file);

        ArrayList<String> lines = new ArrayList<>();

        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            String[] items = str.split(", ");

            int id = Integer.parseInt(items[0]);
            String name = items[1];
            String phoneNumber = items[2];

            if (id == customer.getCustomerId()
                    && name.equals(customer.getName())
                    && phoneNumber.equals(customer.getPhoneNumber()))
                continue;

            lines.add(str);
        }

        inputFile.close();
        textFile(lines);

        System.out.println("SUCCESS: Customer was removed from the database!");
    }

    public void viewRecords() {
        if (customers.isEmpty()) {
            System.out.println("ERROR: There are no registered customers in the database!");
            return;
        }

        System.out.println("List of all registered customers:");

        for (int i = 0; i < customers.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + customers.get(i));
        }
    }

    private void textFile(ArrayList<String> lines) throws IOException {
        PrintWriter outputFile = new PrintWriter("customers.txt");

        for (String s : lines) {
            outputFile.println(s);
        }

        outputFile.close();
    }

    public Customer getCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }

        return null;
    }
}
