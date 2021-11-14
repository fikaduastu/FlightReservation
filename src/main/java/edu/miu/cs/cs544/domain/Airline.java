package edu.miu.cs.cs544.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Airline")
@Setter
@Getter
@NoArgsConstructor
public class Airline {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "code",nullable = false,length = 10)
    private String code;

    @Column(name = "name",nullable = false)
    private String name;

    @Lob
    @Column(name = "history")
    private String history;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights = new ArrayList<>();
}
