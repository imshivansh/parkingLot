package org.example.ParkingLot.Entities;

public class Ticket {
    private final String ticketId;
    private  final String parkingLotId;
    private  final Integer floorNo;
    private  final Integer slotNo;
    private final Vehicle vehicle;
//it comprises ParingLot id num along with flor and slot
    //eg: Park0134_1_4  // it means parked at parking lot no park0134 at first floor and 4th slot


    public Ticket(String ticketId,String parkingLotId,Integer floorNo, Integer slotNo,Vehicle vehicle) {
        this.ticketId = ticketId;
        this.floorNo = floorNo;
        this.slotNo = slotNo;
        this.parkingLotId=parkingLotId;
        this.vehicle=vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public Integer getSlotNo() {
        return slotNo;
    }

    public String getTicketId() {
        return ticketId;
    }
}
