package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Entities.ParkingLot;
import org.example.ParkingLot.Entities.ParkingSlot;

import java.util.List;

public interface IParkingRepository {
    void addParkingLot(ParkingLot parkingLot);
    public ParkingLot getParkingLotById(String id);
    public List<ParkingLot>getAllParkingLot();


}
