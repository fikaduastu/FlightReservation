package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.FlightOffering;
import edu.miu.cs.cs544.dto.FlightOfferingDTO;
import edu.miu.cs.cs544.service.FlightOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flightOffering")
public class FlightOfferingController {

    @Autowired
    private FlightOfferingService flightOfferingService;

    @PostMapping("/add")
    public ResponseEntity<FlightOffering> add(@RequestBody FlightOfferingDTO flightOffering){

        return ResponseEntity.ok(flightOfferingService.addFlightOffering(flightOffering));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<FlightOffering>> findAll(){
        return ResponseEntity.ok(flightOfferingService.findAllFlightOfferings());
    }



}
