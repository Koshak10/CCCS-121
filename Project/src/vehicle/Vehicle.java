package vehicle;

import customer.Customer;

public class Vehicle {

    private final int modelYear;
    private final String make;
    private final String modelName;
    private final String licensePlate;
    private Customer customer;

    public Vehicle(int modelYear, String make, String modelName, String licensePlate) {
        this.modelYear = modelYear;
        this.make = make;
        this.modelName = modelName;
        this.licensePlate = licensePlate;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getMake() {
        return make;
    }

    public String getModelName() {
        return modelName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isAvailableForRent() {
        return customer == null;
    }

    public String toString() {
        return modelYear + ", "
                + make + ", " + modelName + ", "
                + licensePlate + ", " + (customer == null ? "Available" : customer.getCustomerId());
    }

}
