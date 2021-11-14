package edu.miu.cs.cs544.domain;


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
    private long id;


    @Column(name = "code", nullable = false, length = 6)
    private String code;


    @OneToMany
    @JoinTable(name = "Reservation_Ticket")
    private List<Ticket> tickets = new ArrayList<>();
}
