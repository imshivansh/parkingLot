package org.example.ParkingLot.Entities;

import java.util.List;

public class ParkingSlot {
    private final int id;
    private Vehicle vehicle;
    private  boolean occupied;
    private Ticket ticket;

    public ParkingSlot(Integer id) {
        this.id=id;
        this.occupied=false;

    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        if(ticket!=null){
            this.occupied = occupied;

        }
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
