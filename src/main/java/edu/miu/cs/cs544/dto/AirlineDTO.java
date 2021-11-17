package edu.miu.cs.cs544.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AirlineDTO {
    private String code;
    private String name;
    private String history;
}
