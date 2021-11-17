package edu.miu.cs.cs544.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Date dateOfBirth;
    private AddressDTO address;
    private AccountDTO account;
    private List<ReservationDTO> reservations = new ArrayList<>();
}
