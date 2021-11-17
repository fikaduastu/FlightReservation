package edu.miu.cs.cs544.service;



import edu.miu.cs.cs544.domain.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> findAllFlights();
    Flight addFlight(Flight flight);
    Flight findById(Long flightId);
    Flight update(Flight flight);
    void cancelFlight(Long flightId);
}
