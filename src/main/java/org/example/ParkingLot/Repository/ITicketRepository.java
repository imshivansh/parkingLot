package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Entities.Ticket;

public interface ITicketRepository {
    Ticket saveTicket(String id,Ticket ticket);
    void deleteTicket(String id);
    Ticket getTicketById(String id);

}
