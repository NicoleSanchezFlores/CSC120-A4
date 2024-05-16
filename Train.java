import java.util.ArrayList;

public class Train {

    // the engine of the train
    public Engine myEngine;

    // the list of cars attached to the train
    public ArrayList<Car> cars;

    // the total number of cars in the train
    public int nCars;

    // constructor for Train class, initializes the engine and sets up the train with initial car information
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        // initialize the train's engine
        this.myEngine = new Engine(fuelType, fuelCapacity, fuelCapacity);
        // initialize the list of cars with a specified initial capacity
        this.cars = new ArrayList<Car>(nCars);
        // set the total number of cars in the train
        this.nCars = nCars;
    }

    // method to get the train's engine
    public Engine getEngine(){
        return this.myEngine;
    }

    // method to get a specific car by index
    public Car getCar(int i){
        return this.cars.get(i);
    }

    // method to calculate and return the maximum passenger capacity of all cars in the train
    public int getMaxCapacity(){
        int max = 0;

        // iterate through each car in the train
        for (Car car: this.cars){
            // accumulate the capacity of each car
            max += car.getCapacity(); 
        }
        return max;
    }

    // method to calculate and return the total number of available seats across all cars in the train
    public int seatsRemaining(){
        int seatsRemaining = 0;

        // iterate through each car in the train
        for (Car car: this.cars){
            // accumulate the number of available seats in each car
            seatsRemaining += car.seatsRemaining(); 
        }
        return seatsRemaining;
    }

    // method to print the passenger manifest for each car in the train
    public void printManifest(){
        // iterate through each car in the train
        for (Car c:this.cars){
            // print the passenger manifest for the current car
            c.printManifest();
        }
    }

    // main method to create a train, add cars and passengers, and print the passenger manifest
    public static void main(String[] args) {
        // create a new train with electric engine, fuel capacity of 100.0, 20 cars, and a passenger capacity of 30
        Train mytrain = new Train(FuelType.ELECTRIC, 100.0, 20, 30);
        // create three cars
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);
        // add the cars to the train
        mytrain.cars.add(car1);
        mytrain.cars.add(car2);
        mytrain.cars.add(car3);
        // create passengers
        Passenger p = new Passenger("nicole");
        Passenger p1 = new Passenger("lana");
        Passenger p2 = new Passenger("vanessa");
        // add passengers to respective cars
        car1.addPassenger(p);
        car2.addPassenger(p1);
        car3.addPassenger(p2);
        // print the passenger manifest for the train
        mytrain.printManifest();
    }
}
