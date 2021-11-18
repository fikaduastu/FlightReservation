package edu.miu.cs.cs544.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "Ticket")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Ticket {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;


//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "FlightOffering_id")
//    private FlightOffering flightOffering;

    @Column(name = "number", length = 20, nullable = true)
    private String number;

//    @Column(name = "Code",length = 6, nullable = true)
//    private String ticketCode;

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "reservation_id")
//    private Reservation reservation;


}