public class ElectricCar extends Car {

    public ElectricCar() {
        super(2019, "Nissan", "Leaf");
    }

    @Override
    public String fuelSource() {
        return "not oil!";
    }
}
