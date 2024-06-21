import java.util.List;

public class ParkingLot {
    List<Floor> floors;

    public ParkingLot(List<Floor> floors){

        this.floors = floors;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void parkVehicle(Vehicle v){
        for(Floor f:floors){
            if(f.park(v)){
                System.out.println("Parked");
                return;
            }
        }
        System.out.println("Not able to find parking spot");
    }

    public void unparkVehicle(Vehicle v){
        for(Floor f: floors){
            if(f.unpark(v)){
                System.out.println("Unparked vehicle successfully");
                return;
            }
        }
        System.out.println("Not able to find the vehicle in parking spot");
    }

    public void displayAllFreeSlotsOnFloors(){
        for(Floor f:floors){
            System.out.printf("Available slots on floor %d: \n",f.getFloorNo());
            f.displayAllFreeSlot();
        }
    }

    public void displayFreeSlotByVehicleType(VehicleType vehicleType){

        for(Floor f: floors){
            System.out.printf("Available spots for %s: on Floor no %d\n",vehicleType.toString(),f.getFloorNo());
            f.displayFreeSlotsByVehicleType(vehicleType);
        }
    }
}
