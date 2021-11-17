package edu.miu.cs.cs544.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name ="Person")
@ToString
public class Person {

    @Id
    @Column(name="id")
    @GeneratedValue
    private Long id;

    @Column(name = "firstName", length = 100)
    private String firstName;

    @Column(name = "lastName", length =100)
    private String lastName;

    @Column(name = "emailAddress", length = 100)
    private String emailAddress;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name ="account_id")
    private Account account;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
//
//    public void addReservation(Reservation reservation){
//        reservations.add(reservation);
//        //sreturn reservations;
//    }
//
//    public void setReservations1(Reservation reservations){
//
//            this.reservations.add(reservations);
//
//    }
}
