package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.FlightOffering;
import edu.miu.cs.cs544.domain.Reservation;

import java.util.List;

public interface ReservationService {

//        public List<Reservation> get(Long person_id);
//
//        // this should be eager loading of reservation attributes
//        public Reservation details(Long reservation_id);

        public Reservation make(Reservation reservation);

        public void delete(Long reservation_id);

    List<Reservation> getReservationById(Long id);
}
