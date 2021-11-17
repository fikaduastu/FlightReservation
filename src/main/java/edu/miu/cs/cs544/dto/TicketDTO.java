package edu.miu.cs.cs544.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDTO {
    private FlightOfferingDTO flightOffering;
    private String number;
    private String ticketCode;
    private Date flightDate;
}