package edu.miu.cs.cs544.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightDTO {

    private String number;
    private Integer capacity;
    private Date departureTime;
    private Date arrivalTime;
    private AirportDTO departureAirport;
    private AirportDTO arrivalAirport;
    private AirlineDTO airline;
}
