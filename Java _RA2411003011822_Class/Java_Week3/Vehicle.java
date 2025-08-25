public class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    public void startVehicle() {
        System.out.println(make + " " + model + " started.");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled. Current fuel: " + fuelLevel);
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle Info: " + year + " " + make + " " + model + ", Fuel: " + fuelLevel);
    }

    // Main method is inside Vehicle now
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2020, 50);
        Truck truck = new Truck("Ford", "F-150", 2018, 80);
        Motorcycle bike = new Motorcycle("Yamaha", "R15", 2022, 20);

        car.startVehicle();
        truck.refuel(20);
        bike.displayVehicleInfo();

        car.openTrunk();
        truck.loadCargo();
        bike.popWheelie();

        Vehicle[] vehicles = {car, truck, bike};
        System.out.println("\nPolymorphic Behavior:");
        for (Vehicle v : vehicles) {
            v.startVehicle();
            v.displayVehicleInfo();
        }
    }
}

// Subclasses
class Car extends Vehicle {
    public Car(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
    public void openTrunk() {
        System.out.println(make + " " + model + " trunk opened.");
    }
}

class Truck extends Vehicle {
    public Truck(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
    public void loadCargo() {
        System.out.println(make + " " + model + " cargo loaded.");
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
    public void popWheelie() {
        System.out.println(make + " " + model + " is popping a wheelie!");
    }
}
