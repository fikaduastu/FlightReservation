package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Flight;
import edu.miu.cs.cs544.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// View list of airports
// View list of airlines flying out of an airport (search by airport three letter code)
// View list of flights between a departure and destination for a date
// View list of own reservations
// View details of a reservation (flights, departure times, etc.)
// Make a reservation (note: payload will be a list of flights)
// Cancel a reservation
// Confirm and purchase a reservation. This will result in multiple tickets (one for each
// flight in the reservation)
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping
    public List<Flight> findAll() {
        return flightService.findAllFlights();
    }

    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@RequestBody  Flight flight){

            return ResponseEntity.ok(flightService.addFlight(flight));

    }
    @GetMapping("/{countryId}")
    public Flight findById(@PathVariable("countryId") Long countryId) {
        return flightService.findById(countryId);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<?> update(@PathVariable("flightId") Long flightId, @RequestBody Flight flight) {
        if (flightId.equals(flight.getId())) {
            return ResponseEntity.ok(flightService.update(flight));

        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long flightId){
        flightService.cancelFlight(flightId);
    }


}
