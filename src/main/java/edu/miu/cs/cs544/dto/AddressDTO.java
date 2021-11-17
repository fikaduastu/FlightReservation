package edu.miu.cs.cs544.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String zipcode;
}
