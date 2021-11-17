package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Flight;
import edu.miu.cs.cs544.domain.FlightOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface FlightOfferingRepository extends JpaRepository<FlightOffering, Long> {
    @Query("from Flight d where d.number=:flightNo")
    Flight findFlightByNumber(String flightNo);
}
