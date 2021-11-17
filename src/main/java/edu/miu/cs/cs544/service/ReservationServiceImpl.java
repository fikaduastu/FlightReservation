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
import java.util.Random;
import java.util.stream.Collectors;

@Transactional
@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AccountRepository accountRepository;

//    @Override
//    public List<Reservation> get(Long person_id) {
//
//        return reservationRepository.getReservationsByPersonId(person_id);
//    }

//    @Override
//    public Reservation details(Long reservation_id) {
//        return reservationRepository.getReservationDetails(reservation_id);
//    }

    @Override
    public Reservation make(Reservation reservation) {

        String code = getReservationCode();
        reservation.setCode(code);
       // Reservation reservation1 = reservationRepository.save(reservation);
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
    public void delete(Long reservation_id) {

        reservationRepository.deleteById(reservation_id);

    }

    @Override
    public List<Reservation> getReservationById(Long id) {
        List<Account> accounts = accountRepository.findAll();
        Account acc = new Account();
        for (Account account: accounts){
            if (account.getId() == id)
                acc = account;
        }

        Person person = acc.getPerson();

        List<Reservation> reservations = reservationRepository.findAll();
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation: reservations){
            if (reservation.getPerson().equals(person))
                reservationList.add(reservation);
        }
        return reservationList;
       /* List<Reservation> newReserve =  reservationRepository.findAll();
        List<Reservation> copyReservation = new ArrayList<>();

        for(Reservation reservation : newReserve){
            if(reservation.getPerson().equals(accountRepository.findById(id))){
                copyReservation.add(reservation);
            }
        }
        return copyReservation;*/
        // return reservationRepository.findAll().stream().filter(a-> a.getPerson().getId()== id).collect(Collectors.toList());

    }
}
