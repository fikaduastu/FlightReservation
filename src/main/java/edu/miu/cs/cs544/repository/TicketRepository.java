package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("select t from Ticket t where t.number=:ticketNo")
    Ticket findTicketByNumber(String ticketNo);
}
