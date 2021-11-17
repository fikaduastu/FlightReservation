package edu.miu.cs.cs544.service;


import edu.miu.cs.cs544.domain.Airline;
import edu.miu.cs.cs544.domain.Flight;
import edu.miu.cs.cs544.repository.AirlineRepository;
import edu.miu.cs.cs544.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private AirlineRepository repository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Airline> getAllAilrines() {
        return repository.findAll();
    }

//    @Override
//    public Airline addAirline(Airline airline) {
//        //List<Flight> flights = airline.getFlights();
//        List<Flight> entityFlight = new ArrayList<>();
//        for(Flight flight : flights){
//            entityFlight.add(flightRepository.save(flight));
//        }
//       Airline airline1 = repository.save(airline);
//        airline1.setFlights(entityFlight);
//        repository.flush();
//        return airline1;
//    }
    @Override
    public Airline addAirline(Airline airline) {
//        //List<Flight> flights = airline.getFlights();
//        List<Flight> entityFlight = new ArrayList<>();
//        for(Flight flight : flights){
//            entityFlight.add(flightRepository.save(flight));
//        }
//        Airline airline1 = repository.save(airline);
//        airline1.setFlights(entityFlight);
//        repository.flush();
//        return airline1;
        return repository.save(airline);
    }
    @Override
    public Airline findById(Long airlineId) {
        return repository.findById(airlineId).get();
    }



    @Override
    public List<Airline> findAiportByCode(String airportcode) {
        return null;
    }

    @Override
    public Airline update(Airline airline) {
        Airline entity = new Airline();
        entity.setName(airline.getName());
        entity.setHistory(airline.getHistory());
        //entity.setFlights(airline.getFlights());
        return repository.save(entity);
    }

    @Override
    public void deleteAirline(Long airlineId) {
        repository.deleteById(airlineId);
    }

    @Override
    public Airline findAirlineByCode(String airlineCode){
        return repository.findAirlineByCode(airlineCode);
    }
}
