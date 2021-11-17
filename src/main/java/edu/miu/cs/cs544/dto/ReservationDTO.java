package edu.miu.cs.cs544.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTO {
    private String code;
    private List<TicketDTO> tickets = new ArrayList<>();
}
