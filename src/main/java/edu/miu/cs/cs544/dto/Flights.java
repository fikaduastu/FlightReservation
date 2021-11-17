package edu.miu.cs.cs544.dto;

import edu.miu.cs.cs544.domain.FlightOffering;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Data
public class Flights {

    //private List<FlightOffering> flightOfferingList;
    private List<Long> flightNumbers;
}
