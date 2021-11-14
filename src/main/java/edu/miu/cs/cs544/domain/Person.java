package edu.miu.cs.cs544.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name ="Person")
public class Person {

    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;

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
    @JoinColumn(name ="account_id")
    private Account account;

    @OneToMany
    @JoinTable(name = "Person_Reservation")
    private List<Reservation> reservations = new ArrayList<>();
}
