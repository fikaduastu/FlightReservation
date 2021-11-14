package edu.miu.cs.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Airport")
public class Airport {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name ="code", length = 3, nullable = false)
    private String code;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;


}
