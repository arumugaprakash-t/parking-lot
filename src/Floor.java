import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Floor {
    private int floorNo;
    private int noOfSlots;
    List<ParkingSpot> parkingSpotList;
    Map<VehicleType,Integer> availableParkingSpotsByVehicleType;

    public Floor(int floorNo,int noOfSlots){
        this.floorNo = floorNo;
        this.noOfSlots = noOfSlots;
        parkingSpotList = new ArrayList<>();
        availableParkingSpotsByVehicleType = new HashMap<>();

        for(int i=0;i<noOfSlots;i++){
            parkingSpotList.add(new ParkingSpot(i));
        }


        availableParkingSpotsByVehicleType.put(VehicleType.Truck,1);
        availableParkingSpotsByVehicleType.put(VehicleType.Bike,2);
        availableParkingSpotsByVehicleType.put(VehicleType.Car,noOfSlots-3);
    }

    public int getFloorNo() {
        return floorNo;
    }

    public int getNoOfSlots() {
        return noOfSlots;
    }

    public boolean park(Vehicle v){
        switch (v.getVehicleType()){
            case Car:
                for(int i=3;i<noOfSlots;i++){
                    ParkingSpot spot = parkingSpotList.get(i);
                    if(spot.isAvailable()){
                        System.out.println("Spot available");
                        spot.setAvailable(false);
                        spot.setVehicle(v);
                        updateDisplayCount(v,spot.isAvailable());
                        return true;
                    }else{
                        System.out.println("Spot not available");
                        return false;
                    }
                }
                break;
            case Truck:
                ParkingSpot truckSpot = parkingSpotList.get(0);
                if(truckSpot.isAvailable()){
                    System.out.println("Spot available");
                    truckSpot.setAvailable(false);
                    truckSpot.setVehicle(v);
                    updateDisplayCount(v,truckSpot.isAvailable());
                }else{
                    System.out.println("Spot not available");
                }
                break;
            case Bike:
                for(int i=1;i<=2;i++){
                    ParkingSpot spot = parkingSpotList.get(i);
                    if(spot.isAvailable()){
                        System.out.println("Spot available");
                        spot.setAvailable(false);
                        spot.setVehicle(v);
                        updateDisplayCount(v,spot.isAvailable());
                    }else{
                        System.out.println("Spot not available");
                    }
                }
                break;

        }
        return false;
    }

    public boolean unpark(Vehicle v){
        for(ParkingSpot spot : parkingSpotList){
            Vehicle spotVehicle = spot.getVehicle();
            if(!spot.isAvailable() && spotVehicle.getVehicleType()==v.getVehicleType() && spotVehicle.getColor()==v.getColor() && spotVehicle.getRegistrationNum()==v.getRegistrationNum()){
                spot.setVehicle(null);
                spot.setAvailable(true);
                updateDisplayCount(v,spot.isAvailable());
                System.out.println("Unparked Successfull");
                return true;
            }else{
                System.out.println("Not found");
            }
        }
        return false;
    }

    public void displayAllFreeSlot(){
        for(VehicleType key:availableParkingSpotsByVehicleType.keySet()){
            System.out.printf("     Free Slots Available for %s is %d :\n",key.toString(),availableParkingSpotsByVehicleType.get(key));
        }
    }

    public void displayFreeSlotsByVehicleType(VehicleType vehicleType){
        System.out.printf("         Free Slots available for %s is %d :\n",vehicleType.toString(),availableParkingSpotsByVehicleType.get(vehicleType));
    }

    public void updateDisplayCount(Vehicle v,boolean parkingStatus){
        int value = parkingStatus?1:-1;
        availableParkingSpotsByVehicleType.put(v.getVehicleType(),availableParkingSpotsByVehicleType.get(v.getVehicleType())+value);
    }




}
