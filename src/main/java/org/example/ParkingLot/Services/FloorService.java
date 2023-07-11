package org.example.ParkingLot.Services;

import org.example.ParkingLot.Constants;
import org.example.ParkingLot.Entities.Floor;
import org.example.ParkingLot.Entities.ParkingSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FloorService implements IFloorService{
    @Override
    public List<Floor> createAndSaveFloor(int noOfslots, int noOfFloors, String parkingLotId) {
        List<Floor>floorList = new ArrayList<>();
        int i = Constants.ONE;
        while(i<=noOfFloors){
            Map<Integer, ParkingSlot> carSlot=new HashMap<>();
            Map<Integer,ParkingSlot>bikeSlot= new HashMap<>();
            Map<Integer,ParkingSlot>truckSlot = new HashMap<>();
            updateSlots(truckSlot,bikeSlot,carSlot,noOfslots);
            Floor floor = new Floor(i,parkingLotId,carSlot,bikeSlot,truckSlot);
            floor.setNoOfCarSlots(carSlot.size());
            floor.setNoOfBikeSlots(bikeSlot.size());
            floor.setNoOfTruckSlots(truckSlot.size());
            floorList.add(floor);
            i++;

        }
        return floorList;

    }

    private void updateSlots(Map<Integer, ParkingSlot> truckSlot, Map<Integer, ParkingSlot> bikeSlot, Map<Integer, ParkingSlot> carSlot, int noOfSlots) {
      //use case
        /*
        for the given number of slots as per requirement , we will assign one spot at first to the truck if available,at max 2 slots to bike if available
        and rest to the cars depending upon availability

         */
         int count=0;
// updating truckslot
        if(noOfSlots>=1){
            count++;
            truckSlot.put(count,new ParkingSlot(count));
        }else{
            truckSlot.put(Constants.ZERO,new ParkingSlot(Constants.ZERO));
        }
        // updating bikeslot

        if(noOfSlots-count>=Constants.ONE){
            int diff = (noOfSlots-count==Constants.ONE)?Constants.ONE:Constants.TWO;
            while(diff>=Constants.ONE){
                count++;
                bikeSlot.put(count,new ParkingSlot(count));
                diff--;
            }
        }else{
            bikeSlot.put(Constants.ZERO,new ParkingSlot(Constants.ZERO));
        }

        //updating carslot

        if(noOfSlots-count>=1){
            int diff=noOfSlots-count;
            while (diff>= Constants.ONE){
                count++;
                carSlot.put(count,new ParkingSlot(count));
                diff--;
            }
        }else{
            carSlot.put(Constants.ZERO,new ParkingSlot(Constants.ZERO));
        }
    }
}
