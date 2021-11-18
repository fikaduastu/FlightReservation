package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Flight;
import edu.miu.cs.cs544.domain.FlightOffering;
import edu.miu.cs.cs544.domain.Ticket;
import edu.miu.cs.cs544.dto.FlightOfferingDTO;
import edu.miu.cs.cs544.dto.TicketDTO;
import edu.miu.cs.cs544.repository.FlightOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightOfferingServiceImpl implements FlightOfferingService {

    @Autowired
    FlightOfferingRepository repository;

    @Autowired
    TicketService ticketService;

    @Override
    public List<FlightOffering> findAllFlightOfferings() {
        return repository.findAll();
    }

    @Override
    public FlightOffering findById(Long flightOfferingId) {

        return repository.getById(flightOfferingId);
    }

    @Override
    public FlightOffering addFlightOffering(FlightOffering offeringdto) {
//        FlightOffering entity = new FlightOffering();
//        if (offeringdto != null) {
//            Flight flight = repository.findFlightByNumber(offeringdto.getFlight().getNumber());
//            if (flight != null) {
//                entity.setFlight(flight);
//                entity.setFlightDate(offeringdto.getFlightDate());
//                List<Ticket> tickets = offeringdto.getTickets();
//                for (Ticket ticket : tickets) {
//                    Ticket ticket1 = ticketService.findTicketByNumber(ticket.getNumber());
//                    entity.getTickets().add(ticket1);
//                }
//                return repository.save(entity);
//            }
//            return null;
//        }
//        return null;

        return repository.save(offeringdto);
    }

    @Override
    public FlightOffering update(FlightOffering flightOffering) {

        FlightOffering entity = new FlightOffering();
        entity.setId(flightOffering.getId());

        return null;
    }

    @Override
    public void deleteAirport(Long flightOfferingId) {

    }
}
