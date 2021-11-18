package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.FlightOffering;
import edu.miu.cs.cs544.domain.Person;
import edu.miu.cs.cs544.domain.Reservation;

import edu.miu.cs.cs544.repository.AccountRepository;
import edu.miu.cs.cs544.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AccountRepository accountRepository;



    @Override
    public Reservation make(Reservation reservation) {

        String code = getReservationCode();
        reservation.setCode(code);
        return reservationRepository.save(reservation);
    }

    static String getReservationCode()
    {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(6);

        for (int i = 0; i < 6; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }



    @Override
    public List<Reservation> getReservationById(Long id) {
        Account account = accountRepository.findById(id).get();
        Person person = account.getPerson();

        List<Reservation> reservations = reservationRepository.findAll();
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation: reservations){
            if (reservation.getPerson().equals(person))
                reservationList.add(reservation);
        }
        return reservationList;


    }

    @Override
    public List<Reservation> cancelReservation(Long reservationId,Long id) {
        reservationRepository.deleteById(reservationId);
        return getReservationById(id);
    }

    @Override
    public Reservation updateReservationStatus(Long reservationId) {
        Reservation reservation = getReservationByReservationId(reservationId);
        reservation.setStatus("CONFIRMED");
        return reservationRepository.save(reservation);

    }

    @Override
    public Reservation getReservationByReservationId(Long reservationId) {
        return reservationRepository.findById(reservationId).get();
    }
}
