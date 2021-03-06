package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.FlightOffering;
import edu.miu.cs.cs544.domain.Reservation;
import edu.miu.cs.cs544.domain.Ticket;
import edu.miu.cs.cs544.repository.ReservationRepository;
import edu.miu.cs.cs544.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketRepository repository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Ticket findTicketByNumber(String ticketNo) {
        return repository.findTicketByNumber(ticketNo);
    }

    @Override
    public Ticket addTicket() {
//        Random rnd = new Random();
//        Long number = rnd.nextLong(999999999);
//        Long number1 = rnd.nextLong(9999999);
//        String ticketNumber = String.format("%010L", number);
//        String ticketCode = String.format("%06L", number1);
//        Ticket ticket = new Ticket();
//        ticket.setFlightOffering(flightOffering);
//        ticket.setTicketCode(ticketCode);
//        ticket.setNumber(ticketNumber);

        String ticketNumber = getTicketNumber();
        Ticket ticket = new Ticket();
        //ticket.setFlightOffering(flightOffering);

        ticket.setNumber(ticketNumber);
        return repository.save(ticket);
    }

    @Override
    public List<Ticket> getTickets(long id) {
        List<Reservation> reservationList = reservationRepository.findAll();
        List<Ticket> ticketList = new ArrayList<>();
        for (Reservation reservation:reservationList){
            if (reservation.getId() == id){
                ticketList = reservation.getTickets();
            }
        }
        return ticketList;
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    static String getTicketNumber()
    {

        // chose a Character random from this String
        String AlphaNumericString =
                "0123456789"
                ;

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(20);

        for (int i = 0; i < 20; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


}
