package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Airline;
import edu.miu.cs.cs544.domain.Airport;
import edu.miu.cs.cs544.domain.Flight;
import edu.miu.cs.cs544.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository repository;

    @Autowired
    AirlineService airlineService;

    @Autowired
    AirportService airportService;

    @Override
    public List<Flight> findAllFlights() {
        return repository.findAll();
    }

    @Override
    public Flight addFlight(Flight flight){
        Flight entity = new Flight();
        if(flight!=null) {
            Airline airline = airlineService.findAirlineByCode(flight.getAirline().getCode());
            Airport departureAirport = airportService.getAirportById(flight.getDepartureAirport().getId());
            Airport arrivalAirport = airportService.getAirportById(flight.getArrivalAirport().getId());

            if(airline!=null && departureAirport!=null && arrivalAirport!=null){
                entity.setNumber(flight.getNumber());
                entity.setCapacity(flight.getCapacity());
                entity.setDepartureTime(flight.getDepartureTime());
                entity.setArrivalTime(flight.getArrivalTime());
                entity.setDepartureAirport(departureAirport);
                entity.setArrivalAirport(arrivalAirport);
                entity.setAirline(airline);
                return repository.save(entity);

            }
        }
        return null;
    }

    @Override
    public Flight findById(Long flightId) {
        return repository.findById(flightId).get();
    }

    @Override
    public Flight update(Flight flight) {
        Flight entity = findById(flight.getId());
        entity.setNumber(flight.getNumber());
        entity.setCapacity(flight.getCapacity());
        entity.setDepartureTime(flight.getDepartureTime());
        entity.setArrivalTime(flight.getArrivalTime());
        entity.setDepartureAirport(flight.getDepartureAirport());
        entity.setArrivalAirport(flight.getArrivalAirport());
        entity.setAirline(flight.getAirline());
        return repository.save(entity);
    }

    @Override
    public void cancelFlight(Long flightId) {
        repository.deleteById(flightId);
    }
}
