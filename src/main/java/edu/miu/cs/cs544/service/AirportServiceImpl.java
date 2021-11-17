package edu.miu.cs.cs544.service;


import edu.miu.cs.cs544.domain.Airline;
import edu.miu.cs.cs544.domain.Airport;
import edu.miu.cs.cs544.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository repository;


    @Override
    public List<Airport> findAll() {
        return repository.findAll();
    }

    @Override
    public Airport findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Airport saveAirport(Airport airport) {

        return repository.save(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        Airport entity = findById(airport.getId());
        entity.setCode(airport.getCode());
        entity.setName(airport.getName());
        entity.setAddress(airport.getAddress());
        return repository.save(entity);
        }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Airport> saveAll(List<Airport> airportList) {
        return repository.saveAll(airportList);
    }

    @Override
    public Airport getAirportById(Long airporId) {

        return repository.findById(airporId).get();
    }



}
