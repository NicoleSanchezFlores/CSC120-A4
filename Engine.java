public class Engine {

    // attributes to store fuel type, current fuel level, and maximum fuel level
    private FuelType fuelType;
    private Double currentFuelLevel;
    private Double maxFuelLevel; 

    // constructor for our engine class
    // sees the engine with the specific fuel type, current fuel level, and maximum fuel level
    public Engine(FuelType fuelType, Double currentFuelLevel, Double maxFuelLevel) {
        this.fuelType = fuelType;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    // sets the fuel level to the maximum level
    private void refuel() {
        this.currentFuelLevel = this.maxFuelLevel;
    }

    //  the movement of the train by consuming fuel
    // returns true if the engine has enough fuel to go on, false if not
    private boolean go() {
        this.currentFuelLevel -= 3;
        System.out.println(this.currentFuelLevel); // print the current fuel level

        // check if the current fuel level is sufficient to continue
        if (this.currentFuelLevel <= 0) {
            return false; // out of fuel
        } else {
            return true; // still has fuel!!
        }
    }

    // main method to test the engine class
    public static void main(String[] args) {
        // create a new engine object with electric fuel type, initial fuel level of 100.0, and maximum fuel level of 200.0
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 200.0);
        
        // simulate train movement until the engine runs out of fuel
        while (myEngine.go()) {
            System.out.println("choo choo choo chooo chooo!"); // print message indicating movement
        }
        
        System.out.println("No Fuel!"); // print message indicating the train is out of fuel
    }
}
