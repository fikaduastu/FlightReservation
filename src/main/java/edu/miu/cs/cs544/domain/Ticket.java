package edu.miu.cs.cs544.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "Ticket")
@Setter
@Getter
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;


    @ManyToOne
    @JoinColumn(name = "FlightOffering_id")
    private FlightOffering flightOffering;

    @Column(name = "number", length = 20, nullable = false)
    private long number;

    @Column(name = "Code",length = 6, nullable = false)
    private String ticketCode;


}