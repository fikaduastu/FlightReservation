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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    @JsonIgnore
    private Person person;

    @OneToMany(mappedBy = "reservation")
    private List<Ticket> tickets = new ArrayList<>();
}
