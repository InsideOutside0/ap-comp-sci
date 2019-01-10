public abstract class Automobile implements Vehicle {

    public Automobile(int year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public String movesAlong() {
        return "vroom";
    }

    public String fuelSource() {
        return "oil oil oil oil oil oil oil";
    }

    public int numberOfWheels() {
        return 4;
    }

    int year;

    String make;

    String model;



}