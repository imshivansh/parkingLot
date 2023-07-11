package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Entities.ParkingSlot;

public interface IFloorRepository {
    void saveFloor(int floorNo,ParkingSlot parkingSlot);
}
