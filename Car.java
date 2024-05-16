import java.util.ArrayList;

public class Car {
    private ArrayList<Passenger> passengers;
    private int maxCapacity;

    // constructor initializing the car with a maximum capacity
    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengers = new ArrayList<>(maxCapacity);
    }

    // accessor method to retrieve the maximum capacity of the car
    public int getCapacity() {
        return this.maxCapacity;
    }

    // method to calculate the number of remaining seats in the car
    public int seatsRemaining() {
        return maxCapacity - passengers.size();
    }

    // method to add a passenger to the car, if there is available space
    public boolean addPassenger(Passenger passenger) {
        if (passengers.contains(passenger)) {
            System.err.println("The passenger is already on board.");
            return false;
        } else {
            if (passengers.size() < maxCapacity) {
                this.passengers.add(passenger);
                System.out.println("The passenger has been added.");
                return true;
            }
            System.err.println("The car doesn't have available seats.");
            return false;
        }
    }

    // method to remove a passenger from the car
    public boolean removePassenger(Passenger passenger) {
        if (passengers.contains(passenger)) {
            this.passengers.remove(passenger);
            System.out.println("Removed passenger.");
            return true;
        } else {
            System.err.println("The passenger is absent in the car.");
            return false;
        }
    }

    // method to print the list of passengers in the car
    public void printManifest() {
        if (passengers.size() == 0) {
            System.out.println("Empty car.");
        } else {
            System.out.println("Passengers in the car:");
            for (Passenger passenger : passengers) {
                System.out.println(passenger.getName());
            }
        }
    }

    // main method to test the Car class
    public static void main(String[] args) {
        Car car = new Car(3); // create a car with a maximum capacity of 3 passengers
        Passenger p1 = new Passenger("nicole");
        Passenger p2 = new Passenger("lana");
        Passenger p3 = new Passenger("vanessa");

        car.addPassenger(p1); // add passengers to the car
        car.addPassenger(p2);
        car.addPassenger(p3);
        car.printManifest(); // print the list of passengers in the car
    }
}
