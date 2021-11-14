package edu.miu.cs.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Address")
@NoArgsConstructor
@Setter
@Getter
public class Address {

    @Id
    @Column(name="id")
    @GeneratedValue
    private long id;

    @Column(name = "steet", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

}
