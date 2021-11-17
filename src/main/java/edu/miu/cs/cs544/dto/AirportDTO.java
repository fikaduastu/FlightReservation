package edu.miu.cs.cs544.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AirportDTO {
    private String code;
    private String name;
    private AddressDTO address;
}
