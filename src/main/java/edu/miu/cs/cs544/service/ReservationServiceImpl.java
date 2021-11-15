//package edu.miu.cs.cs544.service;
//
//import edu.miu.cs.cs544.domain.FlightOffering;
//import edu.miu.cs.cs544.domain.Reservation;
//
//import edu.miu.cs.cs544.repository.ReservationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Transactional
//@Service
//public class ReservationServiceImpl implements ReservationService{
//
//    @Autowired
//    private ReservationRepository reservationRepository;
//
//    @Override
//    public List<Reservation> get(long person_id) {
//
//        return reservationRepository.getReservationsByPersonId(person_id);
//    }
//
//    @Override
//    public Reservation details(long reservation_id) {
//        return reservationRepository.getReservationDetails(reservation_id);
//    }
//
//    @Override
//    public Reservation make(List<FlightOffering> flightOfferings) {
//        return null;
//    }
//
//    @Override
//    public void delete(long reservation_id) {
//
//        reservationRepository.deleteById(reservation_id);
//
//    }
//}
