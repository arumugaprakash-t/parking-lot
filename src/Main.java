import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Floor floor = new Floor(1,10);
        Floor floor1 = new Floor(2,5);
        Floor floor2 = new Floor(3,15);
        List<Floor> floorList = Arrays.asList(floor,floor1,floor2);
        ParkingLot parkingLot = new ParkingLot(floorList);

        Vehicle vehicle = new Vehicle(VehicleType.Car,"1234","RED");
        parkingLot.displayFreeSlotByVehicleType(VehicleType.Car);
        parkingLot.parkVehicle(vehicle);
        parkingLot.displayFreeSlotByVehicleType(VehicleType.Car);
    }
}