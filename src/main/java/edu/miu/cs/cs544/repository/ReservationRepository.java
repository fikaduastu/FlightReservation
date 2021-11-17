package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

//    @Query("SELECT Reservation AS R FROM Person P WHERE P.id=:person_id")
//    public List<Reservation> getReservationsByPersonId(Long person_id);
//
//
//    @Query("FROM Reservation R WHERE R.id=:reservation_id")
//    public Reservation getReservationDetails(Long reservation_id);
}
