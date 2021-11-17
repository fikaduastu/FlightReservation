package edu.miu.cs.cs544.repository;


import edu.miu.cs.cs544.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    @Query("select a from Airline a where a.code=:airlineCode")
    Airline findAirlineByCode(String airlineCode);

    @Query("select f.airline from Flight f where f.departureAirport.code=:airportcode")
    List<Airline> findAiportByCode(String airportcode);
}
