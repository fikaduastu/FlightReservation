package edu.miu.cs.cs544.dto;


import edu.miu.cs.cs544.domain.Flight;
import edu.miu.cs.cs544.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightOfferingDTO {
    private Date flightDate;
    private Flight flight;
    //private List<Ticket> tickets = new ArrayList<>();
}
