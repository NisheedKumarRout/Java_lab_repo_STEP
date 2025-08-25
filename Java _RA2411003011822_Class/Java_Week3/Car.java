// Real-world analogy: A Car blueprint (class) and actual cars (objects)
public class Car {
    // Instance variables (attributes of each car)
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    // Constructor: initializes all attributes when creating a Car object
    Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false; // by default, car is not running
    }

    // Method to start the engine
    void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }

    // Method to stop the engine
    void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    }

    // Method to display all car information
    void displayInfo() {
        System.out.println("Car Info:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Is Running: " + isRunning);
        System.out.println();
    }

    // Method to calculate the car's age
    int getAge(int currentYear) {
        return currentYear - year;
    }

    // Main method - program starts here
    public static void main(String[] args) {
        // Creating 3 different Car objects (like real cars)
        Car car1 = new Car("Toyota", "Corolla", 2015, "Red");
        Car car2 = new Car("Honda", "Civic", 2018, "Blue");
        Car car3 = new Car("Tesla", "Model 3", 2022, "White");

        // Demonstrating calling methods
        car1.displayInfo();
        car1.startEngine();
        car1.displayInfo();
        System.out.println("Car Age: " + car1.getAge(2025) + " years\n");

        car2.displayInfo();
        car2.startEngine();
        car2.stopEngine();
        System.out.println("Car Age: " + car2.getAge(2025) + " years\n");

        car3.displayInfo();
        car3.startEngine();
        System.out.println("Car Age: " + car3.getAge(2025) + " years\n");

        /*
         Real-world analogy explanation:
         - The 'Car' class is like a blueprint for building cars.
         - Each Car object (car1, car2, car3) is an actual car with its own details.
         - Even though they share the same blueprint, each car has its own state
           (different brand, model, year, color, and isRunning value).
         - Just like in the real world, one car can be running while another is stopped.
        */
    }
}
