package edu.miu.cs.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Flight")
public class Flight {

    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "departureTime")
    @Temporal(TemporalType.TIME)
    private Date departureTime;

    @Column(name = "arrivalTime")
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;

    @OneToOne
    @JoinColumn(name = "departureAirport_id")
    private Airport departureAirport;

    @OneToOne
    @JoinColumn(name = "arrivalAirport_id")
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
}
