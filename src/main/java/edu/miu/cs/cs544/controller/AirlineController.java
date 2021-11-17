package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.domain.Airline;
import edu.miu.cs.cs544.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @GetMapping
    public List<Airline> getAllAirlines(){
        return airlineService.getAllAilrines();
    }

    @PostMapping("/add")
    public ResponseEntity<Airline> addAirline(@RequestBody Airline airline){
        return ResponseEntity.ok(airlineService.addAirline(airline));
    }

    @GetMapping("/{airlineId}")
    public ResponseEntity<Airline> getAirline(@PathVariable("airlineId") Long airlineId){
        return ResponseEntity.ok(airlineService.findById(airlineId));

    }

    @PutMapping("/{airlineId}")
    public ResponseEntity<?> update(@PathVariable("airlineId") Long airlineId, @RequestBody Airline airline) {
        if (airlineId.equals(airline.getId())) {
            return ResponseEntity.ok(airlineService.update(airline));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/{id}")
    public void deleteAirline(@PathVariable Long id){
        airlineService.deleteAirline(id);
    }


}
