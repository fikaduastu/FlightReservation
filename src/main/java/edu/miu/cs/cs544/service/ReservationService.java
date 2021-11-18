package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.FlightOffering;
import edu.miu.cs.cs544.domain.Reservation;

import java.util.List;

public interface ReservationService {


    Reservation make(Reservation reservation);

    List<Reservation> getReservationById(Long id);

    List<Reservation> cancelReservation(Long reservationId,Long id);

    Reservation updateReservationStatus(Long reservationId);

    Reservation getReservationByReservationId(Long reservationId);
}
