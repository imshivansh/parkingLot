package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Entities.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingRepository implements IParkingRepository{
    Map<String, ParkingLot> parkingLotMap;

    public ParkingRepository() {
        this.parkingLotMap = new HashMap<>();
    }

    @Override
    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLotMap.put(parkingLot.getId(),parkingLot);


    }
    @Override
    public ParkingLot getParkingLotById(String id){
        return parkingLotMap.get(id);
    }

    @Override
    public List<ParkingLot> getAllParkingLot() {

        return new ArrayList<>(parkingLotMap.values());
    }
}
