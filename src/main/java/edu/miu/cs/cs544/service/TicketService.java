package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.FlightOffering;
import edu.miu.cs.cs544.domain.Ticket;

public interface TicketService {
    Ticket findTicketByNumber(String ticketNo);
    Ticket addTicket(FlightOffering flightOffering);
}
