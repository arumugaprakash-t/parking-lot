public class Vehicle {
    private VehicleType vehicleType;
    private String registrationNum;
    private String color;

    public Vehicle(VehicleType vehicleType,String registrationNum,String color){
        this.vehicleType = vehicleType;
        this.registrationNum = registrationNum;
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public String getRegistrationNum() {
        return this.registrationNum;
    }
}
