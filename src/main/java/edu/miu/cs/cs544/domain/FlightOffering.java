package edu.miu.cs.cs544.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "FlightOffering")
public class FlightOffering {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "flightOffering")
    private List<Ticket> tickets = new ArrayList<>();



}
