package edu.miu.cs.cs544.service;



import edu.miu.cs.cs544.domain.Airline;
import edu.miu.cs.cs544.domain.Airport;

import java.util.List;

public interface AirportService {

  Airport getAirportById(Long airporId);
 List<Airport> findAll();
 Airport findById(Long id);
 Airport saveAirport(Airport airport);
 Airport updateAirport(Airport airport);
 void deleteById(Long id);
 List<Airport>saveAll(List<Airport> airport);

}
