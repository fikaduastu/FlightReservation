package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.FlightOffering;
import edu.miu.cs.cs544.dto.FlightOfferingDTO;

import java.util.List;

public interface FlightOfferingService {

    List<FlightOffering> findAllFlightOfferings();

    FlightOffering findById(Long flightOfferingId);

    FlightOffering addFlightOffering(FlightOffering flightOffering);

    FlightOffering update(FlightOffering flightOffering);

    void deleteAirport(Long flightOfferingId);
}
