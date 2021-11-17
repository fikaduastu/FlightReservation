package edu.miu.cs.cs544.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "FlightOffering")
@ToString
public class FlightOffering {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column(name = "flightDate")
    @Temporal(TemporalType.DATE)
    private Date flightDate;


    @OneToMany
    @JoinTable(name = "FlightOffering_Table")
    private List<Ticket> tickets = new ArrayList<>();


//    public void addTicket(Ticket ticket){
//        this.tickets.add(ticket);
//        ticket.setFlightOffering(this);
//    }
//
//    public void removeTicket(Ticket ticket){
//        tickets.remove(ticket);
//        ticket.setFlightOffering(null);
//    }

}
