package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.dto.Flights;
import edu.miu.cs.cs544.service.AccountServiceImpl;
import edu.miu.cs.cs544.service.FlightOfferingService;
import edu.miu.cs.cs544.service.ReservationService;
import edu.miu.cs.cs544.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private FlightOfferingService flightOfferingService;



    @GetMapping("/test")
    public String test(){
        return "Get request test!";
    }

    @PostMapping("/testpost")
    public ResponseEntity<Account> testPost(@RequestBody Account request){
        Account entity = new Account();
        entity.setUsername(request.getUsername());
        entity.setPassword(request.getPassword());
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/registration")
    public ResponseEntity<Account> register(@RequestBody Account request) {
        Account response = accountService.register(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable Long id){
        Account response = accountService.getAccount(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/getReservation")
    public ResponseEntity<List<Reservation>> getReservation(@PathVariable Long id){

        List<Reservation> reservations = reservationService.getReservationById(id);
        return ResponseEntity.ok(reservations);

    }

    @PostMapping("/{id}/makeReservation")
    public ResponseEntity<Reservation> makeReservation(@RequestBody Flights flights,@PathVariable Long id){

        Account response = accountService.getAccount(id);
        Person personEntity = response.getPerson();

        List<FlightOffering> flightOfferingList = new ArrayList<>();

        for (Long flightNumber:flights.getFlightNumbers()){
            flightOfferingList.add(flightOfferingService.findById(flightNumber));
        }


            List<Ticket> ticketList = new ArrayList<>();
            for (FlightOffering flightOffering:flightOfferingList){
                ticketList.add(ticketService.addTicket());
            }

            for (Ticket ticket: ticketList){
                System.out.println(ticket);
            }

            Reservation reservation = new Reservation();

            reservation.setPerson(personEntity);
            reservation.setTickets(ticketList);
            Reservation reservationEntity = reservationService.make(reservation);

            return ResponseEntity.ok(reservationEntity);

    }


    @GetMapping("/findAll")
    public ResponseEntity<List<Account>> getAll(){
        return ResponseEntity.ok(accountService.getAllAccount());
    }

    @GetMapping("/{id}/cancelReservation/{reservationId}")
    public ResponseEntity<List<Reservation>> cancelReservation(@PathVariable Long id,@PathVariable Long reservationId ){

        List<Reservation> reservations = reservationService.cancelReservation(reservationId,id);
        return ResponseEntity.ok(reservations);
    }

    @PutMapping("/{id}/updateReservationStatus/{reservationId}")
    public ResponseEntity<Reservation> updateReservationStatus(@PathVariable Long id,@PathVariable Long reservationId ){

        Reservation reservations = reservationService.updateReservationStatus(reservationId);
        return ResponseEntity.ok(reservations);
    }

}
