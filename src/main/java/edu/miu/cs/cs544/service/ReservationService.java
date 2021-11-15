package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.FlightOffering;
import edu.miu.cs.cs544.domain.Reservation;

import java.util.List;

public interface ReservationService {

        public List<Reservation> get(long person_id);

        // this should be eager loading of reservation attributes
        public Reservation details(long reservation_id);

        public Reservation make(List<FlightOffering> flightOfferings);

        public void delete(long reservation_id);
}
