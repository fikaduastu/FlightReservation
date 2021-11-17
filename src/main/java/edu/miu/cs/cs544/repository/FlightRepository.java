package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
