package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Entities.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository implements  ITicketRepository{
    Map<String,Ticket> ticketMap;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
    }

    @Override
    public Ticket saveTicket(String id, Ticket ticket) {
         ticketMap.putIfAbsent(id,ticket);
         return ticketMap.get(id);
    }

    @Override
    public void  deleteTicket(String id) {

        ticketMap.remove(id);
    }

    @Override
    public Ticket getTicketById(String id) {
        return ticketMap.get(id);
    }
}
