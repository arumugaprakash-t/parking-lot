public class ParkingSpot {
    private Integer no;
    private Vehicle vehicle;
    private boolean isAvailable;

    public ParkingSpot(int no){
        this.no = no;
        this.isAvailable = true;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Integer getNo() {
        return no;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
