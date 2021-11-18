package edu.miu.cs.cs544.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;


    @Column(name = "code", nullable = false, length = 6)
    private String code;

    @ManyToOne
    @JoinColumn(name = "person_id",nullable = false)
    @JsonIgnore
    private Person person;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Reservation_Ticket")
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToMany(mappedBy = "reservations",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<FlightOffering> flightOfferings = new ArrayList<>();

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }
}
