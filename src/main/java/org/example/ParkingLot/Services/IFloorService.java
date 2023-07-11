package org.example.ParkingLot.Services;

import org.example.ParkingLot.Entities.Floor;

import java.util.List;

public interface IFloorService {
    List<Floor> createAndSaveFloor(int noOfslots, int noOfFloors,String parkingLotId);
}
