package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.domain.Airport;
import edu.miu.cs.cs544.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/findAll")

    public ResponseEntity<List<Airport>> findAll() {
        List<Airport> airportList = airportService.findAll();
        if (airportList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(airportList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> findById(@PathVariable Long id) {

        Airport airport = airportService.findById(id);
        if (airport == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(airport);
        }
    }

    @DeleteMapping("/deleteAirport/{id}")
    public ResponseEntity<Airport> deleteById(@PathVariable Long id) {
        airportService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping("/{airportId}")
    public ResponseEntity<?> updateAirport(@PathVariable("airportId") Long airportId, @RequestBody Airport airport) {
        if (airportId.equals(airport.getId())) {
            return ResponseEntity.ok(airportService.updateAirport(airport));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/saveAirport")
    public ResponseEntity<Airport> saveAirport(@RequestBody Airport airport){
          airportService.saveAirport(airport);
          return ResponseEntity.ok(airport);
    }

    @PostMapping("/saveAirportAll")
    public ResponseEntity<List<Airport>> saveAll(@RequestBody List<Airport> airportList){
        airportService.saveAll(airportList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
