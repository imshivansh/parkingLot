package org.example.ParkingLot.Entities;

import java.util.Map;

public class Floor {
    private int id;
    private String parkingLotId;
    Map<Integer,ParkingSlot>carSlot;
   Map<Integer,ParkingSlot>bikeSlot;
    Map<Integer,ParkingSlot>truckSlot;
    int noOfCarSlots;
    int noOfBikeSlots;
    int noOfTruckSlots;



    public Floor(int id,String parkingLotId, Map<Integer, ParkingSlot> carSlot, Map<Integer, ParkingSlot> bikeSlot, Map<Integer, ParkingSlot> truckSlot) {
        this.id = id;
        this.parkingLotId=parkingLotId;
        this.carSlot = carSlot;
        this.bikeSlot = bikeSlot;
        this.truckSlot = truckSlot;

    }



    public int getNoOfCarSlots() {
        return noOfCarSlots;
    }

    public void setNoOfCarSlots(int noOfCarSlots) {
        this.noOfCarSlots = noOfCarSlots;
    }

    public int getNoOfBikeSlots() {
        return noOfBikeSlots;
    }

    public void setNoOfBikeSlots(int noOfBikeSlots) {
        this.noOfBikeSlots = noOfBikeSlots;
    }

    public int getNoOfTruckSlots() {
        return noOfTruckSlots;
    }

    public void setNoOfTruckSlots(int noOfTruckSlots) {
        this.noOfTruckSlots = noOfTruckSlots;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, ParkingSlot> getCarSlot() {
        return carSlot;
    }


    public Map<Integer, ParkingSlot> getBikeSlot() {
        return bikeSlot;
    }


    public Map<Integer, ParkingSlot> getTruckSlot() {
        return truckSlot;
    }


}
