package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Entities.ParkingSlot;

import java.util.HashMap;
import java.util.Map;

public class FloorRepository implements IFloorRepository{
    Map<Integer, ParkingSlot>floorMap;

    public FloorRepository() {
        this.floorMap = new HashMap<>();
    }

    @Override
    public void saveFloor(int floorNo,ParkingSlot parkingSlot) {
        floorMap.put(floorNo,parkingSlot);

    }
}
