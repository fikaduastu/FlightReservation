package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.FlightOffering;
import edu.miu.cs.cs544.domain.Ticket;

import java.util.List;

public interface TicketService {
    Ticket findTicketByNumber(String ticketNo);
    Ticket addTicket();
    List<Ticket> getTickets(long id);
    List<Ticket> findAll();
}
